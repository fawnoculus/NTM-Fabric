package net.fawnoculus.ntm.render;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.buffers.GpuBuffer;
import com.mojang.blaze3d.pipeline.BlendFunction;
import com.mojang.blaze3d.pipeline.RenderPipeline;
import com.mojang.blaze3d.systems.RenderPass;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.textures.GpuTexture;
import com.mojang.blaze3d.vertex.VertexFormat;
import net.fawnoculus.ntm.NTM;
import net.fawnoculus.ntm.util.ExceptionUtil;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gl.RenderPipelines;
import net.minecraft.client.render.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.TriState;
import net.minecraft.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.function.Function;

public class ModRenderPipelines {
  public static final Logger LOGGER = LoggerFactory.getLogger(NTM.MOD_NAME + "/Render");
  public static final Function<Identifier, RenderPhase.Texture> TEXTURE_FUNCTION = Util.memoize(identifier -> new RenderPhase.Texture(identifier, TriState.FALSE, false));
  
  public static final RenderPipeline POSITION_COLOR_PIPELINE = RenderPipelines.register(
      RenderPipeline.builder(RenderPipelines.POSITION_COLOR_SNIPPET)
          .withLocation(NTM.id("pipeline/position_color"))
          .withVertexFormat(VertexFormats.POSITION_COLOR, VertexFormat.DrawMode.TRIANGLE_STRIP)
          .build()
  );
  public static final RenderPipeline TEXTURE_PIPELINE = RenderPipelines.register(
      RenderPipeline.builder()
          .withLocation(NTM.id("pipeline/texture"))
          .withVertexShader(NTM.id("textured"))
          .withFragmentShader(NTM.id("textured"))
          .withSampler("Sampler0")
          .withSampler("Sampler2")
          .withBlend(BlendFunction.TRANSLUCENT)
          .withVertexFormat(VertexFormats.POSITION_COLOR_TEXTURE_LIGHT_NORMAL, VertexFormat.DrawMode.TRIANGLES)
          .build()
  );
  
  
  public static void drawTexture(BuiltBuffer buffer, Identifier texture){
    draw(buffer, TEXTURE_PIPELINE,
        ImmutableList.of(
            TEXTURE_FUNCTION.apply(texture),
            RenderPhase.ENABLE_LIGHTMAP,
            RenderPhase.ENABLE_OVERLAY_COLOR,
            RenderPhase.MAIN_TARGET,
            RenderPhase.DEFAULT_TEXTURING,
            RenderPhase.FULL_LINE_WIDTH
        )
    );
  }
  public static void drawPositonColor(BuiltBuffer buffer){
    draw(buffer, POSITION_COLOR_PIPELINE,
        ImmutableList.of(
            RenderPhase.NO_TEXTURE,
            RenderPhase.ENABLE_LIGHTMAP,
            RenderPhase.ENABLE_OVERLAY_COLOR,
            RenderPhase.MAIN_TARGET,
            RenderPhase.DEFAULT_TEXTURING,
            RenderPhase.FULL_LINE_WIDTH
        )
    );
  }
  
  public static void draw(BuiltBuffer buffer, RenderPipeline renderPipeline, ImmutableList<RenderPhase> phases){
    phases.forEach(RenderPhase::startDrawing);
    
    try{
      GpuBuffer gpuBuffer = renderPipeline.getVertexFormat().uploadImmediateVertexBuffer(buffer.getBuffer());
      GpuBuffer gpuBuffer2;
      VertexFormat.IndexType indexType;
      if (buffer.getSortedBuffer() == null) {
        RenderSystem.ShapeIndexBuffer shapeIndexBuffer = RenderSystem.getSequentialBuffer(buffer.getDrawParameters().mode());
        gpuBuffer2 = shapeIndexBuffer.getIndexBuffer(buffer.getDrawParameters().indexCount());
        indexType = shapeIndexBuffer.getIndexType();
      } else {
        gpuBuffer2 = renderPipeline.getVertexFormat().uploadImmediateIndexBuffer(buffer.getSortedBuffer());
        indexType = buffer.getDrawParameters().indexType();
      }
      
      Framebuffer framebuffer = RenderPhase.MAIN_TARGET.get();
      
      try (RenderPass renderPass = RenderSystem.getDevice()
          .createCommandEncoder()
          .createRenderPass(
              framebuffer.getColorAttachment(), OptionalInt.empty(), framebuffer.useDepthAttachment ? framebuffer.getDepthAttachment() : null, OptionalDouble.empty()
          )
      ) {
        renderPass.setPipeline(renderPipeline);
        renderPass.setVertexBuffer(0, gpuBuffer);
        if (RenderSystem.SCISSOR_STATE.isEnabled()) {
          renderPass.enableScissor(RenderSystem.SCISSOR_STATE);
        }
        
        for (int i = 0; i < 12; i++) {
          GpuTexture gpuTexture = RenderSystem.getShaderTexture(i);
          if (gpuTexture != null) {
            renderPass.bindSampler("Sampler" + i, gpuTexture);
          }
        }
        
        renderPass.setIndexBuffer(gpuBuffer2, indexType);
        renderPass.drawIndexed(0, buffer.getDrawParameters().indexCount());
      }
    }catch (Throwable throwable){
      if(buffer != null){
        try {
          buffer.close();
        }catch (Throwable throwable2){
          throwable.addSuppressed(throwable2);
        }
      }
      
      LOGGER.warn("Exception occurred while trying to Render BuiltBuffer \n\tException: {}", ExceptionUtil.makePretty(throwable, false));
    }
    
    if(buffer != null){
      buffer.close();
    }
    
    phases.forEach(RenderPhase::endDrawing);
  }
}

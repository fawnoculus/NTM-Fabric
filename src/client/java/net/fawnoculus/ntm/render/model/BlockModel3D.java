package net.fawnoculus.ntm.render.model;

import net.fawnoculus.ntm.NTMClientConfig;
import net.fawnoculus.ntm.render.wavefront.model.Model3d;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.BlockModelPart;
import net.minecraft.client.render.model.BlockStateModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;
import java.util.function.Function;

public record BlockModel3D(BlockModelPart part) implements BlockStateModel {

	@Override
	public void addParts(Random random, List<BlockModelPart> parts) {
		parts.add(this.part);
	}

	@Override
	public Sprite particleSprite() {
		return this.part.particleSprite();
	}

	public record MultipartUnbaked(Model3d model3d, SpriteIdentifier particleSprite,
								   Function<Vector3f, Vector3f> offset) implements UnbakedGrouped {
		@SuppressWarnings("deprecation")
		public MultipartUnbaked(Model3d model3d, Identifier particleTexture) {
			this(model3d, new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, particleTexture), model3d.defaultBlockTransforms());
		}

		@SuppressWarnings("deprecation")
		public MultipartUnbaked(Model3d model3d, Identifier particleTexture, Function<Vector3f, Vector3f> offset) {
			this(model3d, new SpriteIdentifier(SpriteAtlasTexture.BLOCK_ATLAS_TEXTURE, particleTexture), offset);
		}


		@Override
		public BlockModel3D bake(BlockState state, Baker baker) {
			final List<BakedQuad> quads = model3d.bake(baker, state::toString, offset);
			final Sprite particleSprite = baker.getSpriteGetter().get(this.particleSprite, state::toString);

			return new BlockModel3D(new Part(quads, NTMClientConfig.BLOCK_MODEL_AMBIENT_OCCLUSION.getValue(), particleSprite));
		}

		@Override
		public Object getEqualityGroup(BlockState state) {
			// I have no idea what this is for, but it just needs an object, so I guess this is fine?
			return this;
		}

		@Override
		public void resolve(Resolver resolver) {
		}
	}

	public record Part(List<BakedQuad> quads, boolean useAmbientOcclusion,
					   Sprite particleSprite) implements BlockModelPart {
		@Override
		public List<BakedQuad> getQuads(@Nullable Direction side) {
			return this.quads;
		}

		@Override
		public boolean useAmbientOcclusion() {
			return this.useAmbientOcclusion;
		}

		@Override
		public Sprite particleSprite() {
			return this.particleSprite;
		}
	}
}

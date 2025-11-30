package net.fawnoculus.ntm.client.render.wavefront.model;

import net.fawnoculus.ntm.client.render.wavefront.Polygon;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.Baker;
import net.minecraft.client.render.model.SimpleModel;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3f;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public record WavefrontModelObject(String name, List<Polygon> polygons) implements Model3d {
    public void setTexture(Identifier blockId) {
        for (Polygon face : polygons) {
            face.setTexture(blockId);
        }
    }

    public void setTexture(SpriteIdentifier spriteIdentifier) {
        for (Polygon face : polygons) {
            face.setTexture(spriteIdentifier);
        }
    }

    public @NotNull List<BakedQuad> bake(@NotNull Baker baker, SimpleModel simpleModel, Function<Vector3f, Vector3f> offset) {
        List<BakedQuad> quads = new ArrayList<>();
        for (Polygon face : polygons) {
            quads.add(face.bake(baker, simpleModel, offset));
        }
        return quads;
    }

    @Override
    public float getMaxX() {
        float current = 0f;

        for (Polygon polygon : this.polygons) {
            for (Polygon.GeometryVertex vertex : polygon.vertices) {
                if (vertex.X() > current) {
                    current = vertex.X();
                }
            }
        }

        return current;
    }

    @Override
    public float getMaxY() {
        float current = 0f;

        for (Polygon polygon : this.polygons) {
            for (Polygon.GeometryVertex vertex : polygon.vertices) {
                if (vertex.Y() > current) {
                    current = vertex.X();
                }
            }
        }

        return current;
    }

    @Override
    public float getMaxZ() {
        float current = 0f;

        for (Polygon polygon : this.polygons) {
            for (Polygon.GeometryVertex vertex : polygon.vertices) {
                if (vertex.Z() > current) {
                    current = vertex.X();
                }
            }
        }

        return current;
    }

    @Override
    public float getMinX() {
        float current = 0f;

        for (Polygon polygon : this.polygons) {
            for (Polygon.GeometryVertex vertex : polygon.vertices) {
                if (vertex.X() < current) {
                    current = vertex.X();
                }
            }
        }

        return current;
    }

    @Override
    public float getMinY() {
        float current = 0f;

        for (Polygon polygon : this.polygons) {
            for (Polygon.GeometryVertex vertex : polygon.vertices) {
                if (vertex.Y() < current) {
                    current = vertex.X();
                }
            }
        }

        return current;
    }

    @Override
    public float getMinZ() {
        float current = 0f;

        for (Polygon polygon : this.polygons) {
            for (Polygon.GeometryVertex vertex : polygon.vertices) {
                if (vertex.Z() < current) {
                    current = vertex.X();
                }
            }
        }

        return current;
    }
}

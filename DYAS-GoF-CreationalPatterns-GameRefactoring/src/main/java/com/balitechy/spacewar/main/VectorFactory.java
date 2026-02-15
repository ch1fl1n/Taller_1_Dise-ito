package com.balitechy.spacewar.main;

public class VectorFactory implements VisualFactory {

    @Override
    public PlayerRenderer createPlayerRenderer(Game game) {
        return new VectorPlayerRenderer();
    }

    @Override
    public BulletRenderer createBulletRenderer(Game game) {
        return new VectorBulletRenderer();
    }

    @Override
    public BackgroundRendererInterface createBackgroundRenderer(Game game) {
        return new VectorBackgroundRenderer();
    }
}

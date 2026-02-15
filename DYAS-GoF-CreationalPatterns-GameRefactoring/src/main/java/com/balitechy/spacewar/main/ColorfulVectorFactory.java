package com.balitechy.spacewar.main;

public class ColorfulVectorFactory implements VisualFactory {

    @Override
    public PlayerRenderer createPlayerRenderer(Game game) {
        return new ColorfulVectorPlayerRenderer();
    }

    @Override
    public BulletRenderer createBulletRenderer(Game game) {
        return new ColorfulVectorBulletRenderer();
    }

    @Override
    public BackgroundRendererInterface createBackgroundRenderer(Game game) {
        return new ColorfulVectorBackgroundRenderer();
    }
}

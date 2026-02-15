package com.balitechy.spacewar.main;

public class SpriteFactory implements VisualFactory {

    @Override
    public PlayerRenderer createPlayerRenderer(Game game) {
        return new SpritePlayerRenderer(game);
    }

    @Override
    public BulletRenderer createBulletRenderer(Game game) {
        return new SpriteBulletRenderer(game);
    }

    @Override
    public BackgroundRendererInterface createBackgroundRenderer(Game game) {
        return new BitmapBackgroundRenderer(game);
    }
}

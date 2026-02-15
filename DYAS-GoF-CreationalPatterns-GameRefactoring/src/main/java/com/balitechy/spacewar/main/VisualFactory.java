package com.balitechy.spacewar.main;

public interface VisualFactory {
    PlayerRenderer createPlayerRenderer(Game game);
    BulletRenderer createBulletRenderer(Game game);
    BackgroundRendererInterface createBackgroundRenderer(Game game);
}

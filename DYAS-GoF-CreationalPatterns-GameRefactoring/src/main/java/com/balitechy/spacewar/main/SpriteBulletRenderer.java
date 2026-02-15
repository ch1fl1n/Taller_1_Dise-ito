package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpriteBulletRenderer implements BulletRenderer {
    private BufferedImage image;

    public SpriteBulletRenderer(Game game) {
        this.image = game.getSprites().getImage(35, 52, Bullet.WIDTH, Bullet.HEIGHT);
    }

    @Override
    public void render(Graphics g, Bullet b) {
        g.drawImage(image, (int) b.getX(), (int) b.getY(), null);
    }
}

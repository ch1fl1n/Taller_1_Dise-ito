package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;

public class VectorBulletRenderer implements BulletRenderer {
    @Override
    public void render(Graphics g, Bullet b) {
        g.setColor(Color.WHITE);
        g.fillRect((int)b.getX(), (int)b.getY(), Bullet.WIDTH, Bullet.HEIGHT);
    }
}

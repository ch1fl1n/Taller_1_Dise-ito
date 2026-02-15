package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;

public class ColorfulVectorBulletRenderer implements BulletRenderer {

    @Override
    public void render(Graphics g, Bullet bullet) {
        int x = (int) bullet.getX();
        int y = (int) bullet.getY();

        // Núcleo de la bala
        g.setColor(Color.CYAN);
        g.fillOval(x, y, Bullet.WIDTH, Bullet.HEIGHT);

        // Borde brillante
        g.setColor(Color.BLUE);
        g.drawOval(x, y, Bullet.WIDTH, Bullet.HEIGHT);
    }
}

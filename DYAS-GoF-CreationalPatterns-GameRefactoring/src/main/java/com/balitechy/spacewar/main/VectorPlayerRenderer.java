package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;

public class VectorPlayerRenderer implements PlayerRenderer {
    @Override
    public void render(Graphics g, Player player) {
        g.setColor(Color.WHITE);
        int x = (int) player.getX();
        int y = (int) player.getY();
        g.fillRect(x, y, Player.WIDTH, Player.HEIGHT/2); // diseño simple retro
    }
}

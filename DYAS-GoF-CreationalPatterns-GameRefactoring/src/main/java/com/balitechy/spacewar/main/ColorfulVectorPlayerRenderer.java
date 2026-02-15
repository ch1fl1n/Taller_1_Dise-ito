package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;

public class ColorfulVectorPlayerRenderer implements PlayerRenderer {
    @Override
    public void render(Graphics g, Player player) {
        int x = (int) player.getX();
        int y = (int) player.getY();
        g.setColor(Color.MAGENTA);
        g.fillOval(x, y, Player.WIDTH, Player.HEIGHT);
        g.setColor(Color.YELLOW);
        g.drawOval(x+4, y+4, Player.WIDTH-8, Player.HEIGHT-8);
    }
}

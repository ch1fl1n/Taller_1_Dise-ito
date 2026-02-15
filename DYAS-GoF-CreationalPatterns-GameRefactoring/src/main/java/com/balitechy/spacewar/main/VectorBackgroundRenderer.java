package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Color;
import java.io.IOException;

public class VectorBackgroundRenderer implements BackgroundRendererInterface {
    @Override
    public void render(Graphics g, Canvas c) throws IOException {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, c.getWidth(), c.getHeight());
        g.setColor(Color.DARK_GRAY);
        // simple grid retro
        for(int x=0; x < c.getWidth(); x += 32) g.drawLine(x, 0, x, c.getHeight());
        for(int y=0; y < c.getHeight(); y += 32) g.drawLine(0, y, c.getWidth(), y);
    }
}

package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Canvas;
import java.util.Random;

public class ColorfulVectorBackgroundRenderer implements BackgroundRendererInterface {

    private final Random random = new Random();

    @Override
    public void render(Graphics g, Canvas canvas) {
        int width = canvas.getWidth();
        int height = canvas.getHeight();

        // Fondo base
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, width, height);

        // Estrellas coloridas
        for (int i = 0; i < 120; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);

            g.setColor(new Color(
                    random.nextInt(256),
                    random.nextInt(256),
                    random.nextInt(256)
            ));

            g.fillRect(x, y, 2, 2);
        }
    }
}

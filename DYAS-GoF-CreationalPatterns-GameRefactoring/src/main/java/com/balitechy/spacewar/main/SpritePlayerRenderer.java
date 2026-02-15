package com.balitechy.spacewar.main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SpritePlayerRenderer implements PlayerRenderer {
    private BufferedImage image;

    public SpritePlayerRenderer(Game game) {
        this.image = game.getSprites().getImage(219, 304, Player.WIDTH, Player.HEIGHT);
    }

    @Override
    public void render(Graphics g, Player player) {
        g.drawImage(image, (int) player.getX(), (int) player.getY(), null);
    }
}

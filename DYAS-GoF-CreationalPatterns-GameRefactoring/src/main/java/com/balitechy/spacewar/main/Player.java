package com.balitechy.spacewar.main;

import java.awt.Graphics;

public class Player {
    private double x;
    private double y;
    private double velX;
    private double velY;
    public static final int WIDTH = 56;
    public static final int HEIGHT = 28;

    private Game game;
    private PlayerRenderer renderer;
    private BulletRenderer bulletRenderer;

    public Player(double x, double y, Game game, PlayerRenderer renderer, BulletRenderer bulletRenderer) {
        this.x = x;
        this.y = y;
        this.game = game;
        this.renderer = renderer;
        this.bulletRenderer = bulletRenderer;
    }

    // getters / setters...
    public double getX() { return x; }
    public void setX(double x) { this.x = x; }
    public double getY() { return y; }
    public void setY(double y) { this.y = y; }
    public void setVelX(double velX) { this.velX = velX; }
    public void setVelY(double velY) { this.velY = velY; }

    public void shoot() {
        Bullet b = new Bullet(x + (WIDTH / 2) - 5, y - 18, bulletRenderer);
        game.getBullets().addBullet(b);
    }

    public void tick() {
        x += velX;
        y += velY;
        if(x <= 0) x = 0;
        if(x >= (Game.WIDTH * Game.SCALE) - WIDTH) x = (Game.WIDTH * Game.SCALE) - WIDTH;
        if(y <= 0) y = 0;
        if(y >= (Game.HEIGHT * Game.SCALE) - HEIGHT) y = (Game.HEIGHT * Game.SCALE) - HEIGHT;
    }

    public void render(Graphics g) {
        renderer.render(g, this);
    }

    public void setRenderers(PlayerRenderer renderer,
                         BulletRenderer bulletRenderer) {
    this.renderer = renderer;
    this.bulletRenderer = bulletRenderer;
}

}

package com.balitechy.spacewar.main;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JFrame;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 1L;
    public static final int WIDTH = 320;
    public static final int HEIGHT = WIDTH / 12 * 9;
    public static final int SCALE = 2;
    public final String TITLE = "Space War 2D";

    private boolean running = false;
    private Thread thread;
    private BufferedImage image =
            new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);

    private SpritesImageLoader sprites;
    private Player player;
    private BulletController bullets;
    private BackgroundRendererInterface backgRenderer;

    public void init() {
        requestFocus();

        sprites = new SpritesImageLoader("/sprites.png");
        try {
            sprites.loadImage();
        } catch (IOException e) {
            e.printStackTrace();
        }

        addKeyListener(new InputHandler(this));

        // 🔹 MENÚ INICIAL
        String style = StyleMenu.show();
        applyStyle(style);

        bullets = new BulletController();
    }

    // 🔹 MÉTODO CLAVE (CAMBIO DE ESTILO EN RUNTIME)
    private void applyStyle(String style) {
        VisualFactory factory = FactoryProvider.getFactory(style);

        PlayerRenderer pr = factory.createPlayerRenderer(this);
        BulletRenderer br = factory.createBulletRenderer(this);
        BackgroundRendererInterface bg =
                factory.createBackgroundRenderer(this);

        if (player == null) {
            player = new Player(
                    (WIDTH * SCALE - Player.WIDTH) / 2,
                    HEIGHT * SCALE - 50,
                    this,
                    pr,
                    br
            );
        } else {
            player.setRenderers(pr, br);
        }

        backgRenderer = bg;
    }

    public SpritesImageLoader getSprites() {
        return sprites;
    }

    public BulletController getBullets() {
        return bullets;
    }

    // 🎮 CONTROLES
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
                player.setVelX(5);
                break;
            case KeyEvent.VK_LEFT:
                player.setVelX(-5);
                break;
            case KeyEvent.VK_UP:
                player.setVelY(-5);
                break;
            case KeyEvent.VK_DOWN:
                player.setVelY(5);
                break;
            case KeyEvent.VK_SPACE:
                player.shoot();
                break;
            case KeyEvent.VK_M: // 🔥 CAMBIO DE ESTILO
                String style = StyleMenu.show();
                applyStyle(style);
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        switch (key) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                player.setVelX(0);
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                player.setVelY(0);
                break;
        }
    }

    public void tick() {
        player.tick();
        bullets.tick();
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        try {
            backgRenderer.render(g, this);
            player.render(g);
            bullets.render(g);
        } catch (IOException e) {
            e.printStackTrace();
        }

        g.dispose();
        bs.show();
    }

    private synchronized void start() {
        if (running) return;
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        init();
        while (running) {
            tick();
            render();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH * SCALE, HEIGHT * SCALE));

        JFrame frame = new JFrame(game.TITLE);
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        game.start();
    }
}

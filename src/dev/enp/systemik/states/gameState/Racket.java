package dev.enp.systemik.states.gameState;

import java.awt.*;

public class Racket {
    private static final int WIDTH = 10, HEIGHT = 60;
    private Pong pong;
    private final int x;
    private int y, ya;

    public Racket(Pong pong, int x) {
        this.pong = pong;
        this.x = x;
        y = pong.getHeight() / 2;
    }

    public void tick() {
        if (pong.handler.getKeyManager().aDown)
            ya = pong.speed / 2;
        else if (pong.handler.getKeyManager().aUp)
            ya = -(pong.speed / 2);
        else
            ya = 0;

        move();
    }

    public void move() {
        if (y > 0 && y < pong.getHeight() - HEIGHT - 10)
            y += ya;
        else if (y <= 0)
            y++;
        else if (y >= pong.getHeight() - HEIGHT - 10)
            y--;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void render(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
}

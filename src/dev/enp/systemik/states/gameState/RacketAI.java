package dev.enp.systemik.states.gameState;

import java.awt.*;

public class RacketAI extends Racket{
    private static final int WIDTH = 10, HEIGHT = 60;
    private Pong pong;
    private Ball ball;
    private final int x;
    private int y, ya;

    public RacketAI(Pong pong, int x) {
        super(pong, x);
        this.pong = pong;
        this.ball = pong.getBall();
        this.x = x;
        y = pong.getHeight() / 2;
    }

    public void tick() {
        if (ball.getBounds().y > y + HEIGHT/2)
            ya = pong.speed / 2;
        else
            ya = -(pong.speed / 2);

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

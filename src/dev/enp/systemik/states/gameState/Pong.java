package dev.enp.systemik.states.gameState;

import dev.enp.systemik.Handler;

import java.awt.*;

public class Pong {

    private int width, height;
    private Ball ball;
    private Racket player1;
    private Racket player2;
    protected int speed;

    protected Handler handler;

    public Pong(Handler handler) {
        this.handler = handler;
        width = 320;
        height = 200;
        speed = 2;
        ball = new Ball(this);
        player1 = new RacketAI(this, this.getWidth() - 36);
        player2 = new Racket(this, 20);

    }

    public void tick() {
        ball.tick();
        player1.tick();
        player2.tick();
    }

    public void render(Graphics g) {
        ball.render(g);
        player1.render(g);
        player2.render(g);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Ball getBall() {
        return ball;
    }

    public void changeSpeed(int change) {
        this.speed += change;
        ball.changeSpeed(change);
    }

    public Racket getPlayer(int playerNo) {
        if (playerNo == 1)
            return player1;
        else
            return player2;
    }
}

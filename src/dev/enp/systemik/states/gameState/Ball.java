package dev.enp.systemik.states.gameState;

import java.awt.*;

public class Ball {

    private final int WIDTH = 5, HEIGHT = WIDTH;
    private int x, y, xa, ya;
    private Pong pong;

    public Ball(Pong pong) {
        this.pong = pong;
        x = pong.getWidth() / 2;
        y = pong.getHeight() / 2;
        ya = pong.speed;
        xa = pong.speed;
    }

    public void tick() {
        x += xa;
        y += ya;
        if (x < 0) {
            // should increase score
            x = pong.getWidth() / 2;
            xa = -xa;
        }
        else if (x > pong.getWidth() - WIDTH - 7) {
            // should increase score
            x = pong.getWidth() / 2;
            xa = -xa;
        }
        else if (y < 0 || y > pong.getHeight() - HEIGHT - 10)
            ya = -ya;
            /*if (pong.getPanel().getScore(1) == 10)
                JOptionPane.showMessageDialog(null, "Player 1 wins", "Pong", JOptionPane.PLAIN_MESSAGE);
            else if (pong.getPanel().getScore(2) == 10)
                JOptionPane.showMessageDialog(null, "Player 2 wins", "Pong", JOptionPane.PLAIN_MESSAGE);*/
        checkCollision();
    }


    public void checkCollision() {
        if (pong.getPlayer(1).getBounds().intersects(getBounds()) || pong.getPlayer(2).getBounds().intersects(getBounds()))
            xa = -xa;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WIDTH, HEIGHT);
    }

    public void render(Graphics g) {
        g.fillRect(x, y, WIDTH, HEIGHT);
    }
    
    public void changeSpeed(int change) {
        if (xa >= 0)
            xa += change;
        else if (xa < 0)
            xa -= change;
    }
}

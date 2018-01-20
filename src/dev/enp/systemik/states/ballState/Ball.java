package dev.enp.systemik.states.ballState;

import java.awt.*;

public class Ball {
    private final double a, b, radius;
    private double x, y, angle, angleSpeed;

    public Ball(double a, double b, double radius, double angle, double angleSpeed) {
        this.a = a;
        this.b = b;
        this.radius = radius;
        this.angle = angle;
        this.angleSpeed = angleSpeed;
        tick();
    }

    public void tick() {
        angle += angleSpeed;

        x = a + radius * Math.sin(angle);
        y = b + radius * Math.cos(angle);
    }

    public void render(Graphics g) {
        g.drawOval((int)x, (int)y, 5, 5);
    }
}

package dev.enp.systemik.ui.buttons;

import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.UIObject;

import java.awt.*;

public class UIColorButton extends UIObject {

    private ClickListener clicker;
    private Color color;

    public UIColorButton(float x, float y, int width, int height, Color color, ClickListener clicker) {
        super(x, y, width, height);
        this.color = color;
        this.clicker = clicker;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.setColor(color);
        g.fillRect((int) x, (int) y, width, height);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}

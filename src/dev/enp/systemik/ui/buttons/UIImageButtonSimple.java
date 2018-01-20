package dev.enp.systemik.ui.buttons;

import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.UIObject;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UIImageButtonSimple extends UIObject {

    private BufferedImage image;
    private ClickListener clicker;

    public UIImageButtonSimple(float x, float y, int width, int height, BufferedImage image, ClickListener clicker) {
        super(x, y, width, height);
        this.image = image;
        this.clicker = clicker;
    }

    @Override
    public void tick() {
    }

    @Override
    public void render(Graphics g) {
        if (hovering) {
            g.drawImage(image, (int) x, (int) y, width, height, null);
            g.setColor(new Color(255, 255, 255, 50));
            g.fillRect((int) x, (int) y, width, height);
        }
        else
            g.drawImage(image, (int) x, (int) y, width, height, null);
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}

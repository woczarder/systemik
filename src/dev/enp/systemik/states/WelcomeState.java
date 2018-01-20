package dev.enp.systemik.states;

import dev.enp.systemik.Handler;
import dev.enp.systemik.gfx.Assets;
import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.UIManager;
import dev.enp.systemik.ui.UIObject;
import dev.enp.systemik.ui.buttons.UIImageButton;

import java.awt.Color;
import java.awt.Graphics;

public class WelcomeState extends State {

    public WelcomeState(Handler handler){
        super(handler);

        uiManager.addObject(new UIImageButton(grid.BIG(3), grid.BIG(4), UIObject.BIG, UIObject.BIG, Assets.arrow_right, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().appsState);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 64, handler.getHeight());
        g.fillRect(handler.getWidth() - 64, 0, 64, handler.getHeight());

        g.setColor(Color.WHITE);
        g.drawString("Welcome to systemik", 100, 160);
        g.drawString("by Wiertara", 125, 180);

        uiManager.render(g);
    }

}

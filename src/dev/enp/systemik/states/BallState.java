package dev.enp.systemik.states;

import dev.enp.systemik.Handler;
import dev.enp.systemik.gfx.Assets;
import dev.enp.systemik.states.ballState.Ball;
import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.UIObject;
import dev.enp.systemik.ui.buttons.UIImageButton;
import dev.enp.systemik.ui.buttons.UIImageButtonSimple;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BallState extends State {

    BufferedImage drawCanvas = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

    private ArrayList<Ball> balls;

    Ball b1, b2;


    public BallState(Handler handler) {
        super(handler);

        balls = new ArrayList<>();

        for (int x = 0; x < 10; x++) {
            balls.add(new Ball(160, 100, 50, x, 0.01+x*0.01));
        }

        //exit
        uiManager.addObject(new UIImageButton(iconGrid.BIG(4), iconGrid.BIG(4), UIObject.BIG, UIObject.BIG, Assets.shutdown, new ClickListener() {
            @Override
            public void onClick() {
                handler.getMouseManager().setUIManager(null);
                System.exit(0);
            }
        }));
        //welcomeState
        uiManager.addObject(new UIImageButton(iconGrid.BIG(3), iconGrid.BIG(4), UIObject.BIG, UIObject.BIG, Assets.arrow_left, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().welcomeState);
            }
        }));
/*
        // add rectangle
        uiManager.addObject(new UIImageButtonSimple(grid.BIG(1), grid.BIG(4), UIObject.SMALL, UIObject.SMALL, Assets.icons[15][9], new ClickListener() {
            @Override
            public void onClick() {
                balls.add(new Rectangle(0,0,10,10));
            }
        }));
        // remove rectangle
        uiManager.addObject(new UIImageButtonSimple(grid.BIG(2), grid.BIG(4), UIObject.SMALL, UIObject.SMALL, Assets.icons[16][9], new ClickListener() {
            @Override
            public void onClick() {
                balls.remove(balls.size() - 1);
            }
        }));
*/

    }

    @Override
    public void tick() {
        uiManager.tick();
        for (Ball b : balls) {
            b.tick();
        }
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);

        g.setColor(Color.WHITE);
        for (Ball b : balls) {
            b.render(g);
        }
    }
}

package dev.enp.systemik.states;

import dev.enp.systemik.Handler;
import dev.enp.systemik.gfx.Assets;
import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.Grid;
import dev.enp.systemik.ui.UIObject;
import dev.enp.systemik.ui.buttons.UIImageButton;
import dev.enp.systemik.ui.buttons.UIImageButtonSimple;

import java.awt.*;

public class AppsState extends State {

    public AppsState(Handler handler){
        super(handler);

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
        //drawState
        uiManager.addObject(new UIImageButton(iconGrid.BIG(1), iconGrid.BIG(1), UIObject.BIG, UIObject.BIG, Assets.drawIcon, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().drawState);
            }
        }));
        //gameState
        uiManager.addObject(new UIImageButtonSimple(iconGrid.BIG(2), iconGrid.BIG(1), UIObject.BIG, UIObject.BIG, Assets.icons[20][2], new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().gameState);
            }
        }));
        //ballState
        uiManager.addObject(new UIImageButtonSimple(iconGrid.BIG(3), iconGrid.BIG(1), UIObject.BIG, UIObject.BIG, Assets.icons[19][2], new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().ballState);
            }
        }));

    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        uiManager.render(g);
    }

}

package dev.enp.systemik.states;

import dev.enp.systemik.Handler;
import dev.enp.systemik.gfx.Assets;
import dev.enp.systemik.states.State;
import dev.enp.systemik.states.gameState.Pong;
import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.UIObject;
import dev.enp.systemik.ui.buttons.UIImageButton;
import dev.enp.systemik.ui.buttons.UIImageButtonSimple;

import java.awt.*;

public class GameState extends State {

    private Pong pong;

    public GameState(Handler handler) {
        super(handler);

        pong = new Pong(handler);

        // jump to welcome screen
        uiManager.addObject(new UIImageButton(iconGrid.BIG(3), iconGrid.BIG(4), UIObject.BIG, UIObject.BIG, Assets.arrow_left, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().welcomeState);
            }
        }));
        // game speed -
        uiManager.addObject(new UIImageButtonSimple(iconGrid.MEDIUM(1), iconGrid.MEDIUM(6), UIObject.MEDIUM, UIObject.MEDIUM, Assets.icons[14][9], new ClickListener() {
            @Override
            public void onClick() {
                pong.changeSpeed(-2);
            }
        }));
        // game speed +
        uiManager.addObject(new UIImageButtonSimple(iconGrid.MEDIUM(2), iconGrid.MEDIUM(6), UIObject.MEDIUM, UIObject.MEDIUM, Assets.icons[15][9], new ClickListener() {
            @Override
            public void onClick() {
                pong.changeSpeed(2);
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
        pong.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.drawLine(0, 190, 320, 190);
        uiManager.render(g);
        g.setColor(Color.WHITE);

        pong.render(g);
    }
}

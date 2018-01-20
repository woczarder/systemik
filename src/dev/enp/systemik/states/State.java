package dev.enp.systemik.states;

import java.awt.*;
import dev.enp.systemik.Handler;
import dev.enp.systemik.ui.Grid;
import dev.enp.systemik.ui.UIManager;

public abstract class State {

    private static State currentState = null;

    public static void setState(State state){
        currentState = state;

        //Set the only one MouseManager to new UIManager
        handler.getMouseManager().setUIManager(currentState.getUiManager());
    }

    public static State getState(){
        return currentState;
    }

    //CLASS

    protected static Handler handler;

    protected static Grid iconGrid; // all states have grid, nothing else needs it for now
    protected static Grid grid;

    protected UIManager uiManager;

    public State(Handler handler){
        this.handler = handler;

        this.grid = new Grid(false);
        this.iconGrid = new Grid(true);

        uiManager = new UIManager(handler);
    }

    public abstract void tick();

    public abstract void render(Graphics g);

    public UIManager getUiManager() {
        return uiManager;
    }

}

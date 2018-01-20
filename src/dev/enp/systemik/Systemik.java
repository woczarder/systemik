package dev.enp.systemik;

import dev.enp.systemik.display.Display;
import dev.enp.systemik.gfx.Assets;
import dev.enp.systemik.input.KeyManager;
import dev.enp.systemik.input.MouseManager;
import dev.enp.systemik.states.*;
import dev.enp.systemik.states.GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

public class Systemik {

    Color background = new Color(38,00, 54);

    private Display display;
    private final int width = 320, height = 320;

    private BufferStrategy bs;
    private Graphics g;

    private Handler handler;

    //States
    public State welcomeState;
    public State appsState;
    public State drawState;
    public State gameState;
    public State ballState;

    //Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    public Systemik() {

        keyManager = new KeyManager();
        mouseManager = new MouseManager();

        init();

        //GAME LOOP
        int fps = 60;
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;

        while(true){
            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if(delta >= 1){
                tick();
                render();
                ticks++;
                delta--;
            }

            if(timer >= 1000000000){
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
        }

    }

    private void init() {
        display = new Display(width, height);
        display.getFrame().addKeyListener(keyManager);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        handler = new Handler(this);

        welcomeState = new WelcomeState(handler);
        appsState = new AppsState(handler);
        drawState = new DrawState(handler);
        gameState = new GameState(handler);
        ballState = new BallState(handler);

        State.setState(welcomeState);
    }

    private void tick(){
        keyManager.tick();

        if(State.getState() != null)
            State.getState().tick();
    }

    private void render(){
        bs = display.getCanvas().getBufferStrategy();
        if(bs == null){
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!

        g.setColor(background);
        g.fillRect(0,0,width,height);

        if (State.getState() != null)
            State.getState().render(g);

        //g.fillOval(mouseManager.getMouseX(), mouseManager.getMouseY(),10, 10);

        //End Drawing!
        bs.show();
        g.dispose();
    }

    //Getters and setters

    public MouseManager getMouseManager(){
        return mouseManager;
    }

    public KeyManager getKeyManager(){
        return keyManager;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }
}

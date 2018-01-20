package dev.enp.systemik;

import dev.enp.systemik.input.KeyManager;
import dev.enp.systemik.input.MouseManager;

public class Handler {

    private Systemik systemik;

    public Handler(Systemik systemik) {
        this.systemik = systemik;
    }

    public Systemik getSystemik() {
        return systemik;
    }

    public int getWidth(){
        return systemik.getWidth();
    }

    public int getHeight(){
        return systemik.getHeight();
    }

    public MouseManager getMouseManager() {
        return systemik.getMouseManager();
    }

    public KeyManager getKeyManager(){
        return systemik.getKeyManager();
    }

}

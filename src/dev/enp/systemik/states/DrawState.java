package dev.enp.systemik.states;

import dev.enp.systemik.Handler;
import dev.enp.systemik.gfx.Assets;
import dev.enp.systemik.gfx.ImageLoader;
import dev.enp.systemik.ui.ClickListener;
import dev.enp.systemik.ui.buttons.UIColorButton;
import dev.enp.systemik.ui.buttons.UIImageButton;
import dev.enp.systemik.ui.buttons.UIImageButtonSimple;
import dev.enp.systemik.ui.UIObject;
import dev.enp.systemik.utils.Utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

public class DrawState extends State {

    BufferedImage drawCanvas = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);

    //draw parameters
    private int brushSize;
    private Color brushColor;

    public DrawState(Handler handler) {
        super(handler);

        brushSize = 5;
        brushColor = Color.WHITE;
        //jump to welcome screen
        uiManager.addObject(new UIImageButton(iconGrid.BIG(3), iconGrid.BIG(4), UIObject.BIG, UIObject.BIG, Assets.arrow_left, new ClickListener() {
            @Override
            public void onClick() {
                State.setState(handler.getSystemik().welcomeState);
            }
        }));

        //brushSize-
        uiManager.addObject(new UIImageButtonSimple(8, 20, UIObject.SMALL, UIObject.SMALL, Assets.icons[14][9], new ClickListener() {
            @Override
            public void onClick() {
                brushSize -= 2;
            }
        }));
        //brushSize+
        uiManager.addObject(new UIImageButtonSimple(32, 20, UIObject.SMALL, UIObject.SMALL, Assets.icons[15][9], new ClickListener() {
            @Override
            public void onClick() {
                brushSize += 2;
            }
        }));
        //save
        uiManager.addObject(new UIImageButtonSimple(20, 260, UIObject.MEDIUM, UIObject.MEDIUM, Assets.icons[0][5], new ClickListener() {
            @Override
            public void onClick() {
                try {
                    File outputFile = new File(Utils.getCurrentTimeStamp()+".png");
                    ImageIO.write(drawCanvas, "png", outputFile);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }));
        //COLORS
        uiManager.addObject(new UIColorButton(8, 40, UIObject.SMALL, UIObject.SMALL, Color.WHITE, new ClickListener() {
            @Override
            public void onClick() {
                brushColor = Color.WHITE;
            }
        }));

        uiManager.addObject(new UIColorButton(32, 40, UIObject.SMALL, UIObject.SMALL, Color.BLACK, new ClickListener() {
            @Override
            public void onClick() {
                brushColor = Color.BLACK;
            }
        }));

        uiManager.addObject(new UIColorButton(8, 60,  UIObject.SMALL, UIObject.SMALL, Color.GREEN, new ClickListener() {
            @Override
            public void onClick() {
                brushColor = Color.GREEN;
            }
        }));

        uiManager.addObject(new UIColorButton(32, 60, UIObject.SMALL, UIObject.SMALL, Color.BLUE, new ClickListener() {
            @Override
            public void onClick() {
                brushColor = Color.BLUE;
            }
        }));

        uiManager.addObject(new UIColorButton(8, 80, UIObject.SMALL, UIObject.SMALL, Color.RED, new ClickListener() {
            @Override
            public void onClick() {
                brushColor = Color.RED;
            }
        }));

        uiManager.addObject(new UIColorButton(32, 80, UIObject.SMALL, UIObject.SMALL, Color.MAGENTA, new ClickListener() {
            @Override
            public void onClick() {
                brushColor = Color.MAGENTA;
            }
        }));
    }

    @Override
    public void tick() {
        uiManager.tick();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.GRAY);
        g.fillRect(0, 0, 320, grid.BIG(4));
        uiManager.render(g);
        g.setColor(brushColor);
        g.drawImage(drawCanvas, grid.SMALL(4), grid.SMALL(2), null);
        g.fillOval(270, 20, brushSize, brushSize);

        //Draw thing
        if (handler.getMouseManager().isLeftPressed()) {
            g = drawCanvas.getGraphics();
            g.setColor(brushColor);
            g.fillOval(handler.getMouseManager().getMouseX()-60-brushSize/2, handler.getMouseManager().getMouseY()-20-brushSize/2, brushSize, brushSize);
        }

    }
}

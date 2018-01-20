package dev.enp.systemik.gfx;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;

public class ImageLoader {

    public static BufferedImage loadImage(String path){
        BufferedImage r = null;
        try {
            r = ImageIO.read(ImageLoader.class.getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return r;
        /*try {
            return ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;*/
    }

}
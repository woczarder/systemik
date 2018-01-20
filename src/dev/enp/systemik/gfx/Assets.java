package dev.enp.systemik.gfx;

import java.awt.image.BufferedImage;

public class Assets {

    private static final int width = 32, height = 32;
    public static BufferedImage[] arrow_right, arrow_left, drawIcon, shutdown;
    public static BufferedImage[][] icons;//stationary icons

    public static void init() {
        SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("res/textures/buttons.png"));
        SpriteSheet smallIcons = new SpriteSheet(ImageLoader.loadImage("res/textures/icons_purple.png"));

        arrow_right = new BufferedImage[2];
        arrow_left = new BufferedImage[2];
        drawIcon = new BufferedImage[2];
        shutdown = new BufferedImage[2];
        icons = new BufferedImage[21][16];

        //fill icons matrix with 8x8 icons from purple icons file
        for (int x = 0; x < 21; x++) {
            for (int y = 0; y < 16; y++) {
                icons[x][y] = smallIcons.crop(14 + 18*x, 12 + 18*y,8, 8);
            }
        }

        arrow_right[0] = icons[1][0];
        arrow_right[1] = icons[5][0];

        arrow_left[0] = icons[3][0];
        arrow_left[1] = icons[7][0];

        shutdown[0] = sheet.crop(width*4,0, width, height);
        shutdown[1] = sheet.crop(width*5,0, width, height);

        drawIcon[0] = sheet.crop(width*6,0, width, height);
        drawIcon[1] = sheet.crop(width*7,0, width, height);

    }

}

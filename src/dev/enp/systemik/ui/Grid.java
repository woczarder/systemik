package dev.enp.systemik.ui;

public class Grid {

    // these guy hold numbers for good looking grid spacing
    private int[] BIG;
    private int[] MEDIUM;
    private int[] SMALL;
    private int[] TINY;

    public Grid(boolean isIcon) {
        BIG = new int[4];
        MEDIUM = new int[8];
        SMALL = new int[16];
        TINY = new int[32];

        // filling those sexy arrays

        if (isIcon) {
            for (int x = 0; x < 4; x++) {
                BIG[x] = 8 + x * 80;
                //System.out.println("BIG("+x+") = "+BIG[x]);
            }


            for (int x = 0; x < 8; x++)
                MEDIUM[x] = 4 + x * 40;

            for (int x = 0; x < 16; x++)
                SMALL[x] = 2 + x * 20;

            for (int x = 0; x < 32; x++)
                TINY[x] = 1 + x * 10;
        }
        else {
            for (int x = 0; x < 4; x++) {
                BIG[x] = x * 80;
                //System.out.println("BIG("+x+") = "+BIG[x]);
            }

            for (int x = 0; x < 8; x++)
                MEDIUM[x] = x * 40;

            for (int x = 0; x < 16; x++)
                SMALL[x] = x * 20;

            for (int x = 0; x < 32; x++)
                TINY[x] = x * 10;
        }

    }

    // sorta getters
    public int BIG(int i) {
        return BIG[i-1];
    }

    public int MEDIUM(int i) {
        return MEDIUM[i-1];
    }

    public int SMALL(int i) {
        return SMALL[i-1];
    }

    public int TINY(int i) {
        return TINY[i-1];
    }
}

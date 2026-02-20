package Tetris;

public class UsefulFunctions {
    public static int color(int r, int g, int b, int opacity){
        if (r > 255 || g > 255 || b > 255 || opacity > 255)
            throw new IllegalArgumentException("r, g, b and opacity must be <= 255");
        return (opacity << 24 | r << 16 | g << 8 | b);
    }
    public static int color(int r, int g, int b){
        return (color(r,g,b,255));
    }
}

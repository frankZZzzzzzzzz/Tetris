package Tetris;

import processing.core.PApplet;

/*
0 - long (Cyan - 0,255,255)
1 - L piece (Orange - 255,165,0)
2 - other L piece (Blue - 0,0,255)
3 - s piece (Green - 0,255,0)
4 - other s piece (Red - 255,0,0)
5 - t piece (Purple - 255,0,255)
6 - square (Yellow - 255,255,0)
 */
public class TetrisBox extends Box{
    public TetrisBox(int xPox, int yPos, int width, int height){
        super(xPox,yPos,width,height);
    }
    public TetrisBox(int xPox, int yPos, int width, int height, int color){
        super(xPox,yPos,width,height,color);
    }
    public void draw(PApplet pa){
        if (color == UsefulFunctions.color(0,0,0))
            return;

        super.draw(pa);

        //Inner Darker Box
        int offset = width/4;
        int innerColor = color + UsefulFunctions.color(30,30,30,0);
        pa.fill(innerColor);
        pa.rect(xPos+offset,yPos+offset,xPos+width-offset,yPos+height-offset);
    }
    public void draw(PApplet pa, int color){
        if (color == 0x000000)
            return;

        super.draw(pa, color);

        //Inner Darker Box
        int offset = width/4;
        pa.stroke(0x11000000);
        pa.fill(0x11000000);
        pa.rect(xPos+offset,yPos+offset,width-2*offset,height-2*offset);
    }
}

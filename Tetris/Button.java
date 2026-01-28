package Tetris;

import processing.core.PApplet;

public class Button extends Box{
    public Button(int xPox, int yPos, int width, int height){
        super(xPox,yPos,width,height);
    }

    public boolean isOver(PApplet pa){
        return (xPos <= pa.mouseX && pa.mouseX <= xPos + width &&
                yPos <= pa.mouseY && pa.mouseY <= yPos + height);
    }
}

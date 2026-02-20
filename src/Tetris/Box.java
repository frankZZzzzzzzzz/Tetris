package Tetris;

import processing.core.PApplet;

public class Box {
    protected int color; //Hexadecimal
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    public Box(int xPox, int yPos, int width, int height){
        this.xPos = xPox;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        color = Tetris.UsefulFunctions.color(255,255,255);
    }
    public Box(int xPox, int yPos, int width, int height, int color){
        this.xPos = xPox;
        this.yPos = yPos;
        this.width = width;
        this.height = height;
        this.color = color;
    }
    public void setColor(int color){
        this.color = color;
    }
    public void draw(PApplet pa){
        pa.stroke(0,0,0);
        pa.fill(color);
        pa.rect(xPos,yPos,width,height);
    }
    public void draw(PApplet pa, int color){
        pa.stroke(0,0,0);
        pa.fill(color);
        pa.rect(xPos,yPos,width,height);
    }
}

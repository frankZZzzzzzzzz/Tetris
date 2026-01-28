package Tetris;

import processing.core.PApplet;
import processing.core.PConstants;

public class FunctionButton extends Button{
    private PApplet currPA;
    private String text;
    public FunctionButton(int x, int y, int width, int height, PApplet pa, String text){
        super(x,y,width,height);
        currPA = pa;
        this.text = text;
    }
    public void draw(){
        if (isOver(currPA))
            if (currPA.mousePressed)
                super.draw(currPA,0xffff0000);
            else
                super.draw(currPA,0xffe0e0e0);
        else
            super.draw(currPA);

        currPA.textAlign(PConstants.CENTER,PConstants.CENTER);
        currPA.fill(0,0,0);
        currPA.textSize(20);
        currPA.text(text, xPos+width/2, yPos+height/2);
    }
    public String getText(){
        return (text);
    }
}

package Tetris;
import java.util.LinkedList;

import processing.core.*;

import Application.Application;

public class Runner extends PApplet {
    private LinkedList<Application> ApplicationStack;
    public static void main(String[] args) {
        PApplet.main("Tetris.Runner");
    }
    public void setup(){
        ApplicationStack = new LinkedList<>();
        TetrisApplication Tetris = new TetrisApplication(this);
        ApplicationStack.add(Tetris);
        frameRate(144);
    }
    public void settings(){
        size(1000,500);
    }
    public void keyPressed(){
        System.out.println(keyCode + " " + (char)keyCode);
        ApplicationStack.getFirst().keyPressed();
    }
    public void mouseReleased(){
        ApplicationStack.getFirst().mouseReleased();
    }
    public void draw(){
        ApplicationStack.getFirst().draw();
    }
}

package Application;

import processing.core.PApplet;

public abstract class Application {
    protected PApplet currPA;
    public void setCurrPA(PApplet pa){
        currPA = pa;
    }
    public Application (PApplet pa){
        currPA = pa;
    }
    public Application (){
        currPA = null;
    }
    public abstract void draw();
    public abstract void mousePressed();
    public abstract void mouseReleased();

    public void keyPressed(){

    }
    public abstract void keyReleased();
    public abstract void update(int timeInterval);

}

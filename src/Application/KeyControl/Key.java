package Application.KeyControl;

import Application.Cycler.CycleCounter;

public class Key {
    private int keyCode;
    private CycleCounter TimeCounter;
    public Key(int keyCode){
        this.keyCode = keyCode;
        TimeCounter = new CycleCounter();
    }
    public void increment(long timeStep){
        TimeCounter.increment(timeStep);
    }
    public int getKeyCode(){
        return (keyCode);
    }
    public boolean isNextCycle(){
        return (TimeCounter.isNextCycle());
    }
}

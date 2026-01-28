package Application.KeyControl;

import Application.Cycler.CycleCounter;

public class Key {
    private int keyCode;
    private CycleCounter TimeCounter;
    public Key(int keyCode){
        this.keyCode = keyCode;
        TimeCounter = new CycleCounter();
    }
    public int getKeyCode(){
        return (keyCode);
    }
    public boolean isNextCycle(){
        return (TimeCounter.isNextCycle());
    }
}

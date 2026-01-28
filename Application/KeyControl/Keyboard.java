package Application.KeyControl;

import java.util.LinkedList;

public class Keyboard {
    private LinkedList<Key> KeysInOrder;
    public Keyboard(){
        KeysInOrder = new LinkedList<Key>();
    }
    public void pressedKey(int keyCode){
        KeysInOrder.add(new Key(keyCode));
    }
    public void releasedKey(int keyCode){
        Key releasedKey = null;
        for (Key currKey : KeysInOrder)
            if (currKey.getKeyCode() == keyCode){
                releasedKey = currKey;
                break;
            }
        if (releasedKey != null)
            KeysInOrder.remove(releasedKey);
    }
    public void increment(long timeStep){
        for (Key key : KeysInOrder)
            key.increment(timeStep);
    }
    public LinkedList<Integer> getKeyCycle(){
        LinkedList<Integer> keyCycleOrder = new LinkedList<Integer>();
        while (true){
            for (Key currKey : KeysInOrder)
                if (currKey.isNextCycle())
                    keyCycleOrder.add(currKey.getKeyCode());
                else
                    return(keyCycleOrder);
        }
    }
}

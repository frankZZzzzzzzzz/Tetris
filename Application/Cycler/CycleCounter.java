package Application.Cycler;

public class CycleCounter {
    private long timeCounter;
    private long cycleTime = 1000; // milliseconds
    public CycleCounter(){
        timeCounter = 0;
    }
    public CycleCounter(long cycleTimeMilis){
        timeCounter = 0;
        cycleTime = cycleTimeMilis;
    }
    public void increment(long timeStep){
        timeCounter += timeStep;
    }
    public int getNumOfCycles(){
        int cycles = (int)(timeCounter/cycleTime);
        timeCounter -= cycleTime*cycles;
        return (cycles);
    }
    public boolean isNextCycle(){
        long cycles = timeCounter/cycleTime;
        if (cycles > 0)
            timeCounter -= cycleTime;
        return (cycles > 0);
    }
    public void setCycleTime(long cycleTime){
        this.cycleTime = cycleTime;
    }
}

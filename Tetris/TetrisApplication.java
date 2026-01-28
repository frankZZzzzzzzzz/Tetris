package Tetris;

import Application.Application;
import Application.Cycler.CycleCounter;
import Application.KeyControl.Keyboard;
import Tetris.TetrisPieces.TetrisPiece;
import processing.core.PApplet;

import java.util.ArrayList;

public class TetrisApplication extends Application {
    private long timeCounter;
    private boolean hasStarted;
    private boolean hasEnded;
    private Keyboard keyboard;
    private TetrisBoard board;
    private TetrisGrid visualBoard;
    private TetrisPiece HoldPiece;
    private ArrayList<FunctionButton> functionButtons;
    public TetrisApplication(PApplet pa){
        super(pa);
        timeCounter = 0;
        hasStarted = false;
        hasEnded = false;
        board = new TetrisBoard();

        //Main Board
        int boardHeight = Math.min(pa.width/2, pa.height);
        int boardWidth = boardHeight/2;
        int xPos = pa.width/2-boardWidth/2;
        int yPos = pa.height/2-boardHeight/2;
        visualBoard = new TetrisGrid(xPos,yPos,boardWidth,boardHeight,board,pa);

        int functionHeight = boardHeight/20*2;
        int functionWidth = functionHeight*3/2;
        int offset = (int)(functionWidth*.05);

        //All Function Buttons
        functionButtons = new ArrayList<>();
        FunctionButton button;

        button = new FunctionButton(xPos-offset-functionWidth, yPos+boardHeight+offset-functionHeight,functionWidth-offset*2,functionHeight-offset*2,currPA,"Start");
        functionButtons.add(button);
        button = new FunctionButton(xPos+boardWidth+offset, yPos+boardHeight+offset-functionHeight,functionWidth-offset*2,functionHeight-offset*2,currPA,"Reset");
        functionButtons.add(button);

        //Hold Display
    }
    public void mouseReleased(){
        String currButton = null;
        for (FunctionButton button : functionButtons)
            if (button.isOver(currPA)){
                currButton = button.getText();
                break;
            }
        if (currButton == null)
            return;

        if (currButton.equals("Start")){
            if (!hasStarted)
                hasStarted = true;
        }
        else if (currButton.equals("Reset")){
            hasStarted = false;
            hasEnded = false;
            board.reset();
        }
    }
    public void mousePressed(){

    }
    public void keyReleased(){

    }
    public void keyPressed(){
        keyboard.pressedKey(currPA.key);
    }
    public void update(int timeStep){
        if (!hasStarted)
            return;
        keyboard.increment(timeStep);
        board.update(timeStep,keyboard);
    }
    public void drawAllFunctionButtons(){
        for (FunctionButton button : functionButtons)
            button.draw();
    }
    public void draw(){
        update((int)(currPA.millis() - timeCounter));
        timeCounter = currPA.millis();

        currPA.background(200,200,200);
        drawAllFunctionButtons();
        visualBoard.draw();
    }
}

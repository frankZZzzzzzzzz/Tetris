package Tetris;

import processing.core.*;

import Application.Cycler.CycleCounter;
import Tetris.TetrisPieces.TetrisPiece;
import Application.KeyControl.Keyboard;

import java.util.LinkedList;

/*
1 - long (Cyan)
2 - L piece (Orange)
3 - other L piece (Blue)
4 - s piece (Green)
5 - other s piece (Red)
6 - t piece (Purple)
7 - square (Yellow)
 */

public class TetrisBoard{
    protected int[][] permanentBoard;
    protected TetrisPiece holdPiece;
    protected TetrisPiece currPiece;
    protected LinkedList<TetrisPiece> nextPieces;
    private CycleCounter cycler;
    public TetrisBoard(){
        permanentBoard = new int[20][10];
        holdPiece = null;
        currPiece = TetrisPiece.random();

        cycler = new CycleCounter();

        nextPieces = new LinkedList<TetrisPiece>();

        for (int i = 0; i < 5; i++)
            nextPieces.add(TetrisPiece.random());
    }
    private void placePieceAtTop(TetrisPiece piece){
        currPiece = piece;
    }
    public void clearPermanentBoard(){
        permanentBoard = new int[20][10];
    }
    public void reset(){
        clearPermanentBoard();
        holdPiece = null;
        currPiece = TetrisPiece.random();

        cycler = new CycleCounter();

        nextPieces = new LinkedList<TetrisPiece>();

        for (int i = 0; i < 5; i++)
            nextPieces.add(TetrisPiece.random());
    }
    public int[][] getPermanentBoard(){
        return(permanentBoard);
    }
    private void placeUpcomingPiece(){
        nextPieces.add(TetrisPiece.random());
        placePieceAtTop(nextPieces.removeFirst());
    }
    private void switchHold(){
        if (holdPiece == null){
            holdPiece = currPiece;
            placeUpcomingPiece();
        }
        else{
            TetrisPiece temp = holdPiece;
            holdPiece = currPiece;

            temp.reset();
            placePieceAtTop(temp);
        }
    }
    private void setPiecesPermanent(){
        int color = currPiece.getColor();
        for (int[] position : currPiece.getPositons()){
            permanentBoard[position[0]][position[1]] = color;
        }

        placeUpcomingPiece();
    }
    private boolean canPieceShift(int rShift, int cShift){
        int[][] piecePostion = currPiece.getPositons();
        for (int[] position : piecePostion)
            if (position[0]+rShift < 0 || position[0]+rShift >= permanentBoard.length ||
                position[1]+cShift < 0 || position[1]+cShift >= permanentBoard[0].length ||
                    permanentBoard[position[0]+rShift][position[1]+cShift] != 0){
                return (false);
            }
        return (true);
    }
    private boolean pieceFall(){
        if (!canPieceShift(-1,0)){
            setPiecesPermanent();
            return (false);
        }
        currPiece.shiftDown();
        return (true);
    }
    private void pieceRight(){
        if (!canPieceShift(0,1))
            setPiecesPermanent();
        currPiece.shiftDown();;
    }
    private void pieceLeft(){
        if (!canPieceShift(0,-1))
            setPiecesPermanent();
        currPiece.shiftDown();;
    }
    private void dropPiece(){
        while (true)
            if(!pieceFall())
                return;
    }
    public void update(int timeStep, Keyboard keyboard){
        LinkedList<Integer> keystrokes = keyboard.getKeyCycle();
        cycler.increment(timeStep);
        /*
        if (!keystrokes.isEmpty())
            System.out.println("NOT EMPTY");

        if (!keystrokes.isEmpty()){
            System.out.print("KEYS: ");
            for (Integer keyCode : keystrokes)
                System.out.print(keyCode +  " ");
            System.out.println();
        }

         */
        for (Integer keyCode : keystrokes)
            inputHandler(keyCode);

        int cycles = cycler.getNumOfCycles();

        for (int i = 0; i < cycles; i++){
            pieceFall();
        }
    }
    public void inputHandler(int keyCode){
        switch (keyCode){
            case PConstants.DOWN: pieceFall(); break;
            case PConstants.LEFT: pieceLeft(); break;
            case PConstants.RIGHT: pieceRight(); break;
            case ' ': dropPiece(); break;
            default: return;
        }

    }
}

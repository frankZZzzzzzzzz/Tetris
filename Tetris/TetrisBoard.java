package Tetris;

import Application.Cycler.CycleCounter;
import Tetris.TetrisPieces.TetrisPiece;

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
    private int[][] permanentBoard;
    private int[][] fallingBoard;
    private TetrisPiece holdPiece;
    private TetrisPiece currPiece;
    private LinkedList<TetrisPiece> nextPieces;
    private CycleCounter cycler;
    public TetrisBoard(){
        permanentBoard = new int[20][10];
        fallingBoard = new int[20][10];
        holdPiece = null;
        currPiece = null;

        cycler = new CycleCounter();

        nextPieces = new LinkedList<TetrisPiece>();
        TetrisPiece[] allPieces = TetrisPiece.allPieces;

        for (int i = 0; i < 5; i++)
            nextPieces.add(allPieces[(int)(Math.random()*allPieces.length)]);
        placeUpcomingPiece();
    }
    private void placePieceAtTop(TetrisPiece piece){
        currPiece = piece;
        int[][] piecePlacement = currPiece.getPlacement();
        for (int r = 0; r < piecePlacement.length; r++)
            for (int c = 0; c < piecePlacement[r].length; c++)
                fallingBoard[19-r][4-(piecePlacement[r].length-1)/2+c] = piecePlacement[r][c];
    }
    public void clearFallingBoard(){
        fallingBoard = new int[20][10];
    }
    public void clearPermanentBoard(){
        permanentBoard = new int[20][10];
    }
    public void reset(){
        clearPermanentBoard();
        clearFallingBoard();
        holdPiece = null;
        currPiece = null;

        nextPieces = new LinkedList<TetrisPiece>();
        TetrisPiece[] allPieces = TetrisPiece.allPieces;

        for (int i = 0; i < 5; i++)
            nextPieces.add(allPieces[(int)(Math.random()*allPieces.length)]);
        placeUpcomingPiece();
    }
    public int[][][] getBoard(){
        return (new int[][][]{fallingBoard,permanentBoard});
    }
    private void placeUpcomingPiece(){
        TetrisPiece[] allPieces = TetrisPiece.allPieces;
        nextPieces.add(allPieces[(int)(Math.random()*allPieces.length)]);
        placePieceAtTop(nextPieces.removeFirst());
    }
    private void switchHold(){
        if (holdPiece == null){
            clearFallingBoard();
            holdPiece = currPiece;
            placeUpcomingPiece();
        }
        else{
            clearFallingBoard();
            TetrisPiece temp = holdPiece;
            holdPiece = currPiece;

            placePieceAtTop(temp);
        }
    }
    private void setPiecesPermanent(){
        for (int r = 0; r < fallingBoard.length; r++)
            for (int c = 0; c < fallingBoard[r].length; c++)
                if (fallingBoard[r][c] != 0)
                    permanentBoard[r][c] = fallingBoard[r][c];
    }
    private void pieceFall(){
        for (int c = 0; c < fallingBoard[0].length; c++)
            if (fallingBoard[0][c] != 0){
                setPiecesPermanent();
                clearFallingBoard();
                placeUpcomingPiece();
                return;
            }
        for (int r = 1; r < fallingBoard.length; r++)
            for (int c = 0; c < fallingBoard[r].length; c++)
                if (fallingBoard[r][c] != 0 && permanentBoard[r-1][c] != 0){
                    setPiecesPermanent();
                    clearFallingBoard();
                    placeUpcomingPiece();
                    return;
                }
        for (int r = 1; r < fallingBoard.length; r++)
            fallingBoard[r-1] = fallingBoard[r];
        fallingBoard[fallingBoard.length-1] = new int[fallingBoard[0].length];
    }
    public void update(int timeStep){
        cycler.increment(timeStep);

        int cycles = cycler.getNumOfCycles();

        for (int i = 0; i < cycles; i++){
            pieceFall();
        }
    }

    public TetrisPiece getHoldPiece() {
        return holdPiece;
    }
    public TetrisPiece getCurrPiece() {
        return currPiece;
    }
    public LinkedList<TetrisPiece> getNextPieces() {
        return nextPieces;
    }
}

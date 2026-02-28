package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class SPiece extends TetrisPiece{
    public SPiece(){
        color = UsefulFunctions.color(0,255,0);
        positions = new int[][]{{19,5},{19,6},{18,4},{18,5}};
    }
    public void reset(){
        positions = new int[][]{{19,5},{19,6},{18,4},{18,5}};
    }
}

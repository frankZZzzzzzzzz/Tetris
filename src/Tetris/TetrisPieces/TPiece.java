package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class TPiece extends TetrisPiece{
    public TPiece(){
        color = UsefulFunctions.color(255,0,255);
        positions = new int[][]{{19,4},{19,5},{19,6},{18,5}};
    }
    public void reset(){
        positions = new int[][]{{19,4},{19,5},{19,6},{18,5}};
    }
}

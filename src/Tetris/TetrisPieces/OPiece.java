package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class OPiece extends TetrisPiece{
    public OPiece(){
        color = UsefulFunctions.color(255,255,0);
        positions = new int[][]{{19,4},{19,5},{18,4},{18,4}};
    }
    public void reset(){
        positions = new int[][]{{19,4},{19,5},{18,4},{18,4}};
    }
}

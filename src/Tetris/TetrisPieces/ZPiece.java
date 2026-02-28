package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class ZPiece extends TetrisPiece{
    public ZPiece(){
        color = UsefulFunctions.color(255,0,0);
        positions = new int[][]{{19,4},{19,5},{18,5},{18,4}};
    }
    public void reset(){
        positions = new int[][]{{19,4},{19,5},{18,5},{18,4}};
    }
}

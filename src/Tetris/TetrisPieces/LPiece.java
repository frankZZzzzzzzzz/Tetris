package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class LPiece extends TetrisPiece{
    public LPiece(){
        color = UsefulFunctions.color(255,165,0);
        positions = new int[][]{{19,6},{18,6},{18,5},{18,4}};
    }
    public void reset(){
        positions = new int[][]{{19,6},{18,6},{18,5},{18,4}};
    }
}

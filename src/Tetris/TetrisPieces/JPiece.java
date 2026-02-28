package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class JPiece extends TetrisPiece{
    public JPiece(){
        color = UsefulFunctions.color(0,0,255);
        positions = new int[][]{{19,4},{18,4},{18,5},{18,6}};
    }
    public void reset(){
        positions = new int[][]{{19,4},{18,4},{18,5},{18,6}};
    }
}

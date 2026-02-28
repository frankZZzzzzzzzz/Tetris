package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class IPiece extends TetrisPiece{
    public IPiece(){
        color = UsefulFunctions.color(0,255,255);
        positions = new int[][]{{19,3},{19,4},{19,5},{19,6}};
    }
    public void reset(){
        positions = new int[][]{{19,3},{19,4},{19,5},{19,6}};
    }
}

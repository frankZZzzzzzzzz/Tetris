package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class IPiece extends TetrisPiece{
    public IPiece(){
        color = UsefulFunctions.color(0,255,255);
        placement = new int[][]{{color,color,color,color}};
    }
}

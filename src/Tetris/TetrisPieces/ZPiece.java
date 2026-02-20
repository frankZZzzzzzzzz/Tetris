package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class ZPiece extends TetrisPiece{
    public ZPiece(){
        color = UsefulFunctions.color(255,0,0);
        placement = new int[][]{{color,color,placeHolder},{placeHolder,color,color}};
    }
}

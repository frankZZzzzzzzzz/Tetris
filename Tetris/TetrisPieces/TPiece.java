package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class TPiece extends TetrisPiece{
    public TPiece(){
        color = UsefulFunctions.color(255,0,255);
        placement = new int[][]{{color,color,color},{placeHolder,color,placeHolder}};
    }
}

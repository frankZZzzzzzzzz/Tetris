package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class SPiece extends TetrisPiece{
    public SPiece(){
        color = UsefulFunctions.color(0,255,0);
        placement = new int[][]{{placeHolder,color,color},{color,color,placeHolder}};
    }
}

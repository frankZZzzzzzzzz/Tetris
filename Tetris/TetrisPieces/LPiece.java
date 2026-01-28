package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class LPiece extends TetrisPiece{
    public LPiece(){
        color = UsefulFunctions.color(255,165,0);
        placement = new int[][]{{placeHolder,placeHolder,color},{color,color,color}};
    }
}

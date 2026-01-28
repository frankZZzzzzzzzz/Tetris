package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class OPiece extends TetrisPiece{
    public OPiece(){
        color = UsefulFunctions.color(255,255,0);
        placement = new int[][]{{color,color},{color,color}};
    }
}

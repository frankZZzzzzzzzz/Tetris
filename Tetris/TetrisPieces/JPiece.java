package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

public class JPiece extends TetrisPiece{
    public JPiece(){
        color = UsefulFunctions.color(0,0,255);
        placement = new int[][]{{color,placeHolder,placeHolder},{color,color,color}};
    }
}

package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Objects;

/*
0 - I piece (Cyan - 0,255,255)
1 - L piece (Orange - 255,165,0)
2 - J piece (Blue - 0,0,255)
3 - S piece (Green - 0,255,0)
4 - Z piece (Red - 255,0,0)
5 - T piece (Purple - 255,0,255)
6 - O piece (Yellow - 255,255,0)
 */

public abstract class TetrisPiece {
    public static final TetrisPiece[] allPieces = allTetrisPieces();
    protected final int placeHolder = UsefulFunctions.color(0,0,0,0);
    protected int color;
    protected int[][] placement;
    public int getColor(){
        return (color);
    }
    public int[][] getPlacement(){
        return (placement);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this)
            return (true);
        return (other instanceof TetrisPiece &&
                ((TetrisPiece)other).color == color &&
                Arrays.deepEquals(((TetrisPiece)other).placement, placement));
    }

    private static TetrisPiece[] allTetrisPieces(){
        return (new TetrisPiece[]{new IPiece(), new LPiece(), new JPiece(), new SPiece(), new ZPiece(), new TPiece(), new OPiece()});
    }
}

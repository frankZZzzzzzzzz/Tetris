package Tetris.TetrisPieces;

import Tetris.UsefulFunctions;

import java.util.Arrays;

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
    protected final int placeHolder = UsefulFunctions.color(0,0,0,0);
    public static TetrisPiece random(){
        switch((int)(Math.random()*7)){
            case 0: return (new IPiece());
            case 1: return (new LPiece());
            case 2: return (new JPiece());
            case 3: return (new SPiece());
            case 4: return (new ZPiece());
            case 5: return (new TPiece());
            default: return (new OPiece());
        }
    }

    protected int[][] positions;
    protected int color;
    @Override
    public boolean equals(Object other) {
        if (other == this)
            return (true);
        return (other instanceof TetrisPiece &&
                ((TetrisPiece)other).color == color &&
                Arrays.deepEquals(((TetrisPiece)other).positions, positions));
    }
    public int[][] getRotateClockWise(){
        int[][] rotated = new int[positions.length][2];
        int r = 0;
        int c = 0;
        for (int[] position: positions){
            r += position[0];
            c += position[1];
        }
        r /= positions.length;
        c /= positions.length;
        for (int i = 0; i < positions.length; i++){
            rotated[i][0] = (positions[i][1]-c) + c;
            rotated[i][1] = -(positions[i][0]-r) + r;
        }
        return (rotated);
    }
    public int[][] getRotateCounterClockWise(){
        int[][] rotated = new int[positions.length][2];
        int r = 0;
        int c = 0;
        for (int[] position: positions){
            r += position[0];
            c += position[1];
        }
        r /= positions.length;
        c /= positions.length;
        for (int i = 0; i < positions.length; i++){
            rotated[i][0] = -(positions[i][1]-c) + c;
            rotated[i][1] = (positions[i][0]-r) + r;
        }
        return (rotated);
    }
    public int[][] getRotate180(){
        int[][] rotated = new int[positions.length][2];
        int r = 0;
        int c = 0;
        for (int[] position: positions){
            r += position[0];
            c += position[1];
        }
        r /= positions.length;
        c /= positions.length;
        for (int i = 0; i < positions.length; i++){
            rotated[i][0] = -(positions[i][1]-c) + c;
            rotated[i][1] = -(positions[i][0]-r) + r;
        }
        return (rotated);
    }
    public abstract void reset();
    public int getColor(){
        return (color);
    }
    public int[][] getPositons(){
        return (positions);
    }
    public void shiftDown(){
        for (int[] position: positions)
            position[0]--;
    }
    public void shiftRight(){
        for (int[] position: positions)
            position[1]++;
    }
    public void shiftLeft(){
        for (int[] position: positions)
            position[1]--;
    }
}

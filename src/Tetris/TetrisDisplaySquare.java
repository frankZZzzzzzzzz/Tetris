package Tetris;

import Tetris.TetrisPieces.TetrisPiece;
import processing.core.PApplet;

public class TetrisDisplaySquare extends Box{
    protected TetrisBox[][] grid;
    protected TetrisPiece currPiece;
    public TetrisDisplaySquare(int xPos, int yPos, int width, int height, TetrisPiece piece){
        super(xPos,yPos,width,height,UsefulFunctions.color(0,0,0));

        updatePiece(piece);

    }
    private void updatePieceColors(TetrisPiece newPiece){
        int[][] currPiece = newPiece.getPlacement();
        for (int r = 0; r < currPiece.length; r++)
            for (int c = 0; c < currPiece[r].length; c++)
                grid[r][c].color = currPiece[r][c];
    }
    public void updatePiece(TetrisPiece newPiece){
        if (currPiece == null || currPiece.equals(newPiece))
            return;

        currPiece = newPiece;

        int[][] currPiecePlacement = newPiece.getPlacement();
        if (currPiecePlacement.length == grid.length && currPiecePlacement[0].length == grid[0].length){
            updatePieceColors(newPiece);
            return;
        }

        //ResizeGrid
        grid = new TetrisBox[currPiecePlacement.length][currPiecePlacement[0].length];

        int offset = (int)(Math.min(width,height)*.1f);
        int YRatio = grid[0].length/grid.length;
        int boxSize = ((height-2*offset) > (YRatio*(width-2*offset))) ? (width-2*offset)/grid[0].length : (height-2*offset)/grid.length;
        int boxXPos = xPos+width/2-grid[0].length/2*boxSize;
        int boxYPos = yPos+height/2-grid.length/2*boxSize;

        for (int r = 0; r < grid.length; r++, boxYPos += boxSize)
            for (int c = 0; c < grid[r].length; c++, boxXPos += boxSize)
                grid[r][c] = new TetrisBox(boxXPos,boxYPos,boxSize,boxSize,currPiecePlacement[r][c]);
    }
    public void draw(PApplet pa){
        super.draw(pa);

        if (grid == null)
            return;

        for (TetrisBox[] row : grid)
            for (TetrisBox box : row)
                box.draw(pa);
    }
}

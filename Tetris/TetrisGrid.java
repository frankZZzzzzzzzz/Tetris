package Tetris;

import processing.core.PApplet;

public class TetrisGrid {
    protected PApplet currPA;
    protected int xPos;
    protected int yPos;
    protected int width;
    protected int height;
    protected TetrisBox[][] grid;
    protected TetrisBoard board;
    protected int Timer;
    public TetrisGrid(int xPos, int yPos, int width, int height, TetrisBoard board, PApplet pa){
        currPA = pa;
        this.xPos = xPos;
        this.yPos = yPos;
        this.board = board;
        grid = new TetrisBox[20][10];
        Timer = 0;

        int boxWidth = width/10;
        int boxHeight = height/20;

        for (int r = 0, currYPos = yPos + height - boxHeight; r < 20; r++, currYPos -= boxHeight)
            for (int c = 0, currXPos = xPos; c < 10; c++, currXPos += boxWidth)
                grid[r][c] = new TetrisBox(currXPos,currYPos,boxWidth,boxHeight);

        this.width = boxWidth*10;
        this.height = boxHeight*20;
    }
    public void setCenter(int xCenter, int yCenter, int width, int height, int xRatio, int yRatio){

    }
    public void setCurrPA(PApplet pa){
        currPA = pa;
    }
    private void drawBlackBackground(){
        currPA.stroke(UsefulFunctions.color(255,255,255));
        currPA.fill(0);
        currPA.rect(xPos,yPos,width,height);
    }
    private void drawTetrisGrid(){
        int[][][] currBoard = board.getBoard();
        for (int r = 0; r < 20; r++)
            for (int c = 0; c < 10; c++){
                grid[r][c].draw(currPA, currBoard[0][r][c] != 0 ? currBoard[0][r][c]: currBoard[1][r][c]);
            }
    }
    private void drawWhiteOutline(){
        int boxWidth = width/10;
        int boxHeight = height/20;
        currPA.stroke(0x70ffffff);

        for (int currY = yPos; currY <= yPos+height; currY += boxHeight)
            currPA.line(xPos,currY,xPos+width,currY);

        for (int currX = xPos; currX <= xPos+width; currX += boxWidth)
            currPA.line(currX,yPos,currX,yPos+height);
    }
    public void draw(){
        drawBlackBackground();
        drawTetrisGrid();
        drawWhiteOutline();
    }
}

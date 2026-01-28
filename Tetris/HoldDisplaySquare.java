package Tetris;

import processing.core.PApplet;

public class HoldDisplaySquare extends TetrisDisplaySquare{
    private PApplet currPA;
    private TetrisBoard board;
    public HoldDisplaySquare(int xPos, int yPos, int width, int height, TetrisBoard board, PApplet pa){
        super(xPos, yPos, width, height, null);
    }
    public void update(){
        updatePiece(board.getHoldPiece());
    }
    public void draw(PApplet pa){
        super.draw(currPA);
    }
}

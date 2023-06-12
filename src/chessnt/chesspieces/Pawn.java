package chessnt.chesspieces;

import chessnt.Chessnt;
import chessnt.LogicClasses.Piece;
import chessnt.StyleClasses.StyleManager;
/**
 * Pawn Class representing a piece that replaces the Pawn in Chessn't.
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.1.0
 */
public class Pawn extends Piece {

    int row;
    int column;

    public Pawn(int[] position, boolean isWhite) {
        super(position, isWhite);

        this.row = position[0];
        this.column = position[1];
        
        System.out.println("new serf being created at + " + row + "," + column);
        Chessnt.CellList[row][column].setBackground(StyleManager.WHITE);
        Chessnt.board.set(row, column, this); // this is fine as this is the last
        //line and the serf peice is already fully constructed
    }

    @Override
    public void Move(int[] location) {
        System.out.println("movign!");
        int locationRow = location[0];
        int locationColumn = location[1];
        System.out.println(row + ", " + column + " moving to " + locationRow + "," + locationColumn);
        Chessnt.board.set(row,column, null);
        // bet you've never seen a CS30S student write a line like this before!
        // actually, you probably have, i'm not the only show-off.
        Chessnt.CellList[row][column].setBackground((row + column) % 2 == 0 ?
                StyleManager.lightCell : StyleManager.darkCell);
        Chessnt.board.set(locationRow,locationColumn, this);
        Chessnt.CellList[locationRow][locationColumn].setBackground(StyleManager.WHITE);
        Chessnt.currentlySelectedPiece = null;
        
        row = locationRow;
        column = locationColumn;
    }

    @Override
    public void getCaptured() {
        //dispose of this
        //add to the player's score 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isValidMove(int[] location) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

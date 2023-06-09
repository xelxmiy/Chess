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

    final int row;
    final int column;

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
        System.out.println(row + ", " + column + " moving to " + location[0] + "," + location[1]);
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

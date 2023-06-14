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

    int[][] validLightMoves = {{-1, 0}, {-2, 0}};
    int[][] validDarkMoves = {{1, 0}, {2, 0}};
    
    public Pawn(int row, int column, boolean isWhite) {
        super(row, column , isWhite);

        this.row = row;
        this.column = column;

        System.out.println("new serf being created at + " + row + "," + column);
        Chessnt.CellList[row][column].setBackground(StyleManager.WHITE);
    }
    @Override
    /**
     * Logic for moving the pieces.
     *
     * @param moveRow the row of the location to move the piece
     * @param moveColumn the column of the location to move the piece
     */
    public void Move(int moveRow, int moveColumn) {
        if (isValidMove(moveRow, moveColumn)) {

            Chessnt.board.set(row, column, null);

            Chessnt.CellList[row][column].setBackground((row + column) % 2 == 0
                    ? StyleManager.lightCell : StyleManager.darkCell);

            Chessnt.board.set(moveRow, moveColumn, this);

            Chessnt.CellList[moveRow][moveColumn].setBackground(StyleManager.WHITE);

            Chessnt.currentlySelectedPiece = null;

            row = moveRow;
            column = moveColumn;
        }
    }

    @Override
    public void getCaptured() {
        //dispose of this
        //add to the player's score 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    /**
     * validates that the square the piece is moving to isn't the same color as
     * this piece and that it's a valid square for this piece to move to
     */
    public boolean isValidMove(int moveRow, int moveColumn) {
        //boolean locationIsValid = false;
        //int[][] validMoves = isWhite ? validLightMoves : validDarkMoves;
        //normally i'd use a for loop to iterate through the valid moves, but given
        // that a pawn only has two options to move (unless it's capturing) 
        //i'll just check them both (all 4?) manually 
        //if()
        
        //return locationIsValid;
        return true;
    }

}

package chessnt.LogicClasses;

import chessnt.Chess;
import chessnt.StyleClasses.StyleManager;

/**
 * Abstract <code>Piece</code> class representing a Chess piece.
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.0.1
 */
public abstract class Piece {

    /**
     * the row the piece is on. equiviliant to position[0]
     */
    public int row;
    /**
     * the column the piece is on. equiviliant to position[1]
     */
    public int column;
    /**
     * weather or not the given piece is "white" and goes first.
     */
    public boolean isWhite;

    /**
     * weather or not the given move at a location is valid
     *
     * @param moveRow the row of the location to move the piece
     * @param moveColumn the column of the location to move the piece
     * @return returns if the location the piece wants to move to is valid
     */
    public abstract boolean isValidMove(int moveRow, int moveColumn);

    /**
     * moves the pieces to a location
     *
     * @param moveRow the row of the location to move the piece
     * @param moveColumn the column of the location to move the piece
     */
    public void Move(int moveRow, int moveColumn) {
        if (isValidMove(moveRow, moveColumn)) {

            Chess.board.set(row, column, null);

            Chess.CellList[row][column].setBackground((row + column) % 2 == 0
                    ? StyleManager.lightCell : StyleManager.darkCell);

            Chess.board.set(moveRow, moveColumn, this);

            Chess.CellList[moveRow][moveColumn].setBackground(StyleManager.WHITE);
 
            row = moveRow;
            column = moveColumn;
        }
        
        Chess.currentlySelectedPiece = null;
        
    }

    /**
     * what occurs when the given piece gets captured
     */
    public abstract void getCaptured();

    /**
     * Creates a chess pieces
     *
     * @param row the row of the piece
     * @param column the column of the piece
     * @param isWhite weather or not the piece is white and goes first.
     */
    public Piece(int row, int column, boolean isWhite) {
        this.row = row;
        this.column = column;
        this.isWhite = isWhite;
    }
}

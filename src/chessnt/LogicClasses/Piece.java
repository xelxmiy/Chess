package chessnt.LogicClasses;

import chessnt.Chess;
import javax.swing.ImageIcon;

/**
 * Abstract <code>Piece</code> class representing a Chess piece.
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.1.1
 */
public abstract class Piece {

    /**
     * the row the piece is on
     */
    public int row;

    /**
     * the column the piece is on
     */
    public int column;

    /**
     * weather or not the given piece is "white" and goes first.
     */
    // this *could* technically be final but java's style is terrible 
    // but this is technically not breaking the style guidlines :)
    public boolean isLight;

    /**
     * The icon of this piece
     */
    public ImageIcon pieceIcon;

    /**
     * validates that the square the piece is moving to isn't the same color as
     * this piece and that it's a valid square for this piece to move to
     *
     * @param moveRow the row the piece wants to move to
     * @param moveColumn the column the piece wants to move to
     * @return returns if the move the piece wants to make is an allowed
     * location
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

            Chess.CellList[row][column].setIcon(null);

            Chess.board.set(moveRow, moveColumn, this);

            Chess.CellList[moveRow][moveColumn].setImage(pieceIcon);

            row = moveRow;
            column = moveColumn;

            Chess.lightsTurn = !Chess.lightsTurn;
        }

        Chess.currentlySelectedPiece = null;
    }

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
        this.isLight = isWhite;
    }
}

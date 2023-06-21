package chess.chesspieces;

import chess.Chess;
import chess.Forms.GameFrame;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Pawn that moves forward and takes diagonally 1 square
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.1.5
 */
public class Pawn extends Piece {

    final int startingRow;

    private int direction;

    public Pawn(int row, int column, boolean isWhite) {
        super(row, column, isWhite);

        this.row = row;
        this.column = column;

        direction = isWhite ? -1 : 1;

        startingRow = row;

        this.pieceIcon = isWhite ? StyleManager.lightPawnImg : StyleManager.darkPawnImg;

        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    public void move(int moveRow, int moveColumn) {
        super.move(moveRow, moveColumn);
        if (moveRow == 7 || moveRow == 0) {
            Chess.gameIsRunning = false;
            GameFrame.makePromotionButtonsVisible(moveRow, moveColumn);
        }
    }

    @Override
    public boolean isValidMove(int moveRow, int moveColumn) {
        //normally i'd use a for loop to iterate through the valid moves, but given
        // that a pawn only has two options to move (unless it's capturing) 
        //i'll just check them both (all 4?) manually 
        // update: this was a mistake.

        //checks that the pawn isn't moving to the same square, skipping a turn.
        if (moveRow == row && moveColumn == column) {
            return false;
        }
        //the nesting in this project is killing me, 4 if's? really?
        //double move on first move
        if (moveRow == (row + (2 * direction))) {
            if (row == startingRow) {
                if (moveColumn == column) {
                    //checks that there's nothing in the way
                    if (Chess.board.get(moveRow, moveColumn) == null
                            && Chess.board.get(moveRow + (-1 * direction), moveColumn) == null) {
                        return true;
                    }
                }
            }
        }
        //checks that the pawn is moving forwards
        if (moveRow == (row + (1 * direction))) {
            //checks that the pawn is moving directly forward, and NOT capturing
            if (moveColumn == column) {
                if (Chess.board.get(moveRow, moveColumn) == null) {
                    return true;
                }
            }
            //checks that the pawn is capturing one square diagonally
            if (moveColumn == (column + 1) || moveColumn == (column - 1)) {
                if (Chess.board.get(moveRow, moveColumn) != null
                        && Chess.board.get(moveRow, moveColumn).isLight != isLight) {
                    return true;
                }
            }
        }
        return false;
    }
}

package chess.chesspieces;

import chess.Chess;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Queen piece that moves like a combination of the rook and bishop
 *
 * @author Adam Belski
 * @since 17-Jun-2023
 * @version 1.0.0
 */
public class Queen extends Piece {

    public Queen(int row, int column, boolean isWhite) {

        super(row, column, isWhite);

        this.row = row;
        this.column = column;

        this.pieceIcon = isWhite
                ? StyleManager.lightQueenImg : StyleManager.darkQueenImg;

        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    public boolean isValidMove(int moveRow, int moveColumn) {

        int verticalDirection = row > moveRow ? -1 : 1;
        int horizontalDirection = column > moveColumn ? -1 : 1;

        //check to prevent the knight capturing one of it's own pieces
        if (Chess.board.get(moveRow, moveColumn) != null) {
            if (Chess.board.get(moveRow, moveColumn).isLight == isLight) {
                return false;
            }
        }

        //checks if the piece is moving to the same square, skipping a turn
        if (moveRow == row && moveColumn == column) {
            return false;
        }

        try {
            if ((row - moveRow) / (column - moveColumn) == 1
                    || (row - moveRow) / (column - moveColumn) == -1) {
                // checks that there's no pieces in-between where the queen wants to go
                int j = column + horizontalDirection;
                for (int i = (row + verticalDirection); i != moveRow; i += verticalDirection) {
                    if (Chess.board.get(i, j) != null) {
                        return false;
                    }
                    j += horizontalDirection;
                }
            }
        } catch (ArithmeticException ae) {
            // this occurs if you try to move the bishop directly up or down.
        }

        // checks if the queen is moving not into the same column or row
        if ((moveRow == row || moveColumn == column)) {
            // checks that there's no pieces in-between where the queen wants to go
            if (moveRow == row) {
                int direction = moveColumn > column ? 1 : -1;
                for (int i = (column + direction); i != moveColumn; i += direction) {
                    if (Chess.board.get(row, i) != null) {
                        return false;
                    }
                }
            }
            // checks that there's no pieces in-between where the queen wants to go
            if (moveColumn == column) {
                int direction = moveRow > row ? 1 : -1;
                for (int i = (row + direction); i != moveRow; i += direction) {
                    if (Chess.board.get(i, column) != null) {
                        return false;
                    }
                }
            }
        }
        //checks that the queen is either moving like a rook or like a bishop
        try {
            if (!(moveRow == row
                    || moveColumn == column
                    || (row - moveRow) / (column - moveColumn) == 1
                    || (row - moveRow) / (column - moveColumn) == -1)) {
                return false;
            }
        } catch (ArithmeticException ae) {
            // technically this is the same as moveColumn == column
            return true;
        }
        
        return true;
    }

}

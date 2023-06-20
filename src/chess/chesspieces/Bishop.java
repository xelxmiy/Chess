package chess.chesspieces;

import chess.Chess;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Bishop that moves on the diagonals
 *
 * @author Adam Belski
 * @since 17-Jun-2023
 * @version 1.1.0
 */
public class Bishop extends Piece {

    public Bishop(int row, int column, boolean isWhite) {
        super(row, column, isWhite);

        this.row = row;
        this.column = column;

        this.pieceIcon = isWhite
                ? StyleManager.lightBishopImg : StyleManager.darkBishopImg;

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
            if (!((row - moveRow) / (column - moveColumn) == 1
                    || (row - moveRow) / (column - moveColumn) == -1)) {
                return false;
            }
        } catch (ArithmeticException ae) {
            return false;
            // this occurs if you try to move the bishop directly up or down.
        }
        
        //this code worked second try, i'm very proud
        // checks that there's no pieces in-between where the bishop wants to go
        int j = column + horizontalDirection;
        for (int i = (row + verticalDirection); i != moveRow; i += verticalDirection) {
            if (Chess.board.get(i, j) != null) {
                return false;
            }
            j += horizontalDirection;
        }
        return true;
    }

}

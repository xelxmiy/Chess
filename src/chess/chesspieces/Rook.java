package chess.chesspieces;

import chess.Chess;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Rook Class moves in the same file or row
 *
 * @author Adam Belski
 * @since 16-Jun-2023
 * @version 1.2.1
 */
public class Rook extends Piece {

    public Rook(int row, int column, boolean isWhite) {
        super(row, column, isWhite);

        this.row = row;
        this.column = column;

        this.pieceIcon = isWhite
                ? StyleManager.lightRookImg : StyleManager.darkRookImg;

        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    public boolean isValidMove(int moveRow, int moveColumn) {
        
        if (King.isCastling) {
            return true;
        }

        //check to prevent the rook capturing one of it's own pieces
        if (Chess.board.get(moveRow, moveColumn) != null) {
            if (Chess.board.get(moveRow, moveColumn).isLight == isLight) {
                return false;
            }
        }
        // checks if the rook is moving not into the same column or row
        if (!(moveRow == row || moveColumn == column)) {
            return false;
        }
        //checks if the piece is moving to the same square, skipping a turn
        if (moveRow == row && moveColumn == column) {
            return false;
        }
        // checks that there's no pieces in-between where the rook wants to go
        if (moveColumn == column) {
            int direction = moveRow > row ? 1 : -1;
            for (int i = (row + direction); i != moveRow; i += direction) {
                if (Chess.board.get(i, column) != null) {
                    return false;
                }
            }
        }

        // checks that there's no pieces in-between where the rook wants to go
        if (moveRow == row) {
            int direction = moveColumn > column ? 1 : -1;
            for (int i = (column + direction); i != moveColumn; i += direction) {
                if (Chess.board.get(row, i) != null) {
                    return false;
                }
            }
        }
        return true;
    }
}

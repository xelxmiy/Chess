package chess.chesspieces;

import chess.Chess;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Bishop that moves on the diagonals
 *
 * @author Adam Belski
 * @since 17-Jun-2023
 * @version 1.2.1
 */
public class King extends Piece {

    public static boolean isCastling = false;

    private final int LONG_CASTLE_COLUMN = 2;
    private final int SHORT_CASTLE_COLUMN = 6;
    private final int BACKROW = isLight ? Chess.LIGHT_BACKROW : Chess.DARK_BACKROW;

    private static final int[][] VALID_MOVES = {
        {-1, -1}, {-1, 0}, {-1, +1},
        {0, -1}, {0, +1},
        {+1, -1}, {+1, 0}, {+1, +1}};

    public King(int row, int column, boolean isWhite) {

        super(row, column, isWhite);

        this.row = row;
        this.column = column;

        this.pieceIcon = isWhite
                ? StyleManager.lightKingImg : StyleManager.darkKingImg;

        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    public boolean isValidMove(int moveRow, int moveColumn) {

        if (isCastling) {
            return true;
        }

        if (!hasMoved) {
            if (moveRow == BACKROW
                    && (moveColumn == LONG_CASTLE_COLUMN
                    || moveColumn == SHORT_CASTLE_COLUMN)) {
                final int ROOK_COLUMN = moveColumn == SHORT_CASTLE_COLUMN ? 7 : 0;
                if (Chess.board.get(moveRow, ROOK_COLUMN) != null) {
                    if (!Chess.board.get(moveRow, ROOK_COLUMN).hasMoved) {
                        int direction = moveColumn > column ? 1 : -1;
                        for (int i = (column + direction); i != moveColumn; i += direction) {
                            if (Chess.board.get(row, i) != null) {
                                return false;
                            }
                        }
                        castle(moveColumn == SHORT_CASTLE_COLUMN ? SHORT_CASTLE_COLUMN : LONG_CASTLE_COLUMN);
                    }
                    return false;
                }
                return false;
            }
        }
        //check to prevent the king capturing one of it's own pieces
        if (Chess.board.get(moveRow, moveColumn) != null) {
            if (Chess.board.get(moveRow, moveColumn).isLight == isLight) {
                return false;
            }
        }

        //checks if the piece is moving to the same square, skipping a turn
        if (moveRow == row && moveColumn == column) {
            return false;
        }
        //checks if the location is one of the valid king moves
        for (int[] validMove : VALID_MOVES) {
            if (moveRow == (row + validMove[0]) && (moveColumn == (column + validMove[1]))) {
                return true;
            }
        }
        return false;
    }
    /**
     * Castles the king 
     * 
     * @param kingColumn  the column the king is castling into
     */
    private void castle(int kingColumn) {
        isCastling = true;
        this.move(row, kingColumn);
        Chess.board.get(row, kingColumn
                + (kingColumn == SHORT_CASTLE_COLUMN ? 1 : -2))
                .move(row, kingColumn
                        + (kingColumn == SHORT_CASTLE_COLUMN ? -1 : +1));
        Chess.lightsTurn = !Chess.lightsTurn;
        isCastling = false;
    }

}

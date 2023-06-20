package chess.chesspieces;

import chess.Chess;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Bishop that moves on the diagonals
 *
 * @author Adam Belski
 * @since 17-Jun-2023
 * @version 1.0.0
 */
public class King extends Piece {

    public static boolean isInCheck = false;

    private static int[][] validMoves = {
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
        for (int[] validMove : validMoves) {
            if (moveRow == (row + validMove[0]) && (moveColumn == (column + validMove[1]))) {
                return true;
            }
        }
        return false ;
    }

}

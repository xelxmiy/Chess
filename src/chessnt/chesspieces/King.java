package chessnt.chesspieces;

import chessnt.Chess;
import chessnt.LogicClasses.Piece;
import chessnt.StyleClasses.StyleManager;

/**
 * Bishop that moves on the diagonals
 *
 * @author Adam Belski
 * @since 17-Jun-2023
 * @version 1.0.0
 */
public class King extends Piece {
    
    public static boolean isInCheck = false;
    
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
        return true;
    }
    
}

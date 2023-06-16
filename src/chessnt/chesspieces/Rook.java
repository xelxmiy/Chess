package chessnt.chesspieces;

import chessnt.Chess;
import chessnt.LogicClasses.Piece;
import chessnt.StyleClasses.StyleManager;

/**
 *
 * @author a.belski
 */
public class Rook extends Piece {

    public Rook(int row, int column, boolean isWhite) {
        super(row, column, isWhite);

        this.row = row;
        this.column = column;
        
        
        
        System.out.println("new Rook being created at + " + row + "," + column);

        this.pieceIcon = isWhite ? StyleManager.lightRookImg : StyleManager.darkRookImg;

        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    public boolean isValidMove(int moveRow, int moveColumn) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void getCaptured() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

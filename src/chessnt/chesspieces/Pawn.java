package chessnt.chesspieces;

import chessnt.Chess;
import chessnt.LogicClasses.Piece;
import chessnt.StyleClasses.StyleManager;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Pawn Class representing a piece that replaces the Pawn in Chessn't.
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.1.0
 */
public class Pawn extends Piece {

    final int startingRow;

    private final int direction;

    public Pawn(int row, int column, boolean isWhite) {
        super(row, column, isWhite);

        this.row = row;
        this.column = column;

        direction = isWhite ? -1 : 1;
        
        startingRow = row;
        
        System.out.println("new Pawn being created at + " + row + "," + column);
        
        this.pieceIcon = isWhite ? StyleManager.lightPawnImg : StyleManager.darkPawnImg;
        
        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    /**
     * validates that the square the piece is moving to isn't the same color as
     * this piece and that it's a valid square for this piece to move to
     *
     * @param moveRow the row the piece wants to move to
     * @param moveColumn the column the piece wants to move to
     * @return returns if the move the piece wants to make is an allowed
     * location
     */
    public boolean isValidMove(int moveRow, int moveColumn) {
        //normally i'd use a for loop to iterate through the valid moves, but given
        // that a pawn only has two options to move (unless it's capturing) 
        //i'll just check them both (all 4?) manually 
        // update: this was a mistake.
        if (moveRow == (row + (2 * direction))) {
            if (row == startingRow) {
                if (moveColumn == column) {
                    if (Chess.board.get(moveRow, moveColumn) == null
                            && Chess.board.get(moveRow + (-1 * direction), moveColumn) == null) {
                        return true;
                    }
                }
            }
        }
        if (moveRow == (row + (1 * direction))) {
            if (moveColumn == column) {
                if (Chess.board.get(moveRow, moveColumn) == null) {
                    return true;
                }
            }
            if (moveColumn == (column + 1) || moveColumn == (column - 1)) {
                if (Chess.board.get(moveRow, moveColumn) != null
                        && Chess.board.get(moveRow, moveColumn).isWhite != isWhite) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public void getCaptured() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

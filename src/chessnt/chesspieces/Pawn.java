package chessnt.chesspieces;

import chessnt.Chessnt;
import chessnt.LogicClasses.Piece;
import chessnt.StyleClasses.StyleManager;

/**
 * Pawn Class representing a piece that replaces the Pawn in Chessn't.
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.1.0
 */
public class Pawn extends Piece {

    int row;
    int column;

    int[][] validLightMoves = {{-1, 0}, {-2, 0}, {-1, 1}, {-1, -1}};
    int[][] validDarkMoves = {{1, 0}, {2, 0}, {1, -1}, {1, 1}};

    public Pawn(int[] position, boolean isWhite) {
        super(position, isWhite);

        this.row = position[0];
        this.column = position[1];

        System.out.println("new serf being created at + " + row + "," + column);
        Chessnt.CellList[row][column].setBackground(StyleManager.WHITE);
        Chessnt.board.set(row, column, this); // this is fine as this is the last
        //line and the serf peice is already fully constructed
    }

    /**
     * Logic for moving the pieces.
     *
     * @param location where to move this piece
     */
    @Override
    //having this class be in the Piece class makes it not work for some reason??
    //so each piece is going to have this same code... why?? 
    //TODO: figure it out and fix it so i don't reuse the same code ~8 times
    public void Move(int[] location) {
        if (isValidMove(location)) {

            int locationRow = location[0];
            int locationColumn = location[1];

            Chessnt.board.set(row, column, null);

            // bet you've never seen a CS30S student write a line like this before!
            // actually, you probably have, i'm not the only show-off.
            Chessnt.CellList[row][column].setBackground((row + column) % 2 == 0
                    ? StyleManager.lightCell : StyleManager.darkCell);

            Chessnt.board.set(locationRow, locationColumn, this);

            Chessnt.CellList[locationRow][locationColumn].setBackground(StyleManager.WHITE);

            Chessnt.currentlySelectedPiece = null;

            row = locationRow;
            column = locationColumn;

            position = location;
        }
    }

    @Override
    public void getCaptured() {
        //dispose of this
        //add to the player's score 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean isValidMove(int[] location) {
        return true;
    }

}

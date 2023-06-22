/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.chesspieces;

import chess.Chess;
import chess.LogicClasses.Piece;
import chess.StyleClasses.StyleManager;

/**
 * Knight that moves like an L 
 *
 * @author Adam Belski
 * @since 17-Jun-2023
 * @version 1.0.0
 */
public class Knight extends Piece{
    
    public int[][] validMoves = {
        {-1,2}, {-2,1},
        {-2,-1},{-1,-2},
        {1,-2},{2,-1},
        {1,2},{2,1}};
    
    public Knight(int row, int column, boolean isWhite) {
        super(row, column, isWhite);
             
        this.row = row;
        this.column = column;

        this.pieceIcon = isWhite ?
                StyleManager.lightKnightImg : StyleManager.darkKnightImg;

        Chess.CellList[row][column].setImage(pieceIcon);
    }

    @Override
    public boolean isValidMove(int moveRow, int moveColumn) {
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
        //checks if the location is one of the valid knight movesz
        for(int[] validMove : validMoves) {
            if(moveRow == (row + validMove[0]) && (moveColumn == (column + validMove[1]))) {           
                return true;
            }
        }
        return false;
    }
    
}

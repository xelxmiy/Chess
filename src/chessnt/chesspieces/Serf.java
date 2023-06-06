package chessnt.chesspieces;

import chessnt.Piece;

/** Serf Class representing a piece that replaces the Pawn in Chessn't. 
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.0.0
 */
public class Serf extends Piece{
    
    public Serf(int[] Position, boolean isWhite){
        super(Position, isWhite);
    }
    
    @Override
    public void Move(int[] location) {
        if(isValidMove(location)){
            this.position = location;        
        }
    }

    @Override
    public void getCaptured() {
        //dispose of this
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public boolean isValidMove(int[] location) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}

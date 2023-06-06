package chessnt;

/**
 * Abstract <code>Piece</code> class representing a Chessn't piece. 
 * Can't be instantiated.
 * 
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.0.0
 */
public abstract class Piece {
    /**
     * the position of the given chess piece
     */
    public int[] position = new int[2];
    
    /**
     * weather or not the given piece is "white" and goes first.
     */
    public boolean isWhite;
    
    public abstract boolean isValidMove(int[] location);
    
    public abstract void Move(int[] location);
    
    public abstract void getCaptured();
    
    public Piece(int[] position, boolean isWhite){
        if(position.length != 2) {
            throw new ArrayIndexOutOfBoundsException("Position must be of length 2!");
        }
        this.position = position;
        this.isWhite = isWhite;
    }
}

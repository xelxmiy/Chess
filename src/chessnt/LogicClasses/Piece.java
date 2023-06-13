package chessnt.LogicClasses;
/**
 * Abstract <code>Piece</code> class representing a Chessn't piece.
 *
 * @author Adam Belski
 * @since 06-Jun-2023
 * @version 1.0.1
 */
public abstract class Piece {

    /**
     * the position of the given chess piece
     */
    public int[] position = new int[2];
    /**
     * the row the piece is on. equiviliant to position[0]
     */
    public int row;
    /**
     * the column the piece is on. equiviliant to position[1]
     */
    public int column;
    /**
     * weather or not the given piece is "white" and goes first.
     */
    public boolean isWhite;

    /**
     * weather or not the given move at a location is valid
     *
     * @param location location to check the validity of
     * @return returns if the location the piece wants to move to is valid
     */
    public abstract boolean isValidMove(int[] location);

    /**
     * moves the pieces to a location
     *
     * @param location the location to move a piece to
     */
    public abstract void Move(int[] location);

    ;
    /**
     * what occurs when the given piece gets captured
     */
    public abstract void getCaptured();

    /**
     * Piece constructor,
     *
     * @param position the position on the board this piece is being created at
     * @param isWhite weather or not the piece is white and goes first.
     */
    public Piece(int[] position, boolean isWhite) {
        if (position.length != 2) {
            throw new ArrayIndexOutOfBoundsException("Position must be of length 2!");
        }
        this.position = position;
        this.isWhite = isWhite;
    }
}

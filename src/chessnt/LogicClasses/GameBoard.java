package chessnt.LogicClasses;

/**
 * @author Adam Belski
 * @version 1.0.0
 * @since 7-Jun-2023
 */
public class GameBoard extends Matrix {
    /**
     * creates a Square GameBoard with a set size
     *
     * @param size side length of each side.
     */
    public GameBoard(int size) {
        super(size);
    }
}

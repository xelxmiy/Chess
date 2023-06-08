package chessnt.LogicClasses;

import chessnt.Chessnt;

/**
 * @author Adam Belski
 * @version 1.0.1
 * @since 7-Jun-2023
 */
public class GameBoard extends Matrix {
    
    public int[][] dangerousLightSquares = new int[Chessnt.BOARD_SIZE^2][2];
    public int[][] dangerousDarkSquares = new int[Chessnt.BOARD_SIZE^2][2];
    
    /**
     * creates a Square GameBoard with a set size
     *
     * @param size side length of each side.
     */
    public GameBoard(int size) {
        super(size);
    }
}

package chessnt;
/**
 *
 * @author Adam Belski
 * @version 1.0.0
 * @since 26-Apr-2023
 *
 */
public class Matrix {

    private boolean[][] gameBoard;

    /** creates a gameBoard with a custom size
     *
     * @param rows number of rows
     * @param columns number of columns 
     */
    public Matrix(int rows, int columns) {  
        gameBoard = new boolean[rows][columns];
    }

    /**
     * constructor which creates a square matrix
     *
     * @param size side length of the square
     */
    public Matrix(int size) {
        //tf do you mean this must be first statement in constructor, why??
        this(size, size);
    }

    /**
     * number of rows the gameBoard has
     *
     * @return number of rows the gameBoard has
     */
    public int rows() {
        return gameBoard.length;
    }
    
    /**
     * number of columns the gameBoard has
     *
     * @return number of columns the gameBoard has
     */
    public int columns() {
        return gameBoard[0].length;
    }

    /**
     * gets the value at the specified row and column of the matrix
     *
     * @param row row of value to get
     * @param column column of value to get
     * @return value at the row and column
     */
    public boolean get(int row, int column) {
        return gameBoard[row][column];
    }

    /**
     * sets thee value of a cell in the matrix to the given state
     *
     * @param row row of cell to change
     * @param column column of cell to change
     * @param state state to set the cell to
     */
    public void set(int row, int column, boolean state) {
        gameBoard[row][column] = state;
    }

}

package chess.LogicClasses;
/**
 * @author Adam Belski
 * @version 1.1.0
 * @since 26-Apr-2023
 */
public class Matrix {

    private Piece[][] gameBoard;

    /** creates a gameBoard with a custom size
     *
     * @param rows number of rows
     * @param columns number of columns 
     */
    public Matrix(int rows, int columns) {  
        gameBoard = new Piece[rows][columns];
    }

    /**
     * constructor which creates a square matrix
     *
     * @param size side length of the square
     */
    public Matrix(int size) {
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
     * gets the piece at the specified row and column of the matrix
     *
     * @param row row of value to get
     * @param column column of value to get
     * @return value at the row and column
     */
    public Piece get(int row, int column) {
        return gameBoard[row][column];
    }

    /**
     * sets thee piece at a cell in the matrix to the given state
     *
     * @param row row of cell to change
     * @param column column of cell to change
     * @param piece state to set the cell to
     */
    public void set(int row, int column, Piece piece) {
        gameBoard[row][column] = piece;
    }

}

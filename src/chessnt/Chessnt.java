/** Required package class namespace */
package chessnt;

import javax.swing.JFrame;
import chessnt.LogicClasses.*;
import chessnt.StyleClasses.Cell;

/**
 * Chessnt - Chessn't it's not chess! it's also not *not* chess. it's somewhere
 * in between. chess variation where all of the pieces don't do what the usually
 * do. bad at chess? play this, your opponent won't know what's going on and
 * neither will you!
 *
 * Note: this is not an online multiplayer game, nor does AI support. Therefore
 * to play it you require a second human in the room to do the opposing turn.
 * this is because I am lazy and don't want to make a chess AI.
 *
 * @author Adam Belski
 * @version 1.1.0
 * @since 5-Jun-2023
 */
public class Chessnt {

    public static GameBoard board;
    
    private final static int GAMEPANEL_SIZE = 720;
    
    public static final int BOARD_SIZE = 8;

    public static Cell[][] CellList;

    public Piece[] LightPieces = new Piece[Chessnt.BOARD_SIZE ^ 2];
    public Piece[] DarkPieces = new Piece[Chessnt.BOARD_SIZE ^ 2];

    public static int labelWidth;

    public static int labelHeight;

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        board = new GameBoard(BOARD_SIZE);
        JFrame frame = new GameFrame();

        CellList = new Cell[board.rows()][board.columns()];
        try {
            labelWidth = (int) GAMEPANEL_SIZE / board.columns();
            labelHeight = (int) GAMEPANEL_SIZE / board.rows();
        } catch (NullPointerException npe) {
            System.out.println("npe thrown on lines 48/49!");
        }
        for (int r = 0; r < board.rows(); ++r) {
            for (int c = 0; c < board.columns(); ++c) {
                // brackets here isolate the jlabel. then we add it
                // to the jlabel array and from now on we can only 
                // refer to this label by it's position in the array, which
                // is also it's position on the gameboard. 
                {
                    Cell label = new Cell(r, c, (r + c) % 2 == 0);
                    CellList[r][c] = label;
                }
                GameFrame.giveComponentToGameBoardPanel(CellList[r][c]);
            }
        }
        frame.setVisible(true);
    }
}

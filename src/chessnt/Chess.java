/** Required package class namespace */
package chessnt;

import javax.swing.JFrame;
import chessnt.LogicClasses.*;
import chessnt.LogicClasses.Cell;
import chessnt.StyleClasses.StyleManager;
import chessnt.chesspieces.*;

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
 * @version 1.1.1
 * @since 5-Jun-2023
 */
public class Chess {

    public static GameBoard board;

    private final static int GAMEPANEL_SIZE = 720;

    public static final int BOARD_SIZE = 8;

    public static Cell[][] CellList;

    public static int labelWidth;

    public static int labelHeight;

    public static Piece currentlySelectedPiece;

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        StyleManager.setTheme("Default");
        if (board == null) {
            board = new GameBoard(BOARD_SIZE);
        }
        PlayGame();
    }

    public static void PlayGame() {
        JFrame frame = new GameFrame();

        CellList = new Cell[board.rows()][board.columns()];

        labelWidth = (int) GAMEPANEL_SIZE / board.columns();
        labelHeight = (int) GAMEPANEL_SIZE / board.rows();

        for (int r = 0; r < board.rows(); ++r) {
            for (int c = 0; c < board.columns(); ++c) {
                {
                    Cell cell = new Cell(r, c, (r + c) % 2 == 0);
                    CellList[r][c] = cell;
                    if (r == 6) {
                        Pawn pawn = new Pawn(r, c, true);
                        board.set(r, c, pawn);
                    }
                    if (r == 1) {
                        Pawn pawn = new Pawn(r, c, false);
                        board.set(r, c, pawn);
                    }
                    if (r == 0 && (c == 0 || c == 7)) {
                        Rook rook = new Rook(r, c, false);
                        board.set(r, c, rook);
                    }
                    if (r == 7 && (c == 0 || c == 7)) {
                        Rook rook = new Rook(r, c, true);
                        board.set(r, c, rook);
                    }
                    
                }
                GameFrame.giveComponentToGameBoardPanel(CellList[r][c]);
            }
        }
        frame.setVisible(true);
    }
}

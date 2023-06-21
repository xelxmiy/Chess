/** Required package class namespace */
package chess;

import chess.LogicClasses.GameBoard;
import chess.LogicClasses.Timer;
import chess.LogicClasses.Piece;
import chess.chesspieces.Rook;
import chess.chesspieces.Knight;
import chess.chesspieces.King;
import chess.chesspieces.Pawn;
import chess.chesspieces.Bishop;
import chess.chesspieces.Queen;
import chess.Forms.GameFrame;
import javax.swing.JFrame;
import chess.LogicClasses.Cell;
import chess.StyleClasses.StyleManager;

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
    
    public static boolean gameIsRunning = false;
    
    public static boolean lightsTurn = true;

    public static Cell[][] CellList;

    public static int labelWidth;

    public static int labelHeight;

    public static Piece currentlySelectedPiece;

    public static Timer lightTimer;

    public static Timer blackTimer;

    /**
     * Main method for the project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        lightTimer = new Timer(5, 00, true);

        blackTimer = new Timer(5, 00, false);

        StyleManager.setTheme("Default");

        if (board == null) {
            board = new GameBoard(BOARD_SIZE);
        }
        PlayGame();
    }

    public static void PlayGame() {
        
        JFrame frame = new GameFrame();
        
        frame.setSize(GAMEFRAME_WIDTH, GAMEFRAME_HIEGHT);
        
        frame.setLocationRelativeTo(null);
        
        CellList = new Cell[board.rows()][board.columns()];

        labelWidth = (int) GAMEPANEL_SIZE / board.columns();
        labelHeight = (int) GAMEPANEL_SIZE / board.rows();

        for (int r = 0; r < board.rows(); ++r) {
            for (int c = 0; c < board.columns(); ++c) {
                {
                    Cell cell = new Cell(r, c, (r + c) % 2 == 0);
                    CellList[r][c] = cell;
                    makePieces(r, c);
                }
                GameFrame.giveComponentToGameBoardPanel(CellList[r][c]);
            }
        }
        frame.setVisible(true);
    }

    /**
     * Creates the placement of the pieces
     *
     * @param r current row
     * @param c current column
     */
    private static void makePieces(int r, int c) {
        if (r == LIGHT_FRONTROW) {
            Pawn pawn = new Pawn(r, c, true);
            board.set(r, c, pawn);
        }
        if (r == DARK_FRONTROW) {
            Pawn pawn = new Pawn(r, c, false);
            board.set(r, c, pawn);
        }
        if (r == DARK_BACKROW && (c == 0 || c == 7)) {
            Rook rook = new Rook(r, c, false);
            board.set(r, c, rook);
        }
        if (r == LIGHT_BACKROW && (c == 7 || c == 0)) {
            Rook rook = new Rook(r, c, true);
            board.set(r, c, rook);
        }
        if (r == DARK_BACKROW && (c == 1 || c == 6)) {
            Knight knight = new Knight(r, c, false);
            board.set(r, c, knight);
        }
        if (r == LIGHT_BACKROW && (c == 1 || c == 6)) {
            Knight knight = new Knight(r, c, true);
            board.set(r, c, knight);
        }
        if (r == DARK_BACKROW && (c == 2 || c == 5)) {
            Bishop bishop = new Bishop(r, c, false);
            board.set(r, c, bishop);
        }
        if (r == LIGHT_BACKROW && (c == 2 || c == 5)) {
            Bishop bishop = new Bishop(r, c, true);
            board.set(r, c, bishop);
        }
        if (r == DARK_BACKROW && (c == 3)) {
            Queen queen = new Queen(r, c, false);
            board.set(r, c, queen);
        }
        if (r == LIGHT_BACKROW && (c == 3)) {
            Queen queen = new Queen(r, c, true);
            board.set(r, c, queen);
        }
        if (r == DARK_BACKROW && (c == 4)) {
            King king = new King(r, c, false);
            board.set(r, c, king);
        }
        if (r == LIGHT_BACKROW && (c == 4)) {
            King king = new King(r, c, true);
            board.set(r, c, king);
        }
    }

    /* Final  Variables */
    private static final int LIGHT_BACKROW = 7;

    private static final int LIGHT_FRONTROW = 6;

    private static final int DARK_BACKROW = 0;

    private static final int DARK_FRONTROW = 1;

    private final static int GAMEPANEL_SIZE = 720;

    public static final int BOARD_SIZE = 8;
    
    private final static int GAMEFRAME_WIDTH = 1080;
    
    private final static int GAMEFRAME_HIEGHT = 756; // what??? why??
}

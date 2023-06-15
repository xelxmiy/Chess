package chessnt.LogicClasses;

import chessnt.Chess;
import chessnt.StyleClasses.StyleManager;
import static chessnt.Chess.labelHeight;
import static chessnt.Chess.labelWidth;
import javax.swing.JLabel;

/**
 * @author Adam Belski
 * @version 1.0.1
 * @since 7-Jun-2023
 */
public class Cell extends JLabel {

    public final int row;
    public final int column;

    /**
     * constructor for LifeLabels inside of a Matrix
     *
     * @param row row of Matrix this belongs in
     * @param column column of Matrix this belongs in
     * @param isLight weather or not this cell of the board is light or dark
     */
    public Cell(int row, int column, boolean isLight) {
        super();

        this.row = row;
        this.column = column;

        this.setBorder(StyleManager.BORDER);
        this.setOpaque(true);
        this.setBounds(labelWidth * column, labelHeight * row,
                labelWidth, labelHeight);
        if (isLight) {
            this.setBackground(StyleManager.lightCell);
        } else {
            this.setBackground(StyleManager.darkCell);
        }

        this.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doMouseClick();
            }
        });
    }

    /**
     * Runs on mouse click, changes the currently selected piece or moves the
     * currently selected piece
     */
    private void doMouseClick() {
        if (Chess.currentlySelectedPiece == null) {
            Chess.currentlySelectedPiece = Chess.board.get(row, column);
            if (Chess.currentlySelectedPiece != null) {
                this.setBorder(StyleManager.BORDER_SELECTED);
            }
            return;
        }   
        int cspR = Chess.currentlySelectedPiece.row;
        int cspC = Chess.currentlySelectedPiece.column;
        System.out.println("cspR: " + cspR);
        System.out.println("cspC: " + cspC);
        
        Chess.CellList[cspR][cspC].setBorder(StyleManager.BORDER);
        Chess.currentlySelectedPiece.Move(row, column);
    }
}
package chessnt.StyleClasses;

import chessnt.Chessnt;
import static chessnt.Chessnt.labelHeight;
import static chessnt.Chessnt.labelWidth;
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

    private void doMouseClick() {
        int[] p = {row, column};

        if (Chessnt.board.get(row, column) == null
                && Chessnt.currentlySelectedPiece == null) {
            return;
        }
        if (Chessnt.board.get(row, column) != null) {
            Chessnt.currentlySelectedPiece = Chessnt.board.get(row, column);
            return;
        }
        int cspR = Chessnt.currentlySelectedPiece.position[0];
        int cspC = Chessnt.currentlySelectedPiece.position[1];

        Chessnt.board.get(cspR, cspC).Move(p);
    }
}

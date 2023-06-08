package chessnt.StyleClasses;

import static chessnt.Chessnt.labelHeight;
import static chessnt.Chessnt.labelWidth;
import javax.swing.JLabel;

/**
 * @author Adam Belski
 * @version 1.0.1
 * @since 7-Jun-2023
 */
public class Cell extends JLabel {

    /**
     * constructor for LifeLabels inside of a Matrix
     *
     * @param row row of Matrix this belongs in
     * @param column column of Matrix this belongs in
     * @param isLight weather or not this cell of the board is light or dark
     */
    public Cell(int row, int column, boolean isLight) {
        super();
        this.setBorder(StyleManager.BORDER);
        this.setOpaque(true);
        this.setBounds(labelWidth * column, labelHeight * row,
                labelWidth, labelHeight);
        if (isLight) {
            this.setBackground(StyleManager.lightCell);
        } else {
            this.setBackground(StyleManager.darkCell);
        }
    }
}

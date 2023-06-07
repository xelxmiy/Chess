package chessnt.StyleClasses;

import javax.swing.JLabel;

/**
 * @author Adam Belski
 * @version 1.0.0
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
        
        if(isLight) this.setBackground(StyleManager.lightCell);
        else this.setBackground(StyleManager.darkCell);
    }
}

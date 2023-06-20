package chess.LogicClasses;

import chess.Chess;
import chess.StyleClasses.StyleManager;
import static chess.Chess.labelHeight;
import static chess.Chess.labelWidth;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * @author Adam Belski
 * @version 1.0.3
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
                if (Chess.lightsTurn == Chess.currentlySelectedPiece.isLight) {
                    this.setBorder(StyleManager.borderSelected);
                } else {
                    Chess.currentlySelectedPiece = null;
                }
            }
            return;
        }

        int cspR = Chess.currentlySelectedPiece.row;
        int cspC = Chess.currentlySelectedPiece.column;

        Chess.CellList[cspR][cspC].setBorder(null);
        if (Chess.lightsTurn == Chess.currentlySelectedPiece.isLight) {
            Chess.currentlySelectedPiece.Move(row, column);
        }
    }

    /**
     * sets the image for the current component. a complicated dance of converting
     * one image type to another. "adapted" from
     * https://stackoverflow.com/a/16345968
     *
     * @param imgIcon imageIcon to set this LifeLabel to.
     */
    public void setImage(ImageIcon imgIcon) {
        try {
            BufferedImage img;
            Image image = imgIcon.getImage();
            img = (BufferedImage) image;
            try {
                Image dimg = img.getScaledInstance(this.getWidth(), this.getHeight(),
                        Image.SCALE_SMOOTH);
                ImageIcon imageIcon = new ImageIcon(dimg);
                this.setIcon(imageIcon);
            } catch (IllegalArgumentException IAE) {
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}

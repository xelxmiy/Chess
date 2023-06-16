package chessnt.StyleClasses;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.border.Border;

/**
 * manages the colors, borders, fonts, etc. for all objects
 *
 * @author Adam Belski
 * @since 07-Jun-2023
 * @version 1.0.0
 */
public class StyleManager {

    /**
     * currently selected theme
     */
    public static String selectedTheme = "Default";

    /* public, changeable variables */
    //
    /**
     * this color should be used for the background of jPanels
     */
    public static Color jPanelBackground = new Color(45, 45, 45);

    /**
     * this color is used for things that are slightly darker than the
     * background
     */
    public static Color jPanelExtra = new Color(50, 50, 50);

    /**
     * this color is for accents in conjunction with jPanelBackground
     */
    public static Color jPanelAccents = new Color(35, 35, 35);

    /**
     * this color is for unpressed LifeButtons
     */
    public static Color chessButtonUnpressed = new Color(25, 25, 25);

    /**
     * this color is for highlights LifeButtons
     */
    public static Color chessButtonHighlighted = new Color(30, 30, 30);

    /**
     * this color is for LifeButtons in the pressed state
     */
    public static Color chessButtonPressed = new Color(35, 35, 35);

    /**
     * this color is used for LifeLabels representing white cells
     */
    public static Color lightCell = new Color(55, 55, 55);

    /**
     * this color is used for LifeLabels representing black cells
     */
    public static Color darkCell = new Color(25, 25, 25);

    /**
     * the top color for selected cells
     */
    public static Color selectedHighlight = new Color(255, 0, 0);

    /**
     * the shadow color for selected cells
     */
    public static Color selectedShadow = new Color(0, 255, 0);

    /* final variables */
    //
    /**
     * this color is to use for JLabel fonts and highlights
     */
    public static final Color WHITE = new Color(245, 245, 245);

    /* this is the default font*/
    private static final int LARGE_SIZE = 36;

    private static final int SMALL_SIZE = 18;

    private static final int FONT_STYLE = Font.PLAIN;

    private static final String FACE = "Consolas";

    /**
     * this font is for large titles and LifeButtons
     */
    public static final Font TITLE_FONT = new Font(FACE, FONT_STYLE, LARGE_SIZE);

    /**
     * this font is for JLabels
     */
    public static final Font LABLE_FONT = new Font(FACE, FONT_STYLE, SMALL_SIZE);

    /**
     * This is the standard border for all objects
     */
    public static final Border BORDER = BorderFactory.createBevelBorder(0);

    /**
     * this is the border for the selected piece
     */
    public static final Border BORDER_SELECTED = BorderFactory.createBevelBorder(0, selectedHighlight, selectedShadow);

    /**
     * This is the image for light pawns
     */
    public static ImageIcon lightPawnImg;

    /**
     * This is the image for dark pawns
     */
    public static ImageIcon darkPawnImg;
    
    /**
     * This is the image for dark rooks
     */
    public static ImageIcon darkRookImg;
    
    /**
     * This is the image for dark rooks
     */
    public static ImageIcon lightRookImg;

    /**
     * changes the color scheme of the whole program based on the preset
     *
     * @param theme string of theme preset
     */
    public static void setTheme(String theme) {

        switch (theme) {

            //this is the default theme, it's gray!
            case "Default":

                jPanelBackground = new Color(45, 45, 45);

                jPanelExtra = new Color(45, 45, 45);

                jPanelAccents = new Color(35, 35, 35);

                chessButtonUnpressed = new Color(25, 25, 25);

                chessButtonHighlighted = new Color(30, 30, 30);

                chessButtonPressed = new Color(35, 35, 35);

                lightCell = new Color(40, 40, 40);

                darkCell = new Color(25, 25, 25);
                System.out.println("Setting Images!");
                try {
                    /* Light Pawn Image */
                    File lightPawnFile
                            = new File("src\\images\\lightPawn.png");
                    lightPawnFile.getAbsolutePath();
                    Image lightPawnImgIcon = ImageIO.read(lightPawnFile);
                    lightPawnImg = new ImageIcon(lightPawnImgIcon);

                    /* Dark Pawn Image */
                    File DarkPawnFile
                            = new File("src\\images\\darkPawn.png");
                    DarkPawnFile.getAbsolutePath();
                    Image darkPawnImgIcon = ImageIO.read(DarkPawnFile);
                    darkPawnImg = new ImageIcon(darkPawnImgIcon);
                    
                    /* Dark Rook Image */
                    File darkRookFile
                            = new File("src\\images\\darkRook.png");
                    darkRookFile.getAbsolutePath();
                    Image darkRookImgIcon = ImageIO.read(darkRookFile);
                    darkRookImg = new ImageIcon(darkRookImgIcon);
                    
                    /* Light Rook Image */
                    File lightRookFile
                            = new File("src\\images\\lightRook.png");
                    lightRookFile.getAbsolutePath();
                    Image lightRookImgIcon = ImageIO.read(lightRookFile);
                    lightRookImg = new ImageIcon(lightRookImgIcon);
                } catch (IOException ex) {
                }
                break;
        }
    }
}

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
 * @version 1.1.0
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
    public static Border borderSelected;

    /* images */
    /**
     * This is the image for light pawns
     */
    public static ImageIcon lightPawnImg;

    /**
     * This is the image for dark pawns
     */
    public static ImageIcon darkPawnImg;

    /**
     * This is the image for light knights
     */
    public static ImageIcon lightKnightImg;

    /**
     * This is the image for dark knights
     */
    public static ImageIcon darkKnightImg; //should've named this one "batman"

    /**
     * This is the image for dark bishops
     */
    public static ImageIcon darkBishopImg;

    /**
     * This is the image for light bishops
     */
    public static ImageIcon lightBishopImg;

    /**
     * This is the image for dark rooks
     */
    public static ImageIcon darkRookImg;

    /**
     * This is the image for light rooks
     */
    public static ImageIcon lightRookImg;

    /**
     * This is the image for dark queens
     */
    public static ImageIcon darkQueenImg;

    /**
     * This is the image for light queens
     */
    public static ImageIcon lightQueenImg;
    /**
     * This is the image for dark king
     */
    public static ImageIcon darkKingImg;

    /**
     * This is the image for light king
     */
    public static ImageIcon lightKingImg;

    /**
     * changes the color scheme of the whole program based on the preset
     *
     * @param theme string of theme preset
     */
    public static void setTheme(String theme) {

        String[] paths = new String[12];

        ImageIcon[] pieceImages = new ImageIcon[12];

        switch (theme) {
            //this is the default theme, it's gray!
            case "Default":

                jPanelBackground = new Color(45, 45, 45);

                jPanelExtra = new Color(45, 45, 45);

                jPanelAccents = new Color(35, 35, 35);

                chessButtonUnpressed = new Color(25, 25, 25);

                chessButtonHighlighted = new Color(30, 30, 30);

                chessButtonPressed = new Color(35, 35, 35);

                lightCell = new Color(189, 143, 98);

                darkCell = new Color(115, 81, 48);

                selectedHighlight = new Color(255, 255, 255);

                selectedShadow = new Color(255, 255, 255);

                borderSelected = BorderFactory.createBevelBorder(
                        0, selectedHighlight, selectedShadow);

                String[] newPaths = {
                    "src\\Images\\lightPawn.png",
                    "src\\Images\\darkPawn.png",
                    "src\\Images\\lightKnight.png",
                    "src\\Images\\darkKnight.png",
                    "src\\Images\\lightBishop.png",
                    "src\\Images\\darkBishop.png",
                    "src\\Images\\lightRook.png",
                    "src\\Images\\darkRook.png",
                    "src\\Images\\lightQueen.png",
                    "src\\Images\\darkQueen.png",
                    "src\\Images\\lightKing.png",
                    "src\\Images\\darkKing.png"
                };
                paths = newPaths;
                break;
        }
        //setting images!
        try {
            Image[] images = new Image[pieceImages.length];
            for (int i = 0; i < paths.length; i++) {

                File imageFile
                        = new File(paths[i]);
                imageFile.getAbsolutePath();

                Image image = ImageIO.read(imageFile);

                pieceImages[i] = new ImageIcon(image);
            }
            /*
            I looked for so long for a better way to this.
            it is currently 1 AM as i'm writing this. I give up.
            unfrotunatly, this is my best work.
            i wanted to have each style only set the paths for each image
            and then a for loops iterated through that and using arrays sets
            each piece's image individually, unfortunatly setting the pieces
            only sets that in the position of the array, and i couldn't find a 
            way to access the thing inside. i may or may not ask about this
            depending on if i remember. but this could *be* better, i just don't 
            know if *I* can make it better.
             */
            lightPawnImg = pieceImages[0];
            darkPawnImg = pieceImages[1];
            lightKnightImg = pieceImages[2];
            darkKnightImg = pieceImages[3];
            lightBishopImg = pieceImages[4];
            darkBishopImg = pieceImages[5];
            lightRookImg = pieceImages[6];
            darkRookImg = pieceImages[7];
            lightQueenImg = pieceImages[8];
            darkQueenImg = pieceImages[9];
            lightKingImg = pieceImages[10];
            darkKingImg = pieceImages[11];

        } catch (IOException ex) {
            //this isn't proper error checking, too bad!
            System.out.println(ex.toString());
        }

    }
}

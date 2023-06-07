package chessnt.StyleClasses;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
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

                break;
            //this theme is pink/red!
            case "Strawberry":

                jPanelBackground = new Color(200, 75, 75);

                jPanelExtra = new Color(220, 75, 75);

                jPanelAccents = new Color(35, 35, 35);

                chessButtonUnpressed = new Color(180, 65, 65);

                chessButtonHighlighted = new Color(190, 65, 65);

                chessButtonPressed = new Color(160, 55, 55);

                lightCell = new Color(230, 120, 120);

                darkCell = new Color(160, 55, 55);

                break;

            //this theme is green! 
            case "Jungle":

                jPanelBackground = new Color(45, 90, 45);

                jPanelExtra = new Color(55, 90, 55);

                jPanelAccents = new Color(15, 75, 15);

                chessButtonUnpressed = new Color(25, 80, 25);

                chessButtonHighlighted = new Color(35, 80, 35);

                chessButtonPressed = new Color(15, 70, 15);

                lightCell = new Color(70, 110, 70);

                darkCell = new Color(15, 70, 15);

                break;

        }

    }
}
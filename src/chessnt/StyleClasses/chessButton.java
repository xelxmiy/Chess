package chessnt.StyleClasses;
import javax.swing.JButton;
import javax.swing.event.ChangeEvent;

/**
 * @author Adam Belski
 * @since 07-Jun-2023
 * @version 1.0.0
 */
// stole this whole class from https://stackoverflow.com/a/23958880 lol
// button color when it was pressed was ugly
public class chessButton extends JButton {

    /**
     * constructs a JButton with custom colors
     */
    public chessButton() {
        setFocusPainted(false);
        setContentAreaFilled(false);
        setOpaque(true);
        
        setBorder(StyleManager.BORDER);
        
        setBackground(StyleManager.chessButtonUnpressed);
        setForeground(StyleManager.WHITE);
        setFont(StyleManager.LABLE_FONT);

        addChangeListener((ChangeEvent evt) -> {
            if (getModel().isPressed()) {
                setBackground(StyleManager.chessButtonPressed);
            } else if (getModel().isRollover()) {
                setBackground(StyleManager.chessButtonHighlighted);
            } else {
                setBackground(StyleManager.chessButtonUnpressed);
            }
        });
    }
}

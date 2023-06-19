package chessnt.LogicClasses;

import chessnt.Chess;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Timer that restricts the time the players have to make a move
 *
 * @author Adam Belski
 * @since 19-Jun-2023
 * @version 1.1.1
 */
public final class Timer {

    public int timerLength;

    private final int ONE_SECOND = 1000;

    public Thread timerThread;

    public Timer(int timerLength, boolean isLightTimer) {
        this.timerLength = timerLength;
        makeNewTimer(isLightTimer);
        timerThread.start();
    }

    /**
     * Creates the timerThread logic
     *
     * @param isLightTimer weather the timer is counting down for the light or
     * dark player
     */
    public void makeNewTimer(boolean isLightTimer) {
        timerThread = new Thread(() -> {
            while (true) {
                try {
                    if (isLightTimer == Chess.lightsTurn) {
                        System.out.println(isLightTimer
                                ? "White Has " + timerLength + "s Left"
                                : "Black Has " + timerLength + "s Left");
                        Thread.sleep(ONE_SECOND);
                        timerLength--;
                    }
                    else {
                        // ??????
                        System.out.print("");
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(Timer.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
}

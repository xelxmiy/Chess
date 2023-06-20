/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chess.LogicClasses;

import chess.Chess;
import chess.Forms.GameFrame;

/**
 * Timer that keeps track of how long players have left before they lose
 *
 * @author Adam Belski
 * @since 19-Jun-2023
 * @version 1.0.0
 */
public final class Timer {

    /**
     * how many seconds are left on the counter
     */
    public int secondsCounter;

    /**
     * how many mins are left on the timer
     */
    public int minsCounter; // i can't spell minuites m

    private Thread timerThread;

    private static final int ONE_SECOND = 1000;

    public Timer(int mins, int seconds, boolean isLight) {

        this.secondsCounter = seconds;

        this.minsCounter = mins;

        makeNewTimer(isLight);

    }

    /**
     * Creates a <code>Thread</code> with a <code>Runnable</code> that slowly
     * decrements <code>secondsCounter</code> and <code>minsCounter</code>
     *
     * @param isLight
     */
    public void makeNewTimer(boolean isLight) {
        timerThread = new Thread(() -> {
            while (true) {
                if (Chess.gameIsRunning) {
                    if (Chess.lightsTurn == isLight) {
                        if (secondsCounter == 0) {
                            minsCounter--;
                            secondsCounter = 60;
                        } else {
                            secondsCounter--;
                        }
                        try {
                            GameFrame.UpdateTimer();
                        } catch (NullPointerException npe) {
                            // game needs to run for one tick! 
                        }
                        try {
                            Thread.sleep(ONE_SECOND);
                        } catch (InterruptedException ex) {
                        }
                    } else {
                        System.out.print("");
                    }
                } else {
                    System.out.print("");
                }
            }
        });
        timerThread.start();
    }
}

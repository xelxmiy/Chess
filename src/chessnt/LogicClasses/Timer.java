/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chessnt.LogicClasses;

import chess.Chess;
/**
 * Timer that keeps track of how long players have left before they lose
 *
 * @author Adam Belski
 * @since 19-Jun-2023
 * @version 1.0.0
 */
public final class Timer {

    public int timer;

    public Thread timerThread;

    private static int ONE_SECOND = 1000;

    public Timer(int time, boolean isLight) {

        this.timer = time;

        makeNewTimer(isLight);

    }

    public void makeNewTimer(boolean isLight) {
        timerThread = new Thread(() -> {
            while (true) {
                if (Chess.lightsTurn == isLight) {
                    --timer;
                    System.out.println(isLight ? "White has " + timer + "s left"
                            : "black has " + timer + "s left");
                    try {
                        Thread.sleep(ONE_SECOND);
                    } catch (InterruptedException ex) {
                    }
                } else {
                    System.out.print("");
                }
            }
        });
        timerThread.start();
    }
}

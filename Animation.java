//Guy Leib 31631190

import biuoop.DrawSurface;

/**
 * public interface Animation.
 *
 * @author - Guy Leib
 * version 1.0
 * since 12/6/2021
 */
public interface Animation {
    /**
     * void doOneFrame.
     * @param d - the drawsurface.
     * this method handle the game-specific logic and stopping conditions.
     */
    void doOneFrame(DrawSurface d);

    /**
     * boolean shouldStop.
     * @return - true or false.
     */
    boolean shouldStop();
}
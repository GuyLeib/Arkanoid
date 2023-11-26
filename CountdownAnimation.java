//Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class CountdownAnimation.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021
 * this class will do the countdown in the game.
 */
public class CountdownAnimation implements Animation {
    private boolean stop;
    private long numOfMillis;
    private int count;
    private int initialCount;
    private SpriteCollection spr;
    private long currentTime;

    /**
     * constructor.
     *
     * @param numOfSeconds - the number of the seconds it will take to countdown.
     * @param countFrom    - the number we countdown from.
     * @param gameScreen   - the screen of the game.
     */
    public CountdownAnimation(double numOfSeconds,
                              int countFrom,
                              SpriteCollection gameScreen) {
        this.stop = true;
        this.numOfMillis = (long) (numOfSeconds * 1000);
        this.currentTime = System.currentTimeMillis();
        this.count = countFrom;
        this.initialCount = countFrom;
        this.spr = gameScreen;
    }

    /**
     * public void setBackground.
     * this class will set the background for the countdown.
     *
     * @param d     - the draw surface.
     * @param color - the color of the background.
     */
    public void setBackground(DrawSurface d, Color color) {
        d.setColor(color);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

    }

    @Override
    public void doOneFrame(DrawSurface surface) {
        if (this.count == 0) {
            this.stop = false;
        }
        setBackground(surface, Color.white);
        this.spr.drawAllOn(surface);
        surface.setColor(Color.cyan);
        surface.drawText(390, 100, Integer.toString(this.count), 75);
        if (System.currentTimeMillis() - this.currentTime
                > this.numOfMillis / this.initialCount) {
            this.currentTime = System.currentTimeMillis();
            this.count--;
        }
    }

    @Override
    public boolean shouldStop() {
        return !this.stop;

    }
}
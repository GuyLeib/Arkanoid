// Guy Leib 316311190.

import biuoop.DrawSurface;

/**
 * public interface Sprite.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 29/04/2021.
 * the sprite interface.
 */
public interface Sprite {
    /**
     * void drawOn.
     *
     * @param d - the draw surface.
     *          draw the sprite to the screen.
     */
    void drawOn(DrawSurface d);

    /**
     * void timePassed.
     * notify the sprite that time has passed.
     */
    void timePassed();
}

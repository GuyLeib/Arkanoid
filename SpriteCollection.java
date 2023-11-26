// Guy Leib 316311190.

import biuoop.DrawSurface;

import java.util.ArrayList;
import java.util.List;

/**
 * public class SpriteCollection.
 *
 * @author Guy Leib.
 * since 29/04/2021.
 * version 1.0.
 * this class holds the sprite collection.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * public SpriteCollection.
     * this method construct a sprite collection.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<Sprite>();
    }

    /**
     * public void addSprite.
     *
     * @param s - the sprite needs to be added.
     *          this method add a sprite to the sprite collection.
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * public void notifyAllTimePassed.
     * this method goes over all the sprites in the sprite collection and calls the timePassed method.
     */
    public void notifyAllTimePassed() {
        List<Sprite> spritesList = new ArrayList<Sprite>(this.sprites);
        for (Sprite spr : spritesList) {
            spr.timePassed();
        }
    }

    /**
     * public void drawAllOn.
     *
     * @param d - the drawing surface.
     *          this method goes over all the sprites in the sprite collection and calls the drawOn method.
     */
    public void drawAllOn(DrawSurface d) {
        for (Sprite spr : sprites) {
            spr.drawOn(d);
        }
    }

    /**
     * public void removeSprite.
     *
     * @param s - the sprite to remove.
     */
    public void removeSprite(Sprite s) {
        sprites.remove(s);
    }
}

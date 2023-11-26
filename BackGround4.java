// Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class BackGround4.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021
 * this class represent the fourth level background.
 */
public class BackGround4 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(232, 221, 151));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(230, 151, 83));
        d.fillCircle(80, 90, 60);
        d.setColor(new Color(255, 212, 94));
        d.fillCircle(80, 90, 50);
        d.setColor(Color.YELLOW);
        d.fillCircle(80, 90, 40);
    }

    @Override
    public void timePassed() {

    }
}

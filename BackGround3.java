// Guy Leib 316311190

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class BackGround3.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021
 * this class represent the third level background.
 */
public class BackGround3 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(new Color(159, 230, 160));
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.lightGray);
        d.fillRectangle(100, 200, 300, 200);
        d.setColor(Color.darkGray);
        d.fillRectangle(50, 150, 150, 200);

    }

    @Override
    public void timePassed() {

    }
}

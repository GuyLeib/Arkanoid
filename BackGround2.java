// Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Polygon;
import java.awt.Color;

/**
 * public class BackGround2.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021
 * this class represent the second level background.
 */
public class BackGround2 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(new Color(255, 179, 200));
        d.fillCircle(390, 110, 50);
        d.setColor(new Color(144, 20, 55));
        d.fillCircle(365, 150, 50);
        d.setColor(new Color(255, 163, 60));
        d.fillCircle(430, 150, 50);
        d.setColor(new Color(198, 148, 72));
        int[] xpoints = {500, 400, 300};
        int[] ypoints = {150, 400, 150};
        int npoints = 3;
        d.fillPolygon(new Polygon(xpoints, ypoints, npoints));

    }

    @Override
    public void timePassed() {

    }
}

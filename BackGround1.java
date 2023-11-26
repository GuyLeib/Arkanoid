// Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class BackGround1.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021
 * this class represent the first level background.
 */
public class BackGround1 implements Sprite {
    @Override
    public void drawOn(DrawSurface d) {
        int centerX = 380;
        int centerY = 170;
        d.setColor(Color.black);
        d.fillRectangle(0, 0, 800, 600);
        d.setColor(Color.blue);
        d.drawCircle(centerX, centerY, 50);
        d.drawCircle(centerX, centerY, 90);
        d.drawCircle(centerX, centerY, 130);
        //up
        d.drawLine(centerX, centerY, centerX, centerY - 120);
        //down
        d.drawLine(centerX, centerY, centerX, centerY + 120);
        //left
        d.drawLine(centerX, centerY, centerX - 120, centerY);
        //right
        d.drawLine(centerX, centerY, centerX + 120, centerY);

    }

    @Override
    public void timePassed() {

    }
}

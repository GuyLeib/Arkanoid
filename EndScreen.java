//Guy Leib 316311190.

import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * public class EndScreen.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021.
 * this class represent the end screen.
 * there is an end screen for winning and one for losing.
 */
public class EndScreen implements Animation {
    private int score;
    private KeyboardSensor keyboardSensor;
    private boolean close;
    private String result;

    /**
     * constructor.
     *
     * @param score          - the current score of the game.
     * @param keyboardSensor - the keyboadrd ensor.
     * @param result         - a string that represent the result.
     */
    public EndScreen(Counter score,
                     KeyboardSensor keyboardSensor, String result) {
        this.score = score.getValue();
        this.keyboardSensor = keyboardSensor;
        this.result = result;
        this.close = false;
    }

    @Override
    public void doOneFrame(DrawSurface surface) {
        if (result.equals("win")) { // the winning screen.
            surface.setColor(new Color(255, 185, 46));
            surface.fillRectangle(0, 0, surface.getWidth(), surface.getHeight());
            surface.setColor(Color.black);
            surface.drawText(200, 200, "You Won", 100);
            surface.setColor(new Color(207, 207, 206));
            surface.drawText(204, 196, "You Won", 100);
        } else { // losing screen.
            surface.setColor(new Color(35, 102, 35));
            surface.fillRectangle(0, 0, surface.getWidth(), surface.getHeight());
            surface.setColor(Color.black);
            surface.drawText(200, 200, "You Lost", 100);
            surface.setColor(new Color(207, 207, 206));
            surface.drawText(204, 196, "You Lost", 100);
        }
        surface.setColor(Color.white);
        surface.drawText(250, 350, "Press space to continue", 25);
        surface.setColor(Color.white);
        surface.drawText(340, 580, "Final score: " + this.score, 15);
    }

   @Override
    public boolean shouldStop() {
        return this.close;
    }

}
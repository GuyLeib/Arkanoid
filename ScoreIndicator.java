// Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Color;


/**
 * public class ScoreIndicator.
 *
 * @author - Guy Leib.
 * since 7/6/2021
 * version 1.0
 * this class represent the score indicator in the game.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private Rectangle rectangle;

    /**
     * public ScoreIndicator.
     * constructor.
     *
     * @param score - the score.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
        this.rectangle = new Rectangle(new Point(200, 0), 400, 20);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.orange);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) this.rectangle.getUpperLeft().getY(),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.BLACK);
        d.drawText((int) (this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth() / 2 - 20),
                (int) (this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight() / 2 + 5),
                "Score: "
                        + this.score.getValue(), 13);


    }

    @Override
    public void timePassed() {

    }

    /**
     * public void addToGame.
     *
     * @param game - the game to add to.
     *             this method add score indicator to the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}

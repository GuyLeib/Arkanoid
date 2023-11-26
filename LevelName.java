//Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class LevelName.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 19/06/2021
 * this class will handle the name of each level.
 */
public class LevelName implements Sprite {
    private Rectangle rectangle;
    private String levelName;

    /**
     * public LevelName.
     * constructor.
     *
     * @param name - the current level name.
     */
    public LevelName(String name) {
        this.levelName = name;
        this.rectangle = new Rectangle(new Point(425, 0), 200, 20);
    }

    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.black);
        d.fillRectangle((int) this.rectangle.getUpperLeft().getX() + 170,
                (int) this.rectangle.getUpperLeft().getY() + 1,
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.pink);
        d.drawText((int) (this.rectangle.getUpperLeft().getX()
                        + this.rectangle.getWidth()),
                (int) (this.rectangle.getUpperLeft().getY()
                        + this.rectangle.getHeight()),
                "Level Name: " + this.levelName, 15);


    }

    @Override
    public void timePassed() {
    }

    /**
     * public void addToGame.
     * this method adds the name to a game.
     *
     * @param game the game.
     */
    public void addToGame(GameLevel game) {
        game.addSprite(this);
    }
}

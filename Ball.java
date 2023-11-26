// Guy Leib 316311190.

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * public class Ball.
 *
 * @author Guy Leib.
 * since - 7/6/2021.
 * version 3.0
 * this class manage and represent the ball in the program.
 */
public class Ball implements Sprite {
    private Point center;
    private int radius;
    private Color color;
    private int horizontalBound;
    private int verticalBound;
    private Velocity velocity;
//    private Frame frame;
    private GameEnvironment gameE;

    /**
     * construct a ball from two coordinates, radius and color.
     *
     * @param x     - the x value of the ball center.
     * @param y     - the y value of the ball center.
     * @param r     - the ball's radius.
     * @param color - the ball's color.
     *              this constructor create the center point of a ball.
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point((double) x, (double) y);
        this.radius = r;
        this.color = color;

    }

    /**
     * construct bounded ball from two coordinates, radius and color.
     *
     * @param x               - the x value of the initial location of the ball's center.
     * @param y               - the y value of the initial location of the ball's center.
     * @param r               - the ball's radius.
     * @param color           - the ball's color.
     * @param horizontalBound - the horizontal Bound of the ball.
     * @param verticalBound   - the vertical Bound of the ball.
     */
    public Ball(int x, int y, int r, Color color,
                int horizontalBound, int verticalBound) {
        this.center = new Point((double) x, (double) y);
        this.radius = r;
        this.color = color;
        this.verticalBound = verticalBound;
        this.horizontalBound = horizontalBound;
    }

    /**
     * public Ball.
     *
     * @param center          - the balls center point.
     * @param radius          - the balls radius.
     * @param color           - the balls color.
     * @param v               -  the balls velocity.
     * @param gameEnvironment - the balls game environment.
     *                        this method construct a ball.
     */
    public Ball(Point center, int radius, Color color, Velocity v, GameEnvironment gameEnvironment) {
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.velocity = v;
        this.gameE = gameEnvironment;

    }

    /**
     * public int getX.
     * this method returns the rounded x coordinate of the ball's center.
     *
     * @return the rounded x coordinate of the ball's center.
     */
    public int getX() {
        return (int) Math.round(this.center.getX());
    }

    /**
     * public int getY.
     * this method returns the rounded y coordinate of the ball's center.
     *
     * @return the rounded y coordinate of the ball's center.
     */
    public int getY() {
        return (int) Math.round(this.center.getY());
    }

    /**
     * public int getSize.
     * this method returns the ball's radius.
     *
     * @return the ball's radius.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * public Color getColor.
     * this method returns the ball's color.
     *
     * @return the ball's color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * public void drawOn.
     * this method draws the ball on given DrawSurface.
     *
     * @param surface the DrawSurface to draw on.
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }

    /**
     * public void setVelocity.
     *
     * @param v - the velocity.
     *          this method sets the ball's velocity.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * public void setVelocity.
     * this method sets the ball's velocity from two values.
     *
     * @param dx - the change in position on the x axis.
     * @param dy - the change in position on the y axis.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * public Velocity getVelocity
     * this method returns the ball's velocity.
     *
     * @return the ball's velocity.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * public Point getCenter.
     *
     * @return - the ball center point.
     */
    public Point getCenter() {
        return this.center;
    }

    /**
     * public void moveOneStep.
     * this method moves the ball one step according to the velocity.
     */
    public void moveOneStep() {
        Line trajectory = new Line(this.center, this.getVelocity().
                applyToPoint(this.center));
        if (gameE.getClosestCollision(trajectory) != null) {
            this.center = new Point(gameE.getClosestCollision(trajectory).
                    collisionPoint().getX() - this.velocity.getDx(),
                    gameE.getClosestCollision(trajectory).collisionPoint().getY() - this.velocity.getDy());

            Velocity newVelocity = gameE.getClosestCollision(trajectory).collisionObject().hit(this,
                    gameE.getClosestCollision(trajectory).collisionPoint(), this.velocity);

            this.setVelocity(newVelocity);
        } else { // if the ball can make a move.
            this.center = this.getVelocity().applyToPoint(this.center);

        }
    }

    /**
     * public void setCenter.
     *
     * @param x - the x value of the center.
     * @param y - the y value of the center.
     *          this method sets the new center of the ball.
     */
    public void setCenter(int x, int y) {
        this.center = new Point(x, y);
    }

    /**
     * public void timePassed.
     * this method calls the moveOneStep function and the stuckProblem.
     */
    public void timePassed() {
        this.moveOneStep();
        this.gameE.stuckProblem(this);

    }

    /**
     * public void addToGame.
     * This method adds a ball into a game.
     *
     * @param gameToAdd - is the game that we had the ball to the sprite.
     */
    public void addToGame(GameLevel gameToAdd) {
        gameToAdd.addSprite(this);
    }

    /**
     * public void removeFromGame.
     *
     * @param game - the game to remove from
     *             this method removes the sprite of the ball.
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
    }
}




// Guy Leib 316311190.

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

import java.awt.Color;

/**
 * public class paddle.
 *
 * @author Guy Leib.
 * since 19/6/2021
 * version 3.0
 * this class manage and represent the paddle in the program.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rectangle;
    private int paddleHeight = 20;
    private int paddleWidth;
    private int screenWidth;
    private int screenHeight;
    private Color color;
    private double speed;

    /**
     * public Paddle.
     *
     * @param screenWidth  - the screen width.
     * @param screenHeight - the screen height.
     * @param color        - the paddle color.
     * @param key          - the keyboard sensor.
     * @param paddleWidth  - the paddle width.
     * @param speed        - the paddle speed.
     *                     this method construct the paddle.
     */
    public Paddle(int screenWidth, int screenHeight, KeyboardSensor key, Color color, int speed, int paddleWidth) {
        this.screenWidth = screenWidth;
        Point p = new Point((this.screenWidth - paddleWidth) / 2,
                screenHeight - 4 * paddleHeight);
        this.rectangle = new Rectangle(p, paddleWidth, paddleHeight);
        this.keyboard = key;
        this.color = color;
        this.speed = speed;
        this.paddleWidth = paddleWidth;
    }

    /**
     * public void moveLeft.
     * this method checks if the paddle can move left.
     * this method will change the rectangle location according to the movement ability of the paddle.
     */
    public void moveLeft() {
        double x;
        double y;
        x = this.rectangle.getUpperLeft().getX() - this.speed;
        y = this.rectangle.getUpperLeft().getY();
        if (x < 20) { // means its crossing the block border.
            x = 20; // this is to prevent the paddle cross the left block.
        }
        this.rectangle = new Rectangle(new Point(x, y), paddleWidth, paddleHeight);
    }

    /**
     * public void moveRight.
     * this method checks if the paddle can move right.
     * this method will change the rectangle location according to the movement ability of the paddle.
     */
    public void moveRight() {
        double x;
        double y;
        x = this.rectangle.getUpperLeft().getX() + this.speed;
        y = this.rectangle.getUpperLeft().getY();
        if (x + paddleWidth >= this.screenWidth - 20) { // means its crossing the right block.
            x = this.screenWidth - this.rectangle.getWidth() - 20; // to prevent crossing the right block.
        }
        this.rectangle = new Rectangle(new Point(x, y), paddleWidth, paddleHeight);
    }


    /**
     * public void timePassed.
     * this method is responsible to the movement of the paddle.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();

        }
    }

    /**
     * public void drawOn.
     *
     * @param d - the draw surface.
     *          this method draws the paddle on a given draw surface.
     */
    public void drawOn(DrawSurface d) {
        int x = (int) rectangle.getUpperLeft().getX();
        int y = (int) rectangle.getUpperLeft().getY();
        int width = this.paddleWidth;
        int height = (int) rectangle.getHeight();

        d.setColor(this.color);
        d.fillRectangle(x, y, width, height);
        d.drawRectangle(x, y, width, height);

    }


    /**
     * public Rectangle getCollisionRectangle.
     *
     * @return - the collision rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * public Velocity hit.
     *
     * @param hitter          - the ball hitting the paddle.
     * @param collisionPoint  - the collision point.
     * @param currentVelocity - the current velocity.
     * @return - the updated velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double paddleLocationX = this.rectangle.getUpperLeft().getX();
        double collisionPointX = collisionPoint.getX();
        if (this.rectangle.bottomLine().containAPoint(collisionPoint)) {
            currentVelocity.setDy(currentVelocity.getDy() * -1);
            return currentVelocity;
        }
        if (this.rectangle.leftLine().containAPoint(collisionPoint)
                || rectangle.rightLine().containAPoint(collisionPoint)) {
            currentVelocity.setDx(currentVelocity.getDx() * -1);
            return currentVelocity;
        }
        double segment1 = paddleWidth * (0.2) + paddleLocationX;
        double segment2 = paddleWidth * (0.4) + paddleLocationX;
        double segment3 = paddleWidth * (0.6) + paddleLocationX;
        double segment4 = paddleWidth * (0.8) + paddleLocationX;
        // double segment5 = paddleWidth + paddleLocationX;

        speed = Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                + Math.pow(currentVelocity.getDy(), 2));
        if (collisionPointX <= segment1) {
            return Velocity.fromAngleAndSpeed(300, speed);
        }
        if (collisionPointX <= segment2) {
            return Velocity.fromAngleAndSpeed(330, speed);
        }
        if (collisionPointX <= segment3) {
            return new Velocity(currentVelocity.getDx(),
                    -currentVelocity.getDy());
        }
        if (collisionPointX <= segment4) {
            return Velocity.fromAngleAndSpeed(30, speed);
        }
        // the last case is segment 5.
        return Velocity.fromAngleAndSpeed(60, speed);

    }

    /**
     * public void addToGame.
     *
     * @param g - the game to add to.
     *          this method adds the paddle to the game.
     */
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}


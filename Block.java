// Guy Leib 316311190.
import biuoop.DrawSurface;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * public class Block implements Collidable, Sprite.
 *
 * @author Guy Leib.
 * version 2.0.
 * since 7/6/2021.
 * this class will construct and hold information about the blocks in the game.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rectangle;
    private Color color;
    private int hitsCounter;
    private List<HitListener> hitListeners;

    /**
     * public Block.
     *
     * @param rect  - the block shape.
     * @param color - the block color.
     *              this method will costruct a block from a given rectangle and a color.
     */
    public Block(Rectangle rect, Color color) {
        this.rectangle = rect;
        this.color = color;
        this.hitsCounter = 0;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * public Block.
     *
     * @param p      - the upper left point of the block.
     * @param height - the height of the block.
     * @param width  - the width of the block.
     * @param color  - the color of the block.
     *               this method will construct a ball from a point, height, width and color.
     */
    public Block(Point p, int height, int width, Color color) {
        this.rectangle = new Rectangle(p, width, height);
        this.color = color;
        this.hitsCounter = 0;
        this.hitListeners = new ArrayList<HitListener>();
    }

    /**
     * public void drawOn.
     *
     * @param d - the drawing surface.
     *          this method will draw a block on a given surface.
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) (this.rectangle.getUpperLeft().getX()),
                (int) (this.rectangle.getUpperLeft().getY()),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) (this.rectangle.getUpperLeft().getX()),
                (int) (this.rectangle.getUpperLeft().getY()),
                (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());

    }

    /**
     * public Rectangle getCollisionRectangle.
     *
     * @return - the collisioned rectangle.
     */
    public Rectangle getCollisionRectangle() {
        return this.rectangle;

    }

    /**
     * public Velocity hit.
     *
     * @param hitter          - the ball hitting the block.
     * @param collisionPoint  - the point to check.
     * @param currentVelocity - the ball current velocity.
     * @return - the updated velocity of the ball.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        double dx = currentVelocity.getDx();
        double dy = currentVelocity.getDy();
        double collisionPointX = Math.round(collisionPoint.getX());
        double collisionPointY = Math.round(collisionPoint.getY());
        double bottomRightX = Math.round(this.rectangle.bottomLine().end().getX());
        double bottomRightY = Math.round(this.rectangle.bottomLine().end().getY());
        double bottomLeftX = Math.round(this.rectangle.bottomLine().start().getX());
        double bottomLeftY = Math.round(this.rectangle.bottomLine().start().getY());
        double upperLeftX = Math.round(this.rectangle.getUpperLeft().getX());
        double upperLeftY = Math.round(this.rectangle.getUpperLeft().getY());
        double upperRightX = Math.round(this.rectangle.upperLine().end().getX());
        double upperRightY = Math.round(this.rectangle.upperLine().end().getY());
        if (this.rectangle.isContainPoint(hitter.getCenter())) {
            if (hitter.getVelocity().getDy() > 0) { // if the ball come from above.
                hitter.setCenter((int) hitter.getCenter().getX(), (int) hitter.getCenter().getY() - 20);
                hitter.setVelocity(hitter.getVelocity().getDx(), hitter.getVelocity().getDy() * -1);
                this.notifyHit(hitter);
            } else { // if the ball comes from the bottom.
                hitter.setCenter((int) hitter.getCenter().getX(), (int) hitter.getCenter().getY() + 20);
                hitter.setVelocity(hitter.getVelocity().getDx(), hitter.getVelocity().getDy() * -1);
                this.notifyHit(hitter);
            }
        }
        // if it hits the corner.
        if (collisionPoint.equals(this.rectangle.topRight()) || collisionPoint.equals(this.rectangle.getUpperLeft())
                || collisionPoint.equals(this.rectangle.bottomLine().start())
                || collisionPoint.equals(this.rectangle.bottomLine().end())) {
            this.hitsCounter++;
            this.notifyHit(hitter);
            return new Velocity(-dx, -dy);
        }
        if (this.rectangle.bottomLine().containAPoint(collisionPoint)) {
            this.hitsCounter++;
            this.notifyHit(hitter);
            currentVelocity.setDy(currentVelocity.getDy() * -1);
            return currentVelocity;
        }
        if (this.rectangle.leftLine().containAPoint(collisionPoint)
                || rectangle.rightLine().containAPoint(collisionPoint)) {
            this.hitsCounter++;
            this.notifyHit(hitter);
            currentVelocity.setDx(currentVelocity.getDx() * -1);
            return currentVelocity;
        }
        if (this.rectangle.upperLine().containAPoint(collisionPoint)) {
            this.hitsCounter++;
            this.notifyHit(hitter);
            currentVelocity.setDy(currentVelocity.getDy() * -1);
            return currentVelocity;
        }
        double epsilon = Math.pow(10, -12);
        if (Math.abs(collisionPointX - upperLeftX) <= epsilon
                || Math.abs(collisionPointX - upperRightX) <= epsilon
                || Math.abs(collisionPointX - bottomRightX) <= epsilon
                || Math.abs(collisionPointX - bottomLeftX) <= epsilon) {
            this.hitsCounter++;
            this.notifyHit(hitter);
            return new Velocity(-dx, dy);
        }
        if (Math.abs(collisionPointY - upperLeftY) <= epsilon
                || Math.abs(collisionPointX - upperRightY) <= epsilon
                || Math.abs(collisionPointY - bottomRightY) <= epsilon
                || Math.abs(collisionPointY - bottomLeftY) <= epsilon) {
            this.hitsCounter++;
            this.notifyHit(hitter);
            return new Velocity(dx, -dy);
        }
        return new Velocity(dx, dy);
    }

    /**
     * public void addToGame.
     *
     * @param game - the game to add the block to.
     *             this method add the collidable to the game.
     */
    public void addToGame(GameLevel game) {
        game.addCollidable(this);
        game.addSprite(this);
    }

    /**
     * public void timePassed.
     */
    public void timePassed() {

    }

    /**
     * public void removeFromGame.
     *
     * @param game - the game to remove from.
     *             remove the block from the game and the sprite collection.
     */
    public void removeFromGame(GameLevel game) {
        game.removeCollidable(this);
        game.removeSprite(this);
    }

    /**
     * private void notifyHit.
     *
     * @param hitter - the ball hitting the block.
     *               this method notify all listeners about hit event.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }

    /**
     * public int getHits.
     *
     * @return - the hits counter.
     */
    public int getHits() {
        return this.hitsCounter;
    }
}

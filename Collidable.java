// Guy Leib 316311190.

/**
 * public interface Collidable.
 *
 * @author - Guy Leib.
 * version 1.0.
 * since 29/04/2021.
 * the collidable interface.
 */
public interface Collidable {

    /**
     * getCollisionRectangle.
     *
     * @return - the collision shape of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     *  Velocity hit.
     * @param hitter          - the ball hitting the block.
     * @param collisionPoint  - the collision point.
     * @param currentVelocity - the current velocity.
     * @return - the updated velocity.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}

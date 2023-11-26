// Guy Leib 316311190.

/**
 * public class CollisionInfo.
 *
 * @author Guy Leib.
 * version 1.0
 * since 29/04/2021.
 * this class will hold the collision info.
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collidable;

    /**
     * public Point collisionPoint.
     *
     * @return - the point at which the collision occurs.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * public Collidable collisionObject.
     *
     * @return - the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }

    /**
     * public CollisionInfo.
     *
     * @param collisionPoint - the collision point.
     * @param collidable     - the collidable object involved in the collision.
     *                       this method construct a collision info.
     */
    public CollisionInfo(Point collisionPoint, Collidable collidable) {
        this.collidable = collidable;
        this.collisionPoint = collisionPoint;
    }


}

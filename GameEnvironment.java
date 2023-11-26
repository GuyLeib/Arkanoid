// Guy Leib 316311190.

import java.util.ArrayList;
import java.util.List;

/**
 * public class GameEnvironment.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 29/04/2021.
 * this class will hold the collidable objects of the game.
 * this class will find the closest collision point.
 * this class will handle the case in which the ball accidentally got inside the block.
 */
public class GameEnvironment  {
    private java.util.List<Collidable> collidableList;
    private Rectangle rectangle;
    private GameEnvironment game;

    /**
     * public GameEnvironment.
     * this method construct a new collidable list.
     */
    public GameEnvironment() {
        this.collidableList = new ArrayList<Collidable>();
    }

    /**
     * public void addCollidable.
     *
     * @param c - a collidable object that will be inserted to the collidable list.
     *          this method add the given collidable to the environment.
     */
    public void addCollidable(Collidable c) {
        collidableList.add(c);
    }

    /**
     *  public void removeColliadable.
     * @param c - the collidable to remove.
     */
    public void removeColliadable(Collidable c) {
        collidableList.remove(c);
    }

    // Assume an object moving from line.start() to line.end().
    // If this object will not collide with any of the collidables
    // in this collection, return null. Else, return the information
    // about the closest collision that is going to occur.

    /**
     * public CollisionInfo getClosestCollision.
     *
     * @param trajectory - a line which represent the movement of the ball.
     * @return - the info about the closest collision.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {
        double epsilon = Math.pow(10, -12);
        List<CollisionInfo> collisionInfoList = new ArrayList<CollisionInfo>();

        // first we'll fill collision info list.
        for (Collidable collidable : collidableList) {
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(collidable
                    .getCollisionRectangle());
            if (collisionPoint != null) {
                Collidable collisionObject = collidable;
                CollisionInfo collisionInfo = new CollisionInfo(collisionPoint, collisionObject);
                collisionInfoList.add(collisionInfo);
            }
        }
        if (collisionInfoList.isEmpty()) {
            return null;
        } else {
            Point closestPoint = collisionInfoList.get(0).collisionPoint();
            Collidable closestObject = collisionInfoList.get(0).collisionObject();
            CollisionInfo closestCollisionInfo = new CollisionInfo(closestPoint, closestObject);
            for (int i = 1; i < collisionInfoList.size(); ++i) {
                if (trajectory.start().distance(collisionInfoList.get(i).
                        collisionPoint()) - (trajectory.start().distance(closestPoint)) <= epsilon) {
                    closestPoint = collisionInfoList.get(i).collisionPoint();
                    closestObject = collisionInfoList.get(i).collisionObject();
                    closestCollisionInfo = new CollisionInfo(closestPoint, closestObject);
                }
            }

            return closestCollisionInfo;
        }

    }

    /**
     * public void stuckProblem.
     *
     * @param ball - the ball that needs to be checked.
     * this method will cover the case in which the ball get inside the block.
     * this method will check whether a ball got inside a block, if so it'll update the ball center and velocity.
     */
    public void stuckProblem(Ball ball) {
        if (this.collidableList.isEmpty()) {
            return;
        }
        for (Collidable obj : collidableList) {
            if (obj.getCollisionRectangle().
                    isContainPoint(ball.getCenter())) {
                if (ball.getVelocity().getDy() > 0) { // if the ball come from above.
                    ball.setCenter((int) ball.getCenter().getX(), (int) ball.getCenter().getY() - 20);
                    ball.setVelocity(ball.getVelocity().getDx(), ball.getVelocity().getDy() * -1);
                } else { // if the ball comes from the bottom.
                    ball.setCenter((int) ball.getCenter().getX(), (int) ball.getCenter().getY() + 20);
                    ball.setVelocity(ball.getVelocity().getDx(), ball.getVelocity().getDy() * -1);
                }

            }

        }
    }

}

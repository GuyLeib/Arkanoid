// Guy Leib 316311190.
/**
 * public class Velocity.
 * @author Guy Leib <guyleib9@gmail.com>.
 * since 13/04/2021.
 * version 1.0
 * this class represents a Velocity by specifying
 * the change in position on the `x` and the `y` axis.
 */
public class Velocity {
    private double dx;
    private double dy;
    /**
     * public Velocity.
     * construct Velocity from Cartesian representation.
     * @param dx - the change in position on the x axis.
     * @param dy - the change in position on the y axis.
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }
    /**
     * public static Velocity fromAngleAndSpeed.
     * constructor - construct Velocity from angle and speed.
     * @param angle the angle of the vector.
     * @param speed the length of the vector.
     * @return Velocity object.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        double angleRad = Math.toRadians(angle - 90.0);
        double dx = Math.cos(angleRad) * speed;
        double dy = Math.sin(angleRad) * speed;
        return new Velocity(dx, dy);
    }
    /**
     * public double getDx.
     * this method returns the velocity's change in position on the x axis.
     * @return the velocity's change in position on the x axis.
     */
    public double getDx() {
        return this.dx;
    }
    /**
     * public double getDy.
     * this method returns the velocity's change in position on the y axis.
     * @return the velocity's change in position on the y axis.
     */
    public double getDy() {
        return this.dy;
    }
    /**
     * public void setDx.
     * @param newDx - the new Dx value.
     */
    public void setDx(double newDx) {
        this.dx = newDx;
    }
 /**
 * public void setDy.
 * @param newDy - the new Dy value.
 */
    public void setDy(double newDy) {
        this.dy = newDy;
    }
    /**
     * public Point applyToPoint.
     * @param p - a point.
     * @return - the new point location after applying the velocity.
     */
    public Point applyToPoint(Point p) {
        double newX = p.getX() + this.dx;
        double newY = p.getY() + this.dy;
        return new Point(newX, newY);
    }
}
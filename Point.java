// Guy Leib 316311190.

/**
 * public class Point.
 *
 * @author Guy Leib <guyleib9@gmail.com>.
 * since 29/04/2021.
 * version 2.0
 * this class manage the points values in the program.
 * this class get and set the point values, calculate distance and check equality.
 */
public class Point {
    private double x;
    private double y;

    /**
     * constructor.
     *
     * @param x - x value of the point.
     * @param y - y value of the point.
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * public double distance.
     *
     * @param other - the other point.
     * @return the distance between two points.
     */
    public double distance(Point other) {
        double distanceX = this.x - other.getX();
        double distanceY = this.y - other.getY();
        double distance = Math.sqrt((distanceX * distanceX) + (distanceY * distanceY));
        return distance;
    }

    /**
     * public boolean equals.
     *
     * @param other - the other point
     * @return true if the point are equals or false if the point are not equal.
     */
    public boolean equals(Point other) {
        double epsilon = Math.pow(10, -12);
        return (Math.abs(this.x - other.getX()) <= epsilon) && Math.abs(this.y - other.getY()) <= epsilon;
    }

    /**
     * public double getX.
     *
     * @return the x value of a point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * public double getY.
     *
     * @return the y value of a point.
     */
    public double getY() {
        return this.y;
    }
}


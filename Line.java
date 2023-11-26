// Guy Leib 316311190.

/**
 * public class Line.
 *
 * @author Guy Leib <guyleib9@gmail.com>.
 * since 29/04/2021.
 * version 2.0
 * this class manage the lines in the program.
 * the class can create start and end point, calculate the distance between two lines.
 * this class checks if two lines intersects with each other.
 */
public class Line {
    private Point start;
    private Point end;

    /**
     * public Line.
     * constructor.
     *
     * @param start - the start point of a line.
     * @param end   - the end point of a line.
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * public Line.
     * constructor.
     *
     * @param x1 - the x value of the start point.
     * @param y1 - the y value of the start point.
     * @param x2 - the x value of the end point.
     * @param y2 - the y value of the end point.
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     * public double length.
     *
     * @return - the length of the line
     */
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     * public Point middle.
     *
     * @return - the middle point of the line.
     */
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        Point middle = new Point(midX, midY);
        return middle;
    }

    /**
     * public Point start.
     *
     * @return - the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * public Point end.
     *
     * @return - the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * Public double slope.
     *
     * @return - the slope of a line.
     * calculate the slope of a line ,and return the value.
     */
    public double slope() {
        double slope = ((end.getY() - start.getY()) / (end.getX() - start.getX()));
        return slope;
    }

    /**
     * public double yAxisIntersection.
     *
     * @param slope - gets the slope of a line.
     * @return - the y axis intersection of a line.
     */
    public double yAxisIntersection(double slope) {
        return (start.getY() - (slope * this.start.getX()));
    }

    /**
     * public boolean containAPoint.
     *
     * @param p - the point to check.
     * @return - true if the line is within the line range or false otherwise.
     */
    public boolean containAPoint(Point p) {
        double epsilon = Math.pow(10, -12);
        double x = p.getX();
        double y = p.getY();
        return (x >= Math.min(this.start.getX(), this.end.getX()) - epsilon
                && x <= Math.max(this.start.getX(), this.end.getX()) + epsilon
                && y >= Math.min(this.start.getY(), this.end.getY()) - epsilon
                && y <= Math.max(this.start.getY(), this.end.getY()) + epsilon);
    }

    /**
     * public boolean isIntersecting.
     *
     * @param other - the other line.
     * @return - true if two lines are intersecting, false otherwise.
     */
    public boolean isIntersecting(Line other) {
        if (this.equals(other)) {
            return false;
        }
        double x;
        double y = 0;
        // two points intersection.
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            return this.start.equals(other.start);
        }
        // if the slope is not defined - vertical line.
        if (((start.getX() == end.getX()) && (start.getY() != end.getY()))
                || ((other.start.getX() == other.end.getX()) && other.start.getY() != other.end.getY())) {
            // vertical line and a point intersection.
            if (this.start.getX() == this.end.getX()) {
                y = other.slope() * start.getX() + other.yAxisIntersection(other.slope());
                x = start.getX();
                if (this.containAPoint(new Point(x, y)) && other.containAPoint(new Point(x, y))) {
                    return true;
                }

                if (other.start.equals(other.end)) {
                    y = this.slope() * other.start.getX() + this.yAxisIntersection(this.slope());
                    x = other.start.getX();
                    if (this.containAPoint(new Point(x, y)) && other.containAPoint(new Point(x, y))) {
                        return true;
                    }
                }
            }

            //two vertical lines
            if (start.getX() == end.getX() && other.start.getX() == other.end.getX()
                    && (start.getX() == other.start.getX())
                    && (Math.max(start.getY(), end.getY()) == Math.min(other.start.getY(), other.end.getY()))) {
                return true;
            }

            if (Math.min(start.getY(), end.getY()) == Math.max(other.start.getY(), other.end.getY())) {
                return true;
            }
        } else { // two lines intersection one of them is vertical line.
            if (this.start.getX() == this.end.getX()) {
                y = other.slope() * start.getX() + other.yAxisIntersection(other.slope());
                x = start.getX();
                if (this.containAPoint(new Point(x, y)) && other.containAPoint(new Point(x, y))) {
                    return true;
                }
            }
            if (other.start.getX() == other.end.getX()) {
                y = this.slope() * other.start.getX() + this.yAxisIntersection(this.slope());
                x = other.start.getX();
                if (this.containAPoint(new Point(x, y)) && other.containAPoint(new Point(x, y))) {
                    return true;
                }
            }
        }
        double slope1 = this.slope();
        double slope2 = other.slope();
        double yAxisIntersection1 = this.yAxisIntersection(slope1);
        double yAxisIntersection2 = other.yAxisIntersection(slope2);
        // point and a line intersection.
        if (this.start.equals(this.end) && !other.start.equals(other.end)) {
            if (this.start.getY() == slope2 * this.start.getX() + yAxisIntersection2) {
                return true;
            }
        }
        if (!this.start.equals(this.end) && other.start.equals(other.end)) {
            if (other.start.getY() == slope1 * other.start.getX() + yAxisIntersection1) {
                return true;
            }
        }
        // two lines intersection- if the line parallel to the X Axis.
        if (slope1 == 0) {
            double p = (this.start.getY() - yAxisIntersection2) / slope2;
            if (this.start.getY() == slope2 * p + yAxisIntersection2) {
                if (this.containAPoint(new Point(p, this.start.getY()))
                        && other.containAPoint(new Point(p, this.start.getY()))) {
                    return true;
                }
            }
        }
        if (slope2 == 0) {
            double p = (other.start.getY() - yAxisIntersection1) / slope1;
            if (other.start.getY() == slope1 * p + yAxisIntersection1) {
                if (this.containAPoint(new Point(p, other.start.getY()))
                        && other.containAPoint(new Point(p, other.start.getY()))) {
                    return true;
                }
            }
        }
        // two lines intersection.
        if (slope1 != 0 && slope2 != 0) {
            if (slope1 != slope2) { // different slope.
                x = (yAxisIntersection2 - yAxisIntersection1) / (slope1 - slope2);
                y = (slope1 * x) + yAxisIntersection1;
                if (other.containAPoint(new Point(x, y)) && this.containAPoint(new Point(x, y))) {
                    return true;
                }
            }
        } else { //equal slopes.
            if (yAxisIntersection1 != yAxisIntersection2) {
                return false;
            } else { // two lines with more than one intersection point.
                if ((this.start.equals(other.start()) && !this.end.equals(other.end))
                        || (!this.start.equals(other.start) && this.end.equals(other.end))) {
                    return false;
                }
            }

        }
        return false;

    }

    /**
     * public boolean equals.
     *
     * @param other - the other line.
     * @return - true if the two lines are equal, false otherwise.
     */
    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return this.start.equals(other.start) && this.end.equals(other.end) && this.slope() == other.slope();
    }

    /**
     * public Point intersectionWith.
     *
     * @param other - the other line.
     * @return - if two lines are intersecting return the intersection point, null otherwise.
     */
    public Point intersectionWith(Line other) {
        if (!this.isIntersecting(other)) {
            return null;
        }
        double x;
        double y = 0;
        // two points intersection.
        if (this.start.equals(this.end) && other.start.equals(other.end)) {
            if (this.start.equals(other.start)) {
                return this.start;
            } else {
                return null;
            }
        }
        // if the line slope is not defined - vertical line.
        // its above the rest of the cases to prevent dividing by zero.
        if (((start.getX() == end.getX()) && (start.getY() != end.getY()))
                || ((other.start.getX() == other.end.getX()) && other.start.getY() != other.end.getY())) {
            // vertical line and a point intersection.
            if ((other.start.equals(other.end) || this.start.equals(this.end))
                    && (this.start.equals(this.end))
                    && (this.start.getX() == other.start.getX())
                    && (this.start.getY() >= Math.min(other.start.getY(), other.end.getY()))
                    && (this.start.getY() <= Math.max(other.start.getY(), other.end.getY()))) {
                return this.start;
            }

            if (other.start.equals(other.end)) {
                if (other.start.getX() == this.start.getX()) {
                    if (other.start.getY() >= Math.min(this.start.getY(), this.end.getY())) {
                        if (other.start.getY() <= Math.max(this.start.getY(), this.end.getY())) {
                            return other.start;
                        }
                    }
                }

            }
            //two vertical lines
            if (this.start.getX() == this.end.getX() && other.start.getX() == other.end.getX()) {
                if (this.start.getX() == other.start.getX()
                        && (Math.max(start.getY(), end.getY()) == Math.min(other.start.getY(), other.end.getY()))) {
                    Point intersection = new Point(start.getX(), Math.max(start.getY(), end.getY()));
                    return intersection;
                }

                if (Math.min(start.getY(), end.getY()) == Math.max(other.start.getY(), other.end.getY())) {
                    Point intersection = new Point(this.start.getX(), Math.min(this.start.getY(), this.end.getY()));
                    return intersection;
                }

            } else { // two lines intersection one of them is vertical line.
                if (this.start.getX() == this.end.getX()) {
                    y = other.slope() * start.getX() + other.yAxisIntersection(other.slope());
                    x = start.getX();
                    Point intersection = new Point(x, y);
                    if (this.containAPoint(intersection) && other.containAPoint(intersection)) {
                        return intersection;
                    }
                }
                if (other.start.getX() == other.end.getX()) {
                    y = this.slope() * other.start.getX() + this.yAxisIntersection(this.slope());
                    x = other.start.getX();
                    Point intersection = new Point(x, y);
                    if (this.containAPoint(intersection) && other.containAPoint(intersection)) {
                        return intersection;
                    }
                }
            }
        }
        double slope1 = this.slope();
        double slope2 = other.slope();
        double yAxisIntersection1 = this.yAxisIntersection(slope1);
        double yAxisIntersection2 = other.yAxisIntersection(slope2);
        // point and a line intersection.
        if (this.start.equals(this.end) && !other.start.equals(other.end)) {
            if (this.start.getY() == slope2 * this.start.getX() + yAxisIntersection2) {
                return this.start;
            }
        }
        if (!this.start.equals(this.end) && other.start.equals(other.end)) {
            if (other.start.getY() == slope1 * other.start.getX() + yAxisIntersection1) {
                return other.start;
            }
        }
        // two lines intersection - if the line parallel to the X Axis.
        if (slope1 == 0) {
            double p = (this.start.getY() - yAxisIntersection2) / slope2;
            if (this.start.getY() == slope2 * p + yAxisIntersection2) {
                Point intersection = new Point(p, this.start.getY());
                if (this.containAPoint(intersection) && other.containAPoint(intersection)) {
                    return intersection;
                }
            }
        }
        if (slope2 == 0) {
            double p = (other.start.getY() - yAxisIntersection1) / slope1;
            if (other.start.getY() == slope1 * p + yAxisIntersection1) {
                Point intersection = new Point(p, other.start.getY());
                if (this.containAPoint(intersection) && other.containAPoint(intersection)) {
                    return intersection;
                }
            }
        }

        // two lines intersection.
        if (slope1 != 0 && slope2 != 0) {
            if (slope1 != slope2) { // different slope.
                x = (yAxisIntersection2 - yAxisIntersection1) / (slope1 - slope2);
                y = (slope1 * x) + yAxisIntersection1;
                Point intersection = new Point(x, y);
                if (this.containAPoint(intersection) && other.containAPoint(intersection)) {
                    return intersection;
                }
            }
        } else { //equal slopes.
            if (yAxisIntersection1 != yAxisIntersection2) {
                return null;
            } else { // two lines with more than one intersection point.
                if ((this.start.equals(other.start()) && !this.end.equals(other.end))
                        || (!this.start.equals(other.start) && this.end.equals(other.end))) {
                    return null;
                }
            }
            if (this.start.getX() == this.end.getX()) {
                y = slope2 * start.getX() + yAxisIntersection1;
                x = start.getX();
                Point intersection = new Point(x, y);
                if (this.containAPoint(intersection) && other.containAPoint(intersection)) {
                    return intersection;
                }

            }
        }
        return null;
    }

    /**
     * public Point closestIntersectionToStartOfLine.
     *
     * @param rect - a rectangle.
     * @return - the cloeset intersection point to the start of the line.
     * this method goes over all the intersection point between a line and a rectangle.
     * and returns the colsest intersection point.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this) != null) {
            double minLength = Double.MAX_VALUE;
            Point closestPoint = null;
            java.util.List<Point> intersectionList = rect.intersectionPoints(this);

            for (Point temp : intersectionList) {
                if (this.start.distance(temp) < minLength) {
                    minLength = this.start.distance(temp);
                    closestPoint = temp;
                }
            }

            return closestPoint;
        } else {
            return null;
        }
    }

}


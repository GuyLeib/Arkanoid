// Guy Leib 316311190.

import java.util.List;
import java.util.ArrayList;

/**
 * public class Rectangle.
 *
 * @author - Guy Leib.
 * version 1.0
 * since 29/04/2021.
 * this class will construct and hold the information about the rectangles in the program.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * public Rectangle.
     *
     * @param upperLeft - the upper left point of the rectangle.
     * @param width     -  the width of the rectangle.
     * @param height    - the height of the rectangle.
     *                  this method construct a new rectangle with location ,width and height.
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;

    }

    /**
     * public Point getUpperLeft.
     *
     * @return - the upper left point of the rectangle.
     * this method will return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     * public Point topRight.
     *
     * @return - the top right point of the rectangle.
     * this method will return the top right point of the triangle.
     */
    public Point topRight() {
        double x = upperLeft.getX() + width;
        double y = upperLeft.getY();
        Point topRight = new Point(x, y);
        return topRight;
    }

    /**
     * public Point bottomLeft.
     *
     * @return - the bottom left point of the triangle.
     * this method return the bottom left point of the rectangle.
     */
    public Point bottomLeft() {
        double x = upperLeft.getX();
        double y = upperLeft.getY() + height;
        Point bottomLeft = new Point(x, y);
        return bottomLeft;
    }

    /**
     * public Point bottomRight.
     *
     * @return - the bottom right point of the triangle.
     * this method return the bottom right point of the rectangle.
     */
    public Point bottomRight() {
        double x = topRight().getX();
        double y = bottomLeft().getY();
        Point bottomRight = new Point(x, y);
        return bottomRight;
    }

    /**
     * public Line upperLine.
     *
     * @return - the upper line of the rectangle.
     * this method will return the upper line of the rectangle.
     */
    public Line upperLine() {
        Line topLine = new Line(upperLeft, topRight());
        return topLine;
    }

    /**
     * public Line bottomLine.
     *
     * @return - the bottom line of the rectangle.
     * this method will return the bottom line of the rectangle.
     */
    public Line bottomLine() {
        Line bottomLine = new Line(bottomLeft(), bottomRight());
        return bottomLine;
    }

    /**
     * public Line leftLine.
     *
     * @return - the left line of the rectangle.
     * this method will return the left line of the rectangle.
     */
    public Line leftLine() {
        Line leftLine = new Line(upperLeft, bottomLeft());
        return leftLine;
    }

    /**
     * public Line rightLine.
     *
     * @return - the right line of the rectangle.
     * this method will return the right line of the rectangle.
     */
    public Line rightLine() {
        Line rightLine = new Line(topRight(), bottomRight());
        return rightLine;
    }

    /**
     * public java.util.List<Point> intersectionPoints.
     *
     * @param line - the line to check intersection points with.
     * @return - a list of intersection points.
     * this method will check if there is an intersection points between one the rectangle lines.
     * if there is it'll add it to a list and return the list.
     * if the list is empty, it'll return null.
     */
    // Return a (possibly empty) List of intersection points
    // with the specified line.
    public java.util.List<Point> intersectionPoints(Line line) {
        List<Point> listOfPoints = new ArrayList<Point>();
        //check intersection with each line:
        if (upperLine().isIntersecting(line)
                && upperLine().intersectionWith(line) != null) {
            listOfPoints.add(upperLine().intersectionWith(line));
        }
        if (bottomLine().isIntersecting(line)
                && bottomLine().intersectionWith(line) != null) {
            listOfPoints.add(bottomLine().intersectionWith(line));
        }
        if (leftLine().isIntersecting(line)
                && leftLine().intersectionWith(line) != null) {
            listOfPoints.add(leftLine().intersectionWith(line));
        }
        if (rightLine().isIntersecting(line)
                && rightLine().intersectionWith(line) != null) {
            listOfPoints.add(rightLine().intersectionWith(line));
        }

        if (listOfPoints.isEmpty()) {
            return null;
        } else {
            return listOfPoints;
        }
    }

    /**
     * public double getWidth.
     *
     * @return - the width of the rectangle
     */
    // Return the width and height of the rectangle
    public double getWidth() {
        return width;
    }

    /**
     * public double getHeight.
     *
     * @return - the height of the rectangle
     */
    public double getHeight() {
        return height;
    }

    /**
     * public boolean isContainPoint.
     *
     * @param point - a point to check.
     * @return - true if the point is inside the rectangle, false otherwise.
     * this method will check if a given point is inside the rectangle.
     */
    public boolean isContainPoint(Point point) {
        return point.getX() >= this.getUpperLeft().getX()
                && point.getX() <= this.upperLine().end().getX()
                && point.getY() >= this.getUpperLeft().getY()
                && point.getY() <= this.bottomLine().start().getY();
    }
}

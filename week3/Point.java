/*************************************************************************
 * Name:
 * Email:
 *
 * Compilation:  javac Point.java
 * Execution:
 * Dependencies: StdDraw.java
 *
 * Description: An immutable data type for points in the plane.
 *
 *************************************************************************/

import java.util.Comparator;

public class Point implements Comparable<Point> {

    // compare points by slope
    public final Comparator<Point> SLOPE_ORDER = new SlopeComparator();

    private final int x;                              // x coordinate
    private final int y;                              // y coordinate

    private class SlopeComparator implements Comparator<Point>
    {    
        public int  compare(Point p1, Point p2)
        {
            Point p = new Point(x, y);
        
            if (p1.y == p2.y && p1.x != p2.x) return 0;
            if (p1.y != p2.y && p1.x == p2.x) return (int) Double.POSITIVE_INFINITY;
            if (p1.compareTo(p2) == 0) return (int) Double.NEGATIVE_INFINITY;
        
            if (p.slopeTo(p1) < p.slopeTo(p2)) return -1;
            
            return 1;
        }
    }
    
    // create the point (x, y)
    public Point(int x, int y) {
        /* DO NOT MODIFY */
        this.x = x;
        this.y = y;
    }

    // plot this point to standard drawing
    public void draw() {
        /* DO NOT MODIFY */
        StdDraw.point(x, y);
    }

    // draw line between this point and that point to standard drawing
    public void drawTo(Point that) {
        /* DO NOT MODIFY */
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    // slope between this point and that point
    public double slopeTo(Point that) {
        if (this.y == that.y && this.x != that.x) return 0;
        if (this.y != that.y && this.x == that.x) return Double.POSITIVE_INFINITY;
        if (this.compareTo(that) == 0) return Double.NEGATIVE_INFINITY;
    
        return (double)(that.y - this.y)/((double)(that.x - this.x));
    }

    // is this point lexicographically smaller than that one?
    // comparing y-coordinates and breaking ties by x-coordinates
    public int compareTo(Point that) {
        if (this.y < that.y) return -1;
        if (this.y == that.y && this.x < that.x) return -1;
        if (this.y == that.y && this.x == that.x) return 0;
        
        return 1;
    }

    // return string representation of this point
    public String toString() {
        /* DO NOT MODIFY */
        return "(" + x + ", " + y + ")";
    }

    // unit test
    public static void main(String[] args) {
        /* YOUR CODE HERE */
        Point p = new Point(10000, 0);
        Point p1 = new Point(6000, 7000);
        
        StdOut.println(p.slopeTo(p1));
    }
}
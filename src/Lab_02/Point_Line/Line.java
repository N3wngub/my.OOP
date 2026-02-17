package Point_Line;

public class Line {
    private Point start;
    private Point end;

    public Line() {
        start = new Point();
        end = new Point();
    }

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int xStart, int yStart, int xEnd, int yEnd) {
        start = new Point(xStart, yStart);
        end   = new Point(xEnd, yEnd);
    }

    void setStartPoint(int x, int y) {
        start = new Point(x, y);
    }

    void setEndPoint(int x, int y) {
        end = new Point(x, y);
    }

    Point getStartPoint() {
        return start;
    }

    Point getEndPoint() {
        return end;
    }

    double distance() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    @Override
    public String toString() {
        return "Line [start=" + start.toString() + ", end=" + end.toString() + "]";
    }
}




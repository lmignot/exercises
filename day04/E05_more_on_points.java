 //
 class Point {
    double x;
    double y;
    // sum of the squared distance between each axis

    double distanceTo(Point point) {
        double distanceX = point.x - this.x;
        double distanceY = point.y - this.y;

        distanceX = distanceX * distanceX;
        distanceY = distanceY * distanceY;

        return Math.sqrt(distanceX + distanceY);
    }

    double distanceToOrigin() {
        Point origin = new Point();
        origin.x = 0;
        origin.y = 0;

        return distanceTo(origin);
    }

    void moveTo(Point point) {
        this.x = point.x;
        this.y = point.y;
    }

    void moveTo(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Point clone() {
        Point point = new Point();
        point.x = this.x;
        point.y = this.y;
        return point;
    }

    Point opposite() {
        Point point = new Point();
        point.x = (this.x *1);
        point.y = (this.y *1);
        return point;
    }
}
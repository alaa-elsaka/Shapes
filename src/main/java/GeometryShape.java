abstract public class GeometryShape {
    protected String color;
    protected Point center;
    protected Point location;

    public GeometryShape(){
        this.color = "Burnt Umber";
    }
    abstract void setColor(String color);

    abstract String getColor();

    abstract double getPerimeter();

    abstract double getArea();


    public void setCenterPoint(Point point) {
        //Point p = new Point(point.getX(), point.getY());
        this.center = point;
    }


    public Point getCenterPoint() {
        return this.center;
    }


    public void setLocationPoint(Point point) {
        this.location = point;
    }


    public Point getLocationPoint() {
        return this.location;
    }

    public Point moveCoordinate(Point customPoint){
        return this.center.addCoordinate(customPoint);

    }
}

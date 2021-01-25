public class Circle extends GeometryShape{
    private int radius;
    private final double PI = 3.14;

    public Circle() {
        this.radius = 1;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    void setColor(String color) {
        this.color = color;
    }

    @Override
    String getColor() {
        return this.color;
    }

    @Override
    double getPerimeter() {
        return (2 * PI * radius);
    }

    @Override
    double getArea() {
        return PI * this.radius * this.radius;
    }

    @Override
    public String toString(){
        String result = "";
        result =(this.location != null) ? String.format(
                "circle of radius <%d> at (%d,%d)",
                this.radius,this.getLocationPoint().getX(),
                this.getLocationPoint().getY()):
                String.format(
                        "circle of radius <%d>",
                        this.radius);

        return result;


    }
}

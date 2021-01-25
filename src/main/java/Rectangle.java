public class Rectangle extends GeometryShape{
    private int width;
    private int length;

    public Rectangle() {
        this.width = 1;
        this.length = 1;

    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getLength() {
        return this.length;
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
        return 2 * (this.length + this.width);
    }

    @Override
    double getArea() {
        return this.length * this.width;
    }

    @Override
    public String toString(){
        String result = "";
            result =(this.location != null) ? String.format(
                    "<%d> X <%d> rectangle at (%d,%d)",
                    width,length,this.getLocationPoint().getX(),
                    this.getLocationPoint().getY()):
                    String.format(
                            "<%d> X <%d> rectangle",
                            width,length);

        return result;


    }

}

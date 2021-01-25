public class Point {

    private int x;
    private int y;

    public Point(){}
    public Point(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Point addCoordinate(Point customPoint) {
        this.x += customPoint.getX();
        this.y += customPoint.getY();
        return this;
    }

    @Override
    public String toString(){
        return String.format("(%d,%d)",this.x,this.y);

    }
}


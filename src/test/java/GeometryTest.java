import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GeometryTest {

    private  Rectangle rectangle;
    private  Circle circle;
    private  Point point;


    @BeforeEach
    public void setup(){
        rectangle = new Rectangle();
        circle = new Circle();
        point = new Point();

    }

    @Test
    public void CreateRectangleAndRetrieveLW(){
        rectangle.setWidth(15);
        rectangle.setLength(10);

        assertEquals(15, rectangle.getWidth());
        assertEquals(10, rectangle.getLength());
    }

    @Test
    public  void CreateRectangleWithoutArgument(){
        assertEquals(1, rectangle.getWidth());
        assertEquals(1, rectangle.getLength());
    }

    @Test
    public void ChangeRectangleWidth(){
        rectangle.setWidth(20);
        assertEquals(20, rectangle.getWidth());
    }

    @Test
    public void ChangeRectangleLength(){
        rectangle.setLength(20);
        assertEquals(20, rectangle.getLength());
    }

    @Test
    public void CreateCircleWithRadius(){
        circle.setRadius(15);
        assertEquals(15, circle.getRadius());
    }

    @Test
    public  void CreateCircleWithoutArgument(){
        assertEquals(1, circle.getRadius());
    }

    @Test
    public void ChangeChangeRadius(){
        circle.setRadius(20);
        assertEquals(20, circle.getRadius());
    }

    @Test
    public void RetrieveShapeColour(){
        GeometryShape shape = circle;
        circle.setColor("Red");
        assertEquals("Red",circle.getColor());

        shape = rectangle;
        rectangle.setColor("Blue");
        assertEquals("Blue",rectangle.getColor());
    }

    @Test
    public void RetrieveShapeColourNoSetter(){
        GeometryShape shape = circle;
        assertEquals("Burnt Umber",circle.getColor());

        shape = rectangle;
        assertEquals("Burnt Umber",rectangle.getColor());
    }

    @Test
    public void RetrieveShapePerimeter(){
        GeometryShape shape = circle;
        assertEquals(6.28,circle.getPerimeter(),0);

        shape = rectangle;
        assertEquals(4,rectangle.getPerimeter());
    }

    @Test
    public void RetrieveShapeArea(){
        GeometryShape shape = circle;
        assertEquals(3.14,circle.getArea(),0);

        shape = rectangle;
        assertEquals(1,rectangle.getArea());
        rectangle.setLength(3);
        assertEquals(3,rectangle.getArea());
    }

    @Test
    public void CreatePointRetrieveCoordinates(){
        point = new Point(15,10);
        assertEquals(15, point.getX());
        assertEquals(10, point.getY());
    }

    @Test
    public void SetShapeCenterLocationToPoint(){
        point = new Point(15,10);
        GeometryShape shape = circle;
        shape.setCenterPoint(point);
        assertEquals(15, shape.getCenterPoint().getX());
        assertEquals(10, shape.getCenterPoint().getY());
    }

    @Test
    public void SetShapeLocationToPoint(){
        point = new Point(15,10);
        GeometryShape shape = circle;
        shape.setLocationPoint(point);
        assertEquals(15, shape.getLocationPoint().getX());
        assertEquals(10, shape.getLocationPoint().getY());
    }

    @Test
    public void CheckNoShapeLocation(){
        GeometryShape shape = circle;
        assertEquals(null, shape.getLocationPoint());
    }

    @Test
    public void checkAddCoordinates(){
        Point originalPoint = new Point(15,10);
        Point customPoint = new Point(2,3);

        Point result = originalPoint.addCoordinate(customPoint);

        assertEquals(17 ,result.getX() );
        assertEquals(13 ,result.getY() );

    }

    @Test
    public void checkMoveCenterPoint(){
        point = new Point(15,10);
        GeometryShape shape = circle;
        shape.setCenterPoint(point);
        Point customPoint = new Point(2,3);
        Point result = shape.moveCoordinate(customPoint);
        assertEquals(17 ,result.getX() );
        assertEquals(13 ,result.getY() );

    }

    @Test
    public void checkAbsoluteLinearDistance(){
        Point point1 = new Point(5,5);
        Point point2 = new Point(8,12);

        GeometryShape shape1 = circle;
        GeometryShape shape2 = rectangle;

        shape1.setCenterPoint(point1);
        shape2.setCenterPoint(point2);

        int resultX =  Math.abs(shape1.getCenterPoint().getX()
        - shape2.getCenterPoint().getX());
        int resultY =  Math.abs(shape1.getCenterPoint().getY()
                - shape2.getCenterPoint().getY());

        assertEquals(3, resultX);
        assertEquals(7, resultY);

    }

    @Test
    public void checkPrintRecatangleWithinPlane(){
        GeometryShape shape = rectangle;
        Point point = new Point(5,5);
        rectangle.setWidth(15);
        rectangle.setLength(10);
        shape.setLocationPoint(point);
        String expected = "<15> X <10> rectangle at (5,5)";
        assertTrue(expected.equals(shape.toString()));
    }

    @Test
    public void checkPrintRecatangleNoWithinPlane(){
        GeometryShape shape = rectangle;
        rectangle.setWidth(15);
        rectangle.setLength(10);
        String expected = "<15> X <10> rectangle";
        assertTrue(expected.equals(shape.toString()));
    }
    @Test
    public void checkPrintCircleWithinPlane(){
        GeometryShape shape = circle;
        Point point = new Point(5,5);
        circle.setRadius(15);
        shape.setLocationPoint(point);
        String expected = "circle of radius <15> at (5,5)";
        assertTrue(expected.equals(shape.toString()));
    }

    @Test
    public void checkPrintCircleNoWithinPlane(){
        GeometryShape shape = circle;
        circle.setRadius(15);
        String expected = "circle of radius <15>";
        assertTrue(expected.equals(shape.toString()));
    }

    @Test
    public void checkPrintPoint(){
        Point point = new Point(5, 8);
        String expected = "(5,8)";
        assertTrue(expected.equals(point.toString()));
    }

    @Test
    public void checkPlaneRepresentation()
    {
        GeometryShape shape1 = circle;
        circle.setRadius(15);
        GeometryShape shape2 = rectangle;
        rectangle.setWidth(15);
        rectangle.setLength(10);
        Plane plane = new Plane();
        plane.addShape(shape1);
        plane.addShape(shape2);

        String expected = "circle of radius <15><15> X <10> rectangle";
        String result = plane.toString();
        assertTrue(expected.equals(result));
    }
}

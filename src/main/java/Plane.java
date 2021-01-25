

import java.util.ArrayList;
import java.util.List;

public class Plane {

    private List<GeometryShape> shapes = new ArrayList<>();

    public void addShape(GeometryShape shape){
        shapes.add(shape);
    }


    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();

        for(GeometryShape shape : shapes){
            sb.append(shape);
        }
        return sb.toString();
    }
}

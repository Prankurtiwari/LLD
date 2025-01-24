package Creational_Design_Pattern.FactoryPattern;

public class ShapeMain {
    public static void main(String[] args) {
        Shape shape;
        ShapeFactory shapeFactory = new ShapeFactory();
        shape = shapeFactory.getShape("circle");
        shape.draw();
        shape = shapeFactory.getShape("triangle");
        shape.draw();
    }
}

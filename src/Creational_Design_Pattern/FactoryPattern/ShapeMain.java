package Creational_Design_Pattern.FactoryPattern;

public class ShapeMain {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.getShape("circle").draw();
        shapeFactory.getShape("triangle").draw();
    }
}

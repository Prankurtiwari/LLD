package Creational_Design_Pattern.FactoryPattern;

public class ShapeFactory {
    private Shape shape;

    public Shape getShape(String input) {
        switch (input) {
            case "circle":
                shape = new Circle();
                break;
            case "rectangle":
                shape = new Rectangle();
                break;
            case "square":
                shape = new Square();
                break;
            default:
                throw new RuntimeException("Invalid Shape");
        }
        return shape;
    }
}

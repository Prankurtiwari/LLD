package SOLID.liskovSubstition.without;


public class Bicycle extends Vehicle {
  public boolean hasEngine() {
      throw new RuntimeException(" no Engine");
  }
}

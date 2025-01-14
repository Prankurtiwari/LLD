package Behavioural_Design_Pattern.StrategyPattern.with.Strategy;

public class NormalDriveStrategy implements DriveStrategy{
    @Override
    public void drive() {
        System.out.println("normal drive");
    }
}

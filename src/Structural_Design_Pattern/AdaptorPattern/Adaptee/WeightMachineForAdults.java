package Structural_Design_Pattern.AdaptorPattern.Adaptee;

public class WeightMachineForAdults implements WeightMachine{
    @Override
    public double getWeightInPounds() {
        return 28.0;
    }
}

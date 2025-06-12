package Structural_Design_Pattern.AdaptorPattern.Adaptor;

import Structural_Design_Pattern.AdaptorPattern.Adaptee.WeightMachine;
import Structural_Design_Pattern.AdaptorPattern.Adaptee.WeightMachineForAdults;

public class WeightMachineAdaptorImpl implements WeightMachineAdaptor{

    WeightMachine machine;

    public WeightMachineAdaptorImpl(WeightMachine machine) {
        this.machine = machine;
    }

    @Override
    public double getWeightInKg() {
        double weight = machine.getWeightInPounds();
        return weight * 0.45;
    }
}

package Structural_Design_Pattern.AdaptorPattern.Client;

import Structural_Design_Pattern.AdaptorPattern.Adaptee.WeightMachineForAdults;
import Structural_Design_Pattern.AdaptorPattern.Adaptor.WeightMachineAdaptor;
import Structural_Design_Pattern.AdaptorPattern.Adaptor.WeightMachineAdaptorImpl;

public class Main {
    public static void main(String[] args) {
        WeightMachineAdaptor adaptor = new WeightMachineAdaptorImpl(new WeightMachineForAdults());
        System.out.println(adaptor.getWeightInKg());
    }
}

package Behavioural_Design_Pattern.NullObjectPattern;

import Behavioural_Design_Pattern.NullObjectPattern.factory.MachineFactory;
import Behavioural_Design_Pattern.NullObjectPattern.model.Machine;

public class MachineDemo {
    public static void main(String[] args) {
        Machine handMachine = MachineFactory.getMachineObject("hand");
        System.out.println(handMachine.getFuelCapacity());
        System.out.println(handMachine.seatingCapacity());

        Machine nullMachine  = MachineFactory.getMachineObject("auto");
        System.out.println(nullMachine.getFuelCapacity());
        System.out.println(nullMachine.seatingCapacity());
    }
}

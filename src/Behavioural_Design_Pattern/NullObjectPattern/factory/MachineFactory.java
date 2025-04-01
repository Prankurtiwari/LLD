package Behavioural_Design_Pattern.NullObjectPattern.factory;

import Behavioural_Design_Pattern.NullObjectPattern.model.Machine;
import Behavioural_Design_Pattern.NullObjectPattern.model.impl.HandMachine;
import Behavioural_Design_Pattern.NullObjectPattern.model.impl.NullMachine;

public class MachineFactory {
    public static Machine getMachineObject(String typeofMachine) {
        if ("hand".equals(typeofMachine)) {
            return new HandMachine();
        }
        return new NullMachine();
    }
}

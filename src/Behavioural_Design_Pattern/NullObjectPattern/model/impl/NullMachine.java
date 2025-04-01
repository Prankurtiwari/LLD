package Behavioural_Design_Pattern.NullObjectPattern.model.impl;

import Behavioural_Design_Pattern.NullObjectPattern.model.Machine;

public class NullMachine implements Machine {
    @Override
    public int getFuelCapacity() {
        return 0;
    }

    @Override
    public int seatingCapacity() {
        return 0;
    }
}

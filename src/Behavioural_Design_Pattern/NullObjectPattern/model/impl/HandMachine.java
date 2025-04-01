package Behavioural_Design_Pattern.NullObjectPattern.model.impl;

import Behavioural_Design_Pattern.NullObjectPattern.model.Machine;

public class HandMachine implements Machine {
    @Override
    public int getFuelCapacity() {
        return 100;
    }

    @Override
    public int seatingCapacity() {
        return 6;
    }
}

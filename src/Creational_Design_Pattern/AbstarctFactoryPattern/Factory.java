package Creational_Design_Pattern.AbstarctFactoryPattern;

public abstract class Factory {
    public GPU gpu;
    public Monitor monitor;

    public abstract GPU createGPU();
    public abstract Monitor createMonitor();

}

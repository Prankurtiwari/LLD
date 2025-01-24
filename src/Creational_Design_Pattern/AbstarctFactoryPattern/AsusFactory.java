package Creational_Design_Pattern.AbstarctFactoryPattern;

public class AsusFactory extends Factory {
    @Override
    public GPU createGPU() {
        this.gpu = new AsusGPU();
        return this.gpu;
    }

    @Override
    public Monitor createMonitor() {
        this.monitor = new AsusMonitor();
        return this.monitor;
    }
}

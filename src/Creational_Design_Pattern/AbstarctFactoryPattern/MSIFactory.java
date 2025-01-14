package Creational_Design_Pattern.AbstarctFactoryPattern;

public class MSIFactory extends Company{
    @Override
    public GPU createGPU() {
        this.gpu = new MSIGPU();
        return this.gpu;
    }

    @Override
    public Monitor createMonitor() {
        this.monitor = new MSIMonitor();
        return this.monitor;
    }
}

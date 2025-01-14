package SOLID.interfaceSegmented.with;

public class Waiter implements IWaiter{
    @Override
    public void serveCustomers() {
        System.out.println("serving");
    }

    @Override
    public void takeOrder() {
        System.out.println("taking order");
    }
}

package SOLID.interfaceSegmented.without;

public class waiter implements RestaurantEmployee{
    @Override
    public void washDish() {
        // not my job
    }

    @Override
    public void serveCustomers() {
        // yes my job
        System.out.println("serving");
    }

    @Override
    public void cookFood() {
        // not my job
    }
}

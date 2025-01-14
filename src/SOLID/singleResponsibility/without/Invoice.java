package SOLID.singleResponsibility.without;


class Marker {
    String name;
    String color;
    int year;
    int price;

    public Marker(String name, String color, int year, int price) {
        this.name = name;
        this.color = color;
        this.year = year;
        this.price = price;
    }
}

// Not following Single responsibility
class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculatorTotal() {
        return marker.price * this.quantity;
    }

    // printing logic can change in future
    public void printInvoice() {
        // print the invoice
    }

    // saving logic can change in future
    public void saveToDB() {
        // save to data into DB
    }
}

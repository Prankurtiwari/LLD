package SOLID.singleResponsibility.with;


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

public class Invoice {
    private Marker marker;
    private int quantity;

    public Invoice (Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public int calculatorTotal() {
        return marker.price * this.quantity;
    }

}

class  InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb() {
        //save to db;
    }

}

class InvoicePrinter {
    Invoice invoice;

    public InvoicePrinter(Invoice invoice) {
        this.invoice = invoice;
    }

    public void printInvoice() {
        //save to db;
    }
}



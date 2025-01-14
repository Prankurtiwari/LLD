package Behavioural_Design_Pattern.ObserverPattern.Observable;

import Behavioural_Design_Pattern.ObserverPattern.Observer.NotificationObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneStockObservable implements StockObservable{

    List<NotificationObserver> list = new ArrayList<>();
    final String productName = "Iphone";
    int stock;


    @Override
    public void add(NotificationObserver observer) {
        list.add(observer);
    }

    @Override
    public void remove(NotificationObserver observer) {
        list.remove(observer);
    }

    @Override
    public void alert() {
        for (NotificationObserver observer: list) {
            observer.update();
        }
    }

    @Override
    public void setStock(int newStock) {
        if (this.stock == 0) {
            alert();
        }
        if (newStock == 0) {
            this.stock = 0;
        }
        this.stock +=  newStock;
    }

    @Override
    public String getName() {
        return productName;
    }
}

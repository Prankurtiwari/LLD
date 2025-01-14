package Behavioural_Design_Pattern.ObserverPattern.Observable;

import Behavioural_Design_Pattern.ObserverPattern.Observer.NotificationObserver;

public interface StockObservable {
    void add(NotificationObserver observer);
    void remove(NotificationObserver observer);

    void alert();

    void setStock(int stock);

    String getName();
}

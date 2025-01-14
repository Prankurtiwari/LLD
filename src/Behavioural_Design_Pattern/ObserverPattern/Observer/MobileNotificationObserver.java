package Behavioural_Design_Pattern.ObserverPattern.Observer;

import Behavioural_Design_Pattern.ObserverPattern.Observable.StockObservable;

public class MobileNotificationObserver implements NotificationObserver{

    StockObservable observable;
    String number;

    public MobileNotificationObserver(StockObservable observable, String number) {
        this.observable =observable;
        this.number = number;
    }
    @Override
    public void update() {
        sendNotification(observable);
    }

    private void sendNotification(StockObservable observable) {
        System.out.println(observable.getName() + "in stock");
        System.out.println("notification set to " + number);
    }


}

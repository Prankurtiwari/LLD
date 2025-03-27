package Behavioural_Design_Pattern.ObserverPattern.Observer;

import Behavioural_Design_Pattern.ObserverPattern.Observable.StockObservable;

public class EmailNotificationObserver implements NotificationObserver{
    private final StockObservable observable;
    private final String email;

    public EmailNotificationObserver(StockObservable observable, String email) {
        this.observable =observable;
        this.email = email;
    }
    @Override
    public void update() {
        sendNotification(observable);
    }

    private void sendNotification(StockObservable observable) {
        System.out.println(observable.getName() + "in stock");
        System.out.println("notification set to " + email);
    }
}

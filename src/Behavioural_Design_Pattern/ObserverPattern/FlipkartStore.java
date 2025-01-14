package Behavioural_Design_Pattern.ObserverPattern;

import Behavioural_Design_Pattern.ObserverPattern.Observable.IphoneStockObservable;
import Behavioural_Design_Pattern.ObserverPattern.Observable.StockObservable;
import Behavioural_Design_Pattern.ObserverPattern.Observer.EmailNotificationObserver;
import Behavioural_Design_Pattern.ObserverPattern.Observer.MobileNotificationObserver;
import Behavioural_Design_Pattern.ObserverPattern.Observer.NotificationObserver;

public class FlipkartStore {

    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IphoneStockObservable();
        NotificationObserver notificationObserver1 = new EmailNotificationObserver(iphoneStockObservable, "tiwariprankur61@gmail.com");
        NotificationObserver notificationObserver2 = new MobileNotificationObserver(iphoneStockObservable, "9891364555");
        NotificationObserver notificationObserver3 = new EmailNotificationObserver(iphoneStockObservable, "prakarsh99@gmail.com");
        NotificationObserver notificationObserver4 = new MobileNotificationObserver(iphoneStockObservable, "8726362039");


        iphoneStockObservable.add(notificationObserver1);
        iphoneStockObservable.add(notificationObserver2);
        iphoneStockObservable.add(notificationObserver3);
        iphoneStockObservable.add(notificationObserver4);

        iphoneStockObservable.setStock(20);

        iphoneStockObservable.remove(notificationObserver3);
        iphoneStockObservable.remove(notificationObserver4);

        iphoneStockObservable.setStock(0);

        iphoneStockObservable.setStock(30);

    }
}

package Observer.Observable;

import Observer.Observer.NotificationAlertObserver;

public interface StockObservable {

    void add(NotificationAlertObserver notificationAlertObserver);
    void remove(NotificationAlertObserver notificationAlertObserver);
    void notifySubscribers();
    void setStockCount(int newStockAdded);
    int getStockCount();
}

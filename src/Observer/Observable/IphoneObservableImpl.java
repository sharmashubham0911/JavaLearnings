package Observer.Observable;

import Observer.Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements StockObservable{

    List<NotificationAlertObserver> notificationAlertObserverList = new ArrayList<>();

    int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver notificationAlertObserver) {

        notificationAlertObserverList.add(notificationAlertObserver);
    }

    @Override
    public void remove(NotificationAlertObserver notificationAlertObserver) {

        notificationAlertObserverList.remove(notificationAlertObserver);
    }

    @Override
    public void notifySubscribers() {

        // call update on each object

        for (NotificationAlertObserver notificationAlertObserver: notificationAlertObserverList){

            notificationAlertObserver.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {

        if (stockCount == 0){

            notifySubscribers();
        }

        stockCount += newStockAdded;
    }

    @Override
    public int getStockCount() {
        return stockCount;
    }
}

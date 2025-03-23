package Observer.Observer;

import Observer.Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver{

    String userId, msg;
    StockObservable observable;

    public MobileAlertObserverImpl(String userId, StockObservable stockObservable){

        this.userId = userId;
        this.observable = stockObservable;
    }

    @Override
    public void update() {
        sendMsgOnMobile(userId, "product is in stock, hurry up!");
    }

    void sendMsgOnMobile(String userId, String msg){
        System.out.println("Msg Send to userId " + userId);
        System.out.println(msg);
        System.out.println("currentStock: " + observable.getStockCount());
    }
}

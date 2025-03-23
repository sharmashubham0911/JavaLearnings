package Observer.Observer;

import Observer.Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    StockObservable observable;
    String emailId, msg;

    public EmailAlertObserverImpl (String emailId, StockObservable observable){
        this.emailId =  emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendEmail(emailId, "Email: Iphone is in stock, hurryUp!");
    }

    void sendEmail(String emailId, String msg){
        System.out.println("emailId " + emailId);
        System.out.println(msg);
        System.out.println("currentStock: " + observable.getStockCount());
    }
}

package Singleton;

public class Singletone {



    private Singletone(){

    }

    private static class SingletoneHelper{

        private static final Singletone singletoneObj = new Singletone();
    }

    public static Singletone getSingletonObject(){
        return SingletoneHelper.singletoneObj;
    }

}

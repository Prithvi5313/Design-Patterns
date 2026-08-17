package DesignPatterns.CreationalDesignPatterns.Singleton;

public class Singleton {
    private static Singleton singleton;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main (String[] args){
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();
        System.out.println(singleton1 == singleton2);

    }
}

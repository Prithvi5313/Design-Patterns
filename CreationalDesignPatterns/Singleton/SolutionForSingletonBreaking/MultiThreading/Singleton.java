package DesignPatterns.CreationalDesignPatterns.Singleton.SolutionForSingletonBreaking.MultiThreading;



public class Singleton implements Cloneable {
    private static Singleton singleton;
    private Singleton(){
    }

    public static Singleton getInstance(){
        if (singleton == null) {

            synchronized (Singleton.class) {

                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }


    public static void main (String[] args) throws CloneNotSupportedException {

    }
}

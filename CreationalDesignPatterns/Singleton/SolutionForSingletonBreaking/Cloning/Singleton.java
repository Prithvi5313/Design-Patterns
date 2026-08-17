package DesignPatterns.CreationalDesignPatterns.Singleton.SolutionForSingletonBreaking.Cloning;



public class Singleton implements Cloneable {
    private static Singleton singleton;
    private Singleton(){

    }

    public static Singleton getInstance(){
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    //Solution Block
    @Override
    protected Singleton clone() throws CloneNotSupportedException {
        return singleton;
    }
    //Solution Block end

}
class Main{
    public static void main (String[] args) throws CloneNotSupportedException {
        Singleton s1 = Singleton.getInstance();
        Singleton s2 = (Singleton) s1.clone();
        System.out.println(s1 == s2);

    }
}

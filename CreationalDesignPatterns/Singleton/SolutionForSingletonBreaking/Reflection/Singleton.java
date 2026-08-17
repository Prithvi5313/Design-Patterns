package DesignPatterns.CreationalDesignPatterns.Singleton.SolutionForSingletonBreaking.Reflection;

import java.lang.reflect.Constructor;

public class Singleton {
    private static Singleton singleton;
    private Singleton(){
        //solution block
        if (singleton != null) {
            throw new RuntimeException("Use getInstance()");
        }
        //solution block end
    }

    public static Singleton getInstance(){
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

}
class Main{

    public static void main (String[] args) throws Exception{
        Singleton s1 = Singleton.getInstance();
        Constructor<Singleton> constructor = Singleton.class.getDeclaredConstructor();
        constructor.setAccessible(true);
        Singleton s2 = constructor.newInstance();
        System.out.println(s1 == s2);

    }
}

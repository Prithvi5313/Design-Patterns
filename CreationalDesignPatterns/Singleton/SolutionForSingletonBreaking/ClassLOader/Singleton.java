package DesignPatterns.CreationalDesignPatterns.Singleton.SolutionForSingletonBreaking.ClassLOader;
public class Singleton {

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
class main{
    public static void main(String[] args) {

        Singleton s1 = Singleton.getInstance();
        Singleton s2 = Singleton.getInstance();

        ClassLoader loader = Singleton.class.getClassLoader();

        System.out.println(loader);
        System.out.println(s1 == s2);
    }
}
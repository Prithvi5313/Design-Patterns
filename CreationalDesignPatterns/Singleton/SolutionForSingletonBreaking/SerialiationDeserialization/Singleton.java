package DesignPatterns.CreationalDesignPatterns.Singleton.SolutionForSingletonBreaking.SerialiationDeserialization;


import java.io.*;

public class Singleton implements  Serializable{
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
    protected Object readResolve() {
        return getInstance();
    }
    //Solution Block end
}
class Main{
    public static void main (String[] args) throws IOException, ClassNotFoundException {
        Singleton s1 = Singleton.getInstance();
        ObjectOutputStream out =
                new ObjectOutputStream(
                        new FileOutputStream("object.ser"));
        out.writeObject(s1);
        out.close();

        ObjectInputStream in =
                new ObjectInputStream(
                        new FileInputStream("object.ser"));

        Singleton s2 = (Singleton) in.readObject();
        in.close();
        System.out.println(s1 == s2);

    }
}

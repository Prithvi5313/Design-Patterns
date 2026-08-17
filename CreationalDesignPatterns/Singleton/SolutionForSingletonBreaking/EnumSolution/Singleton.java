package DesignPatterns.CreationalDesignPatterns.Singleton.SolutionForSingletonBreaking.EnumSolution;

enum Singleton {

    INSTANCE;

    public void doSomething() {
        System.out.println("Doing something...");
    }


}
class Main{

    public static void main(String[] args) {

        Singleton s1 = Singleton.INSTANCE;
        Singleton s2 = Singleton.INSTANCE;

        System.out.println(s1 == s2);
    }
}
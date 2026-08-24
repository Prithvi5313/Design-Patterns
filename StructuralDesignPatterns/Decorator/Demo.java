package DesignPatterns.StructuralDesignPatterns.Decorator;

interface Burger{

     double getCost();

     String getDescription();
}

class ZingerBurger implements Burger{

    @Override
    public double getCost() {
        return 180.0;
    }

    @Override
    public String getDescription() {
        return "This is Zinger Burger";
    }
}

class VegBurger implements Burger{

    @Override
    public double getCost() {
        return 150.0;
    }

    @Override
    public String getDescription() {
        return "This is Veg Burger";
    }
}

interface  BurgerDecorator extends Burger{

}

class ExtraCheese implements  BurgerDecorator{

    Burger burger;

    public ExtraCheese(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getCost() {
        return burger.getCost() + 30;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Added Cheese";
    }
}
class ExtraMayonese implements  BurgerDecorator{

    Burger burger;

    public ExtraMayonese(Burger burger) {
        this.burger = burger;
    }

    @Override
    public double getCost() {
        return burger.getCost() + 10;
    }

    @Override
    public String getDescription() {
        return burger.getDescription() + ", Added Mayo";
    }
}
public class Demo {
    public static void main (String [] args){
        Burger burger = new ZingerBurger();
        burger = new ExtraCheese(burger);
        System.out.println(burger.getCost());
        System.out.println(burger.getDescription());
        burger = new ExtraMayonese(burger);
        System.out.println(burger.getCost());
        System.out.println(burger.getDescription());
    }

}

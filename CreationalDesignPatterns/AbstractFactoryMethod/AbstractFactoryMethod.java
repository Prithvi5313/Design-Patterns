package DesignPatterns.CreationalDesignPatterns.AbstractFactoryMethod;


interface Checkbox{
    void check();
}
interface Button{
    void click();
}

class WindowsCheckBox implements Checkbox{
    @Override
    public void check(){
        System.out.println("Windows CheckBox");
    }
}
class WindowsButton implements Button{
    @Override
    public void click(){
        System.out.println("Windows Button");
    }
}

class MacButton implements Button{
    @Override
    public void click(){
        System.out.println("Mac Button");
    }
}
class MacCheckBox implements Checkbox{
    @Override
    public void check(){
        System.out.println("Mac CheckBox");
    }
}

interface AbstractFactoryMethod{
    Button createButton();
    Checkbox createCheckBox();
}
 class WindowsFactory implements  AbstractFactoryMethod{

    @Override
    public Button createButton(){
        return new WindowsButton();
    }

     @Override
     public Checkbox createCheckBox() {
         return new WindowsCheckBox();

     }
 }

class MacFactory implements  AbstractFactoryMethod{

    @Override
    public Button createButton(){
        return new MacButton();
    }

    @Override
    public Checkbox createCheckBox() {
        return new MacCheckBox();

    }
}

class main{
    public static void main(String args[]){
        AbstractFactoryMethod gui = new MacFactory();
        Button button = gui.createButton();
        button.click();
        Checkbox checkbox = gui.createCheckBox();
        checkbox.check();

    }
}


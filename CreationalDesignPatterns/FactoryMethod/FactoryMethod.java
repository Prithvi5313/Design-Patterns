package DesignPatterns.CreationalDesignPatterns.FactoryMethod;


interface Notification{
    void send();
}

class Email implements Notification{
    @Override
    public void send() {
        System.out.println("Sending Email");
    }
}

class Sms implements Notification{
    @Override
    public void send() {
        System.out.println("Sending Sms");
    }
}
public class FactoryMethod {
    public static Notification createNotification(String type){
        if(type.trim().equalsIgnoreCase("Email"))
            return new Email();
        else if((type.trim().equalsIgnoreCase("Sms")))
            return new Sms();
        return null;
    }
}

class Main{
    public static void main(String [] args){
        Notification notification1 = FactoryMethod.createNotification("Email");
        notification1.send();
        Notification notification2 = FactoryMethod.createNotification("Sms");
        notification2.send();
    }
}


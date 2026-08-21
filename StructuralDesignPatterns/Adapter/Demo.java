package DesignPatterns.StructuralDesignPatterns.Adapter;

interface AppleCharger {
    void chargeApplePhone();
}

interface AndroidCharger {
    void chargeAndroidPhone();
}

class ChargerXYZ implements AndroidCharger {

    @Override
    public void chargeAndroidPhone() {
        System.out.println("Android phone is charging");
    }
}


// Concrete Target
class ChargerABC implements AppleCharger {

    @Override
    public void chargeApplePhone() {
        System.out.println("Apple phone is charging");
    }
}


// Client
class Iphone {

    private AppleCharger appleCharger;

    public Iphone(AppleCharger appleCharger) {
        this.appleCharger = appleCharger;
    }

    public void chargeApplePhone() {
        appleCharger.chargeApplePhone();
    }
}


// Adapter
class Adapter implements AppleCharger {

    private AndroidCharger androidCharger;

    public Adapter(AndroidCharger androidCharger) {
        this.androidCharger = androidCharger;
    }

    @Override
    public void chargeApplePhone() {

        System.out.println(
                "Adapter is converting Apple charging request to Android charging request"
        );
        androidCharger.chargeAndroidPhone();
    }
}

public class Demo {

    public static void main(String[] args) {

        // 1. Using original Apple charger
        AppleCharger appleCharger = new ChargerABC();

        Iphone iphone1 = new Iphone(appleCharger);

        iphone1.chargeApplePhone();


        System.out.println();


        // 2. Using Android charger with Adapter
        AndroidCharger androidCharger = new ChargerXYZ();

        AppleCharger adapter = new Adapter(androidCharger);

        Iphone iphone2 = new Iphone(adapter);

        iphone2.chargeApplePhone();
    }
}
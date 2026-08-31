package DesignPatterns.StructuralDesignPatterns.Proxy;

interface Image {
    void display();
}

// Real Subject
class RealImage implements Image {

    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Proxy
class ProxyImage implements Image {

    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {

        // Create the real object only when needed
        if (realImage == null) {
            realImage = new RealImage(fileName);
        }

        realImage.display();
    }
}

// Main class
public class Main {

    public static void main(String[] args) {

        Image image = new ProxyImage("test.jpg");

        // Image is loaded for the first time
        image.display();

        // Image is already loaded
        image.display();
    }
}
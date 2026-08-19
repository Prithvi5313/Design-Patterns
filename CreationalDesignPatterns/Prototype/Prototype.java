package DesignPatterns.CreationalDesignPatterns.Prototype;

class NetworkConnection implements Cloneable {

    private String ip;
    private String importantData;

    public NetworkConnection() {
        this.ip = "192.168.1.1";
    }

    public void loadImportantData() throws InterruptedException {

        System.out.println("Loading important data...");
        Thread.sleep(3000);
        importantData = "Very Important Network Data";
        System.out.println("Data loaded successfully.");
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getIp() {
        return ip;
    }

    public String getImportantData() {
        return importantData;
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", importantData='" + importantData + '\'' +
                '}';
    }

    @Override
    public NetworkConnection clone() {

        try {
            return (NetworkConnection) super.clone();

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class  Prototype {

    public static void main(String[] args) throws InterruptedException {

        // Create original object
        NetworkConnection original = new NetworkConnection();

        original.setIp("192.168.1.10");

        // Expensive operation
        original.loadImportantData();

        System.out.println("Original:");
        System.out.println(original);


        // Clone the original object
        NetworkConnection clone1 = original.clone();

        System.out.println("\nClone 1:");
        System.out.println(clone1);


        // Another clone
        NetworkConnection clone2 = original.clone();

        System.out.println("\nClone 2:");
        System.out.println(clone2);
    }
}
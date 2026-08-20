package DesignPatterns.CreationalDesignPatterns.Prototype.DeepClone;





import java.util.ArrayList;
import java.util.List;

class NetworkConnection implements Cloneable {

    private String ip;
    private String importantData;
    private List<String> links = new ArrayList<>();
    public NetworkConnection() {
        this.ip = "192.168.1.1";
    }

    public void loadImportantData() throws InterruptedException {

        links.add("www.abc.com");
        links.add("www.xyz.com");
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

    public void setImportantData(String importantData) {
        this.importantData = importantData;
    }

    public List<String> getLinks() {
        return links;
    }

    public void setLinks(List<String> links) {
        this.links = links;
    }

    @Override
    public String toString() {
        return "NetworkConnection{" +
                "ip='" + ip + '\'' +
                ", importantData='" + importantData + '\'' +
                ", links=" + links +
                '}';
    }

    @Override
    public NetworkConnection clone() {

            //Deep Clone Logic
            NetworkConnection networkConnection = new NetworkConnection();
            networkConnection.setIp(this.getIp());
            networkConnection.setImportantData((this.getImportantData()));
            for(String link : this.links){
                networkConnection.getLinks().add(link);
            }
            return networkConnection;
            //Deep Clone Logic ends here
    }
}
public class DeepClone {
    public static void main(String[] args) throws InterruptedException {

        // Create original object
       NetworkConnection original = new NetworkConnection();

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

        // Removing one value
        original.getLinks().remove(0);
        System.out.println("Original:");
        System.out.println(original);


        System.out.println("\nClone 1:");
        System.out.println(clone1);
        System.out.println("\nClone 2:");
        System.out.println(clone2);


    }
}


package DesignPatterns.StructuralDesignPatterns.Facade;

// Subsystem 1
class CPU {

    public void freeze() {
        System.out.println("CPU Freeze");
    }

    public void jump(long position) {
        System.out.println("CPU Jump to position: " + position);
    }

    public void execute() {
        System.out.println("CPU Execute");
    }
}

// Subsystem 2
class Memory {

    public void load(long position, byte[] data) {
        System.out.println("Loading data into memory...");
    }
}

// Subsystem 3
class HardDrive {

    public byte[] read(long lba, int size) {
        System.out.println("Reading data from Hard Drive...");
        return new byte[size];
    }
}

// Facade
class ComputerFacade {

    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade() {
        cpu = new CPU();
        memory = new Memory();
        hardDrive = new HardDrive();
    }

    public void start() {

        System.out.println("Starting Computer...");

        cpu.freeze();

        byte[] bootData = hardDrive.read(0, 1024);

        memory.load(0, bootData);

        cpu.jump(0);

        cpu.execute();

        System.out.println("Computer Started Successfully!");
    }
}

// Client
public class Demo {

    public static void main(String[] args) {

        ComputerFacade computer = new ComputerFacade();

        computer.start();
    }
}
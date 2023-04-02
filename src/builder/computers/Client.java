package builder.computers;

public class Client {
    public static void main(String[] args) {
        Computer.ComputerBuilder builder = new Computer.ComputerBuilder("500 GB", "8 GB");
        builder.setBluetoothEnabled(true);

        Computer computer = builder.build();
        computer.printSpec();
    }
}

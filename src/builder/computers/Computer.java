package builder.computers;

public class Computer {
    private String HDD;
    private String RAM;

    private boolean isGraphicCardEnabled;
    private boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
        this.isGraphicCardEnabled = builder.isGraphicsCardEnabled;
    }

    public void printSpec(){
        String info = "Computer Specs: "+"\n";
        info += "HDD: "+this.HDD + "\n";
        info += "RAM: "+this.RAM + "\n";
        if(this.isGraphicCardEnabled){
            info += "Graphics Enabled: Yes"+"\n";
        } else{
            info += "Graphics Enabled: No"+"\n";
        }

        if(this.isBluetoothEnabled) {
            info += "Bluetooth Enabled: Yes"+"\n";
        } else {
            info += "Bluetooth Enabled: No"+"\n";
        }

        System.out.println(info);


    }


    public static class ComputerBuilder {
        // Required Parameter
        private String HDD;
        private String RAM;

        // Optional Parameter
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled){
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build(){
            return new Computer(this);
        }


    }

}

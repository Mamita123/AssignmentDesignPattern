import java.util.List;

public class ComputerDirector {
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    public void constructComputer(String processor, int ramSizeGB, String hardDrive, String graphicsCard, String operatingSystem) {
        computerBuilder.buildProcessor(processor);
        computerBuilder.buildRAM(ramSizeGB);
        computerBuilder.buildHardDrive(hardDrive);
        computerBuilder.buildGraphicsCard(graphicsCard);
        computerBuilder.buildOperatingSystem(operatingSystem);

    }
    public void addAccessories(List<String> accessories) {
        computerBuilder.buildAccessories(accessories);
    }

    public Computer getComputer() {
        return computerBuilder.getComputer();
    }

}



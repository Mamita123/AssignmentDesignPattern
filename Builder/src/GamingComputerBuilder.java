import java.util.List;

public class GamingComputerBuilder implements ComputerBuilder{
    private Computer computer;

    public GamingComputerBuilder() {
        this.computer = new Computer("", 0, "", "", "");
    }

    @Override
    public void buildProcessor(String processor) {
        computer.setProcessor(processor);
    }

    @Override
    public void buildRAM(int ramSizeGB) {
        computer.setRamSizeGB(ramSizeGB);
    }

    @Override
    public void buildHardDrive(String hardDrive) {
        computer.setHardDrive(hardDrive);
    }

    @Override
    public void buildGraphicsCard(String graphicsCard) {
        computer.setGraphicsCard(graphicsCard);
    }

    @Override
    public void buildOperatingSystem(String operatingSystem) {
        computer.setOperatingSystem(operatingSystem);
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
    @Override
    public void buildAccessories(List<String> accessories) {
        for (String accessory : accessories) {
            computer.addAccessory(accessory);
        }
    }

}

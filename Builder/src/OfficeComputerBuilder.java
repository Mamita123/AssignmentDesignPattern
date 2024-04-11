import java.util.List;

public class OfficeComputerBuilder implements ComputerBuilder{
    private Computer computer;
    public OfficeComputerBuilder(){
        this.computer = new Computer("Default Processor",8, "Default Hard drive", "Default Grapgics Card", "Default operating system");
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

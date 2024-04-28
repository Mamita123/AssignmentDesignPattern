import java.util.List;

public interface ComputerBuilder {
    void buildProcessor(String processor);
    void buildRAM(int ramSizeGB);
    void buildHardDrive(String hardDrive);

    void buildGraphicsCard(String graphicsCard);


    void buildOperatingSystem(String operatingSystem);
    Computer getComputer();
    void buildAccessories(List<String> accessories);

}

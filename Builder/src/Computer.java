import java.util.ArrayList;
import java.util.List;

public class Computer {
    private String processor;
    private int ramSizeGB;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;

    private List<String> accessories;

    public Computer(String processor, int ramSizeGB, String hardDrive, String graphicsCard, String operatingSystem){
        this.processor = processor;
        this.ramSizeGB = ramSizeGB;
        this.hardDrive = hardDrive;
        this.graphicsCard = graphicsCard;
        this.operatingSystem = operatingSystem;
        this.accessories = new ArrayList<>();
    }

    public String getProcessor(){
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getRamSizeGB() {
        return ramSizeGB;
    }

    public void setRamSizeGB(int ramSizeGB) {
        this.ramSizeGB = ramSizeGB;
    }

    public String getHardDrive() {
        return hardDrive;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }
    public void addAccessory(String accessory) {
        accessories.add(accessory);
    }

    public List<String> getAccessories() {
        return accessories;
    }

    @Override
    public String toString(){
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ramSizeGB=" + ramSizeGB +
                ", hardDrive='" + hardDrive + '\'' +
                ", graphicsCard='" + graphicsCard + '\'' +
                ", operatingSystem='" + operatingSystem + '\'' +
                ",accessories= '" + accessories + '\'' +
                '}';
    }
    }


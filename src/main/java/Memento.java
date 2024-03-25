
public class Memento implements IMemento {
    private int[] options;
    private boolean isSelected;

    private long timestamp;  // Added timestamp field
    private String description; //Added description field

    public Memento(int[] options, boolean isSelected) {
        this.options = options.clone(); // Copy options array
        this.isSelected = isSelected;
        this.timestamp = System.currentTimeMillis(); // Set current timestamp when creating the memento
        this.description = "Memento created"; // Default description
        //System.out.println("Memento created");

    }

    public int[] getOptions(){return options.clone();// Return a copy of options array}
    }


    public boolean isSelected() {
        return isSelected;
    }
    // Implementation of the getTimestamp method
    @Override
    public long getTimestamp() {
        return timestamp;
    }

    // Implementation of the getDescription method
    @Override
    public String getDescription() {
        return description;
    }}






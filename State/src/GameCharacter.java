// Game character class
public class GameCharacter {

    protected String name;
    protected int experiencePoints;
    protected int healthPoints;

    // Constructor
    public GameCharacter(String name) {
        this.name = name;
        this.experiencePoints = 0;
        this.healthPoints = 100;
    }

    // Method to gain experience
    public void gainExperience(int amount) {
        experiencePoints += amount;
    }

    // Method to decrease health
    public void decreaseHealth(int amount) {
        healthPoints -= amount;
        if (healthPoints <= 0) {
            System.out.println("You are out of health. Game Over!");
            System.exit(0);
        }
    }

    // Method to heal
    public void heal(int amount) {
        healthPoints += amount;
        if (healthPoints > 100)
            healthPoints = 100;
    }

}


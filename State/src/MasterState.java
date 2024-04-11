/*public class MasterState implements CharacterState{
    @Override
    public void train(GameCharacter character) {
        character.gainExperience(50);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.heal(20);
    }

    @Override
    public void fight(GameCharacter character) {
        character.gainExperience(100);
    }

    @Override
    public String toString() {
        return "Master";
    }
}*/
// MasterState.java
public class MasterState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        character.gainExperience(50); // Example: Master gains 50 experience points when training
    }

    @Override
    public void meditate(GameCharacter character) {
        character.heal(20); // Example: Master heals for 20 health points when meditating
    }

    @Override
    public void fight(GameCharacter character) {
        // Example: Master might have additional fighting abilities
    }

    @Override
    public String toString() {
        return "Master";
    }
}


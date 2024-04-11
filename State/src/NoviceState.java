// NoviceState.java
public class NoviceState implements CharacterState {

    @Override
    public void train(GameCharacter character) {
        character.gainExperience(10);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.heal(5);
    }

    @Override
    public void fight(GameCharacter character) {
        System.out.println("You are not skilled enough to fight!");
    }

    @Override
    public String toString() {
        return "Novice";
    }
}
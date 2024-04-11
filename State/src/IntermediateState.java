public class IntermediateState implements CharacterState{
    @Override
    public void train(GameCharacter character) {
        character.gainExperience(20);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.heal(10);
    }

    @Override
    public void fight(GameCharacter character) {
        character.gainExperience(30);
    }

    @Override
    public String toString() {
        return "Intermediate";
    }
}

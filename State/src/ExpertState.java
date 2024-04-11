public class ExpertState implements CharacterState{
    @Override
    public void train(GameCharacter character) {
        character.gainExperience(30);
    }

    @Override
    public void meditate(GameCharacter character) {
        character.heal(15);
    }

    @Override
    public void fight(GameCharacter character) {
        character.gainExperience(50);
        character.decreaseHealth(20);
    }

    @Override
    public String toString() {
        return "Expert";
    }
}

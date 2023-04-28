public class BarbarianLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage += 10;
        character.speed += 0.25;
        character.protection += 2;
    }
}

class BardLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage += character.damage / 2;
        character.speed += 0.5;
        character.protection += character.protection / 2;
    }
}

class DruidLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage += 10;
        character.speed += 0.25;
        character.protection += 2;
    }
}

class RangerLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage += character.damage % 10;
        character.speed += 0.5;
        character.protection += character.protection % 5;
    }
}

class RogueLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage += character.damage / 3;
        character.speed += 1.25;
        character.protection += 3;
    }
}

class WizardLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage += 5;
        character.speed += 1;
        character.protection += 1;
    }
}

class DefaultLevelUpCharacter implements LevelUpCharacter{
    @Override
    public void applyLevelUp(Character character) {
        character.damage++;
        character.speed += 0.25;
        character.protection++;
    }
}

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WhiteBoxGiven {


    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    // simple attack test with test of experience after attack
    @Test
    public void equalDP() {
        Character wiz1 = new Wizard();
        Character wiz2 = new Wizard();

        GamePlay game = new GamePlay(wiz1, wiz2);
        game.attack(wiz1, wiz2);

        assertEquals(wiz1.experience, 7);
        assertEquals(wiz2.experience, 7);
    }

    //Node coverage Test case sequence 1
    @Test
    public void NodeTestSequenceOne() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        Bar2.speed = 1.0;
        Bar2.protection = 5;
        Bar2.health = 1;
        GamePlay game = new GamePlay(Bar, Bar2);

        assertEquals(11, game.play());
    }

    //Node coverage Test case sequence 2
    @Test
    public void NodeTestSequenceTwo() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        Bar2.speed = 3.0;
        Bar2.protection = 5;
        Bar2.health = 1;
        GamePlay game = new GamePlay(Bar, Bar2);

        assertEquals(15, game.play());
    }

    //Edge coverage Test case sequence 1
    @Test
    public void EdgeTestSequenceOne() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        GamePlay game = new GamePlay(Bar, Bar2);
        game.opponents.remove(Bar2);

        assertEquals(0, game.play());
    }

    //Edge coverage Test case sequence 2
    @Test
    public void EdgeTestSequenceTwo() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        Character Bar3 = new Barbarian();
        GamePlay game = new GamePlay(Bar, Bar2);
        game.addOpponent(Bar3);

        assertEquals(25, game.play());
    }

    //Edge coverage Test case sequence 3
    @Test
    public void EdgeTestSequenceThree() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        GamePlay game = new GamePlay(Bar, Bar2);

        assertEquals(10, game.play());
    }

    //Edge coverage Test case sequence 4
    @Test
    public void EdgeTestSequenceFour() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        Character Bar3 = new Barbarian();
        Bar2.health = 0;
        Bar3.health = 0;
        GamePlay game = new GamePlay(Bar, Bar2);
        game.addOpponent(Bar3);

        assertEquals(0, game.play());
    }

    //Description Based Testing: 0 Health Characters are removed
    @Test
    public void playCharacterRemoval() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        Bar2.health = 0;
        GamePlay game = new GamePlay(Bar, Bar2);
        int opponentCountBefore = game.opponents.size();

        assertEquals(0, game.play());
        assertEquals(1, opponentCountBefore - game.opponents.size());
    }

    //Description Based Testing: Then the characters level up -- if health > 0
    //Both Barbarians have enough experience to level up but opponent will have 0 health after
    //character attacks first.
    @Test
    public void attackCallLevelUp() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        GamePlay game = new GamePlay(Bar, Bar2);
        Bar.experience = 20;
        Bar2.experience = 20;
        Bar2.protection = 5;
        Bar2.health = 1;
        game.attack(Bar,Bar2);

        assertEquals(2, Bar.level);
        assertEquals(1, Bar2.level);
    }

    //Description Based Testing: Add an opponent to the list of opponents
    @Test
    public void addOpponentCheck() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        GamePlay game = new GamePlay(Bar, Bar2);
        int opponentCountBefore = game.opponents.size();
        Character Bar3 = new Barbarian();
        game.addOpponent(Bar3);
        int opponentCountAfter = game.opponents.size();

        assertEquals(1, opponentCountAfter - opponentCountBefore);
    }

    //Description Based Testing: Remove an opponent from the list of opponents
    @Test
    public void removeOpponentCheck() {
        Character Bar = new Barbarian();
        Character Bar2 = new Barbarian();
        GamePlay game = new GamePlay(Bar, Bar2);
        int opponentCountBefore = game.opponents.size();
        game.removeOpponent(Bar2);
        int opponentCountAfter = game.opponents.size();

        assertEquals(-1, opponentCountAfter - opponentCountBefore);
    }

}
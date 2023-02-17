import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class BlackBoxGiven {

    private Class<GamePlay> classUnderTest;

    @SuppressWarnings("unchecked")
    public BlackBoxGiven(Object classUnderTest) {
        this.classUnderTest = (Class<GamePlay>) classUnderTest;
    }

    // Define all classes to be tested
    @Parameterized.Parameters
    public static Collection<Object[]> cartClassUnderTest() {
        Object[][] classes = {
            {GamePlay1.class},
            {GamePlay2.class},
            {GamePlay3.class},
            {GamePlay4.class},
            {GamePlay5.class}
        };
        return Arrays.asList(classes);
    }

    private GamePlay createGame() throws Exception {
        Constructor<GamePlay> constructor = classUnderTest.getConstructor();
        return constructor.newInstance();
    }

    GamePlay game;

    @org.junit.Before
    public void setUp() throws Exception {
        game = createGame();
    }

    //TESTING takeDamage

    // normal experience when healthy
    @Test
    public void dealtDamageNormalExperience() {
        Wizard wiz = new Wizard();
        Barbarian bar = new Barbarian();
        Bard bard = new Bard();
        Druid dru = new Druid();
        Ranger ran = new Ranger();
        Rogue ro = new Rogue();
        
        game.dealDamage(wiz);
        assertEquals(wiz.experience, 5);

        game.dealDamage(bar);
        assertEquals(bar.experience, 10);

        game.dealDamage(bard);
        assertEquals(bard.experience, 6);

        game.dealDamage(dru);
        assertEquals(dru.experience, 7);

        game.dealDamage(ran);
        assertEquals(ran.experience, 8);

        game.dealDamage(ro);
        assertEquals(ro.experience, 5);
    }

    //TESTING dealDamage

    // normal experience when less than zero health boundary
    @Test
    public void testdealDamageLessThanZeroHealthBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = -1;
        game.dealDamage(bar);
        assertEquals(bar.experience, 0);
    }

    // normal experience when zero health
    @Test
    public void testdealDamageZeroHealth() {
        Barbarian bar = new Barbarian();
        bar.health = 0;
        game.dealDamage(bar);
        assertEquals(bar.experience, 0);
    }

    // double experience when greater than zero health boundary
    @Test
    public void testdealDamageGreaterThanZeroHealthBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 1;
        game.dealDamage(bar);
        assertEquals(bar.experience, 20);
    }

    // double experience when less than ten health boundary
    @Test
    public void testdealDamageLessThanTenHealthBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 9;
        game.dealDamage(bar);
        assertEquals(bar.experience, 20);
    }

    // normal experience when ten health
    @Test
    public void testdealDamageTenHealth() {
        Barbarian bar = new Barbarian();
        bar.health = 10;
        game.dealDamage(bar);
        assertEquals(bar.experience, 10);
    }

    // normal experience when greater than ten health boundary
    @Test
    public void testdealDamageGreaterThanTenHealthBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 11;
        game.dealDamage(bar);
        assertEquals(bar.experience, 10);
    }

    // normal experience when less than hundred health boundary
    @Test
    public void testdealDamageLessThanHundredHealthBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 99;
        game.dealDamage(bar);
        assertEquals(bar.experience, 10);
    }

    // normal experience when hundred health is tested as the sample test given

    // normal experience when greater than hundred health boundary
    @Test
    public void testdealDamageGreaterThanHundredHealthBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 101;
        game.dealDamage(bar);
        assertEquals(bar.experience, 10);
    }

    //TESTING takeDamage

    // experience takeDamage when blow less than attacked
    @Test
    public void testexperiencetakeDamageblowLessThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, -1);
        assertEquals(bar.experience, 0);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageblowLessThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, -1);
        assertEquals(bar.health, 100);
    }

    // experience takeDamage when blow less than attacked
    @Test
    public void testexperiencetakeDamageZero() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 0);
        assertEquals(bar.experience, 0);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageZero() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 0);
        assertEquals(bar.health, 100);
    }

    // experience takeDamage when blow less than attacked
    @Test
    public void testexperiencetakeDamageGreatThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 1);
        assertEquals(bar.experience, 9);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageGreaterThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 1);
        assertEquals(bar.health, 104);
    }

    // experience takeDamage when blow less than attacked
    @Test
    public void testexperiencetakeDamageLessThanProtectionBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 9);
        assertEquals(bar.experience, 1);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageLessThanProtectionBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 9);
        assertEquals(bar.health, 100);
    }

    // experience takeDamage when blow less than attacked
    @Test
    public void testexperiencetakeDamageEqualProtection() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 10);
        assertEquals(bar.experience, 0);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageEqualProtection() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 10);
        assertEquals(bar.health, 100);
    }

    // experience takeDamage when blow less than attacked
    @Test
    public void testexperiencetakeDamageGreaterThanProtectionBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 11);
        assertEquals(bar.experience, 0);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageGreaterThanProtectionBoundary() {
        Barbarian bar = new Barbarian();
        game.takeDamage(bar, 11);
        assertEquals(bar.health, 99);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageHealthLessThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 1;
        game.takeDamage(bar, 12);
        assertEquals(bar.health, 0);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageHealthZero() {
        Barbarian bar = new Barbarian();
        bar.health = 1;
        game.takeDamage(bar, 11);
        assertEquals(bar.health, 0);
    }

    // health takeDamage when attacked
    @Test
    public void testhealthtakeDamageHealthGreaterThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        bar.health = 1;
        game.takeDamage(bar, 10);
        assertEquals(bar.health, 1);
    }

    //TESTING takeDamage

    @Test
    public void testattackBothHealthLessThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = -1;
        wiz.health = -1;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 100);
    }

    @Test
    public void testattackOneHealthLessThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = -1;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 100);
    }

    @Test
    public void testattackTwoHealthLessThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        wiz.health = -1;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 100);
    }

    @Test
    public void testattackBothHealthZero() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = 0;
        wiz.health = 0;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 100);
    }

    @Test
    public void testattackOneHealthZero() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = 0;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 100);
    }

    @Test
    public void testattackTwoHealthZero() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        wiz.health = 0;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 0);
    }

    @Test
    public void testattackBothHealthGreaterThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = 1;
        wiz.health = 1;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 0);
    }

    @Test
    public void testattackOneHealthGreaterThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = 1;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 91);
    }

    @Test
    public void testattackTwoHealthGreaterThanZeroBoundary() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        wiz.health = 1;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 0);
    }

    @Test
    public void testattackOrderHealth() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = 20;
        wiz.health = 2;
        game.attack(bar, wiz);
        assertEquals(bar.health, 20);
    }

    @Test
    public void testattackOrderDamage() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        bar.health = 20;
        wiz.health = 2;
        game.attack(bar, wiz);
        assertEquals(wiz.health, 0);
    }

    @Test
    public void testattackLevelUpHealthLessThanZero() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        wiz.health = -1;
        bar.health = -1;
        game.attack(bar, wiz);
        game.attack(bar, wiz);
        assertEquals(bar.level, 1);
    }

    @Test
    public void testattackLevelUpHealthZero() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        wiz.health = 0;
        bar.health = 0;
        game.attack(bar, wiz);
        game.attack(bar, wiz);
        assertEquals(bar.level, 1);
    }

    @Test
    public void testattackLevelUpHealthGreaterThanZeroFirst() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        game.attack(bar, wiz);
        game.attack(bar, wiz);
        assertEquals(bar.level, 2);
    }

    @Test
    public void testattackLevelUpHealthGreaterThanZeroSecond() {
        Barbarian bar = new Barbarian();
        Wizard wiz = new Wizard();
        game.attack(bar, wiz);
        game.attack(bar, wiz);
        assertEquals(wiz.level, 2);
    }
}
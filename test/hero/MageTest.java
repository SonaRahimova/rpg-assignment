package hero;

import item.ItemSlot;
import item.weapons.Weapon;
import item.weapons.WeaponType;
import item.weapons.exceptions.InvalidWeaponException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MageTest {

    @Test
    public void whenInvalidExceptionThrown_thenAssertionSucceeds() {
        Hero testHero = new Mage();
        Weapon weapon = new Weapon(ItemSlot.WEAPON, 1, WeaponType.DAGGER, 7, 1.1f);

        assertThrows(InvalidWeaponException.class, () -> testHero.equip(weapon));
    }

    @Test
    void ShouldReturnCalculatedMageDps() throws InvalidWeaponException {
        Hero testHero = new Mage();
        Weapon weapon = new Weapon(ItemSlot.WEAPON, 1, WeaponType.WAND, 7, 1.1f);
        testHero.equip(weapon);
        float expected = (7 * 1.1f) * (1 + (8 / 100f));
        float actual = testHero.calculateCharacterDps();

        assertEquals(expected, actual);
    }

    @Test
    void LevelingUpIsWorking() {
        Hero testHero = new Mage();
        testHero.levelUp();

        assertEquals(2, testHero.getLevel());
    }

    @Test
    void LevelShouldStartAt1() {
        Hero testHero = new Mage();

        assertEquals(1, testHero.getLevel());
    }

    @Test
    void AttributesWorking() {
        Hero testHero = new Mage();

        assertEquals(8, testHero.attributes.getIntelligence());
        assertEquals(1, testHero.attributes.getDexterity());
        assertEquals(1, testHero.attributes.getStrength());
    }

    @Test
    void AttributesWorkingLevelTwo() {
        Hero testHero = new Mage();
        testHero.levelUp();
        assertEquals(13, testHero.attributes.getIntelligence());
        assertEquals(2, testHero.attributes.getDexterity());
        assertEquals(2, testHero.attributes.getStrength());
    }
}

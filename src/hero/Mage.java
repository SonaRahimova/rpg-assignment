package hero;

import item.armor.Armor;
import item.armor.ArmorType;
import item.armor.exception.InvalidArmorException;
import item.weapons.Weapon;
import item.weapons.WeaponType;
import item.weapons.exceptions.InvalidWeaponException;

public class Mage extends Hero {

    public Mage() {
        super(new PrimaryAttributes(1,1,8));
    }

    @Override
    public void levelUp() {
        attributes.setStrength(attributes.getStrength()+1);
        attributes.setDexterity(attributes.getDexterity()+1);
        attributes.setIntelligence(attributes.getIntelligence()+5);
        super.levelUp();
    }

    @Override
    public int getMainAttributeValue() {
        var bonusAttributes = 0;

        for (var item:equipment.values()) {
            if (item instanceof Armor) {
                Armor armor = (Armor)item;
                bonusAttributes += armor.getArmorAttributes().getIntelligence();
            }
        }

        return attributes.getIntelligence() + bonusAttributes;
    }

    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        if ((weapon.getWeaponType() != WeaponType.STAFF && weapon.getWeaponType()  != WeaponType.WAND)
                || weapon.getRequiredLevel()>level) {
            throw new InvalidWeaponException();
        }
        equipment.put(weapon.getItemSlot(), weapon);
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        if (armor.getType() != ArmorType.CLOTHS || armor.getRequiredLevel()>level) {
            throw new InvalidArmorException();
        }
        equipment.put(armor.getItemSlot(), armor);
    }



}

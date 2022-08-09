package hero;

import item.Item;
import item.ItemSlot;
import item.armor.Armor;
import item.armor.exception.InvalidArmorException;
import item.weapons.Weapon;
import item.weapons.exceptions.InvalidWeaponException;

import java.util.HashMap;
import java.util.Map;

public abstract class Hero {
    protected int level = 1;
    protected PrimaryAttributes attributes;

    protected Map<ItemSlot, Item> equipment = new HashMap<>();

    public void levelUp() {
        level++;
    }

    public Hero(PrimaryAttributes attributes) {
        this.attributes = attributes;
    }

    public abstract int getMainAttributeValue();

    public int getLevel() {
        return level;
    }

    public float calculateCharacterDps() {
        Weapon weapon = (Weapon)(equipment.get(ItemSlot.WEAPON));
        return weapon.getWeaponDps() * (1 + (getMainAttributeValue() /100f));
    }

    public abstract void equip(Weapon weapon) throws InvalidWeaponException;

    public abstract void equip(Armor armor) throws InvalidArmorException;


}



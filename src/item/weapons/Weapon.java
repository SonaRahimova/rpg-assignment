package item.weapons;

import item.Item;
import item.ItemSlot;

public class Weapon extends Item {
    private WeaponType weaponType;
    private int damage;
    private float attackSpeed;

    public WeaponType getWeaponType() {
        return weaponType;
    }

    /* public Weapon(WeaponType weaponType, int damage, double attackSpeed, int requiredLevel) {
        this.weaponType = weaponType;
        this.dps = damage * attackSpeed;
    }*/


    public float getWeaponDps() {
        return damage * attackSpeed;
    }

    public Weapon(ItemSlot itemSlot, int requiredLevel, WeaponType weaponType, int damage, float attackSpeed) {
        super(itemSlot, requiredLevel);
        this.weaponType = weaponType;
        this.damage = damage;
        this.attackSpeed = attackSpeed;
    }
}

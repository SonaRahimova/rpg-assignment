package item.armor;

import hero.PrimaryAttributes;
import item.Item;
import item.ItemSlot;

public class Armor extends Item {
    private ArmorType type;

    public Armor(ItemSlot itemSlot, int requiredLevel, ArmorType armorType, PrimaryAttributes bonusAttributes) {
        super(itemSlot, requiredLevel);
        type = armorType;
        armorAttributes = bonusAttributes;
    }

    public PrimaryAttributes getArmorAttributes() {
        return armorAttributes;
    }

    private PrimaryAttributes armorAttributes;

    public ArmorType getType() {
        return type;
    }
}

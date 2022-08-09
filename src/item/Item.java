package item;

public abstract class Item {
    private ItemSlot itemSlot;
    private int requiredLevel;

    public ItemSlot getItemSlot() {
        return itemSlot;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public Item(ItemSlot itemSlot, int requiredLevel) {
        this.itemSlot = itemSlot;
        this.requiredLevel = requiredLevel;
    }
}

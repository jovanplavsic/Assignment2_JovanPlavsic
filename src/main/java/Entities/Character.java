package Entities;

import java.util.ArrayList;
import java.util.List;

/**
 * A Player‐controlled creature who can carry items.
 */
public class Character extends Creature {
    private List<Item> inventory = new ArrayList<>();

    public Character(String name, int str, int cft, int hp) {
        super(name, str, cft, hp);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void addToInventory(List<Item> items) {
        inventory.addAll(items);
    }

    public String viewInventory() {
        System.out.println();

        if (inventory.isEmpty()) {
            return "Inventory is empty.";
        }
        StringBuilder sb = new StringBuilder("YOUR INVENTORY\n");
        for (int i = 0; i < inventory.size(); i++) {
            sb.append(i)
                    .append(" | ")
                    .append(inventory.get(i).getName())
                    .append("\n");
        }
        return sb.toString();
    }

    public Item leftHand() {
        if (inventory.isEmpty()) {
            return null;
        }
        return inventory.get(0);
    }

    public Item rightHand() {
        if (inventory.size() < 2) {
            return null;
        }
        return inventory.get(1);
    }

    public void switchItems(int a, int b) {
        if (inventory.size() < 2) {
            throw new IllegalStateException("Only one item in inventory");
        }
        if (a < 0 || a >= inventory.size() || b < 0 || b >= inventory.size()) {
            throw new IndexOutOfBoundsException(
                    "Invalid indices: " + a + ", " + b
            );
        }
        Item one = inventory.get(a);
        Item two = inventory.get(b);

        inventory.set(a, two);
        inventory.set(b, one);
    }
}




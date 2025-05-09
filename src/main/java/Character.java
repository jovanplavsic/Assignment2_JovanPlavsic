import java.util.ArrayList;
import java.util.List;

public class Character {
    protected String name;
    protected int strength;
    protected int craft;
    protected int health;
    protected List<Item> inventory = new ArrayList<>();

    public Character(String name, int strength, int health, int craft) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getStrength() {
        return this.craft;
    }

    public int getCraft() {
        return this.craft;
    }

    public int getHealth() {
        return this.health;
    }

    public List<Item> getInventory(){return this.inventory; }

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

    public boolean takeDamage(int damage) {
        this.health = this.health - damage;

        if (this.health > 0) {
            return false;
        }
        return true;

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
            return;
        }
        Item one = inventory.get(a);
        Item two = inventory.get(b);

        inventory.set(a, two);
        inventory.set(b, one);
    }
}



import java.util.ArrayList;
import java.util.List;

public class Character {
    protected String name;
    protected int craft;
    protected int health;
    protected List<Item> inventory = new ArrayList<>();

    public Character(String name, int health, int defense, int craft) {
        this.name = name;
        this.craft = craft;
        this.health = health;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getCraft() {
        return this.craft;
    }

    public void addToInventory(Item item) {
        this.inventory.add(item);
    }

    public boolean takeDamage(int damage) {
        this.health = this.health - damage;

        if (this.health > 0) {
            return false;
        }
        return true;

    }
}


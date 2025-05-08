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


//    public void addToInventory(Item item) {
//        this.inventory.add(item);
//    }
    public void addToInventory(List<Item> items) {
        inventory.addAll(items);
    }


    public boolean takeDamage(int damage) {
        this.health = this.health - damage;

        if (this.health > 0) {
            return false;
        }
        return true;

    }

}


public class Monster {
    private String name;
    protected int strength;
    protected int craft;
    protected int health;

    public Monster(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    public String getName() { return this.name; }

    public int getHealth() {
        return this.health;
    }

    public String getDescription() {
        return this.name + ": " + this.strength + ", " + this.craft + ", " + this.health;
    }

    public void takeDamage(int damage) {
        this.health = this.health - damage;
    }
}

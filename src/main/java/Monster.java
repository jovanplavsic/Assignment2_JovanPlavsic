public class Monster {
    private String name;
    protected int strength;
    protected int craft;
    protected int health;

    public  Monster(String name, int strength, int craft, int health) {
        this.name = name;
        this.strength = strength;
        this.craft = craft;
        this.health = health;
    }

    public String getName(){
        return this.name;
    }
}

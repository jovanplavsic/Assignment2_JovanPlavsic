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

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public String getDescription() {

        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append("\n")
                .append("Str: ").append(this.strength).append(" ")
                .append("Cft: ").append(this.craft).append(" ")
                .append("Hth: ").append(this.health).append(" ");
        return sb.toString();
    }

    public void takeDamage(int damage) {
        this.health = this.health - damage;
    }

    public int getCraft() {
        return this.craft;
    }

    public int getStrength() {
        return this.strength;
    }

}

public class Axe extends Item {
    public Axe() {
        super("Axe", 5, 0);
    }
    public void throwAxe(Character user, Character target) {
        int damage = user.getStrength() * getPower();

        System.out.println("Throw Axe at " + target.getName()
                           + " for " + damage + " damage.");

        target.takeDamage(this.power);
    }
}

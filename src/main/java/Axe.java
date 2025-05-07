public class Axe extends Item {
    public Axe() {
        super("Axe", 10, 0);
    }
    public void throwAxe(Character target) {
        System.out.println("Throw Axe at " + target.getName()
                           + " for " + this.power + " damage.");
        target.takeDamage(this.power);
    }
}

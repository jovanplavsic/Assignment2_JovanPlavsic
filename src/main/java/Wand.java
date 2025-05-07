    public class Wand extends Item {
    public Wand() {
        super("Wand", 5, 0);
    }

    public void castSpell(Character target) {
        System.out.println("Casts a spell on " + target.getName()
                           + " for " + this.power + " damage.");
        target.takeDamage(this.power);
    }
}


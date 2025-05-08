public class Wand extends Item {
    public Wand() {
        super("Wand", 5, 0);
    }

    public void use(Character user, Monster target) {
        int damage = user.getCraft() * getPower();

        System.out.println("Casts a spell on " + target.getName()
                           + " for " + damage + " damage.");

        target.takeDamage(this.power);
    }
}


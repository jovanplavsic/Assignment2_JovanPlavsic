public class Wizard extends Character{

    public Wizard(String name) {
        // name, health, attack, defense
        super(name, 60, 15, 5);
    }

    public void castSpell(Character target) {
        int dmg = this.attack * 2;
        System.out.println(getName() + " casts a spell on " + target.getName()
                           + " for " + dmg + " damage.");
        target.takeDamage(dmg);
    }
}


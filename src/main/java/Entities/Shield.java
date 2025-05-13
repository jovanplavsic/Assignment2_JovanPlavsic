/** Represent a shield item */
public class Shield extends Item{
    public Shield() {
        super("Shield", 0, 10);
    }

    /** Lower the durability of shield */
    public void use(Character user, Monster target) {

       this.diminishDefence(1);
    }
}

public class Shield extends Item{
    public Shield() {
        super("Shield", 0, 10);
    }

    public int useShield(Character user, Character target) {
       int protection = this.getDefence();

       this.diminishDefence(1);

       return protection;
    }
}

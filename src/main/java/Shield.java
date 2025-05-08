public class Shield extends Item{
    public Shield() {
        super("Shield", 0, 10);
    }

    public void use(Character user, Character target) {
       int protection = this.getDefence();

       this.diminishDefence(1);
    }
}

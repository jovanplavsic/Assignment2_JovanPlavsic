public class Item {
    protected int power;
    protected int defence;

    public Item(String name, int power, int defence) {
        this.power = power;
        this.defence = defence;
    }

    public int getPower(){
        return this.power;
    }

}



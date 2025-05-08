public class Item {
    private String name;
    protected int power;
    protected int defence;

    public Item(String name, int power, int defence) {
        this.name = name;
        this.power = power;
        this.defence = defence;
    }

    public int getPower(){
        return this.power;
    }

    public int getDefence(){
        return  this.defence;
    }

    public String getName(){
        return this.name;
    }

    public void diminishDefence(int damage){
        if (damage > this.defence){
            this.defence -= damage;
        }
        else {
            System.out.println("Shield Broken");
        }
    }

}



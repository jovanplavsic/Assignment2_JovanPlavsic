    /** Represents an item with a name, power, and defence*/
public abstract class Item {
    private String name;
    protected int power;
    protected int defence;

        /** Create Item object*/
    public Item(String name, int power, int defence) {
        this.name = name;
        this.power = power;
        this.defence = defence;
    }

    /** Methods to return the power, defence, and name */
    public int getPower(){
        return this.power;
    }

    public int getDefence(){
        return  this.defence;
    }

    public String getName(){
        return this.name;
    }

    /** Optionally decrease item health with each use */
    public void diminishDefence(int damage){
        if (damage > this.defence){
            this.defence -= damage;
        }
        else {
            System.out.println("Shield Broken");
        }
    }

}



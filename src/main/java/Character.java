public class Character {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int [] inventory;

     public Character(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public String getName(){
         return this.name;
    }

    public int getHealth(){
         return this.health;
    }

    public void getStats(){
         System.out.println("Attack: " + this.attack + "Defence: " + this.defense);
    }

    public boolean takeDamage(int damage){
         this.health = this.health - damage;
         if (this.health > 0){
             return false;
         }
         return true;
    }

}

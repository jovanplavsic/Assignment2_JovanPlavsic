package Entities;

/**
 *
 */
public abstract class Creature {
    protected String name;
    protected int strength;
    protected int craft;
    protected int health;

    public Creature(String name, int strength, int craft, int health) {
        this.name     = name;
        this.strength = strength;
        this.craft    = craft;
        this.health   = health;
    }

    public String getName()     { return name;     }
    public int    getStrength() { return strength; }
    public int    getCraft()    { return craft;    }
    public int    getHealth()   { return health;   }

    /**
     *
     */
    public boolean takeDamage(int damage) {
        health -= damage;
        return health <= 0;
    }

    /** A text description of this creature’s stats. */
    public String getDescription() {
        return "Name" + name + "Str: " + strength + " Cft: " + "Hth" + health;
    }
}

package Environment;

import Entities.Monster;

/**
 * Represent a Door that connects two chambers and is protected by a guard
 */
public class Door {
    private Chamber a, b;
    private Monster guard;

    /**
     * Create door object connecting two chamebrs and a guard
     */
    public Door(Chamber a, Chamber b, Monster guard) {
        this.a = a;
        this.b = b;
        this.guard = guard;

        a.addDoor(this);
        b.addDoor(this);
    }
    /**
     * Create door object connecting two chambers with no guard
     */
    public Door(Chamber a, Chamber b) {
        this.a = a;
        this.b = b;

        a.addDoor(this);
        b.addDoor(this);
    }

    /**
     * Connect two chambers
     */
    public static Door connect(Chamber a, Chamber b) {
        return new Door(a, b, null);
    }

    public static Door connect(Chamber a, Chamber b, Monster guard) {
        return new Door(a, b, guard);
    }

    /**
     * Return guard protecting door
     */
    public Monster getGuard() {
        return this.guard;
    }

    /**
     * Return true if guard exists and has health above 0
     */
    public boolean isGuarded() {
        if (this.guard != null) {
            if (this.guard.getHealth() > 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * Return all chambers that door connects
     */
    public Chamber[] getChambers() {
        return new Chamber[]{this.a, this.b};
    }

    /**
     * Returns the other chamber that the door connects given one chamber
     */
    public Chamber otherSide(Chamber from) {
        if (from == a) {
            return b;
        } else {
            return a;
        }
    }
}

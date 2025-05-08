public class Door {
    private Chamber a, b;
    private Monster guard;

    public Door(Chamber a, Chamber b, Monster guard ){
        this.a = a;
        this.b = b;
        this.guard = guard;

        a.addDoor(this);
        b.addDoor(this);
    }
}

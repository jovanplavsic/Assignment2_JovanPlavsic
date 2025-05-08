public class Door {
    private Chamber a, b;
    private Monster guard;

    public Door(Chamber a, Chamber b, Monster guard ){
        this.a = a;
        this.b = b;
        this.guard = guard;

        a.setDoor(this);
        b.setDoor(this);
    }

    public static Door connect(Chamber a, Chamber b) {
        return new Door(a, b, null);
    }

    public static Door connect(Chamber a, Chamber b, Monster guard) {
        return new Door(a, b, guard);
    }

    public Monster getGuard(){
       return this.guard;
    }
}

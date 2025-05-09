public class Move implements Action{
    private Dungeon dungeon;
    private Door door;

    public Move(Dungeon dungeon, Door door, Chamber chamber){
        this.dungeon = dungeon;
        this.door = door;
    }

    public Move(Dungeon dungeon, Door door){
        this.dungeon = dungeon;
        this.door = door;
    }

    @Override
    public String printAction(){
        return "Move from " + dungeon.getCurrentChamber() + "---";
    }

    @Override
    public void execute(){
        if (!door.isGuarded()){
            Chamber next = this.door.otherSide(dungeon.getCurrentChamber());
            dungeon.setCurrentChamber(next);
            System.out.println("Moved to chamber ");
        } else {
            System.out.println("Can't pass, monster in the way");
        }

    }

    @Override
    public String toString(){
        Chamber current = this.door.otherSide(this.dungeon.getCurrentChamber());
        if (current == this.dungeon.getPreviousChamber()){
            return "Move to previous chamber";
        }
        return "Move to chamber " + current.getId();
    }
}

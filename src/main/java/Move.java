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
        Chamber next = this.door.otherSide(dungeon.getCurrentChamber());
        dungeon.setCurrentChamber(next);

    }

    @Override
    public String toString(){
        return this.door.otherSide(dungeon.getCurrentChamber()).toString();
    }
}

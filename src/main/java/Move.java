public class Move implements Action{
    private Dungeon dungeon;
    private Door door;
    private Chamber chamber;

    public Move(Dungeon dungeon, Door door, Chamber chamber){
        this.dungeon = dungeon;
        this.door = door;
        this.chamber = chamber;
    }

    @Override
    public String printAction(){
        return "Move from " + dungeon.getCurrentChamber() + "---";
    }

    @Override
    public void doAction(){
        dungeon.setCurrentChamber(this.chamber);
    }
}

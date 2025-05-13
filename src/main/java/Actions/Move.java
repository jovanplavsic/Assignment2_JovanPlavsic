package Actions;

import Environment.Chamber;
import Environment.Door;
import Environment.Dungeon;

/** Simulates moving from chamber to chamber */
public class Move implements Action {
    private Dungeon dungeon;
    private Door door;

    /** Create Move object with door and dungeon*/
    public Move(Dungeon dungeon, Door door){
        this.dungeon = dungeon;
        this.door = door;
    }

    /** Execute logic of moving from chamber to chamber */
    @Override
    public void execute(){
        if (!door.isGuarded()){
            Chamber next = this.door.otherSide(dungeon.getCurrentChamber());
            dungeon.setCurrentChamber(next);
            System.out.println("\n---------------------------\n");

            System.out.println("YOU MOVED CHAMBERS");
            System.out.println();

        } else {
            System.out.println("Can't pass, monster in the way");
        }

    }

    /** Return string summary of action*/
    @Override
    public String toString(){
        Chamber current = this.door.otherSide(this.dungeon.getCurrentChamber());
        if (current == this.dungeon.getPreviousChamber()){
            return "Move to previous chamber";
        }
        return "Move to chamber " + current.getId();
    }
}

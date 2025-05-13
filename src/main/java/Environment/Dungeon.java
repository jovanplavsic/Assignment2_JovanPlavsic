package Environment;

import Actions.*;
import Entities.Character;

import java.util.ArrayList;
import java.util.List;

/** Represents a dungeon that contains everything in the game such as chambers, entities, and items */
public class Dungeon {
    private Character player;
    private Chamber startChamber;
    private Chamber currentChamber;
    private Chamber previousChamber = null;
    private Chamber endChamber;

    public Dungeon(Character player, Chamber start, Chamber end) {
        this.player = player;
        this.startChamber = start;
        this.currentChamber = start;
        this.endChamber = end;
    }

    /** Return current chamber that player is in */
    public Chamber getCurrentChamber() {
        return this.currentChamber;
    }
    /** Set previous chamber that player was just in*/
    public Chamber getPreviousChamber() {
        return this.previousChamber;
    }
    /** Set current chamber */
    public void setCurrentChamber(Chamber chamber) {
        this.previousChamber = this.currentChamber;
        this.currentChamber = chamber;
    }
    /** Return True if player health is 0 or less, or if player reached the final chamber */
    public boolean isFinished() {
        if (this.player.getHealth() <= 0) {
            System.out.println("YOU DIED");
            return true;
        } else if (this.currentChamber == this.endChamber){
            System.out.println("YOU WIN");
            return true;
        }
        return false;
    }

    /** Return list of possible actions that a user can take at that given moment */
    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        Chamber here = currentChamber;
        if (!this.player.getInventory().isEmpty()){
            actions.add(new Swap(player));
        }
        if (!here.getItems().isEmpty()) {
            actions.add(new PickUp(player, here));
        }

        for (Door door : here.getDoors()) {
            if (door.isGuarded()) {
                actions.add(new Fight(player, door.getGuard()));
            }else{
                actions.add(new Move(this, door));
            }
        }
        return actions;
    }
}


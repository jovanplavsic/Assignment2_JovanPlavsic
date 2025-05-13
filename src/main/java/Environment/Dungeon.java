package Environment;

import Actions.Action;
import Entities.Character;

import java.util.ArrayList;
import java.util.List;

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

    public Chamber getCurrentChamber() {
        return this.currentChamber;
    }

    public Chamber getPreviousChamber() {
        return this.previousChamber;
    }

    public void setCurrentChamber(Chamber chamber) {
        this.previousChamber = this.currentChamber;
        this.currentChamber = chamber;
    }

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

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        Chamber here = currentChamber;
        if (!this.player.inventory.isEmpty()){
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


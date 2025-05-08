import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private Character player;
    private Chamber startChamber;
    private Chamber currentChamber;
    private Chamber endChamber;

    public Dungeon(Character player, Chamber start, Chamber end) {
        this.player = player;
        this.startChamber = start;
        this.endChamber = end;
    }

    public Chamber getCurrentChamber(){
        return this.currentChamber;
    }

    public Chamber getStartChamber(){
        return this.startChamber;
    }

    public Chamber getEndChamber(){
        return this.endChamber;
    }

    public void setCurrentChamber(Chamber chamber){
        this.currentChamber = chamber;
    }

    public boolean isFinished(){
        if (this.player.getHealth() > 0){
            return true;
        }
        return false;
    }

    public List<Action> getActions() {
        List<Action> actions = new ArrayList<>();
        Chamber here = currentChamber;

        for (Door door : here.getDoors()) {
            if (door.isGuarded()) {
                actions.add(new Fight(player, door));
            }
        }
        if (here.getItems() != null) {
            actions.add(new PickUp(player, here));
        }
        for (Door door : here.getDoors()) {
            if (!door.isGuarded()) {
                actions.add(new Move(this, door));
            }
        }
        return actions;
    }
}


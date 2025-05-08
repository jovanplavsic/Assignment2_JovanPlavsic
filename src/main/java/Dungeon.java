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
}


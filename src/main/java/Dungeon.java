import java.util.ArrayList;
import java.util.List;

public class Dungeon {
    private Character player;
    private Chamber startChamber;
    private Chamber endChamber;

    public Dungeon(Character player, Chamber start, Chamber end) {
        this.startChamber = start;
        this.endChamber = end;
    }

}


import Entities.*;
import Entities.Character;
import Environment.Chamber;
import Environment.Door;
import Environment.Dungeon;

public class Game {
    public static void main(String[] args) {
        // initialize some chambers
        Chamber[] chambers = new Chamber[] {
            new Chamber(),
            new Chamber(new Axe()),
            new Chamber(new Shield()),
            new Chamber(),
            new Chamber(),
            new Chamber()
        };

        // connect the chambers with doors
        Door.connect(chambers[0], chambers[1]);
        Door.connect(chambers[1], chambers[2], new Monster("Goblin", 30, 0, 80));
        Door.connect(chambers[1], chambers[5], new Monster("Monkey", 0, 30, 80));
        Door.connect(chambers[2], chambers[3], new Monster("Spider", 20, 0, 80));
        Door.connect(chambers[3], chambers[4]);

        Character player = new Wizard("Gandalf");

        // initialize the dungeon with player, entry chamber, and goal chamber
        Dungeon d = new Dungeon(player, chambers[0], chambers[4]);

        TextUI ui = new TextUI();
        ui.play(d);
    }
}


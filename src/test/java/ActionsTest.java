import Actions.Fight;
import Actions.Move;
import Actions.PickUp;
import Entities.Axe;
import Entities.Character;
import Entities.Monster;
import Entities.Wand;
import Environment.Chamber;
import Environment.Door;
import Environment.Dungeon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test all classes in Actions package
 */
public class ActionsTest {
    @Test
    public void test_toString() {
        // Create Character and Monster
        Character hero = new Character("John", 10, 5, 20);
        Monster goblin = new Monster("Goblin", 3, 0, 10);
        Fight fight = new Fight(hero, goblin);

        assertEquals("Fight Goblin", fight.toString());
    }

    @Test
    public void testExecute() {
        Character hero = new Character("John", 8, 4, 20);
        Monster goblin = new Monster("Goblin", 2, 0, 10);
        Fight fight = new Fight(hero, goblin);

        assertDoesNotThrow(fight::execute);
    }

    @Test
    public void testExecuteUnguardedMovesChamber() {
        Chamber entry = new Chamber();
        Chamber exit = new Chamber();
        Door.connect(entry, exit);
        Character dummy = new Character("Test", 1, 1, 1);
        Dungeon dungeon = new Dungeon(dummy, entry, exit);
        Door door = entry.getDoors().getFirst();
        Move move = new Move(dungeon, door);

        move.execute();

        assertEquals(exit, dungeon.getCurrentChamber());
    }

    @Test
    public void testMoveToString() {
        Chamber entry = new Chamber();
        Chamber exit = new Chamber();
        Door.connect(entry, exit);
        Character dummy = new Character("Test", 1, 1, 1);
        Dungeon dungeon = new Dungeon(dummy, entry, exit);
        Door door = entry.getDoors().getFirst();
        Move move = new Move(dungeon, door);

        String description = move.toString();

        assertEquals("Move to chamber " + exit.getId(), description);
    }

    @Test
    public void testExecuteAddsItems() {
        Chamber chamber = new Chamber();
        Axe axe = new Axe();
        chamber.getItems().add(axe);

        Character player = new Character("John", 1, 1, 10);
        PickUp pickUp = new PickUp(player, chamber);

        assertTrue(chamber.getItems().contains(axe));
        assertTrue(player.getInventory().isEmpty());

        pickUp.execute();

        assertTrue(player.getInventory().contains(axe));
        assertTrue(chamber.getItems().isEmpty());
    }

    @Test
    public void testToStringPickUp() {
        Chamber chamber = new Chamber();
        Wand wand = new Wand();
        chamber.getItems().add(wand);

        Character player = new Character("Johs", 1, 1, 10);
        PickUp pickUp = new PickUp(player, chamber);

        String descBefore = pickUp.toString();
        assertEquals("Pick up Wand ", descBefore);

        pickUp.execute();
        String descAfter = pickUp.toString();
        assertEquals("No items", descAfter);

    }
}

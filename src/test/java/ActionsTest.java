import Actions.Fight;
import Entities.Character;
import Entities.Monster;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test all classes in Actions package*/
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
        Character hero = new Character("Hero", 8, 4, 20);
        Monster goblin = new Monster("Goblin", 2, 0, 10);
        Fight fight = new Fight(hero, goblin);

        assertDoesNotThrow(fight::execute);
    }
}

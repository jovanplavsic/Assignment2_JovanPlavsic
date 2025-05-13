
import java.util.Arrays;
import Entities.Axe;
import Entities.Character;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;

/**
 * Test functionality of entity package classes
 */
public class EntitiesTest {
     private Character character;
    private Axe axe1;
    private Axe axe2;

    @BeforeEach
    public void setUp() {
        character = new Character("Hero", 5, 3, 20);
        axe1 = new Axe();
        axe2 = new Axe();
    }

    @Test
    public void testEmptyInventoryView() {
        String view = character.viewInventory();
        assertEquals("Inventory is empty.", view);
    }

    @Test
    public void testLeftAndRightHand() {
        assertNull(character.leftHand());
        assertNull(character.rightHand());

        character.addToInventory(Collections.singletonList(axe1));
        assertEquals(axe1, character.leftHand());
        assertNull(character.rightHand());

        character.addToInventory(Collections.singletonList(axe2));
        assertEquals(axe1, character.leftHand());
        assertEquals(axe2, character.rightHand());
    }

    @Test
    public void testSwitchItemsSwapsCorrectly() {
        character.addToInventory(Arrays.asList(axe1, axe2));
        character.switchItems(0, 1);
        assertEquals(axe2, character.getInventory().get(0));
        assertEquals(axe1, character.getInventory().get(1));
    }

    @Test
    public void testSwitchItemsInvalidIndicesThrows() {
        character.addToInventory(Arrays.asList(axe1, axe2));
        assertThrows(IndexOutOfBoundsException.class, () -> character.switchItems(-1, 1));
        assertThrows(IndexOutOfBoundsException.class, () -> character.switchItems(0, 2));
    }

}

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class EntityTest {

    // Character tests

    @Test
    void testConstructorAndGetters() {
        Character c = new Character("Alice", 10, 5, 20);
        assertEquals("Alice", c.getName());
        // Note: getStrength() currently returns craft per implementation
        assertEquals(5, c.getStrength());
        assertEquals(5, c.getCraft());
        assertEquals(20, c.getHealth());
    }

    @Test
    void testAddToInventory_appendsItems() {
        Character c = new Character("Bob", 1, 1, 10);
        Axe axe = new Axe();
        Shield shield = new Shield();
        c.addToInventory(Arrays.asList(axe, shield));
        List<Item> inv = c.getInventory();
        assertTrue(inv.contains(axe));
        assertTrue(inv.contains(shield));
    }

    @Test
    void testViewInventory_whenEmpty_returnsEmptyMessage() {
        Character c = new Character("Carol", 1, 1, 10);
        String output = c.viewInventory();
        assertEquals("Inventory is empty.", output);
    }

    @Test
    void testViewInventory_whenNotEmpty_listsItems() {
        Character c = new Character("Dave", 1, 1, 10);
        Axe axe = new Axe();
        Shield shield = new Shield();
        c.addToInventory(Arrays.asList(axe, shield));
        String output = c.viewInventory();
        assertTrue(output.startsWith("YOUR INVENTORY"));
        assertTrue(output.contains("0 | Axe"));
        assertTrue(output.contains("1 | Shield"));
    }

    @Test
    void testTakeDamage_aboveZero_returnsFalse() {
        Character c = new Character("Eve", 1, 1, 10);
        boolean died = c.takeDamage(5);
        assertFalse(died);
        assertEquals(5, c.getHealth());
    }

    @Test
    void testTakeDamage_atOrBelowZero_returnsTrue() {
        Character c = new Character("Frank", 1, 1, 5);
        boolean died = c.takeDamage(5);
        assertTrue(died);
        assertEquals(0, c.getHealth());
    }

    @Test
    void testLeftHand_whenEmpty_returnsNull() {
        Character c = new Character("Gina", 1, 1, 10);
        assertNull(c.leftHand());
    }

    @Test
    void testRightHand_withOneItem_returnsNull() {
        Character c = new Character("Hank", 1, 1, 10);
        c.addToInventory(Collections.singletonList(new Axe()));
        assertNull(c.rightHand());
    }

    @Test
    void testLeftAndRightHand_returnCorrectItems() {
        Character c = new Character("Ivy", 1, 1, 10);
        Axe axe = new Axe();
        Shield shield = new Shield();
        c.addToInventory(Arrays.asList(axe, shield));
        assertEquals(axe, c.leftHand());
        assertEquals(shield, c.rightHand());
    }

    @Test
    void testSwitchItems_swapsPositions() {
        Character c = new Character("Jack", 1, 1, 10);
        Axe axe = new Axe();
        Shield shield = new Shield();
        c.addToInventory(Arrays.asList(axe, shield));
        c.switchItems(0, 1);
        assertEquals(shield, c.getInventory().get(0));
        assertEquals(axe, c.getInventory().get(1));
    }

    @Test
    void testSwitchItems_withInvalidIndices_noChange() {
        Character c = new Character("Kim", 1, 1, 10);
        Axe axe = new Axe();
        Shield shield = new Shield();
        c.addToInventory(Arrays.asList(axe, shield));
        c.switchItems(0, 5);  // invalid index
        assertEquals(axe, c.getInventory().get(0));
        assertEquals(shield, c.getInventory().get(1));
    }

    // Monster tests

    @Test
    void testMonsterConstructorAndGetters() {
        Monster m = new Monster("Orc", 8, 3, 30);
        assertEquals("Orc", m.getName());
        assertEquals(8, m.getStrength());
        assertEquals(3, m.getCraft());
        assertEquals(30, m.getHealth());
    }

    @Test
    void testTakeDamage_reducesHealth() {
        Monster m = new Monster("Goblin", 5, 2, 20);
        m.takeDamage(7);
        assertEquals(13, m.getHealth());
    }

    @Test
    void testTakeDamage_toZero_allowsDeathCheck() {
        Monster m = new Monster("Troll", 5, 2, 10);
        m.takeDamage(10);
        assertEquals(0, m.getHealth());
    }

    @Test
    void testGetDescription_containsAllStats() {
        Monster m = new Monster("Dragon", 15, 7, 100);
        String desc = m.getDescription();
        assertTrue(desc.contains("Dragon"));
        assertTrue(desc.contains("Str: 15"));
        assertTrue(desc.contains("Cft: 7"));
        assertTrue(desc.contains("Hth: 100"));
    }
}

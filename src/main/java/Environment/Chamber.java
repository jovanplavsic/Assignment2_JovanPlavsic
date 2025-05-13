package Environment;

import Entities.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Represents a chamber which can contain items
 */
public class Chamber {
    private List<Door> doors = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private static int nextId = 0;
    private final int id;


    /**
     * Create chamber object
     */
    public Chamber() {
        this.id = nextId++;
    }

    /**
     * Create chamber object with items
     */
    public Chamber(Item... items) {
        this.id = nextId++;
        this.items.addAll(Arrays.asList(items));
    }

/**
     * Add door to chamber
     */
    public void addDoor(Door door) {
        this.doors.add(door);
    }

    /**
     * Return list of all doors in chamber
     */
    public List<Door> getDoors() {
        return this.doors;
    }

    /**
     * Return list of all items in chamber
     */
    public List<Item> getItems() {
        return this.items;
    }

    /**
     * Remove all items from chamber
     */
    public void removeItems(List<Item> items) {
        this.items.removeAll(items);
    }

/**
     * Return ID of chamber
     */
    public int getId() {
        return this.id;
    }
}

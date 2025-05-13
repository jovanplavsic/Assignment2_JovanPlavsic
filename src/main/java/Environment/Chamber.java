package Environment;

import Entities.Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chamber {
    private List<Door> doors = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    private static int nextId = 0;
    private final int id;

    public Chamber(){
        this.id = nextId++;
    }

    public Chamber(Item... items){
        this.id = nextId++;
        this.items.addAll(Arrays.asList(items));
    }

    public void addDoor(Door door){
        this.doors.add(door);
    }

    public List<Door> getDoors(){
        return this.doors;
    }

    public List<Item> getItems(){ return this.items;}

    public void removeItems(List<Item> items){
        this.items.removeAll(items);
    }

    public int getId(){
        return this.id;
    }
}

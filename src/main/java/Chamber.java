import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chamber {
    private List<Door> doors = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public Chamber(){
    }

    public Chamber(Item... items){
        this.items.addAll(Arrays.asList(items));
    }

    public void addDoor(Door door){
        this.doors.add(door);
    }

    public List<Door> getDoors(){
        return this.doors;
    }

    public List<Item> getItems(){
        return this.items;
    }
}

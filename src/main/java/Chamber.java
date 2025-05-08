import java.util.ArrayList;
import java.util.List;

public class Chamber {
    private List<Door> doors = new ArrayList<>();
    private Item item;

    public Chamber(Item item){
        this.item = item;
    }

    public Chamber(){
    }

    public void addDoor(Door door){
        doors.add(door);
    }

    public Item getItem(){
        return this.item;
    }
}

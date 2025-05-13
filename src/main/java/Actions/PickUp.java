package Actions;

import Actions.Action;
import Entities.Character;
import Entities.Item;
import Environment.Chamber;

import java.util.List;

/** Simulate picking up item from chamber*/
public class PickUp implements Action {
    private Character player;
    private List<Item> items;
    private Chamber chamber;

    /** Create PickUp object*/
    public PickUp(Character player, Chamber chamber) {
        this.player = player;
        this.chamber = chamber;
        this.items  = chamber.getItems();
    }

    /** Execute the logic of the code */
    @Override
    public void execute(){
        this.player.addToInventory(this.items);
        this.chamber.removeItems(this.items);
    }
    /** Return string description of action */
    @Override
    public String toString(){
        StringBuilder s = new StringBuilder();

        if (this.items.isEmpty()){
            return "No items";
        }

        for (Item item : this.items){
            s.append("Pick up " + item.getName() + " ");
        }
        return s.toString();
    }
}

import java.util.List;

public class PickUp implements Action{
    private Character player;
     private List<Item> items;
    private Chamber chamber;

    public PickUp(Character player, Chamber chamber) {
        this.player = player;
        this.chamber = chamber;
        this.items  = chamber.getItems();
    }

    @Override
    public String printAction(){
        return "Pick up " + items;
    }

    @Override
    public void execute(){
        this.player.addToInventory(this.items);
        this.chamber.removeItems(this.items);
    }

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

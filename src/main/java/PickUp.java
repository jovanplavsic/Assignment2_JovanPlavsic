public class PickUp implements Action{
    private Character player;
    private Item item;
    private Chamber chamber;

    public PickUp(Character player, Chamber chamber) {
        this.player = player;
        this.chamber = chamber;
        this.item  = chamber.getItem();
    }


    @Override
    public String printAction(){
        return "Pick up " + item.getName();
    }

    @Override
    public void doAction(){
        player.addToInventory(this.item);
    }
}

public class Fight implements Action{
    private Character player;
    private Monster guard;
    private Door door;

    public Fight(Character player, Door door) {
        this.player = player;
        this.door   = door;
        this.guard  = door.getGuard();
    }


    @Override
    public String printAction(){
        Monster guard = door.getGuard();
        return "Fight " + guard.getName();
    }

    @Override
    public void execute(){
        Monster guard = door.getGuard();
        Item playerItem = player.inventory.getFirst();
        playerItem.use(player, guard);
    }
}

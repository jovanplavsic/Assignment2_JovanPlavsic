import java.util.Random;

public class Fight implements Action{
    private Character player;
    private Monster guard;
    private final Random rng = new Random();

    public Fight(Character player, Monster guard) {
        this.player = player;
        this.guard = guard;
    }


    @Override
    public String printAction(){
        return "Fight " + this.guard.getName();
    }

    @Override
    public void execute(){

        boolean monsterUsesStrength = monster.getCraft() == 0;
        int monsterSkill = monsterUsesStrength
                           ? monster.getStrength()
                           : monster.getCraft();
        int playerSkill  = monsterUsesStrength
                           ? player.getStrength()
                           : player.getCraft();

    }

    @Override
    public String toString(){
        Monster guard = door.getGuard();

        return "Fight " + guard.getName();
    }
}

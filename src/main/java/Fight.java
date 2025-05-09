import java.util.Random;

public class Fight implements Action {
    private Character player;
    private Monster guard;
    private final Random rng = new Random();

    public Fight(Character player, Monster guard) {
        this.player = player;
        this.guard = guard;
    }


    @Override
    public String printAction() {
        return "Fight " + this.guard.getName();
    }

    @Override
    public void execute() {

        boolean useStrength;
        if (guard.getCraft() == 0) {
            useStrength = true;
        } else {
            useStrength = false;
        }

        int monsterSkill;
        if (useStrength) {
            monsterSkill = guard.getStrength();
        } else {
            monsterSkill = guard.getCraft();
        }

        int playerSkill;
        if (useStrength) {
            playerSkill = player.getStrength();
        } else {
            playerSkill = player.getCraft();
        }

        Item right = player.rightHand();
        int itemBonus = 0;
        if (right != null) {
            if (useStrength) {
                itemBonus = right.getPower();
            } else {
                itemBonus = right.getPower();
            }
        }

        int monsterRoll = rng.nextInt(6) + 1 + monsterSkill;
        int playerRoll = rng.nextInt(6) + 1 + playerSkill + itemBonus;

        System.out.println();
        System.out.println("BEGIN FIGHT");
        System.out.println("You roll " + playerRoll + " vs. monster’s " + monsterRoll);

        int diff = playerRoll - monsterRoll;
        if (diff > 0) {
            guard.takeDamage(diff);
            System.out.println("You deal " + diff + " damage! Monster health is now " + guard.getHealth());
            if (guard.getHealth() <= 0) {
                System.out.println("Monster defeated!");
                System.out.println();
            }
        } else {
            int damage = -diff;
            int newPlayerHealth = player.getHealth() - damage;
            player.takeDamage(diff);
            System.out.println("Monster deals " + diff + " damage! Your health is now " + player.getHealth());
            System.out.println();
        }


    }

    @Override
    public String toString() {
        return "Fight " + this.guard.getName();
    }
}

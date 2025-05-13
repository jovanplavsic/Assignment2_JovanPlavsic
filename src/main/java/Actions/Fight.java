package Actions;

import Entities.Character;

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
        Item left = player.leftHand();

        int itemBonus = 0;
        if (right != null) {
                itemBonus += right.getPower();
            }
        if (left != null) {
                itemBonus += left.getPower();
            }

        int monsterRoll = rng.nextInt(6) + 1 + monsterSkill;
        int playerRoll = rng.nextInt(6) + 1 + playerSkill + itemBonus;

        System.out.println();
        System.out.println("BEGIN FIGHT");
        System.out.println("You roll " + playerRoll + " vs. " + this.guard.getName() + "’s " + monsterRoll);

        int diff = playerRoll - monsterRoll;
        if (diff > 0) {
            guard.takeDamage(diff);
            System.out.println("You deal " + diff + " damage! " + this.guard.getName() + " health is now " + guard.getHealth());
            if (guard.getHealth() <= 0) {
                System.out.println(this.guard.getName() + " defeated!");
                System.out.println();
            }
        } else if (diff < 0){
            player.takeDamage(diff);
            System.out.println(this.guard.getName() + " deals " + diff + " damage! Your health is now " + player.getHealth());
            System.out.println();
        } else{
            player.takeDamage(10);
            System.out.println(this.guard.getName() + " deals " + 10 + " damage! Your health is now " + player.getHealth());
            System.out.println();
        }
    }

    @Override
    public String toString() {
        return "Fight " + this.guard.getName();
    }
}

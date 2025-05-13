package Actions;

import Entities.Character;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swap implements Action {
    private final Character player;

    public Swap(Character player) {
        this.player = player;
    }

    @Override
    public String printAction() {
        return this.toString();
    }

    @Override
    public void execute() {
        System.out.println(player.viewInventory());

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Enter first item index (or c to cancel): ");
            String line = reader.readLine().trim();
            if ("c".equalsIgnoreCase(line)) {
                System.out.println("Swap cancelled.");
                return;
            }
            int first = Integer.parseInt(line);

            System.out.print("Enter second item index (or c to cancel): ");
            line = reader.readLine().trim();
            if ("c".equalsIgnoreCase(line)) {
                System.out.println("Swap cancelled.");
                return;
            }
            int second = Integer.parseInt(line);

            player.switchItems(first, second);
            System.out.println("Items swapped!");
        } catch (Exception e) {
            System.out.println("Swap failed: please enter two valid indices.");
        }
    }


    @Override
    public String toString() {
        return "View or Swap inventory items";
    }
}

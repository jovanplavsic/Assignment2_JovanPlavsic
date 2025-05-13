package Actions;

import Entities.Character;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/** Simulate swapping items in inventory */
public class Swap implements Action {
    private final Character player;

    /** Create swap object*/
    public Swap(Character player) {
        this.player = player;
    }

    /** Execute logic of swapping by doing the following
     * 1. Display inventory and indexes of items
     * 2. Take 2 inputs
     * 3. Swap the two items in those indexes
     * */
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

    /** Return string description of action */
    @Override
    public String toString() {
        return "View or Swap inventory items";
    }
}

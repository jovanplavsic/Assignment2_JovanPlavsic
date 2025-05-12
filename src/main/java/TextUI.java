import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class TextUI {
    public void play(Dungeon d) {
        System.out.println("---------------------------------------");
        System.out.println("Loading game...");
        System.out.println();
        while (!d.isFinished()) {
            print(d);
            Action a = ask(d);
            a.execute();
        }
    }

    /**
     * Print the current room of the dungeon.
     */
    private void print(Dungeon d) {
        Chamber r = d.getCurrentChamber();
        StringBuilder s = new StringBuilder();
        s.append("Chamber " + r.getId() + " has " + r.getDoors().size() + " doors ");
        s.append("and " + r.getItems().size() + " items\n\n");

        int j = 0;
        if (!r.getItems().isEmpty()) {
            s.append("Items: \n");
            for (Item item : r.getItems()) {
                s.append("[" + j++ +"]");
                s.append(item.getName()).append("\n");
            }
            s.append("\n");
        }


        int i = 0;
        for (Door door : r.getDoors()) {
            if (door.isGuarded()) {
                Monster guard = door.getGuard();
                if (guard != null) {
                    s.append("Door " + i++ + " is guarded by a ")
                            .append(guard.getDescription())
                            .append("\n");
                } else {
                    s.append("No guard at this door\n");
                }
            }
        }

        System.out.println(s);
    }

    /**
     * Asks the user for an action.
     */
    private Action ask(Dungeon d) {
        StringBuilder s = new StringBuilder();
        s.append("Here are your options:\n");
        List<Action> actions = d.getActions();
        for (int i = 0; i < actions.size(); i++) {
            Action a = actions.get(i);
            s.append("\t" + i + ": " + a.toString() + "\n");
        }
        System.out.println(s);

        // ask for action
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        try {
            int command = Integer.parseInt(reader.readLine());
            return actions.get(command);
        } catch (IOException e) {
            return new PrintError(d, e);
        }
    }
}

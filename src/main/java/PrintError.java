import Actions.Action;
import Environment.Dungeon;

import java.io.IOException;

public class PrintError implements Action {
    private final Dungeon dungeon;
    private final IOException exception;

     public PrintError(Dungeon dungeon, IOException exception) {
        this.dungeon = dungeon;
        this.exception = exception;
    }

    @Override
    public void execute() {
        System.out.println("Error: " + exception.getMessage());
     }

     @Override
    public String toString(){ return "Error: " + exception.getMessage();}
}

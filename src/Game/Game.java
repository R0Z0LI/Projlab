package Game;

import java.util.ArrayList;

public class Game {
    private ArrayList<Steppable> steppables;

    public Game() {
        steppables = new ArrayList<>();
    }

    public void addSteppable(Steppable s) {
        steppables.add(s);
    }

    public void removeSteppable(Steppable s) {
        steppables.remove(s);
    }

    public void stepSteppabbles() {
        for (Steppable s : steppables) {
            s.step();
        }
    }

    public void endGame() {
        System.out.println("! A játék véget ért.");
    }
}

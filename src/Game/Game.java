package Game;

import java.util.ArrayList;

public class Game {
    private ArrayList<Steppable> steppables;

    public Game(){
        steppables = new ArrayList<>();
    }
    public void AddSteppable(Steppable s){
        steppables.add(s);
    }
    public void RemoveSteppable(Steppable s){
        steppables.remove(s);
    }
    public void StepSteabbles(){
        for(Steppable s : steppables)
            s.Step();
    }
    public void EndGame(){
        System.out.println("! A játék véget ért.");
    }
}

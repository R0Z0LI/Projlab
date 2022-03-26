package agent;

import virologist.Virologist;

public abstract class Agent implements Steppable{

    private int time_left;

    public Agent(int timeleft){
        time_left=timeleft;
    }

    public void setTime_left(int time_left) {
        this.time_left = time_left;
    }

    public int getTime_left() {
        return time_left;
    }

    public void Step(){
        time_left--;
    }

    public abstract void RemoveBehFromStack(Virologist v);

    public abstract void AddBehToStack(Virologist v);
}

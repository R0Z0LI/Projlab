package behaviors;

import agent.Agent;
import virologist.Virologist;

public class ApplyBehavior {
    private Virologist virologist;

    public ApplyBehavior(Virologist v){
        virologist=v;
    }

    public ApplyBehavior() {

    }

    /**+
     * Végrehajtja egy ágens kenését. (Nem feltétlenül lesz sikeres, hiszen
     * az áldozat kivédheti.)
     * @param agent     ágens, amit kenni kell
     * @param affected  virológus, akire kenni kell
     */
    public void apply(Agent agent, Virologist affected){
        if(affected==virologist)
            agent.AddBehToStack(virologist);
        else {
            affected.beInfected(agent, virologist);
        }

    }
}

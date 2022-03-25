package behaviors;

import virologist.Virologist;

public class ApplyBehavior {
    private Virologist virologist;

    public ApplyBehavior(Virologist v){
        virologist=v;
    }

    /**+
     * Végrehajtja egy ágens kenését. (Nem feltétlenül lesz sikeres, hiszen
     * az áldozat kivédheti.)
     * @param agent     ágens, amit kenni kell
     * @param affected  virológus, akire kenni kell
     */
    public void Apply(Agent agent, Virologist affected){
        if(affected==virologist)
            agent.AddBehToStack(virologist);
        else {
            affected.Beinfected(agent, virologist);
        }

    }
}
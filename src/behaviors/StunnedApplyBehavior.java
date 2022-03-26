package behaviors;

import agent.Agent;
import virologist.Virologist;

public class StunnedApplyBehavior extends ApplyBehavior{
    public StunnedApplyBehavior(Virologist v){
        super(v);
    }

    public StunnedApplyBehavior() {
        super();
    }
    /**+
     * Lebénulva nem sikerül a kenés.
     * @param agent     ágens, amit kenni kellene
     * @param affected  virológus, akire kenni kellene
     */
    @Override
    public void apply(Agent agent, Virologist affected) {
        System.out.println("-> StunnedApplyBehavior.apply(Agent agent, Virologist affected)");
        System.out.println("! Lebénulva nem sikerül a kenés.");

        return;
    }
}

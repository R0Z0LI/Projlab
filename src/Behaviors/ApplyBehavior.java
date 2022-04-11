package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

public class ApplyBehavior {
    private Virologist virologist;

    public ApplyBehavior(Virologist v) {
        virologist = v;
    }

    public ApplyBehavior() {
    }

    public void setVirologist(Virologist v) {
        virologist = v;
    }

    public Virologist getVirologist() {
        return virologist;
    }

    /**
     * +
     * Végrehajtja egy ágens kenését. (Nem feltétlenül lesz sikeres, hiszen
     * az áldozat kivédheti.)
     *
     * @param agent    ágens, amit kenni kell
     * @param affected virológus, akire kenni kell
     */
    public void apply(Agent agent, Virologist affected) {
        System.out.println("->ApplyBehavior.apply(Agent, affected)");
        if (affected == virologist) {
            System.out.println("! A virologus rakeni magara az agenst.\n");
            agent.addBehavior(virologist);
        } else {
            System.out.println("! A  masik virologusra rakenik az agenst.");
            affected.beInfected(agent, virologist);
        }

    }
}

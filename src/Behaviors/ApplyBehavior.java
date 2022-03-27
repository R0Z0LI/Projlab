package Behaviors;

import Agent.Agent;
import Virologist.Virologist;

public class ApplyBehavior {
    private Virologist virologist;

    public ApplyBehavior(Virologist v){
        virologist=v;
    }
    public ApplyBehavior(){

    }

    /**+
     * Végrehajtja egy ágens kenését. (Nem feltétlenül lesz sikeres, hiszen
     * az áldozat kivédheti.)
     * @param agent     ágens, amit kenni kell
     * @param affected  virológus, akire kenni kell
     */
    public void apply(Agent agent, Virologist affected){
        System.out.println("->ApplyBehavior.apply(Agent, affected)");
        if(affected==virologist) {
            System.out.println("! A virológus rákeni magára az ágenst.");
            agent.AddBehToStack(virologist);
        }
        else {
            System.out.println("! A  másik virológusra rákenik az ágenst.");
            affected.beInfected(agent, virologist);
        }

    }
}

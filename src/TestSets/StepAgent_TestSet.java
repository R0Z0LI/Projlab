package TestSets;

import PropertyHandler.PropertyHandler;
import Agent.*;
import Virologist.Virologist;

import java.util.Scanner;

/**
 * Teszt eset, ami az ágens idejének telését és az ágens eltávolítását teszteli.
 */
public class StepAgent_TestSet {

    private int time = 5;
    private Virologist viro;
    private Agent usedAgent;

    /**
     * Konstruktor, ami meghívja a teszt inicializálását.
     */
    public StepAgent_TestSet() {
        init_test();
    }

    /**
     *  Lefutattja a tesztet, és megnézi az eredményt.
     */
    public void test() {
        System.out.println("Testing Agent stepping and removal ...");

        usedAgent.Step(); // time should reach 0, and be removed from viro

        // checking
        System.out.println("Testing has ended. Time left for the used Agent: " + usedAgent.getTime_left());
        if (viro.getPropertyHandler().getAgents().size() == 0)
            System.out.println("The agent has been successfully removed from the virologist! OK");
        else
            System.out.println("The agent hasn't been removed!!!!");
    }

    /**
     * Inicializál mindent szükséges objektumot és tagváltozót, ami kell a teszteléshez.
     */
    private void init_test() {

        System.out.println("Init agent stepping test ...");

        PropertyHandler ph = new PropertyHandler(3, 10, 10, viro);
        viro = new Virologist(2, ph, null);

        System.out.print("Melyik ágens legyen léptetve? [v/b/t] ");
        Scanner sc = new Scanner(System.in);
        String agentType = sc.next();
        switch (agentType) {
            case "v":
                System.out.print("Lejárt az ágens hatásának ideje? [i/n] ");
                if (sc.next().equals("i"))
                    time = 1;
                usedAgent = new ProtectionAgent(time);
                break;

            case "b":
                System.out.print("Lejárt az ágens hatásának ideje? [i/n] ");
                if (sc.next().equals("i"))
                    time = 1;
                usedAgent = new ParalyseAgent(time);
                break;

            case "t":
                System.out.print("Lejárt az ágens hatásának ideje? [i/n] ");
                if (sc.next().equals("i"))
                    time = 1;
                usedAgent = new CrazyDanceAgent(time);
                break;

            default:
                System.err.println("You used a wrong Agent type!");
        }

        viro.applyAgent(usedAgent, viro);

        //ph.addAgent(usedAgent);
        // PROBLEM: agent-et nem lehet megadni, mert steppable-t vár
        // SOLUTION: az egész steppable interfészt kidobjuk és agent-et használunk helyette
        // game.AddSteppable((Steppable) usedAgent);

        System.out.println("Init has ended.");
    }
}

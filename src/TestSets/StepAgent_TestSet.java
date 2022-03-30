package TestSets;

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

        usedAgent.step(); // time should reach 0, and be removed from viro

        // checking
        System.out.println("Testing has ended. Time left for the used Agent: " + usedAgent.getTimeLeft());
    }

    /**
     * Inicializál mindent szükséges objektumot és tagváltozót, ami kell a teszteléshez.
     */
    private void init_test() {

        System.out.println("Init agent stepping test ...");

        viro = new Virologist();

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

        System.out.println("Init has ended.");
    }
}

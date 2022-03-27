package TestSets;

import Collectible.Collectible;
import Materials.*;
import PropertyHandler.PropertyHandler;
import Behaviors.StealBehavior;
import Equipments.*;
import Virologist.Virologist;

import java.util.Scanner;

/**
 * Teszt eset, ami az ágens idejének telését és az ágens eltávolítását teszteli.
 */
public class Steal_TestSet {

    private Collectible valuable;
    private int amount = 1;
    private Virologist stealingViro;
    private Virologist affectedViro;

    /**
     * Konstruktor, ami meghívja a teszt inicializálását.
     */
    public Steal_TestSet() {
        init_test();
    }

    /**
     *  Lefutattja a tesztet, és megnézi az eredményt.
     */
    public void test() {

        System.out.println("Testing stealing ...");

        for (int i = 0; i < amount; i++)
            stealingViro.steal(valuable, affectedViro);

        /////// EZEN AZ AMOUNT CUCCON MÉG DOLGOZNI FOGOK - DANI (de a legtöbb érsze már működik)
        // checking if everything is OK
        if (amount == 0) {
            System.out.println("Testing has ended. Empty inventory. Nice.");
        } else if (stealingViro.getPropertyHandler().getEquipments().size() != 0)
            System.out.println("Testing has ended. Found equipment in inventory. Nice.");
        else if (stealingViro.getPropertyHandler().getAminos().size() == amount) {
            System.out.println("Testing has ended. Found aminos in inventory, and it's the asked amount. Very Nice.");
        } else if (stealingViro.getPropertyHandler().getNucleos().size() == amount) {
            System.out.println("Testing has ended. Found nucleos in inventory, and it's the asked amount. Very Nice.");
        } else {
            System.out.println("Testing has ended, but nothing was found!");
        }
    }

    /**
     * Inicializál mindent szükséges objektumot és tagváltozót, ami kell a teszteléshez.
     */
    private void init_test() {

        System.out.println("Init stealing test ...");

        PropertyHandler ph1 = new PropertyHandler(3, 10, 10, stealingViro);
        stealingViro = new Virologist(2, ph1, null);
        stealingViro.setStealBehaviors(new StealBehavior(stealingViro));

        PropertyHandler ph2 = new PropertyHandler(3, 10, 10, affectedViro);
        affectedViro = new Virologist(2, ph2, null);
        affectedViro.setStealBehaviors(new StealBehavior(affectedViro));

        Scanner sc = new Scanner(System.in);
        System.out.println("Mit szeretnél lopni? [a, n, k, z, v]");
        switch (sc.next()) {
            case "a":
                valuable = new AminoAcid();
                System.out.print("Mennyi aminosavat lopjon el? [0…10] ");
                amount = sc.nextInt();
                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                amount -= 10 - sc.nextInt();

                for (int i = 0; i < amount; i++) {
                    affectedViro.getPropertyHandler().addAmino((AminoAcid) valuable);
                }

                break;
            case "n":
                valuable = new Nucleotid();
                System.out.print("Mennyi nukleotidot lopjon el? [0…10] ");
                amount = sc.nextInt();
                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                amount -= 10 - sc.nextInt();

                for (int i = 0; i < amount; i++) {
                    affectedViro.getPropertyHandler().addNucleo((Nucleotid) valuable);
                }

                break;
            case "k":
                valuable = new Gloves();
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                if (sc.nextInt() == 0)
                    amount = 0;

                affectedViro.getPropertyHandler().addEquipment((Gloves) valuable);
                break;

            case "z":
                valuable = new Sack();
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                if (sc.nextInt() == 0)
                    amount = 0;
                else
                affectedViro.getPropertyHandler().addEquipment((Sack) valuable);

                break;
            case "v":
                valuable = new Cape();
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                if (sc.nextInt() == 0)
                    amount = 0;

                affectedViro.getPropertyHandler().addEquipment((Cape) valuable);

                break;
            default:
                System.err.println("You used a wrong type!");
        }

        System.out.println("Init has ended.");

    }
}

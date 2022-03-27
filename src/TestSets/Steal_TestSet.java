package TestSets;

import Collectible.Collectible;
import Materials.*;
import PropertyHandler.PropertyHandler;
import Behaviors.StealBehavior;
import Equipments.*;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Teszt eset, ami az ágens idejének telését és az ágens eltávolítását teszteli.
 */
public class Steal_TestSet {

    private List<Collectible> valuables = new ArrayList<>();
    private int amount = 1;
    private int freeSpace = 1;
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

        // steal the things we want to steal
        for (Collectible valuable: valuables) {
            stealingViro.steal(valuable, affectedViro);
        }

        // checking if everything is OK
        if (stealingViro.getPropertyHandler().getAminos().size() == amount || stealingViro.getPropertyHandler().getNucleos().size() == amount) {
            System.out.println("Testing has ended. Found material in inventory, and it's the asked amount. Very Nice.");
        } else if (stealingViro.getPropertyHandler().getEquipments().size() == valuables.size()) {
            System.out.println("Testing has ended. Stealing equipment was OK.");
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
        stealingViro.addStealBehavior(new StealBehavior(stealingViro));

        PropertyHandler ph2 = new PropertyHandler(3, 10, 10, affectedViro);
        affectedViro = new Virologist(2, ph2, null);
        affectedViro.addStealBehavior(new StealBehavior(affectedViro));

        Scanner sc = new Scanner(System.in);
        System.out.println("Mit szeretnél lopni? [a, n, k, z, v]");
        switch (sc.next()) {
            case "a":
                System.out.print("Mennyi aminosavat lopjon el? [0…10] ");
                amount = sc.nextInt();
                for (int i = 0; i < amount; i++)
                    valuables.add(new AminoAcid());

                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                stealingViro.getPropertyHandler().setMax_material(sc.nextInt());

                for (int i = 0; i < amount; i++)
                    affectedViro.getPropertyHandler().addAmino((AminoAcid) valuables.get(i));
                break;

            case "n":
                System.out.print("Mennyi nukleotidot lopjon el? [0…10] ");
                amount = sc.nextInt();
                for (int i = 0; i < amount; i++)
                    valuables.add(new Nucleotid());

                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                stealingViro.getPropertyHandler().setMax_material(sc.nextInt());

                for (int i = 0; i < amount; i++)
                    affectedViro.getPropertyHandler().addNucleo((Nucleotid) valuables.get(i));
                break;

            case "k":
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                freeSpace = sc.nextInt();
                for (int i = 0; i < 3-freeSpace; i++) {
                    valuables.add(new Gloves());
                    stealingViro.getPropertyHandler().addEquipment((Gloves) valuables.get(valuables.size()-1));
                }

                if (freeSpace > 0) {
                    valuables.add(new Gloves());
                    affectedViro.getPropertyHandler().addEquipment((Gloves) valuables.get(valuables.size()-1));
                }
                break;

            case "z":
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                freeSpace = sc.nextInt();
                for (int i = 0; i < 3-freeSpace; i++) {
                    valuables.add(new Sack());
                    stealingViro.getPropertyHandler().addEquipment((Sack) valuables.get(valuables.size()-1));
                }

                if (freeSpace > 0) {
                    valuables.add(new Sack());
                    affectedViro.getPropertyHandler().addEquipment((Sack) valuables.get(valuables.size()-1));
                }
                break;

            case "v":
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                freeSpace = sc.nextInt();
                for (int i = 0; i < 3-freeSpace; i++) {
                    valuables.add(new Cape());
                    stealingViro.getPropertyHandler().addEquipment((Cape) valuables.get(valuables.size()-1));
                }

                if (freeSpace > 0) {
                    valuables.add(new Cape());
                    affectedViro.getPropertyHandler().addEquipment((Cape) valuables.get(valuables.size()-1));
                }
                break;

            default:
                System.err.println("You used a wrong type!");
        }

        System.out.println("Init has ended.");

    }
}

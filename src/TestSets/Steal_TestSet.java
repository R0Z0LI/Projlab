package TestSets;

import Collectible.Collectible;
import Materials.*;
import Equipments.*;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Teszt eset, ami az ágens idejének telését és az ágens eltávolítását teszteli.
 */
public class Steal_TestSet {

    private List<Collectible> valuables = new ArrayList<>(); // the things that we are stealing
    private int amount = 1; // the amount that we are trying to steal
    private int currFullness = 0;
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
        for (Collectible valuable: valuables)
            stealingViro.steal(valuable, affectedViro);

        // checking if everything is OK
        if (stealingViro.getPropertyHandler().getAminoAcids().size() == amount || stealingViro.getPropertyHandler().getNucleotids().size() == amount) {
            System.out.println("Testing has ended. Found material in inventory, and it's the asked amount. Very Nice.");
        } else if (stealingViro.getPropertyHandler().getEquipments().size() == valuables.size() + currFullness) {
            System.out.println("Testing has ended. Stealing equipment was OK.");
        } else {
            // for some reason we weren't able to steal anything, this should NOT occur
            System.out.println("Testing has ended, but nothing was found!");
        }
    }

    /**
     * Inicializál mindent szükséges objektumot és tagváltozót, ami kell a teszteléshez.
     */
    private void init_test() {

        System.out.println("Init stealing test ...");

        // creating virologists
        stealingViro = new Virologist();
        affectedViro = new Virologist();

        // space that is available in the stealing virologist's inventory
        int freeSpace;

        Scanner sc = new Scanner(System.in);
        System.out.println("Mit szeretnél lopni? [a, n, k, z, v]");
        switch (sc.next()) {
            // if we want to steal aminoacid
            case "a":
                // creating the things that we are gonna steal
                System.out.print("Mennyi aminosavat lopjon el? [0…10] ");
                amount = sc.nextInt();
                for (int i = 0; i < amount; i++)
                    valuables.add(new AminoAcid());

                // changing available space
                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                stealingViro.getPropertyHandler().setMaxMaterial(sc.nextInt());

                // putting the valuables in the other virologist
                for (int i = 0; i < amount; i++)
                    affectedViro.getPropertyHandler().add((AminoAcid) valuables.get(i));
                break;

            // if we want to steal nucleotid
            case "n":
                // creating the things that we are gonna steal
                System.out.print("Mennyi nukleotidot lopjon el? [0…10] ");
                amount = sc.nextInt();
                for (int i = 0; i < amount; i++)
                    valuables.add(new Nucleotid());

                // changing available space
                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                stealingViro.getPropertyHandler().setMaxMaterial(sc.nextInt());

                // putting the valuables in the other virologist
                for (int i = 0; i < amount; i++)
                    affectedViro.getPropertyHandler().add((Nucleotid) valuables.get(i));
                break;

            // if we want to steal gloves
            case "k":
                // creating, and adding the other stuff to our inventory
                System.out.print("Mennyi védoeszkozt tud még eltárolni? [0…3] ");
                freeSpace = sc.nextInt();
                currFullness = 3-freeSpace;
                for (int i = 0; i < currFullness; i++)
                    stealingViro.getPropertyHandler().add(new Gloves());

                // creating and putting the valuables in the other virologist
                if (currFullness < 3) {
                    valuables.add(new Gloves());
                    affectedViro.getPropertyHandler().add((Gloves) valuables.get(valuables.size()-1));
                }
                break;

            // if we want to steal a sack
            case "z":
                // creating, and adding the other stuff to our inventory
                System.out.print("Mennyi védoeszkozt tud még eltárolni? [0…3] ");
                freeSpace = sc.nextInt();
                currFullness = 3-freeSpace;
                for (int i = 0; i < currFullness; i++)
                    stealingViro.getPropertyHandler().add(new Sack());

                // creating and putting the valuables in the other virologist
                if (currFullness < 3) {
                    valuables.add(new Sack());
                    affectedViro.getPropertyHandler().add((Sack) valuables.get(valuables.size() - 1));
                }
                break;

            // if we want to steal cape
            case "v":
                // creating, and adding the other stuff to our inventory
                System.out.print("Mennyi védoeszkozt tud még eltárolni? [0…3] ");
                freeSpace = sc.nextInt();
                currFullness = 3-freeSpace;
                for (int i = 0; i < currFullness; i++)
                    stealingViro.getPropertyHandler().add(new Cape());

                // creating and putting the valuables in the other virologist
                if (currFullness < 3) {
                    valuables.add(new Cape());
                    affectedViro.getPropertyHandler().add((Cape) valuables.get(valuables.size() - 1));
                }
                break;

            default:
                System.err.println("You used a wrong type!");
        }

        System.out.println("Init has ended.");

    }
}

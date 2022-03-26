package TestSets;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import behaviors.StealBehavior;
import equipments.*;
import virologist.Virologist;

import java.util.Scanner;

public class Steal_TestSet {

    private Collectible valuable;
    private int amount = 1;
    private Virologist stealingViro;
    private Virologist affectedViro;

    // constructor
    public Steal_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {
        for (int i = 0; i < amount; i++)
            stealingViro.steal(valuable, affectedViro);
    }

    // initializing everything we need for this test
    private void init_test() {

        PropertyHandler ph = new PropertyHandler(3, 10, 10, stealingViro, null, null, null, null, null);
        stealingViro = new Virologist(2, ph, null, null, null, null, null, null, null);
        stealingViro.setStealBeh(new StealBehavior(stealingViro));

        Scanner sc = new Scanner(System.in);
        System.out.println("Mit szeretnél lopni? [amino, nukleo, kesztyu, zsak, vedokopeny]");
        switch (sc.next()) {
            case "amino":
                System.out.print("Mennyi aminosavat lopjon el? [0…10] ");
                amount = sc.nextInt();
                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                amount -= sc.nextInt();
                break;
            case "nukleo":
                System.out.print("Mennyi nukleotidot lopjon el? [0…10] ");
                amount = sc.nextInt();
                System.out.print("Mennyi aminosavat tud még eltárolni? [0…10] ");
                amount -= sc.nextInt();
                break;
            case "kesztyu":
                valuable = new Gloves();
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                if (sc.nextInt() == 0)
                    amount = 0;
                break;
            case "zsak":
                valuable = new Sack();
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                if (sc.nextInt() == 0)
                    amount = 0;
                break;
            case "vedokopeny":
                valuable = new Cape();
                System.out.print("Mennyi védőeszközt tud még eltárolni? [0…3] ");
                if (sc.nextInt() == 0)
                    amount = 0;
                break;
            default:
                System.err.println("You used a wrong type!");
        }

    }
}

package TestSets;

import Equipments.*;
import Virologist.Virologist;

import java.util.Scanner;

/**
 * Teszt eset, ami a felszerelés eldobását teszteli.
 */
public class ThrowEquipment_TestSet {

    private Equipment equip;
    private Virologist viro;

    /**
     * Konstruktor, ami meghívja a teszt inicializálását.
     */
    public ThrowEquipment_TestSet() { init_test(); }

    /**
     *  Lefutattja a tesztet, és megnézi az eredményt.
     */
    public void test() {
        System.out.println("Testing Equipment throwing ...");
        viro.destroyEquipment(equip);

        // Checking testing result
        if (viro.getPropertyHandler().getEquipments().size() == 0)
            System.out.println("Testing has ended. No equipment in inventory. Nice.");
        else
            System.out.println("Testing has ended, but there is still an equipment in the inventory!");
    }

    /**
     * Inicializál mindent szükséges objektumot és tagváltozót, ami kell a teszteléshez.
     */
    private void init_test() {

        System.out.println("Init equipment throwing test ...");

        // constructing a virologist
        viro = new Virologist();

        // reading in the equipment that we want to throw away
        Scanner sc = new Scanner(System.in);
        System.out.print("Melyik védőfelszerelést dobja el? [v/k/z] ");
        switch (sc.next()) {
            case "v":
                equip = new Cape();
                break;
            case "k":
                equip = new Gloves();
                break;
            case "z":
                equip = new Sack();
                break;
            default:
                System.err.println("You used a wrong Equipment type!");
        }

        // adding chosen equipment to virologist
        viro.getPropertyHandler().addEquipment(equip);

        System.out.println("Init has ended.");
    }
}

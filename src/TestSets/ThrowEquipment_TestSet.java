package TestSets;

import PropertyHandler.PropertyHandler;
import equipments.*;
import virologist.Virologist;

import java.util.Scanner;

public class ThrowEquipment_TestSet {

    private Equipment equip;
    private Virologist viro;

    // constructor
    public ThrowEquipment_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {
        viro.destroyEquipment(equip);
    }

    // initializing everything we need for this test
    private void init_test() {

        PropertyHandler ph = new PropertyHandler(3, 10, 10, viro);
        viro = new Virologist(2, ph, null);

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

        viro.getPropertyHandler().AddEquipment(equip);
    }

}

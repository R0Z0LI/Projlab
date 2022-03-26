package TestSets;

import PropertyHandler.PropertyHandler;
import equipments.*;
import virologist.Virologist;

import java.util.List;
import java.util.Scanner;

public class ThrowEquipment_TestSet {

    private List<Equipment> equip;
    private Virologist viro;

    // constructor
    public ThrowEquipment_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {
        viro.DestroyEquipment(equip.get(0));
    }

    // initializing everything we need for this test
    private void init_test() {

        PropertyHandler ph = new PropertyHandler(3, 10, 10, viro, null, null, null, null, null);
        viro = new Virologist(2, ph, null, null, null, null, null, null, null);

        Scanner sc = new Scanner(System.in);
        System.out.print("Melyik védőfelszerelést dobja el? [v/k/z] ");
        switch (sc.next()) {
            case "v":
                equip.add(new Cape());
                break;
            case "k":
                equip.add(new Gloves());
                break;
            case "z":
                equip.add(new Sack());
                break;
            default:
                System.err.println("You used a wrong Equipment type! WE are gonna choose cape for you!");
                equip.add(new Cape());
        }

        viro.getPropertyHandler().setEquipments(equip);
    }

}

package TestSets;

import Collectible.Collectible;
import Field.*;
import Materials.*;
import PropertyHandler.PropertyHandler;
import Equipments.*;
import Gencode.*;
import Virologist.Virologist;

import java.util.Scanner;

public class Collect_TestSet {

    private Virologist viro;
    private Collectible collectible;
    private Field field;

    public Collect_TestSet() {
        init_test();
    }

    public void test() {
        System.out.println("Testing collecting ...");

        viro.collect(collectible);

        // checking
        if (viro.getPropertyHandler().getNucleos().size() != 0)
            System.out.println("Testing has ended. Found equipment in inventory. Nice.");
        else if (viro.getPropertyHandler().getAminos().size() != 0) {
            System.out.println("Testing has ended. Found aminos in inventory, and it's the asked amount. Very Nice.");
        } else if (viro.getPropertyHandler().getEquipments().size() != 0) {
            System.out.println("Testing has ended. Found nucleos in inventory, and it's the asked amount. Very Nice.");
        } else {
            System.out.println("Testing has ended, but nothing was found!");
        }

        System.out.println("Testing has ended.");
    }

    private void init_test() {

        System.out.println("Init collecting test ...");

        field = new Laboratory();
        viro = new Virologist();

        Scanner sc = new Scanner(System.in);

        System.out.print("Mit vennél fel? [kesztyű, köpeny, zsák, Amino, Nucleo, Gencode] ");
        String CollectType = sc.next();
        if(!(CollectType.equals("kesztyű") || CollectType.equals("zsák")  || CollectType.equals("köpeny") || CollectType.equals("Nucleo") || CollectType.equals("Amino") || CollectType.equals("Gencode"))){
            CollectType = "kesztyű";
        }
        switch (CollectType) {

            case "kesztyű":
                collectible = new Gloves();
                field = new Shelter();
                ((Shelter) field).AddEquipment((Equipment) collectible);
                viro.setCurrentField(field);
                break;

            case "köpeny":
                collectible = new Cape();
                field = new Shelter();
                ((Shelter) field).AddEquipment((Equipment) collectible);
                viro.setCurrentField(field);
                break;

            case "zsák":
                collectible = new Sack();
                field = new Shelter();
                ((Shelter) field).AddEquipment((Equipment) collectible);
                viro.setCurrentField(field);
                break;

            case "Amino":
                collectible = new AminoAcid();
                field = new Warehouse();
                ((Warehouse) field).AddAmino((AminoAcid) collectible);
                viro.setCurrentField(field);
                break;

            case "Nucleo":
                field = new Warehouse();
                collectible = new Nucleotid();
                ((Warehouse) field).AddNucleo((Nucleotid) collectible);
                viro.setCurrentField(field);
                break;

            case "Gencode":
                field = new Laboratory();
                collectible = new AmnesiaCode(4,5, field);
                ((Laboratory) field).AddGenCode((GenCode) collectible);
                viro.setCurrentField(field);
                break;

            default:
                System.err.println("Wrong input!");
                break;
        }

        System.out.println("Init has ended.");

    }
}

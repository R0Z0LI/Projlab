package TestSets;

import Collectible.Collectible;
import Field.*;
import Materials.*;
import PropertyHandler.PropertyHandler;
import behaviors.CollectBehavior;
import equipments.*;
import gencode.*;
import virologist.Virologist;

import java.util.Scanner;

public class Collect_TestSet {

    private Virologist viro;
    private Collectible collectible;
    private Field field;

    public Collect_TestSet() {
        init_test();
    }

    public void test() {
        viro.collect(collectible);
    }

    private void init_test() {

        field = new Laboratory();
        PropertyHandler ph = new PropertyHandler();
        viro = new Virologist(2, ph, field);

        CollectBehavior collectBehavior = new CollectBehavior(viro);

        Scanner sc = new Scanner(System.in);

        System.out.print("Mit vennél fel? [kesztyű, köpeny, zsák, Amino, Nucleo] ");
        String CollectType = sc.next();
        switch (CollectType) {

            case "kesztyű":
                collectible = new Gloves();
                field = new Shelter();
                ((Shelter) field).AddEquipment((Equipment) collectible);
                viro.setCurrField(field);
                break;

            case "köpeny":
                collectible = new Cape();
                field = new Shelter();
                ((Shelter) field).AddEquipment((Equipment) collectible);
                viro.setCurrField(field);
                break;

            case "zsák":
                collectible = new Sack();
                field = new Shelter();
                ((Shelter) field).AddEquipment((Equipment) collectible);
                viro.setCurrField(field);
                break;

            case "Amino":
                collectible = new AminoAcid();
                field = new Warehouse();
                ((Warehouse) field).AddAmino((AminoAcid) collectible);
                viro.setCurrField(field);
                break;

            case "Nucleo":
                field = new Warehouse();
                collectible = new Nucleotid();
                ((Warehouse) field).AddNucleo((Nucleotid) collectible);
                viro.setCurrField(field);
                break;

            case "Gencode":
                field = new Laboratory();
                collectible = new AmnesiaCode(4,5, field);
                ((Laboratory) field).AddGenCode((GenCode) collectible);
                viro.setCurrField(field);
                break;

            default:
                System.err.println("Wrong input!");
                break;
        }


    }
}

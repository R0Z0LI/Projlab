package TestSets;

import Collectible.Collectible;
import Field.*;
import Materials.*;
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
        if (viro.getPropertyHandler().getEquipments().size() != 0)
            System.out.println("Testing has ended. Found equipment in inventory. Nice.");
        else if (viro.getPropertyHandler().getAminoAcids().size() != 0) {
            System.out.println("Testing has ended. Found aminos in inventory, and it's the asked amount. Very Nice.");
        } else if (viro.getPropertyHandler().getNucleotids().size() != 0) {
            System.out.println("Testing has ended. Found nucleos in inventory, and it's the asked amount. Very Nice.");
        } else {
            System.out.println("Testing has ended, but nothing was found!");
        }

        System.out.println("Testing has ended.");
    }

    private void init_test() {

        System.out.println("Init collecting test ...");

        field = new Laboratory();
        viro = new Virologist(field);

        Scanner sc = new Scanner(System.in);

        System.out.print("Mit vennel fel? [kesztyu, kopeny, zsak, Amino, Nucleo, Gencode] ");
        String CollectType = sc.next();
        if(!(CollectType.equals("kesztyu") || CollectType.equals("zsak")  || CollectType.equals("kopeny") || CollectType.equals("Nucleo") || CollectType.equals("Amino") || CollectType.equals("Gencode"))){
            CollectType = "kesztyu";
        }
        switch (CollectType) {

            case "kesztyu":
                field = new Shelter();
                collectible = new Gloves((Shelter) field);
                ((Shelter) field).add((Equipment) collectible);
                viro.setCurrentField(field);
                break;

            case "kopeny":
                collectible = new Cape();
                field = new Shelter();
                ((Shelter) field).add((Equipment) collectible);
                viro.setCurrentField(field);
                break;

            case "zsak":
                collectible = new Sack();
                field = new Shelter();
                ((Shelter) field).add((Equipment) collectible);
                viro.setCurrentField(field);
                break;

            case "Amino":
                collectible = new AminoAcid();
                field = new Warehouse();
                ((Warehouse) field).add((AminoAcid) collectible);
                viro.setCurrentField(field);
                break;

            case "Nucleo":
                field = new Warehouse();
                collectible = new Nucleotid();
                ((Warehouse) field).add((Nucleotid) collectible);
                viro.setCurrentField(field);
                break;

            case "Gencode":
                field = new Laboratory();
                collectible = new AmnesiaCode(4,5, (Laboratory) field);
                ((Laboratory) field).add((GenCode) collectible);
                viro.setCurrentField(field);
                break;

            default:
                System.err.println("Wrong input!");
                break;
        }

        System.out.println("Init has ended.");

    }
}

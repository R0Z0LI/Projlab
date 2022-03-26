package TestSets;

import Collectible.Collectible;
import Field.Laboratory;
import Field.Shelter;
import Field.Warehouse;
import Materials.AminoAcid;
import Materials.Nucleotid;
import PropertyHandler.PropertyHandler;
import behaviors.CollectBehavior;
import equipments.Cape;
import equipments.Gloves;
import equipments.Sack;
import gencode.AmnesiaCode;
import gencode.GenCode;
import virologist.Virologist;

import java.util.Scanner;

public class Collect_TestSet {

    private Virologist virologist;
    Collectible c;


    public Collect_TestSet() {
        init_test();
    }

    public void test() {
        virologist.collect(c);
    }

    private void init_test() {

        PropertyHandler ph = new PropertyHandler();
        Laboratory laboratory = new Laboratory();
        virologist = new Virologist(2, ph, laboratory);
        CollectBehavior collectBehavior = new CollectBehavior(virologist);

        Scanner sc = new Scanner(System.in);


        System.out.print("Mit vennél fel? [kesztyű, köpeny, zsák, Amino, Nucleo] ");
        String CollectType = sc.next();
        switch (CollectType) {

            case "kesztyű":
                Gloves glove = new Gloves();
                Shelter shelter = new Shelter();
                virologist.collect(glove);
                collectBehavior.Collect(glove, ph);
                glove.BeCollected(ph);
                glove.AddBehToStack(virologist);

                ph.AddEquipment(glove);
                shelter.RemoveEquipment(glove);
                break;

            case "köpeny":
                Cape cape = new Cape();
                Shelter shelter1 = new Shelter();

                virologist.collect(cape);
                collectBehavior.Collect(cape, ph);
                cape.BeCollected(ph);
                cape.AddBehToStack(virologist);

                ph.AddEquipment(cape);
                shelter1.RemoveEquipment(cape);
                break;
            case "zsák":
                Sack sack = new Sack();
                Shelter shelter2 = new Shelter();

                virologist.collect(sack);
                collectBehavior.Collect(sack, ph);
                ph.setMax_material(5);      //tfh 5re növeljük 3ról
                sack.BeCollected(ph);
                ph.AddEquipment(sack);

                shelter2.RemoveEquipment(sack);
                break;
            case "Amino":
                Warehouse wh = new Warehouse();
                AminoAcid amino = new AminoAcid();

                virologist.collect(amino);
                collectBehavior.Collect(amino,ph);
                amino.BeCollected(ph);

                ph.AddAmino(amino);
                wh.RemoveAmino(amino);
                break;
            case "Nucleo":
                Warehouse wh2 = new Warehouse();
                Nucleotid nucleo = new Nucleotid();


                virologist.collect(nucleo);
                collectBehavior.Collect(nucleo,ph);
                nucleo.BeCollected(ph);

                ph.AddNucleo(nucleo);
                wh2.RemoveNucleo(nucleo);

                break;

            case "Gencode":
                Laboratory lab = new Laboratory();
                GenCode gencode = new AmnesiaCode(4,5, lab);

                virologist.collect(gencode);
                collectBehavior.Collect(gencode, ph);
                gencode.BeCollected(ph);

                ph.AddGenCode(gencode);





            default:
                System.err.println("Wrong input!");

                break;
        }


    }
}

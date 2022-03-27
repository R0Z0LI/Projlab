package TestSets;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Gencode.*;
import Virologist.Virologist;

import java.util.Scanner;

public class CreateAgent_TestSet {
    private Virologist virologist;
    private Gencode.GenCode genCode;

    // constructor
    public CreateAgent_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {

        virologist.createAgent(genCode);

    }

    // initializing everything we need for this test
    private void init_test() {
        virologist=new Virologist();
        virologist.setCurrentField(new Field());
        System.out.println("Melyik kódból állítson elő ágenst a virológus? védő/felejtő/bénító/vitustánc [v/f/b/t]");
        Scanner sc = new Scanner(System.in);
        String code= sc.next();
        System.out.println("Van elég anyaga az előállításhoz? [i/n]");
        String material = sc.next();
        switch (code){
            case "v":
                genCode=new ProtecionCode();
                break;
            case "f":
                genCode=new AmnesiaCode();
                break;
            case "b":
                genCode=new ParalyseCode();
                break;
            case "t":
                genCode=new CrazyDanceCode();
                break;
            default:
                System.out.println("Nem jó kód, így most felejtő lesz.");
                genCode=new AmnesiaCode();
                break;
        }
        if(material.equals("i")){
            int n= genCode.getNucleo_needed();
            int a= genCode.getAmino_needed();
            for(int i=0; i<a; ++i)
                virologist.getPropertyHandler().addAmino(new AminoAcid());
            for(int i=0; i<n; ++i)
                virologist.getPropertyHandler().addNucleo(new Nucleotid());
        }
    }
}

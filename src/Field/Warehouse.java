package Field;

import Materials.*;

import java.util.ArrayList;

/**
 * A raktárat reprezentáló osztály
 */
public class Warehouse extends Field {
    private static int id = 0;
    private ArrayList<Nucleotid> nucleotids = new ArrayList<>();
    private ArrayList<AminoAcid> aminoAcids = new ArrayList<>();
    private String name;

    public Warehouse(){
        this.name = "who" + id++;
    }
    /**
     * Anyagot pusztít a mezőn.
     */
    @Override
    public void rampage() {
        nucleotids.clear();
        aminoAcids.clear();
        System.out.println("\tA virologist rampaged, and destroyed every material in the warehouse.");
    }

    /**
     * Hozzáadja a praméterként kapott aminósavat a tárolt aminósavakhoz
     *
     * @param aminoAcid Ezt adja hozzá
     */
    public void add(AminoAcid aminoAcid) {
        //System.out.println("-> AddAmino(AminoAcid aminoAcid)\n! Hozzaadja a prameterkent kapott aminosavat a currAmino-hoz\n\n");
        aminoAcids.add(aminoAcid);
        System.out.println("Added a new amino acid to the warehouse.");
    }

    /**
     * Hozzáadja a paraméterként kapott nukletidot a currNucleotid-hez
     *
     * @param nucleotid Ezt adja hozzá
     */
    public void add(Nucleotid nucleotid) {
        //System.out.println("-> AddNucleo(Nucleotid nucleotid)\n! Hozzaadja a prameterkent kapott nukletidot a currNucleotid-hez\n\n");
        nucleotids.add(nucleotid);
        System.out.println("Added a new nucleotid to the warehouse.");
    }

    /**
     * Elveszi a paraméterként kapott aminósavat a currAmino-ból
     *
     * @param aminoAcid Ezt veszi el
     */
    public void remove(AminoAcid aminoAcid) {
        //System.out.println("-> RemoveAmino(AminoAcid aminoAcid)\n! Elveszi a parameterkent kapott aminosavat a currAmino-bol\n\n");
        aminoAcids.remove(aminoAcid);
        System.out.println("Removed an amino acid from the warehouse.");
    }

    /**
     * Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból
     *
     * @param nucleotid Ezt veszi el
     */
    public void remove(Nucleotid nucleotid) {
        //System.out.println("-> RemoveNucleo(Nucleotid nucleotid)\n! Elveszi a parameterkent kapott nukleotidet a currNucleotid-bol\n\n");
        nucleotids.remove(nucleotid);
        System.out.println("Removed a nucleotid from the warehouse.");
    }

    /**
     * currAmino getterje
     *
     * @return Visszaadja a currAmino-t
     */
    public ArrayList<AminoAcid> getAminoAcids() {
        //System.out.println("-> getCurrAmino\n! currAmino getterje\n <- currAmino");
        return aminoAcids;
    }

    /**
     * currNucleotid getterje
     *
     * @return Visszaadja a currNucleotid-et
     */
    public ArrayList<Nucleotid> getNucleotids() {
        //System.out.println("-> getCurrNucletid()\n! currNucleotid getterje\n<- currNucleotid\n\n");
        return nucleotids;
    }
}

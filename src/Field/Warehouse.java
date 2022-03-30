package Field;

import Materials.AminoAcid;
import Materials.Nucleotid;

import java.util.ArrayList;
import java.util.List;

/**
 * A raktárat reprezentáló osztály
 */
public class Warehouse extends Field {
    private List<Nucleotid> nucleotids = new ArrayList<>();
    private List<AminoAcid> aminoAcids = new ArrayList<>();

    /**
     * Hozzáadja a praméterként kapott aminósavat a currAmino-hoz
     *
     * @param aminoAcid Ezt adja hozzá
     */
    public void add(AminoAcid aminoAcid) {
        System.out.println("-> AddAmino(AminoAcid aminoAcid)\n! Hozzáadja a praméterként kapott aminósavat a currAmino-hoz\n\n");
        aminoAcids.add(aminoAcid);
    }

    /**
     * Hozzáadja a paraméterként kapott nukletidot a currNucleotid-hez
     *
     * @param nucleotid Ezt adja hozzá
     */
    public void add(Nucleotid nucleotid) {
        System.out.println("-> AddNucleo(Nucleotid nucleotid)\n! Hozzáadja a praméterként kapott nukletidot a currNucleotid-hez\n\n");
        nucleotids.add(nucleotid);
    }

    /**
     * Elveszi a paraméterként kapott aminósavat a currAmino-ból
     *
     * @param aminoAcid Ezt veszi el
     */
    public void remove(AminoAcid aminoAcid) {
        System.out.println("-> RemoveAmino(AminoAcid aminoAcid)\n! Elveszi a paraméterként kapott aminósavat a currAmino-ból\n\n");
    }

    /**
     * Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból
     *
     * @param nucleotid Ezt veszi el
     */
    public void remove(Nucleotid nucleotid) {
        System.out.println("-> RemoveNucleo(Nucleotid nucleotid)\n! Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból\n\n");
    }

    /**
     * currAmino getterje
     *
     * @return Visszaadja a currAmino-t
     */
    public List<AminoAcid> getAminoAcids() {
        System.out.println("-> getCurrAmino\n! currAmino getterje\n <- currAmino");
        return aminoAcids;
    }

    /**
     * currNucleotid getterje
     *
     * @return Visszaadja a currNucleotid-et
     */
    public List<Nucleotid> getNucleotids() {
        System.out.println("-> getCurrNucletid()\n! currNucleotid getterje\n<- currNucleotid\n\n");
        return nucleotids;
    }
}

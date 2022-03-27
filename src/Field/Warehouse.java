package Field;

import Materials.AminoAcid;
import Materials.Nucleotid;

import java.util.ArrayList;
import java.util.List;

/**
 * A raktárat reprezentáló osztály
 */
public class Warehouse extends Field{
    private List<Nucleotid> currNucleotid = new ArrayList<>();
    private List<AminoAcid> currAmino = new ArrayList<>();

    /**
     * Hozzáadja a praméterként kapott aminósavat a currAmino-hoz
     * @param aminoAcid             Ezt adja hozzá
     */
    public void AddAmino(AminoAcid aminoAcid){
        System.out.println("-> AddAmino(AminoAcid aminoAcid)\n! Hozzáadja a praméterként kapott aminósavat a currAmino-hoz\n\n");
        currAmino.add(aminoAcid);
    }

    /**
     * Hozzáadja a praméterként kapott nukletidot a currNucleotid-hez
     * @param nucleotid             Ezt adja hozzá
     */
    public void AddNucleo(Nucleotid nucleotid){
        System.out.println("-> AddNucleo(Nucleotid nucleotid)\n! Hozzáadja a praméterként kapott nukletidot a currNucleotid-hez\n\n");
        currNucleotid.add(nucleotid);
    }

    /**
     * Elveszi a paraméterként kapott aminósavat a currAmino-ból
     * @param aminoAcid             Ezt veszi el
     */
    public void RemoveAmino(AminoAcid aminoAcid){
        System.out.println("-> RemoveAmino(AminoAcid aminoAcid)\n! Elveszi a paraméterként kapott aminósavat a currAmino-ból\n\n");
    }

    /**
     * Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból
     * @param nucleotid             Ezt veszi el
     */
    public void RemoveNucleo(Nucleotid nucleotid){
        System.out.println("-> RemoveNucleo(Nucleotid nucleotid)\n! Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból\n\n");
    }

    /**
     * currAmino getterje
     * @return                      Visszaadja a currAmino-t
     */
    public List<AminoAcid> getCurrAmino(){
        System.out.println("-> getCurrAmino\n! currAmino getterje\n <- currAmino");
        return currAmino;
    }

    /**
     * currNucleotid getterje
     * @return                      Visszaadja a currNucleotid-et
     */
    public List<Nucleotid> getCurrNucletid(){
        System.out.println("-> getCurrNucletid()\n! currNucleotid getterje\n<- currNucleotid\n\n");
        return currNucleotid;
    }
}

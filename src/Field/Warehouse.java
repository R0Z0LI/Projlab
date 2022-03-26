package Field;

import Materials.AminoAcid;
import Materials.Nucleotid;

import java.util.List;

/**
 * A raktárat reprezentáló osztály
 */
public class Warehouse extends Field{
    private List<Nucleotid> currNucleotid;
    private List<AminoAcid> currAmino;

    /**
     * Hozzáadja a praméterként kapott aminósavat a currAmino-hoz
     * @param aminoAcid             Ezt adja hozzá
     */
    public void AddAmino(AminoAcid aminoAcid){

    }

    /**
     * Hozzáadja a praméterként kapott nukletidot a currNucleotid-hez
     * @param nucleotid             Ezt adja hozzá
     */
    public void AddNucleo(Nucleotid nucleotid){

    }

    /**
     * Elveszi a paraméterként kapott aminósavat a currAmino-ból
     * @param aminoAcid             Ezt veszi el
     */
    public void RemoveAmino(AminoAcid aminoAcid){

    }

    /**
     * Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból
     * @param nucleotid             Ezt veszi el
     */
    public void RemoveNucleo(Nucleotid nucleotid){

    }

    /**
     * currAmino getterje
     * @return                      Visszaadja a currAmino-t
     */
    public List<AminoAcid> getCurrAmino(){
        return currAmino;
    }

    /**
     * currNucleotid getterje
     * @return                      Visszaadja a currNucleotid-et
     */
    public List<Nucleotid> getCurrNucletid(){
        return currNucletid;
    }
}

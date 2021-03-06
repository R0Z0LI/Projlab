package Field;

import Collectible.Collectible;
import Gencode.GenCode;
import Graphics.FieldView;
import Materials.*;
import Virologist.Virologist;

import java.util.ArrayList;

/**
 * A raktárat reprezentáló osztály
 */
public class Warehouse extends Field {
    private static int id = 0;
    private ArrayList<Nucleotid> nucleotids = new ArrayList<>();
    private ArrayList<AminoAcid> aminoAcids = new ArrayList<>();

    /**
     * Warehouse constructor
     */
    public Warehouse(){
        super(0);
        this.name = "who" + id++;
        fields.add(this);
    }

    /**
     * Anyagot pusztít a mezőn.
     */
    @Override
    public void rampage() {
        nucleotids.clear();
        aminoAcids.clear();
    }

    /**
     * Hozzáadja a praméterként kapott aminósavat a tárolt aminósavakhoz
     *
     * @param aminoAcid Ezt adja hozzá
     */
    public void add(AminoAcid aminoAcid) {
        aminoAcids.add(aminoAcid);
    }

    /**
     * Hozzáadja a paraméterként kapott nukletidot a currNucleotid-hez
     *
     * @param nucleotid Ezt adja hozzá
     */
    public void add(Nucleotid nucleotid) {
        nucleotids.add(nucleotid);
    }

    /**
     * Elveszi a paraméterként kapott aminósavat a currAmino-ból
     *
     * @param aminoAcid Ezt veszi el
     */
    public void remove(AminoAcid aminoAcid) {
        aminoAcids.remove(aminoAcid);
    }

    /**
     * Elveszi a paraméterként kapott nukleotidet a currNucleotid-ból
     *
     * @param nucleotid Ezt veszi el
     */
    public void remove(Nucleotid nucleotid) {
        nucleotids.remove(nucleotid);
    }

    /**
     * Get the collectibles from this field
     * @return
     */
    public Collectible getCollectible() {
        if (!aminoAcids.isEmpty())
            return aminoAcids.get(0);
        else if (!nucleotids.isEmpty())
            return nucleotids.get(0);
        return null;
    }

    /**
     * currAmino getterje
     *
     * @return Visszaadja a currAmino-t
     */
    public ArrayList<AminoAcid> getAminoAcids() {
        return aminoAcids;
    }

    /**
     * currNucleotid getterje
     *
     * @return Visszaadja a currNucleotid-et
     */
    public ArrayList<Nucleotid> getNucleotids() {
        return nucleotids;
    }
    public String toString() {
        String name = this.name;
        String neighbours = "";
        for (Field neighbour : this.neighbours) {
            neighbours += neighbour.name + " ";
        }
        if(neighbours.equals(""))
            neighbours="0";
        String viros= "";
        for(Virologist v : virologists)
            viros+=v.toString()+" ";
        if(viros.equals(""))
            viros="0";
        String things = "";
        for(AminoAcid a: aminoAcids)
            things+=a.getName()+" ";
        for(Nucleotid n: nucleotids)
            things+=n.getName()+" ";
        if(things.equals(""))
            things="0";
        return name + "\n" + neighbours+"\n"+things + "\n"+ viros+"\n"+name+"\n";
    }
}

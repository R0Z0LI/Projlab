package Field;

import Materials.AminoAcid;
import Materials.Nucleotid;

import java.util.List;

public class Warehouse extends Field{
    private List<Nucleotid> currNucletid;
    private List<AminoAcid> currAmino;

    public void AddAmino(AminoAcid aminoAcid){

    }

    public void AddNucleo(Nucleotid nucleotid){

    }

    public void RemoveAmino(AminoAcid aminoAcid){

    }

    public void RemoveNucleo(Nucleotid nucleotid){

    }

    public List<AminoAcid> getCurrAmino(){
        return currAmino;
    }

    public List<Nucleotid> getCurrNucletid(){
        return currNucletid;
    }
}

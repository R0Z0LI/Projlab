package gencode;

import Collectible.Collectible;
import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import agent.Agent;

import java.util.UUID;

public abstract class GenCode implements Collectible {

    private int amino_needed;
    private int nucleo_needed;
    private String uid;
    private Field currPosition;
    private AminoAcid[] aminoBill;
    private Nucleotid[] nucleoBill;

    public GenCode(int aminoneeded, int nucleoneeded, Field field){
        amino_needed=aminoneeded;
        nucleo_needed=nucleoneeded;
        currPosition=field;
        aminoBill=new AminoAcid[amino_needed];
        nucleoBill=new Nucleotid[nucleo_needed];
        uid= UUID.randomUUID().toString();
    }

    public int getAmino_needed(){
        return amino_needed;
    }

    public int getNucleo_needed() {
        return nucleo_needed;
    }

    public Field getCurrPosition(){
        return currPosition;
    }

    public String getUid(){
        return uid;
    }

    public abstract Agent RevealAgent();

    public abstract boolean PayAminoBill(AminoAcid pa);

    public abstract boolean PayNucleoBill(Nucleotid pn);

}

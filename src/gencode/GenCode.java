package gencode;

import Collectible.Collectible;
import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import agent.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**+
 * Gentikai kódot reprezentáló osztály.
 */
public abstract class GenCode implements Collectible {

    private int amino_needed;
    private int nucleo_needed;
    private String uid;
    private Field currPosition;
    private List<AminoAcid> aminoBill;
    private List<Nucleotid> nucleoBill;

    public GenCode(int aminoneeded, int nucleoneeded, Field field){
        amino_needed = aminoneeded;
        nucleo_needed = nucleoneeded;
        currPosition = field;
        aminoBill = new ArrayList<>();
        nucleoBill = new ArrayList<>();
        uid = UUID.randomUUID().toString();
    }

    public GenCode() {

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

    public List<AminoAcid> getAminoBill() {
        return aminoBill;
    }

    public List<Nucleotid> getNucleoBill() {
        return nucleoBill;
    }

    public String getUid(){
        return uid;
    }

    /**+
     * Létrehozza a belőle készíthető ágenst.
     *
     * @return Agent    a létrehozott ágens
     */
    public abstract Agent revealAgent();





}

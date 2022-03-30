package Gencode;

import Collectible.Collectible;
import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import Agent.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * +
 * Gentikai kódot reprezentáló osztály.
 */
public abstract class GenCode implements Collectible {

    private int aminoNeeded;
    private int nucleoNeeded;
    //TODO lehet-e .equals függvénnyel helyyesttesíteni?
    private String uid;
    private Field currentPosition;
    private List<AminoAcid> aminoBill;
    private List<Nucleotid> nucleoBill;

    public GenCode(int aminoNeeded, int nucleoNeeded, Field field) {
        this.aminoNeeded = aminoNeeded;
        this.nucleoNeeded = nucleoNeeded;
        currentPosition = field;
        aminoBill = new ArrayList<>();
        nucleoBill = new ArrayList<>();
        uid = UUID.randomUUID().toString();
    }

    public GenCode(int aminoneeded, int nucleoneeded) {
        aminoNeeded = aminoneeded;
        nucleoNeeded = nucleoneeded;
    }


    public void setField(Field lab) {
        currentPosition = lab;
    }

    public int getAminoNeeded() {
        return aminoNeeded;
    }

    public int getNucleoNeeded() {
        return nucleoNeeded;
    }

    public Field getCurrentPosition() {
        return currentPosition;
    }

    public List<AminoAcid> getAminoBill() {
        return aminoBill;
    }

    public List<Nucleotid> getNucleoBill() {
        return nucleoBill;
    }

    public String getUid() {
        return uid;
    }

    /**
     * +
     * Létrehozza a belőle készíthető ágenst.
     *
     * @return Agent    a létrehozott ágens
     */
    public abstract Agent revealAgent();

}

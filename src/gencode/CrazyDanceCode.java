package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import agent.Agent;
import agent.AmnesiaAgent;
import agent.CrazyDanceAgent;

public class CrazyDanceCode extends GenCode{
    public CrazyDanceCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    @Override
    public Agent RevealAgent() {
        CrazyDanceAgent cda=new CrazyDanceAgent(30);
        return cda;
    }

    @Override
    public boolean PayAminoBill(AminoAcid pa) {
        return false;
        //????????????
    }

    @Override
    public boolean PayNucleoBill(Nucleotid pn) {
        return false;
        //????????????
    }

}

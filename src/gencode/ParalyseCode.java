package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import agent.Agent;
import agent.ParalyseAgent;

public class ParalyseCode extends GenCode{
    public ParalyseCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    @Override
    public Agent RevealAgent() {
        ParalyseAgent pa=new ParalyseAgent(30);
        return pa;
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

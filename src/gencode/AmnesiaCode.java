package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import agent.Agent;
import agent.AmnesiaAgent;

public class AmnesiaCode extends GenCode{
    public AmnesiaCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    @Override
    public Agent RevealAgent() {
        AmnesiaAgent ae=new AmnesiaAgent(30);
        return ae;
    }


    @Override
    public boolean PayAminoBill(AminoAcid pa) {
       //????????????
        return false;
    }

    @Override
    public boolean PayNucleoBill(Nucleotid pn) {
        //????????????
        return false;
    }

}

package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import agent.Agent;
import agent.ParalyseAgent;
import agent.ProtectionAgent;

public class ProtecionCode extends GenCode{
    public ProtecionCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    @Override
    public Agent RevealAgent() {
        ProtectionAgent pa=new ProtectionAgent(30);
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

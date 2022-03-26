package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import PropertyHandler.PropertyHandler;
import agent.Agent;
import agent.ParalyseAgent;
import agent.ProtectionAgent;

import java.util.List;

public class ProtecionCode extends GenCode{
    public ProtecionCode(int aminoneeded, int nucleoneeded, Field field) {
        super(aminoneeded, nucleoneeded, field);
    }

    public ProtecionCode() {
        super();
    }

    @Override
    public Agent RevealAgent() {
        ProtectionAgent pa=new ProtectionAgent(30);
        return pa;
    }


    @Override
    public void BeCollected(PropertyHandler propertyHandler) {

    }

    @Override
    public void BeRemoved(PropertyHandler propertyHandler) {

    }
}

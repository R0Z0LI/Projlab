package gencode;

import Field.Field;
import Materials.AminoAcid;
import Materials.Nucleotid;
import PropertyHandler.PropertyHandler;
import agent.Agent;
import agent.AmnesiaAgent;
import agent.CrazyDanceAgent;

import java.util.List;

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
    public void BeCollected(PropertyHandler propertyHandler) {

    }

    @Override
    public void BeRemoved(PropertyHandler propertyHandler) {

    }
}

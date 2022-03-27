package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.CrazyDanceAgent;

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

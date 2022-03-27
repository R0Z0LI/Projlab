package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.AmnesiaAgent;

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
    public void BeCollected(PropertyHandler propertyHandler) {

    }

    @Override
    public void BeRemoved(PropertyHandler propertyHandler) {

    }
}

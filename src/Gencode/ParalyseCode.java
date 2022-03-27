package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.ParalyseAgent;

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
    public void BeCollected(PropertyHandler propertyHandler) {

    }

    @Override
    public void BeRemoved(PropertyHandler propertyHandler) {

    }
}

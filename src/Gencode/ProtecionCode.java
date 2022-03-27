package Gencode;

import Field.Field;
import PropertyHandler.PropertyHandler;
import Agent.Agent;
import Agent.ProtectionAgent;

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

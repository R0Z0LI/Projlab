package TestSets;

import PropertyHandler.PropertyHandler;
import agent.*;
import behaviors.*;
import equipments.Cape;
import equipments.Equipment;
import equipments.Gloves;
import virologist.Virologist;
import Field.Field;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ApplyAgent_TestSet {

    private List<Agent> usedAgent;
    private Virologist applyingViro;
    private Virologist affectedViro;

    // constructor
    public ApplyAgent_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {
        applyingViro.ApplyAgent(usedAgent.get(0), affectedViro);
    }

    // initializing everything we need for this test
    private void init_test() {

        Field field = new Field();

        // setting up applying virologist
        applyingViro = new Virologist();
        applyingViro.setApplyBeh(new ApplyBehavior(applyingViro));
        applyingViro.setCurrField(field);

        Scanner sc = new Scanner(System.in);

        // setting up the applied agent
        System.out.print("Melyik ágenst használja? [v/f/b/t] ");
        String agentType = sc.next();
        switch (agentType) {
            case "v":
                usedAgent.add(new ProtectionAgent(30));
                break;
            case "f":
                usedAgent.add(new AmnesiaAgent(30));
                break;
            case "b":
                usedAgent.add(new ParalyseAgent(30));
                break;
            case "t":
                usedAgent.add(new CrazyDanceAgent(30));
                break;
            default:
                System.err.println("You used a wrong Agent type! WE are gonna choose CrazyAgent for you!");
                usedAgent.add(new CrazyDanceAgent(30));
        }
        applyingViro.getPropertyHandler().setAgents(usedAgent);

        System.out.print("Egy másik virológusra kenje? [i/n] ");
        if (sc.next() == "i") {
            // setting up affected virologist
            affectedViro = new Virologist();
            affectedViro.setDefenseBeh(new DefenseBehavior(affectedViro));
            affectedViro.setCurrField(field);

            // setting up defenses for both virologists

            System.out.print("Van kesztyűje a másik virológusnak? [i/n] ");
            if (sc.next() == "i") {
                affectedViro.getPropertyHandler().setEquipments((List<Equipment>) new Gloves());
                affectedViro.setDefenseBeh(new GloveDefBehavior(affectedViro));

                System.out.print("Van kesztyűje a támadó virológusnak? [i/n] ");
                if (sc.next() == "i") {
                    applyingViro.getPropertyHandler().setEquipments((List<Equipment>) new Gloves());
                    applyingViro.setDefenseBeh(new GloveDefBehavior(applyingViro));
                }
            }

            System.out.print("Hat védő ágens  a másik virológusra? [i/n] ");
            if (sc.next() == "i") {
                affectedViro.getPropertyHandler().setAgents((List<Agent>) new ProtectionAgent(30));
                affectedViro.setDefenseBeh(new DefAgentDefBehavior(affectedViro));
            }

            System.out.print("Van védőköpenye  a másik virológusnak? [i/n] ");
            if (sc.next() == "i") {
                affectedViro.getPropertyHandler().setEquipments((List<Equipment>) new Cape());
                affectedViro.setDefenseBeh(new CapeDefBehavior(affectedViro));
            }

        } else {
            // if we are applying it on ourselves
            affectedViro = applyingViro;
        }
    }

}

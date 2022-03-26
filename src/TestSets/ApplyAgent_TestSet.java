package TestSets;

import agent.*;
import behaviors.*;
import equipments.Cape;
import equipments.Gloves;
import gencode.ProtecionCode;
import virologist.Virologist;
import Field.Field;

import java.io.IOException;
import java.util.Scanner;

public class ApplyAgent_TestSet {

    private Agent usedAgent;
    private Virologist applyingViro;
    private Virologist affectedViro;

    // constructor
    public ApplyAgent_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {
        applyingViro.ApplyAgent(usedAgent, affectedViro);
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
                usedAgent = new ProtectionAgent();
                break;
            case "f":
                usedAgent = new AmnesiaAgent();
                break;
            case "b":
                usedAgent = new ParalyseAgent();
                break;
            case "t":
                usedAgent = new CrazyDanceAgent();
                break;
            default:
                System.err.println("You used a wrong Agent type! WE are gonna choose CrazyAgent for you!");
                usedAgent = new CrazyDanceAgent();
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
                affectedViro.getPropertyHandler().AddEquipment(new Gloves());
                affectedViro.setDefenseBeh(new GloveDefBehavior(affectedViro));

                System.out.print("Van kesztyűje a támadó virológusnak? [i/n] ");
                if (sc.next() == "i") {
                    applyingViro.getPropertyHandler().AddEquipment(new Gloves());
                    applyingViro.setDefenseBeh(new GloveDefBehavior(applyingViro));
                }
            }

            System.out.print("Hat védő ágens a másik virológusra? [i/n] ");
            if (sc.next() == "i") {
                affectedViro.getPropertyHandler().MakeAgent(new ProtecionCode());
                affectedViro.setDefenseBeh(new DefAgentDefBehavior(affectedViro));
            }

            System.out.print("Van védőköpenye a másik virológusnak? [i/n] ");
            if (sc.next() == "i") {
                affectedViro.getPropertyHandler().AddEquipment(new Cape());
                affectedViro.setDefenseBeh(new CapeDefBehavior(affectedViro));
            }

        } else {
            // if we are applying it on ourselves
            affectedViro = applyingViro;
        }

    }

}

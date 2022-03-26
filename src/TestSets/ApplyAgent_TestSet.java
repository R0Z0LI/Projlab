package TestSets;

import PropertyHandler.PropertyHandler;
import agent.*;
import behaviors.*;
import equipments.Cape;
import equipments.Gloves;
import virologist.Virologist;
import Field.Field;

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
        applyingViro.applyAgent(usedAgent, affectedViro);
    }

    // initializing everything we need for this test
    private void init_test() {

        Field field = new Field();

        // setting up applying virologist
        PropertyHandler ph1 = new PropertyHandler(3, 10, 10, applyingViro);
        applyingViro = new Virologist(2, ph1, null);
        applyingViro.setApplyBehaviors(new ApplyBehavior(applyingViro));
        applyingViro.setCurrField(field);

        Scanner sc = new Scanner(System.in);

        // setting up the applied agent
        System.out.print("Melyik ágenst használja? [v/f/b/t] ");
        String agentType = sc.next();
        switch (agentType) {
            case "v":
                usedAgent = new ProtectionAgent(30);
                break;
            case "f":
                usedAgent = new AmnesiaAgent(30);
                break;
            case "b":
                usedAgent = new ParalyseAgent(30);
                break;
            case "t":
                usedAgent = new CrazyDanceAgent(30);
                break;
            default:
                System.err.println("You used a wrong Agent type! WE are gonna choose CrazyAgent for you!");
                usedAgent = new CrazyDanceAgent(30);
        }


        System.out.print("Egy másik virológusra kenje? [i/n] ");
        if (sc.next().equals("i")) {
            // setting up affected virologist
            PropertyHandler ph2 = new PropertyHandler(3, 10, 10, affectedViro);
            affectedViro = new Virologist(2, ph2, null);
            affectedViro.setDefenseBehaviors(new DefenseBehavior(affectedViro));
            affectedViro.setCurrField(field);

            // setting up defenses for both virologists

            System.out.print("Van kesztyűje a másik virológusnak? [i/n] ");
            if (sc.next().equals("i")) {
                affectedViro.getPropertyHandler().AddEquipment(new Gloves());
                affectedViro.setDefenseBehaviors(new GloveDefBehavior(affectedViro));

                System.out.print("Van kesztyűje a támadó virológusnak? [i/n] ");
                if (sc.next().equals("i")) {
                    applyingViro.getPropertyHandler().AddEquipment(new Gloves());
                    applyingViro.setDefenseBehaviors(new GloveDefBehavior(applyingViro));
                }
            }

            System.out.print("Hat védő ágens  a másik virológusra? [i/n] ");
            if (sc.next().equals("i")) {
                affectedViro.getPropertyHandler().AddAgent(new ProtectionAgent(30));
                affectedViro.setDefenseBehaviors(new DefAgentDefBehavior(affectedViro));
            }

            System.out.print("Van védőköpenye  a másik virológusnak? [i/n] ");
            if (sc.next().equals("i")) {
                affectedViro.getPropertyHandler().AddEquipment(new Cape());
                affectedViro.setDefenseBehaviors(new CapeDefBehavior(affectedViro));
            }

        } else {
            // if we are applying it on ourselves
            affectedViro = applyingViro;
        }
    }

}

package TestSets;

import Agent.*;
import Behaviors.*;
import Equipments.Cape;
import Equipments.Gloves;
import Virologist.Virologist;
import Field.Field;

import java.util.Scanner;

import static java.awt.Color.BLUE;

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
        applyingViro = new Virologist();
        applyingViro.setCurrentField(field);

        Scanner sc = new Scanner(System.in);

        // setting up the applied agent
        System.out.print("Melyik ágenst használja? védő/felejtő/bénító/vitustánc [v/f/b/t] ");
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
        if (sc.next().equals( "i")) {
            // setting up affected virologist
            affectedViro = new Virologist();
            affectedViro.setCurrentField(field);

            // setting up defenses for both virologists

            System.out.print("Van kesztyűje a másik virológusnak? [i/n] ");
            if (sc.next().equals("i")) {
                affectedViro.getPropertyHandler().addEquipment(new Gloves());
                //affectedViro.setDefenseBehaviors(new GloveDefBehavior(affectedViro));
                affectedViro.addDefenseBehavior(new GloveDefBehavior(affectedViro));

                System.out.print("Van kesztyűje a támadó virológusnak? [i/n] ");
                if (sc.next().equals("i")) {
                    applyingViro.getPropertyHandler().addEquipment(new Gloves());
                    //applyingViro.setDefenseBehaviors(new GloveDefBehavior(applyingViro));
                    applyingViro.addDefenseBehavior(new GloveDefBehavior(applyingViro));
                }
            }

            System.out.print("Hat védő ágens  a másik virológusra? [i/n] ");
            if (sc.next().equals("i")) {
                affectedViro.getPropertyHandler().addAgent(new ProtectionAgent(30));
                //affectedViro.setDefenseBehaviors(new DefAgentDefBehavior(affectedViro));
                affectedViro.addDefenseBehavior(new DefAgentDefBehavior(affectedViro));
            }

            System.out.print("Van védőköpenye  a másik virológusnak? [i/n] ");
            if (sc.next().equals("i")) {
                affectedViro.getPropertyHandler().addEquipment(new Cape());
                //affectedViro.setDefenseBehaviors(new CapeDefBehavior(affectedViro));
                affectedViro.addDefenseBehavior(new CapeDefBehavior(affectedViro));
            }

        } else {
            // if we are applying it on ourselves
            affectedViro = applyingViro;
        }
    }

}

package TestSets;

import Steppable.Agent;
import behaviors.*;
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

        try {
            Scanner sc = new Scanner(System.in);

            // setting up the applied agent
            System.out.print("Melyik ágenst használja? [v/f/b/t] ");
            String agentType = sc.next();
            switch (agentType) {
                case "v":
                    usedAgent = new DefAgent();
                    break;
                case "f":
                    usedAgent = new AmnesiaAgent();
                    break;
                case "b":
                    usedAgent = new ParalysesAgent();
                    break;
                case "t":
                    usedAgent = new CrazyMoveAgent();
                    break;
                default:
                    System.err.println("You used a wrong Agent type! WE are gonna choose CrazyAgent for you!");
                    usedAgent = new CrazyMoveAgent();
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
                    affectedViro.getPropertyHandler().setEquipments(new Gloves());
                    affectedViro.setDefenseBeh(new GloveDefBehavior(affectedViro));

                    System.out.print("Van kesztyűje a támadó virológusnak? [i/n] ");
                    if (sc.next() == "i") {
                        applyingViro.getPropertyHandler().setEquipments(new Gloves());
                        applyingViro.setDefenseBeh(new GloveDefBehavior(applyingViro));
                    }
                }

                System.out.print("Hat védő ágens  a másik virológusra? [i/n] ");
                if (sc.next() == "i") {
                    affectedViro.getPropertyHandler().setEquipments(new DefAgent());
                    affectedViro.setDefenseBeh(new DefAgentDefBehavior(affectedViro));
                }

                System.out.print("Van védőköpenye  a másik virológusnak? [i/n] ");
                if (sc.next() == "i") {
                    affectedViro.getPropertyHandler().setEquipments(new Cape());
                    affectedViro.setDefenseBeh(new CapeDefBehavior(affectedViro));
                }

            } else {
                // if we are applying it on ourselves
                affectedViro = applyingViro;
            }

        } catch (IOException e){
            System.err.println("ERROR: couldn't read");
        }

    }

}

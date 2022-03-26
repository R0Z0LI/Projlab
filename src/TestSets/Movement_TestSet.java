package TestSets;

import agent.*;
import behaviors.*;
import virologist.Virologist;
import Field.Field;
import java.util.ArrayList;
import java.util.Random;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Movement_TestSet {

    private Agent usedAgent;
    private Virologist applyingViro;
    private Virologist affectedViro;

    // constructor
    public Movement_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {

    }

    // initializing everything we need for this test
    private void init_test() {

        Virologist virologist = new Virologist();
        Field jelenlegi = new Field();
        MovementBehavior movementBehavior = new MovementBehavior(virologist);
        ArrayList neighbours = jelenlegi.getNeighbours();
        Field cél = (Field)neighbours.get(0);

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Melyik mozgást teszteljük? Sima / Crazy / Stunned");
            String MovementType = sc.next();
            switch (MovementType) {
                case "Sima":
                    movementBehavior.Move(jelenlegi, cél);

                    virologist.setCurrField(cél);
                    jelenlegi.RemoveVirologist(virologist);
                    cél.AddVirologist(virologist);
                    break;

                case "Crazy":
                    CrazyMoveBehavior crazyMoveBehavior= new CrazyMoveBehavior();
                    crazyMoveBehavior.Move(jelenlegi, cél);

                    virologist.setCurrField(cél);
                    jelenlegi.RemoveVirologist(virologist);
                    cél.AddVirologist(virologist);
                    break;

                case "Stunned":
                    StunnedMoveBehavior stunnedMoveBehavior = new StunnedMoveBehavior();
                    stunnedMoveBehavior.Move(jelenlegi, cél);
                    break;

                default:
                    System.err.println("Wrong input! We choose Sima 4 u");
                    MovementType = "Sima";
                    break;

        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
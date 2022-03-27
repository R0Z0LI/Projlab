package TestSets;

import Field.Field;
import Behaviors.CrazyMoveBehavior;
import Behaviors.MovementBehavior;
import Behaviors.StunnedMoveBehavior;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.Scanner;

public class Movement_TestSet {

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

        ArrayList<Field> neighbours = jelenlegi.getNeighbours();

        Field cel = new Field();
        jelenlegi.addNeighbour(cel);
        cel = neighbours.get(0);

        MovementBehavior movementBehavior = new MovementBehavior(virologist);

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Melyik mozgást teszteljük? Sima / Crazy / Stunned");
            String MovementType = sc.next();
            switch (MovementType) {
                case "Sima":

                    movementBehavior.move(jelenlegi, cel);

                    virologist.setCurrField(cel);
                    jelenlegi.RemoveVirologist(virologist);
                    cel.addVirologist(virologist);
                    break;

                case "Crazy":
                    CrazyMoveBehavior crazyMoveBehavior= new CrazyMoveBehavior();
                    crazyMoveBehavior.move(jelenlegi, cel);

                    virologist.addCrazyMoveBeh(crazyMoveBehavior);
                    virologist.setCurrField(cel);
                    jelenlegi.RemoveVirologist(virologist);
                    cel.addVirologist(virologist);
                    break;

                case "Stunned":
                    StunnedMoveBehavior stunnedMoveBehavior = new StunnedMoveBehavior();
                    virologist.addMoveBeh(stunnedMoveBehavior);
                    stunnedMoveBehavior.move(jelenlegi, cel);
                    break;

                default:
                    System.err.println("Wrong input!");
                    break;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
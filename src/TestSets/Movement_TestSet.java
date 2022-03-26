package TestSets;

import Field.Field;
import behaviors.CrazyMoveBehavior;
import behaviors.MovementBehavior;
import behaviors.StunnedMoveBehavior;
import virologist.Virologist;

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

        MovementBehavior movementBehavior = new MovementBehavior(virologist);
        ArrayList<Field> neighbours = jelenlegi.getNeighbours();
        Field cel = neighbours.get(0);

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Melyik mozgást teszteljük? Sima / Crazy / Stunned");
            String MovementType = sc.next();
            switch (MovementType) {
                case "Sima":

                    movementBehavior.Move(jelenlegi, cel);

                    virologist.setCurrField(cel);
                    jelenlegi.RemoveVirologist(virologist);
                    cel.addVirologist(virologist);
                    break;

                case "Crazy":
                    CrazyMoveBehavior crazyMoveBehavior= new CrazyMoveBehavior();
                    crazyMoveBehavior.Move(jelenlegi, cel);

                    virologist.AddCrazyMoveBeh(crazyMoveBehavior);
                    virologist.setCurrField(cel);
                    jelenlegi.RemoveVirologist(virologist);
                    cel.addVirologist(virologist);
                    break;

                case "Stunned":
                    StunnedMoveBehavior stunnedMoveBehavior = new StunnedMoveBehavior();
                    virologist.AddMoveBeh(stunnedMoveBehavior);
                    stunnedMoveBehavior.Move(jelenlegi, cel);
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
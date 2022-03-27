package TestSets;

import Field.Field;
import Field.Laboratory;
import Field.Shelter;
import Behaviors.CrazyMoveBehavior;
import Behaviors.MovementBehavior;
import Behaviors.StunnedMoveBehavior;
import PropertyHandler.PropertyHandler;
import Virologist.Virologist;

import java.util.ArrayList;
import java.util.Scanner;

public class Movement_TestSet {
    private Virologist virologist;
    // constructor
    public Movement_TestSet() {
        init_test();
    }

    // testing use case
    public void test() {

    }

    // initializing everything we need for this test
    private void init_test() {
        PropertyHandler ph = new PropertyHandler(3, 10, 10, virologist);

        Laboratory jelenlegi = new Laboratory();
        Shelter cel = new Shelter();
        Shelter crazy = new Shelter();
        virologist = new Virologist(2, ph, jelenlegi);
        jelenlegi.addNeighbour(cel);
        jelenlegi.addNeighbour(crazy);
        MovementBehavior movementBehavior = new MovementBehavior(virologist);

        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Melyik mozgást teszteljük? Sima / Crazy / Stunned");
            String MovementType = sc.next();
            switch (MovementType) {
                case "Sima":

                    movementBehavior.move(jelenlegi, cel);

                    virologist.setCurrentField(cel);
                    jelenlegi.RemoveVirologist(virologist);
                    cel.addVirologist(virologist);
                    break;

                case "Crazy":
                    CrazyMoveBehavior crazyMoveBehavior= new CrazyMoveBehavior(virologist);
                    crazyMoveBehavior.move(jelenlegi, cel);

                    virologist.addMoveBehavior(crazyMoveBehavior);
                    virologist.setCurrentField(crazy);
                    jelenlegi.RemoveVirologist(virologist);
                    crazy.addVirologist(virologist);
                    break;

                case "Stunned":
                    StunnedMoveBehavior stunnedMoveBehavior = new StunnedMoveBehavior();
                    virologist.addMoveBehavior(stunnedMoveBehavior);
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
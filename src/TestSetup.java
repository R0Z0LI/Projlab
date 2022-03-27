import TestSets.*;

import java.util.Scanner;

public class TestSetup {

    public static void main(String[] args) {
        String cyan="\u001B[36m";
        boolean run = true;
        while (run) {
            Scanner sc = new Scanner(System.in);
            System.out.println(cyan+"Mit szeretnél tesztelni? Válassz egy számot:");
            System.out.println("1. Move Virologist");
            System.out.println("2. Collect");
            System.out.println("3. Create Agent");
            System.out.println("4. Apply Agent");
            System.out.println("5. Steal");
            System.out.println("6. Throw equipment");
            System.out.println("7. Step Agent");
            System.out.println("If you want to stop testing, then write anything.");

            switch (sc.next()) {
                case "1":
                    Movement_TestSet test1 = new Movement_TestSet();
                    test1.test();
                    break;
                case "2":
                    Collect_TestSet test2 = new Collect_TestSet();
                    test2.test();
                    break;
                case "3":
                    CreateAgent_TestSet test3 =new CreateAgent_TestSet();
                    test3.test();
                    break;
                case "4":
                    ApplyAgent_TestSet test6 = new ApplyAgent_TestSet();
                    test6.test();
                    break;
                case "5":
                    Steal_TestSet test5 = new Steal_TestSet();
                    test5.test();
                    break;
                case "6":
                    ThrowEquipment_TestSet test8 = new ThrowEquipment_TestSet();
                    test8.test();
                    break;
                case "7":
                    StepAgent_TestSet test7 = new StepAgent_TestSet();
                    test7.test();
                    break;
                default:
                    run = false;
            }
        }
    }
}

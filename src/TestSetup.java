import TestSets.*;

import java.util.Scanner;

public class TestSetup {

   public static void main(String[] args) {
        String cyan="\u001B[36m";
        boolean run = true;
        while (run) {
            Scanner sc = new Scanner(System.in);
            System.out.println(cyan+"Mit szeretnel tesztelni? Valassz egy szamot:");
            System.out.println("1. Move Virologist");
            System.out.println("2. Collect");
            System.out.println("3. Create Agent");
            System.out.println("4. Apply Agent");
            System.out.println("5. Steal");
            System.out.println("6. Throw equipment");
            System.out.println("7. Step Agent");
            System.out.println("8. Kill Virologist");
            System.out.println("9. Komplex1");
            System.out.println("10. Komplex2");
            System.out.println("If you want to stop testing, then write anything.");

            switch (sc.next()) {
                case "1":   // move test
                    Movement_TestSet test1 = new Movement_TestSet();
                    test1.test();
                    break;
                case "2":   // collect test
                    Collect_TestSet test2 = new Collect_TestSet();
                    test2.test();
                    break;
                case "3":   // create test
                    CreateAgent_TestSet test3 =new CreateAgent_TestSet();
                    test3.test();
                    break;
                case "4":   // apply test
                    ApplyAgent_TestSet test4 = new ApplyAgent_TestSet();
                    test4.test();
                    break;
                case "5":   // steal test
                    Steal_TestSet test5 = new Steal_TestSet();
                    test5.test();
                    break;
                case "6":   // throw test
                    ThrowEquipment_TestSet test6 = new ThrowEquipment_TestSet();
                    test6.test();
                    break;
                case "7":   //
                    StepAgent_TestSet test7 = new StepAgent_TestSet();
                    test7.test();
                    break;
                    case "8":
                    Kill_TestSet test8 = new Kill_TestSet();
                    test8.test();
                    break;
                default:
                    run = false;
            }
        }
    }
}

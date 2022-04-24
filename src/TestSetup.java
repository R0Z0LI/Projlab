import Game.*;
import TestSets.TestInOutHandler;

import java.util.Scanner;

public class TestSetup {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Mit szeretnel tesztelni? Valassz egy szamot:");
        System.out.println("1. Move Virologist");
        System.out.println("2. Collect Materials");
        System.out.println("3. Collect Equipments");
        System.out.println("4. Collect Gencode and win the game");
        System.out.println("5. Create an agent");
        System.out.println("6. Throw equipment");
        System.out.println("7. Steal something");
        System.out.println("8. Apply an agent");
        System.out.println("9. Bear Test");
        System.out.println("10. Move + Collect + Throw");
        System.out.println("If you want to stop testing, then write anything.");

        Game game = new Game();
        switch (sc.next()) {
            case "1":   // Move Virologist
                game.getHandler().setInputFile("tests//move_commands.txt");
                game.getHandler().setOutputFile("tests_output//move.txt");
                game.start("tests//move_testInit.txt");
                break;
            case "2":   // Collect Materials
                game.getHandler().setInputFile("tests//collectMaterials_commands.txt");
                game.getHandler().setOutputFile("tests_output//collectMaterials.txt");
                game.start("tests//collectMaterials_testInit.txt");
                break;
            case "3":   // Collect Equipments
                game.getHandler().setInputFile("tests//collectEquipments_commands.txt");
                game.getHandler().setOutputFile("tests_output//collectEquipments.txt");
                game.start("tests//collectEquipments_testInit.txt");
                break;
            case "4":   // Collect Gencode and win the game
                game.getHandler().setInputFile("tests//collectGenCodeWin_commands.txt");
                game.getHandler().setOutputFile("tests_output//collectGenCodeWin.txt");
                game.start("tests//collectGenCodeWin_testInit.txt");
                break;
            case "5":   // Create an agent
                game.getHandler().setInputFile("tests//create_commands.txt");
                game.getHandler().setOutputFile("tests_output//create.txt");
                game.start("tests//create_testInit.txt");
                break;
            case "6":   // Throw equipment
                game.getHandler().setInputFile("tests//throw_commands.txt");
                game.getHandler().setOutputFile("tests_output//throw.txt");
                game.start("tests//throw_testInit.txt");
                break;
            case "7":   // Steal something
                game.getHandler().setInputFile("tests//steal_commands.txt");
                game.getHandler().setOutputFile("tests_output//steal.txt");
                game.start("tests//steal_testInit.txt");
                break;
            case "8":   // Apply an agent
                game.getHandler().setInputFile("tests//apply_commands.txt");
                game.getHandler().setOutputFile("tests_output//apply.txt");
                game.start("tests//apply_testInit.txt");
                break;
            case "9":   // Bear Test
                game.getHandler().setInputFile("tests//bear_commands.txt");
                game.getHandler().setOutputFile("tests_output//bear.txt");
                game.start("tests//bear_testInit.txt");
                break;
            case "10":  // Move + Collect + Throw
                game.getHandler().setInputFile("tests//komplex_commands.txt");
                game.getHandler().setOutputFile("tests_output//komplex.txt");
                game.start("tests//komplex_testInit.txt");
                break;
        }
        game.getHandler().writeInFile();
    }
}

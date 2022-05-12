import Game.*;

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
                game.getHandler().setInputFile("src//tests//move_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//move.txt");
                game.start("src//tests//move_testInit.txt",null);
                break;
            case "2":   // Collect Materials
                game.getHandler().setInputFile("src//tests//collectMaterials_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//collectMaterials.txt");
                game.start("src//tests//collectMaterials_testInit.txt",null);
                break;
            case "3":   // Collect Equipments
                game.getHandler().setInputFile("src//tests//collectEquipments_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//collectEquipments.txt");
                game.start("src//tests//collectEquipments_testInit.txt",null);
                break;
            case "4":   // Collect Gencode and win the game
                game.getHandler().setInputFile("src//tests//collectGenCodeWin_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//collectGenCodeWin.txt");
                game.start("src//tests//collectGenCodeWin_testInit.txt",null);
                break;
            case "5":   // Create an agent
                game.getHandler().setInputFile("src//tests//create_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//create.txt");
                game.start("src//tests//create_testInit.txt",null);
                break;
            case "6":   // Throw equipment
                game.getHandler().setInputFile("src//tests//throw_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//throw.txt");
                game.start("src//tests//throw_testInit.txt",null);
                break;
            case "7":   // Steal something
                game.getHandler().setInputFile("src//tests//steal_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//steal.txt");
                game.start("src//tests//steal_testInit.txt",null);
                break;
            case "8":   // Apply an agent
                game.getHandler().setInputFile("src//tests//apply_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//apply.txt");
                game.start("src//tests//apply_testInit.txt",null);
                break;
            case "9":   // Bear Test
                game.getHandler().setInputFile("src//tests//bear_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//bear.txt");
                game.start("src//tests//bear_testInit.txt",null);
                break;
            case "10":  // Move + Collect + Throw
                game.getHandler().setInputFile("src//tests//komplex_commands.txt");
                game.getHandler().setOutputFile("src//tests_output//komplex.txt");
                game.start("src//tests//komplex_testInit.txt",null);
                break;
        }
        game.getHandler().writeInFile();
    }
}

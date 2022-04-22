package TestSets;

import Collectible.Collectible;
import Equipments.Axe;
import Equipments.Equipment;
import Field.*;
import Virologist.Virologist;
import Game.Game;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kill_TestSet {

    /**
     * Teszt eset, ami az ágens idejének telését és az ágens eltávolítását teszteli.
     */

    private Game game;
    private Axe axe;
    private Virologist killerViro;
    private Virologist deadViro;

    /**
     * Konstruktor, ami meghívja a teszt inicializálását.
     */
    public Kill_TestSet() {
        init_test();
    }

    /**
     *  Lefutattja a tesztet, és megnézi az eredményt.
     */
    public void test() {

        System.out.println("Testing Killing ...");

        // checking if everything is OK
        ArrayList<Virologist> virologists = game.getVirologists();
        for(int i = 0; i < virologists.size(); i++){
            if(virologists.get(i).equals(deadViro))
                System.out.println("The test failed");
            else
                System.out.println("The dead virologist got removed from the game.");
        }
        System.out.println("\n\n\n");
    }

    /**
     * Inicializál mindent szükséges objektumot és tagváltozót, ami kell a teszteléshez.
     */
    private void init_test() {
        System.out.println("Init Killing test ...");

        game = new Game();
        Field field = new Field();
        killerViro = new Virologist(field);
        deadViro = new Virologist(field);
        axe = new Axe();

        game.addVirologistManually(killerViro);
        game.addVirologistManually(deadViro);
        killerViro.getPropertyHandler().add(axe);

        List<Equipment> killerEquipments = killerViro.getPropertyHandler().getEquipments();
        for (int i = 0; i < killerEquipments.size(); i++){
            if(killerEquipments.get(i) == axe) {
                System.out.println("The potential killer has an axe, and is ready to kill!");
                deadViro.beKilled();
                killerViro.getPropertyHandler().remove(axe);
            }
        }
        for (int i = 0; i < killerEquipments.size(); i++){
            if(killerEquipments.get(i) == axe)
                System.out.println("The axe did not get removed from the killer");
            else
                System.out.println("The axe got removed from the killer");

        }

        System.out.println("Do you want to rob the corpse? y/n");
        Scanner sc = new Scanner(System.in);
        if(sc.next().equals("y")){
            Steal_TestSet stealTestSet = new Steal_TestSet();
            stealTestSet.test();
        }




    }

}

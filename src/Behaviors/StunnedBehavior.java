package Behaviors;

import Collectible.Collectible;
import PropertyHandler.PropertyHandler;
import TestSets.TestOutputWriter;

import java.util.ArrayList;

public class StunnedBehavior extends AutomaticBehavior{
    /**+
     * bénít: nem engedélyez több akciót
     */
    @Override
    public void execute(){
        System.out.println(viro.toString()+" is paralysed, can’t do anything.");
        TestOutputWriter.appendToTestOutput(viro.toString()+" is paralysed, can’t do anything.\n");
        viro.setActionCounter(0);
    }

    /**+
     * visszaadja a virológus összes ellopható dolgát
     * @param ph a virológus eszközkezelője
     * @return ellopható dolgok
     */
    @Override
    public ArrayList<Collectible> getStealables(PropertyHandler ph){
        ArrayList<Collectible> things = new ArrayList<>();
        things.addAll(ph.getNucleotids());
        things.addAll(ph.getAminoAcids());
        things.addAll(ph.getEquipments());
        return things;
    }
}

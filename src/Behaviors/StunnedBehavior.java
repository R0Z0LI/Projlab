package Behaviors;

import Collectible.Collectible;
import Graphics.VirologistView;
import PropertyHandler.PropertyHandler;

import java.util.ArrayList;

public class StunnedBehavior extends AutomaticBehavior{
    /**
     * bénít: nem engedélyez több akciót
     */
    @Override
    public void execute(){
        viro.getVirologistView().displayStunnedVirologist(viro.getCurrentField().getView(), VirologistView.ACTIVE_MODE);
        System.out.println(viro.getName() + " is paralysed, can not do anything.");
        viro.setActionCounter(0);
    }

    /**
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

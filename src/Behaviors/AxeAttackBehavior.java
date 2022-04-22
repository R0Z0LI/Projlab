package Behaviors;

import TestSets.TestInOutHandler;
import Virologist.Virologist;

public class AxeAttackBehavior extends AttackBehavior{
    @Override
    public void attack( Virologist v){
        System.out.println(viro.getName()+" successfully used axe.");
        TestInOutHandler.appendToTestOutput(viro.getName()+" successfully used axe.\n");
        v.beKilled();
    }
}

package Behaviors;

import TestSets.TestInOutHandler;
import Virologist.Virologist;

public class AxeAttackBehavior extends AttackBehavior{
    public AxeAttackBehavior(Virologist v){
        super(v);
    }
    @Override
    public void attack( Virologist v){
        System.out.println(viro.getName()+" successfully used axe.");
        TestInOutHandler.appendToTestOutput(viro.getName()+" successfully used axe.");
        v.beKilled();
    }
}

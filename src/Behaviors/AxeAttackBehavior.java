package Behaviors;

import Virologist.Virologist;

public class AxeAttackBehavior extends AttackBehavior{
    @Override
    public void attack( Virologist v){
        v.beKilled();
    }
}

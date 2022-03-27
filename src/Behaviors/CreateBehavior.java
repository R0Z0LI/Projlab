package Behaviors;

import Gencode.GenCode;
import Virologist.Virologist;

public class CreateBehavior {
    private Virologist virologist;

    public CreateBehavior(Virologist v){
        virologist=v;
    }
    public CreateBehavior() { }

    public void setVirologist(Virologist v){
        virologist=v;
    }
    public Virologist getVirologist(){
        return virologist;
    }

    /**+
     * Kezdeményezi egy ágens előállítását genetikai kódból.
     * @param code  genetikai kód, amelyből az ágenst elő kell állítani.
     */
    public void create(GenCode code){
        System.out.println("->CreateBehavior. create(GenCode code)");
        virologist.getPropertyHandler().makeAgent(code);
    }
}

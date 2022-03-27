package behaviors;

import gencode.GenCode;
import virologist.Virologist;

public class CreateBehavior {
    private Virologist virologist;

    public CreateBehavior(Virologist v){
        virologist=v;
    }

    public CreateBehavior() {

    }
    public void setVirologist(Virologist v){
        virologist=v;
    }

    /**+
     * Kezdeményezi egy ágens előállítását genetikai kódból.
     * @param code  genetikai kód, amelyből az ágenst elő kell állítani.
     */
    public void create(GenCode code){
        System.out.println("->CreateBehavior. create(GenCode code)");
        virologist.getPropertyHandler().MakeAgent(code);
    }
}

package behaviors;

import virologist.Virologist;

public class CreateBehavior {
    private Virologist virologist;

    public CreateBehavior(Virologist v){
        virologist=v;
    }

    /**+
     * Kezdeményezi egy ágens előállítását genetikai kódból.
     * @param code  genetikai kód, amelyből az ágenst elő kell állítani.
     */
    public void Create(GenCode code){
        virologist.GetPropertyHandler().MakeAgent(code);
    }
}

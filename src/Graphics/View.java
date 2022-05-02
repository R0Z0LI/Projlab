package Graphics;

/**
 * View interface that is shown to the user.
 * It can be updated and activated.
 */
public interface View {
    /**
     * Updates the view to show the current view for the model.
     */
    void update();

    /**
     * Activates the view, so that it is the shown/active view on the mainframe.
     */
    void activateView();
}

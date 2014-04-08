/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer;

import eclaimer.GUI.EclaimDataPanel;
import eclaimer.GUI.TablePanel;

/**
 *
 * The purpose of this class is basically a singleton that allows the laptop manager
 * access to the data panel on the main window. So that it can update the drop menus
 * with new data.
 */
public class GlobalUpdater
{
    private static GlobalUpdater instance = null;
    private EclaimDataPanel dataPanel;
    private TablePanel tablePanel;

     /**
     * Creates the GlobalUpdater() method is protected since it is a singleton and
     * new instances can't be created outside of this class.
     *
     * @return the created GlobalUpdater object().
     */
    protected GlobalUpdater()
    {

    }

     /**
     * Gets the single instance of the GlobalUpdater object. Creates one if does not exist.
     * Does not create one if one does exist (hence singleton).
     *
     * @return the laptop model.
     */
    public static GlobalUpdater getInstance()
    {
        if(instance == null)
        {
            instance = new GlobalUpdater();
        }

        return instance;
    }

     /**
     * Sets the data panel reference.
     *
     * @param theDataPanel the panel whose reference we are saving.
     */
    public void setDataPanel(EclaimDataPanel theDataPanel)
    {
        dataPanel = theDataPanel;
    }

    /**
     * Sets the table panel reference.
     *
     * @param theTablePanel the panel whose reference we are saving.
     */
    public void setTablePanel(TablePanel theTablePanel)
    {
        tablePanel = theTablePanel;
    }

     /**
     * Gets the data panel reference.
     *
     * @return the data panel reference.
     */
    public EclaimDataPanel getDataPanel()
    {
        return dataPanel;
    }

    /**
     * Gets the table panel reference.
     *
     * @return the table panel reference.
     */
    public TablePanel getTablePanel()
    {
        return tablePanel;
    }
}
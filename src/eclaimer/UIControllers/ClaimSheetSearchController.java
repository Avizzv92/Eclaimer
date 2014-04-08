/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.UIControllers;

import eclaimer.GUI.ClaimTablePanel;

public class ClaimSheetSearchController
{
    private ClaimTablePanel table;

    /**
     * Constructs a ClaimSheetSearch controller with a reference the the table it is controlling.
     *
     * @param theTable
     */
    public ClaimSheetSearchController(ClaimTablePanel theTable)
    {
        table = theTable;
    }

    /**
     * Called when the update search button is pressed, this updates the table based on the new parameters of the search.
     */
    public void updateSearch()
    {
        table.updateTable();
    }
}

/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer;

import eclaimer.BaseObjects.Eclaim;
import eclaimer.GUI.AlertWindow;
import eclaimer.GUI.TablePanel;
import eclaimer.Utilities.HistoryCache;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class FileManager
{
    private TablePanel tablePanel;

     /**
     * Creates a FileManager object while passing a reference to the table panel
     * which has all of the created eclaims.
     *
     * @param panel the table panel containing eclaim data that will be used to save the claim to a file.
     * @return the created FileManager object.
     */
    public FileManager(TablePanel panel)
    {
        tablePanel = panel;
    }

     /**
     * Called when the user chooses to create a brand new warranty claim.
     */
    public void shouldMakeNew()
    {
        tablePanel.newClaim();
    }

     /**
     * Called when the user decides to open an already created claim.
     *
     * @param filePath the path of the file to open.
     */
    public void shouldOpen(String filePath)
    {
        CSVManager csvManager = new CSVManager();
        tablePanel.setAllEclaims(csvManager.openCSVClaimFile(new File(filePath)));
    }

     /**
     * Exports the claim to a .csv file that will be submitted to Lenovo.
     *
     * @param filePath the path of the file to export.
     */
    public void shouldExportCSV(String filePath)
    {
        ArrayList<Eclaim> claims = tablePanel.getAllEclaims();

        if(claims.isEmpty())
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: No Eclaims made to export.");
            window.setVisible(true);

            return;
        }

        CSVManager csvManager = new CSVManager();
        csvManager.addClaimToTextFile(claims, filePath);
        
        for(Eclaim e : claims)
        {
            HistoryCache.sendToHistory(e.getLaptopID(), e.getProblemDescription());
        }
        
        HistoryCache.saveCache();
    }

     /**
     * Gets the file path of the app support folder located in the documents directory.
     *
     * @return the file path.
     */
    public static File getAppSupportPath()
    {/*
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        File myDoc = fw.getDefaultDirectory();
        String myDocString = myDoc.getPath();

        //Mac OS File Structure is different....
        if(System.getProperty("os.name").contains("Windows"))myDocString += "/Eclaimer_Support";
        else myDocString +="/Documents/Eclaimer_Support";
*/
        File f = new File("C:/Users/Administrator/Dropbox/Laptop Help Desk/Eclaimer Files/Eclaimer/Eclaimer_Support");
        return f;
    }

     /**
     * Gets the file path of the documents directory on the computer.
     *
     * @return the file path.
     */
    public static File getDocumentsPath()
    {
        JFileChooser fr = new JFileChooser();
        FileSystemView fw = fr.getFileSystemView();
        File myDoc = fw.getDefaultDirectory();

        return myDoc;
    }
}

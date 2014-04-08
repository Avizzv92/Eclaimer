/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.Utilities;

import eclaimer.FileManager;
import eclaimer.GUI.AlertWindow;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class AutomaticLaptopIdentifier
{
    public static ArrayList<String> identifiers = null;
    public static ArrayList<String> serialNumbers = null;
    
    //Load the data from the text files into the approriate arrays for later use.
    public static void loadData()
    {
        if(identifiers == null)
        {
            try
            {
                File myDoc = FileManager.getAppSupportPath();
                String myDocString = myDoc.getPath() + "/" + "LaptopIdentifiers" + ".txt";
                Scanner scan = new Scanner(new File(myDocString));
                identifiers = new ArrayList();

                while (scan.hasNext()) {
                    identifiers.add(scan.nextLine());
                }

                scan.close();
            }

            catch(IOException ex)
            {
                AlertWindow window = new AlertWindow();
                window.setErrorMessage("Error: There was a problem with the Laptop Identifiers file. \nDescription: " + ex.toString());
                window.setLocation(new Point(0,0));
                window.setVisible(true);
            }
        }
        
        if(serialNumbers == null)
        {
            try
            {
                File myDoc = FileManager.getAppSupportPath();
                String myDocString = myDoc.getPath() + "/" + "LaptopSerialNumbers" + ".txt";
                Scanner scan = new Scanner(new File(myDocString));
                serialNumbers = new ArrayList();

                while (scan.hasNext()) {
                    serialNumbers.add(scan.nextLine());
                }

                scan.close();
            }

            catch(IOException ex)
            {
                AlertWindow window = new AlertWindow();
                window.setErrorMessage("Error: There was a problem with the Laptop Serial Number file. \nDescription: " + ex.toString());
                window.setLocation(new Point(0,0));
                window.setVisible(true);
            }
        }
    }

    /**
     * Returns whether or no the sn is a valid one.
     *
     * @param  sn  the string containing the serial number to check.
     * @return true/false whether or not it is valid sn.
     */
    public static void isValid(String sn)
    {
        boolean isMatch = false;
        
        sn = sn.toLowerCase();
        
        for(String serialNumber : serialNumbers)
        {
           if(sn.equalsIgnoreCase(serialNumber))isMatch = true;
        }
        
        if(!isMatch)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("That serial number may not be valid.");
            window.setLocation(new Point(0,0));
            window.setVisible(true);
        }
    }
    
    /**
     * Returns the laptops ID for a given serial number string.
     *
     * @param  sn  the string containing the serial number to match an id for.
     * @return the matched laptop id.
     */
    public static String idLaptopWithSN(String sn)
    {
        sn = sn.toLowerCase();

        for(String identifier: identifiers)
        {
            int index = identifier.indexOf(":");
            String id = identifier.substring(index+1, identifier.length());
            id = id.toLowerCase();

            if(sn.startsWith(id)) {
                return identifier.substring(0,index);
            }
        }

        return null;
    }
}

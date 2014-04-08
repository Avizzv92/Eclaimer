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

public class DamageDescriptionScreener
{
    private static ArrayList<String> filterWords = null;

     /**
     * Searches for the containment of a bad word in a non-protec damage description.
     *
     * @param  description  the problem description to search in.
     * @return     whether or not the string contains a "No-No" word.
     */
    public static boolean containsBadWord(String description)
    {
        description = description.toLowerCase();

        if(filterWords == null)
        {
            try
            {
                File myDoc = FileManager.getAppSupportPath();
                String myDocString = myDoc.getPath() + "/" + "FilterWords" + ".txt";
                Scanner scan = new Scanner(new File(myDocString));
                filterWords = new ArrayList();

                while (scan.hasNext()) {
                    filterWords.add(scan.nextLine());
                }

                scan.close();
            }

            catch(IOException ex)
            {
                AlertWindow window = new AlertWindow();
                window.setErrorMessage("Error: There was a problem with the Filter Words file. \nDescription: " + ex.toString());
                window.setLocation(new Point(0,0));
                window.setVisible(true);
            }
        }

        for(String badWord : filterWords)
        {
            badWord = badWord.toLowerCase();

            if(description.indexOf(badWord) >= 0) {
                return true;
            }
        }

        return false;
    }
}

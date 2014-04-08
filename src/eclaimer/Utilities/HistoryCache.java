/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package eclaimer.Utilities;

import eclaimer.FileManager;
import eclaimer.GUI.AlertWindow;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Administrator
 */
public class HistoryCache 
{
    static public Map<String,ArrayList> history = new HashMap<String,ArrayList>();
    
    /**
     * Loads the cache containing the history from the data file. It also removes history older than 30 days.
     */
    public static void loadCache()
    {
        /*
        File fileName = new File(FileManager.getAppSupportPath().getPath()+"/HistoryCache");
	FileInputStream fis = null;
        ObjectInputStream in = null;

	try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            history = (Map<String,ArrayList>) in.readObject();
            in.close();
            removeOldHistory();
	}

        catch (IOException ex) {
	}

        catch (ClassNotFoundException ex) {
	}*/
    }

    /**
     * Saves the history cache to a data file.
     */
    public static void saveCache()
    {
        /*
        File fileName = new File(FileManager.getAppSupportPath().getPath()+"/HistoryCache");

	FileOutputStream fos = null;
	ObjectOutputStream out = null;

        try {
		fos = new FileOutputStream(fileName);
		out = new ObjectOutputStream(fos);
		out.writeObject(history);
                out.close();
	}

        catch (IOException ex) {
        }*/
    }
    
    /**
     * Sends a laptop to the history cache where the sn, description, and current date will be stored.
     *
     * @param sn the Serial Number of the laptop to send to history.
     * @param description the problem description of the laptop to send to history.
     */
    public static void sendToHistory(String sn, String description)
    {
        /*
        ArrayList list = new ArrayList();
        list.add(sn);
        list.add(description);
        
        Calendar cal = Calendar.getInstance();
        list.add(cal);
        
        history.put(sn.toUpperCase(),list);*/
    }
    
    /**
     * Removes laptops added more than 30 days ago.
     */
    public static void removeOldHistory()
    {
        /*
        for(String sn : history.keySet())
        {
            Calendar cal = Calendar.getInstance();
            Calendar oldCal = (Calendar)history.get(sn).get(2);
            cal.setTime(oldCal.getTime());
            Calendar calCurrent = Calendar.getInstance();
            long daysBetween = TimeUnit.MILLISECONDS.toDays(cal.getTime().getTime() - calCurrent.getTime().getTime());

            if(daysBetween > 30 || daysBetween < -30)
            {
                history.remove(sn);
            }
        }*/
    }
    
    /**
     * Checks to make sure whether or not the laptop serial number has been used on another eclaim in the past 30 days.
     *
     * @param sn the serial number of the laptop to check.
     * @return whether or not the laptop is old enough for another warranty claim.
     */
    public static boolean isOldEnough(String sn)
    {   
        ArrayList list = history.get(sn);
        
        if(list == null)
        {
            return true;
        }
        
        else
        {
            Calendar cal = (Calendar)list.get(2);
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Caution: " + sn + " has been used in another warranty claim in the past 30 days.\n Date: " + cal.getTime() + "\n Description: " + list.get(1));
            window.setVisible(true);
            
            return false;
        }
    }
}

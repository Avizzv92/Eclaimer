/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.Utilities;

import eclaimer.FileManager;
import eclaimer.GUI.AlertWindow;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class ProfileInfoFetcher extends ColumnDefines
{
    private ArrayList<String> profileInfoList;

    /**
     * Creates a ProfileInfoFetcher object.
     *
     * @return the ProfileInfoFetcher object.
     */
    public ProfileInfoFetcher()
    {
         profileInfoList = new ArrayList();

        try
        {
            File myDoc = FileManager.getAppSupportPath();
            String myDocString = myDoc.getPath() + "/Profile.txt";

             Scanner scan = new Scanner(new File(myDocString));

             while(scan.hasNextLine())
                 profileInfoList.add(scan.nextLine());
        }

        catch(Exception ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Problem opening the Profile text file.\nDescription: " + ex.toString());
            window.setVisible(true);
        }
    }

    /**
     * Gets the information for a given field description.
     *
     * @param fieldDescription the field for which we are getting information for.
     * @return the string containing the desired information.
     */
    public String getInfoForField(int fieldDescription)
    {
        try
        {
            switch(fieldDescription)
            {
                case LOCATION_ID: return extractInformation(profileInfoList.get(0));
                case ECA: return extractInformation(profileInfoList.get(1));
                case SERVICE_DATE: return currentDateString(); ///////
                case POP_DATE: return currentDateString();//////
                case TECHNICIAN_ID: return extractInformation(profileInfoList.get(2));
                case SERVICE_DELVIERY_TYPE: return extractInformation(profileInfoList.get(3));
                case AUTHO_CODE: return extractInformation(profileInfoList.get(4));
                case INCIDENT_NUMBER: return "";////////??????
                case CUST_CONTACT_NAME: return extractInformation(profileInfoList.get(5));
                case CUST_COMPANY: return extractInformation(profileInfoList.get(6));
                case CUST_ADDRESS1: return extractInformation(profileInfoList.get(7));
                case CUST_ADDRESS2: return extractInformation(profileInfoList.get(8));
                case CUST_CITY: return extractInformation(profileInfoList.get(9));
                case CUST_COUNTRY: return extractInformation(profileInfoList.get(10));
                case CUST_STATE: return extractInformation(profileInfoList.get(11));
                case CUST_ZIP: return extractInformation(profileInfoList.get(12));
                case CUST_PHONE: return extractInformation(profileInfoList.get(13));
                case CUST_EMAIL: return extractInformation(profileInfoList.get(14));
                case SHIPTO_DEALER: return extractInformation(profileInfoList.get(15));
                case SHIPMENT_METHOD: return extractInformation(profileInfoList.get(16));
                case SHIPTO_NAME: return extractInformation(profileInfoList.get(17));
                case SHIPTO_COMPANY: return extractInformation(profileInfoList.get(18));
                case SHIPTO_ADDRESS: return extractInformation(profileInfoList.get(19));
                case SHIPTO_ADDRESS2: return extractInformation(profileInfoList.get(20));
                case SHIPTO_CITY: return extractInformation(profileInfoList.get(21));
                case SHIPTO_COUNTRY: return extractInformation(profileInfoList.get(22));
                case SHIPTO_STATE: return extractInformation(profileInfoList.get(23));
                case SHIPTO_ZIP: return extractInformation(profileInfoList.get(24));
                case SHIPTO_PHONE: return extractInformation(profileInfoList.get(25));
                case SHIPTO_EMAIL: return extractInformation(profileInfoList.get(26));
            }
        }

        catch(Exception ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: The Profile text file is missing information or corrupt.\nDescription: " + ex.toString());
            window.setVisible(true);
        }

        return null;
    }

    /**
     * Extracts information from a string since it is formatted like Field:Information in file.
     *
     * @param str the complete string we are extracting from.
     * @return the string containing the information.
     */
    private String extractInformation(String str)
    {
        String returnString = "";
        int index = str.indexOf(":");
        if(index < 0)return returnString;
        returnString = str.substring(index+1, str.length());
        return returnString;
    }

    /**
     * Returns a formatted date string indicating the current date.
     *
     * @return the formatted date string.
     */
    private String currentDateString()
    {
        String DATE_FORMAT_NOW = "yyyy-MM-dd";

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);

        return sdf.format(cal.getTime());
    }
}

/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer;

import eclaimer.Utilities.ColumnDefines;
import eclaimer.Utilities.ProfileInfoFetcher;
import eclaimer.BaseObjects.Eclaim;
import eclaimer.GUI.AlertWindow;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class CSVManager extends ColumnDefines
{
    private final String PROTEC_ID = "YBCD";
    private final String NON_PROTEC_ID = "YBCM";

    /**
     * Creates a properly formatted string generated from the claims array, theFile will be passed onto a method that handles file saving.
     *
     * @param  claims  the array of claims to be added to the text file.
     * @param  theFile  the path of the file to save to.
     */
    public void addClaimToTextFile(ArrayList<Eclaim> claims, String theFile)
    {
        ProfileInfoFetcher fetcher = new ProfileInfoFetcher();

        String finalString = "";

        for(Eclaim e : claims)
        {
            String claimNumber = e.getClaimNumber();//0
            String locationID = fetcher.getInfoForField(LOCATION_ID);//1
            boolean isProtec = e.getIsProtec();
            String claimType = "";//2
                if(isProtec)claimType = PROTEC_ID;
                else claimType = NON_PROTEC_ID;
            String eca = fetcher.getInfoForField(ECA);//3
            String laptopModel = e.getLaptopModelNumber();//4
            String laptopID = e.getLaptopID();//5
            String serviceDate = fetcher.getInfoForField(SERVICE_DATE);//6
            String popDate = fetcher.getInfoForField(POP_DATE);//7
            String techId = fetcher.getInfoForField(TECHNICIAN_ID);//8
            String serviceDeliveryType = fetcher.getInfoForField(SERVICE_DELVIERY_TYPE);//9
            String authoCode = fetcher.getInfoForField(AUTHO_CODE);//10
            String incidentNumber = fetcher.getInfoForField(INCIDENT_NUMBER);//11
            
            String part1 = e.getPart1();//12
                if(part1.equals("None"))part1 = "";
            part1 = extractFRUNumberFromString(part1);

            String part2 = e.getPart2();//13
                if(part2.equals("None"))part2 = "";
            part2 = extractFRUNumberFromString(part2);

            String part3 = e.getPart3();//14
                if(part3.equals("None"))part3 = "";
            part3 = extractFRUNumberFromString(part3);

            System.out.println(e.getPart3());
            
            String part4 = "";//15
            String part5 = "";//16
            String custContNameLabel = fetcher.getInfoForField(CUST_CONTACT_NAME);
            String custCompLabel = fetcher.getInfoForField(CUST_COMPANY);
            String custAddress1Label = fetcher.getInfoForField(CUST_ADDRESS1);
            String custAddress2Label = fetcher.getInfoForField(CUST_ADDRESS2);
            String custCityLabel = fetcher.getInfoForField(CUST_CITY);
            String custCountryLabel = fetcher.getInfoForField(CUST_COUNTRY);
            String custStateLabel = fetcher.getInfoForField(CUST_STATE);
            String custZipLabel = fetcher.getInfoForField(CUST_ZIP);
            String custPhoneLabel = fetcher.getInfoForField(CUST_PHONE);
            String custEmailLabel = fetcher.getInfoForField(CUST_EMAIL);
            String shiptoDealerLabel = fetcher.getInfoForField(SHIPTO_DEALER);
            String shipMethodLabel = fetcher.getInfoForField(SHIPMENT_METHOD);
            String shiptoNameLabel = fetcher.getInfoForField(SHIPTO_NAME);
            String shiptoCompanyLabel = fetcher.getInfoForField(SHIPTO_COMPANY);
            String shiptoAddress1Label = fetcher.getInfoForField(SHIPTO_ADDRESS);
            String shiptoAddress2Label = fetcher.getInfoForField(SHIPTO_ADDRESS2);
            String shiptoCityLabel = fetcher.getInfoForField(SHIPTO_CITY);
            String shiptoCountryLabel = fetcher.getInfoForField(SHIPTO_COUNTRY);
            String shiptoStateLabel = fetcher.getInfoForField(SHIPTO_STATE);
            String shiptoZipLabel = fetcher.getInfoForField(SHIPTO_ZIP);
            String shiptoPhoneLabel = fetcher.getInfoForField(SHIPTO_PHONE);
            String shiptoEmailLabel = fetcher.getInfoForField(SHIPTO_EMAIL);

            String problemDescription = e.getProblemDescription();

            String rowString = claimNumber + "," + locationID + "," + claimType + "," + eca + "," + laptopModel + ","
                    + laptopID + "," + serviceDate + "," + popDate + "," + techId + "," + serviceDeliveryType + ","
                    + authoCode + ","+ incidentNumber + "," + part1 + "," + part2 + "," + part3 + "," + part4 + "," + part5 + "," + custContNameLabel + ","
                    + custCompLabel + "," + custAddress1Label + "," + custAddress2Label + "," + custCityLabel + "," + custCountryLabel + ","
                    + custStateLabel + "," + custZipLabel + "," + custPhoneLabel + "," + custEmailLabel + "," + shiptoDealerLabel + ","
                    + shipMethodLabel + "," + shiptoNameLabel + "," + shiptoCompanyLabel + "," + shiptoAddress1Label + "," + shiptoAddress2Label + ","
                    + shiptoCityLabel + "," + shiptoCountryLabel + "," + shiptoStateLabel + "," + shiptoZipLabel + "," + shiptoPhoneLabel + ","
                    + shiptoEmailLabel + "," + problemDescription;

            if(claims.indexOf(e) != claims.size()-1) rowString += "\r\n";

            finalString += rowString;
        }

        writeClaimToTextFile(finalString, theFile);
    }

    /**
     * Writes a claim string to a given text file (.csv format)
     *
     * @param  claimString  the formatted string which contains all the claims.
     * @param  theFile the path of the file to save to.
     */
    public void writeClaimToTextFile(String claimString, String theFile)
    {
        String formattedString = theFile.replaceAll(".csv", "");
        File fileToSave = new File(formattedString+".csv");

        try
        {
            FileWriter fw = new FileWriter (fileToSave);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter outFile = new PrintWriter (bw);
            outFile.println(claimString);
            outFile.close();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Could not export claim to the CSV file.\nDescription: " + ex.toString());
            window.setVisible(true);
        }
    }

    /**
     * Returns the laptops ID for a given serial number string.
     *
     * @param  theFile  the path of the file to open, a .csv containing all of the claims.
     * @return     the array of eclaims gathered from the file.
     */
    public ArrayList<Eclaim> openCSVClaimFile(File theFile)
    {
        ArrayList<Eclaim> eclaimsExtracted = new ArrayList();
        
        try
        {
            Scanner scan = new Scanner(theFile);

            while (scan.hasNext()) 
            {
                String lineContent = scan.nextLine();
                String[] lineParts = lineContent.split(",");
                
                Eclaim extractedEclaim = new Eclaim();
                extractedEclaim.setClaimNumber(lineParts[CLAIM_REF_ID]);
                extractedEclaim.setLaptopID(lineParts[SERIAL_NUMBER]);
                extractedEclaim.setLaptopModel(extractedEclaim.getLaptopModelForNumber(lineParts[PRODCT_ID]));
                
                if(lineParts[PART1].length()>0)extractedEclaim.setPart1(":" + lineParts[PART1]);
                else extractedEclaim.setPart1("None");
                if(lineParts[PART2].length()>0)extractedEclaim.setPart2(":" + lineParts[PART2]);
                else extractedEclaim.setPart2("None");
                if(lineParts[PART3].length()>0)extractedEclaim.setPart3(":" + lineParts[PART3]);
                else extractedEclaim.setPart3("None");

                if(lineParts[CLAIM_TYPE].equals(PROTEC_ID))extractedEclaim.setIsProtec(true);
                else extractedEclaim.setIsProtec(false);
                extractedEclaim.setDescription(lineParts[FAIL_DESCRIPTION]);
                eclaimsExtracted.add(extractedEclaim);
            }
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Could not properly read LaptopList.txt.\nDescription: " + ex.toString());
            window.setLocation(new Point(0,0));
            window.setVisible(true);
            
            return null;
        }
        
        return eclaimsExtracted;
    }

    /**
     * Extracts a FRU number from a given string, this is done because part information is formatted like "Description:FRU"
     *
     * @param  str  the string containing the description and FRU.
     * @return     the FRU extracted from the string.
     */
    private String extractFRUNumberFromString(String str)
    {
        String returnString = "";
        int index = str.indexOf(":");
        if(index < 0)return returnString;
        returnString = str.substring(index+1, str.length());

        return returnString;

    }
}

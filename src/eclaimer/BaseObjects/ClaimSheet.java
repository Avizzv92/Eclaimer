/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.BaseObjects;

import eclaimer.FileManager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class ClaimSheet implements Comparable<ClaimSheet>
{
    private String dbID;
    private String claimNumber;
    private String laptopID;
    private String laptopModel;
    private String part1;
    private String part2;
    private String part3;
    private boolean isProtec;
    private String problemDescription;
    private String date;
    private String trackingNumber;

    /**
     * The default ClaimSheet constructor
     *
     * @return a default ClaimSheet object.
     */
    public ClaimSheet()
    {
        dbID = null;
        claimNumber = null;
        laptopID = null;
        laptopModel = null;
        part1 = null;
        part2 = null;
        part3 = null;
        isProtec = false;
        problemDescription = null;
        date = null;
        trackingNumber = null;
    }

    /**
     * Returns a fully defined ClaimSheet object.
     *
     * @param  claim claim number.
     * @param id laptop ID.
     * @param model laptop model.
     * @param firstPart the fist part.
     * @param secondPart the second part.
     * @param thirdPart the third part.
     * @param protec indicate whether the warranty claim is a protec or not.
     * @param description the damage description.
     * @param theTrackingNumber the tracking number.
     * @param theDate the date the repair was completed
     * @return an ClaimSheet object
     */
    public ClaimSheet(String claim, String id, String model, String firstPart, String secondPart, String thirdPart, boolean protec, String description, String theDate, String theTrackingNumber)
    {
        claimNumber = claim;
        laptopID = id;
        laptopModel = model;
        part1 = firstPart;
        part2 = secondPart;
        part3 = thirdPart;
        isProtec = protec;
        problemDescription = description;
        date = theDate;
        trackingNumber = theTrackingNumber;
        dbID = "";
    }

    /**
     * Compares ClaimSheet objects based on their claim number. This helps in the sorting process.
     *
     * @param  e the ClaimSheet to compare this to.
     * @return  the comparison result.
     */
    @Override
    public int compareTo(ClaimSheet e)
    {
        return e.getClaimNumber().compareToIgnoreCase(getClaimNumber());
    }

    /**
     * Sets the claim number.
     *
     * @param  claim the claim number.
     */
    public void setClaimNumber(String claim)
    {
        claimNumber = claim;
    }

    /**
     * Sets the laptop id number.
     *
     * @param  id the laptop id number.
     */
    public void setLaptopID(String id)
    {
        laptopID = id;
    }

    /**
     * Sets the laptop model (description IE T400).
     *
     * @param  model the laptop model.
     */
    public void setLaptopModel(String model)
    {
        laptopModel = model;
    }

    /**
     * Sets the first part.
     *
     * @param  firstPart the first part.
     */
    public void setPart1(String firstPart)
    {
        part1 = firstPart;
    }

    /**
     * Sets the second part.
     *
     * @param  secondPart the second part.
     */
    public void setPart2(String secondPart)
    {
        part2 = secondPart;
    }

    /**
     * Sets the third part.
     *
     * @param  thirdPart the third part.
     */
    public void setPart3(String thirdPart)
    {
        part3 = thirdPart;
    }

    /**
     * Sets whether is protec.
     *
     * @param  protec is protec.
     */
    public void setIsProtec(boolean protec)
    {
        isProtec = protec;
    }

    /**
     * Sets the tracking number.
     *
     * @param  theTrackingNumber the tracking number.
     */
    public void setTrackingNumber(String theTrackingNumber)
    {
        trackingNumber = theTrackingNumber;
    }

    /**
     * Sets the date.
     *
     * @param  date the date.
     */
    public void setDate(String theDate)
    {
        date = theDate;
    }

    /**
     * Sets the problem description.
     *
     * @param  description the problem description.
     */
    public void setDescription(String description)
    {
        problemDescription = description;
    }

    /**
     * Sets the database id.
     *
     * @param  theDBID the database id.
     */
    public void setDBID(String theDBID)
    {
        dbID = theDBID;
    }

    /**
     * Gets the claim number.
     *
     * @return the claim number.
     */
    public String getClaimNumber()
    {
        return claimNumber;
    }

    /**
     * Gets the laptop id number.
     *
     * @return the laptop id number.
     */
    public String getLaptopID()
    {
        return laptopID;
    }

    /**
     * Gets the laptop model (description IE T400).
     *
     * @return the laptop model.
     */
    public String getLaptopModel()
    {
        return laptopModel;
    }

    /**
     * Gets the first part.
     *
     * @return the first part.
     */
    public String getPart1()
    {
        return part1;
    }

    /**
     * Gets the second part.
     *
     * @return the second part.
     */
    public String getPart2()
    {
        return part2;
    }

    /**
     * Gets the third part.
     *
     * @return the third part.
     */
    public String getPart3()
    {
        return part3;
    }

    /**
     * Gets is protec.
     *
     * @return is protec.
     */
    public boolean getIsProtec()
    {
        return isProtec;
    }

    /**
     * Gets the problem description.
     *
     * @return the problem description.
     */
    public String getProblemDescription()
    {
        return problemDescription;
    }

    /**
     * Gets the tracking number.
     *
     * @return the tracking number.
     */
    public String getTrackingNumber()
    {
        return trackingNumber;
    }

    /**
     * Gets the date completed.
     *
     * @return the date completed.
     */
    public String getDate()
    {
        return date;
    }

    /**
     * Gets the database id.
     *
     * @return the database id.
     */
    public String getDBID()
    {
        return dbID;
    }

    /**
     * Gets the laptop model number based on the laptop model.
     *
     * @return the laptop model number.
     */
    public String getLaptopModelNumber()
    {
        String laptopModelNumber = "";
        File myDoc = FileManager.getAppSupportPath();
        String myDocString = myDoc.getPath() + "/LaptopList.txt";

        Scanner scan;
        try
        {
            scan = new Scanner(new File(myDocString));
        }
        catch (IOException ex){return "";}

        while (scan.hasNext()) {
            String laptopModelName = scan.nextLine();
            String laptopModelSub = "";
            int index = laptopModelName.indexOf(":");
            laptopModelSub = laptopModelName.substring(0, index);

            if(laptopModelSub.equals(this.laptopModel))
                laptopModelNumber = laptopModelName.substring(index+1, laptopModelName.length());
        }

        return laptopModelNumber;
    }

    /**
     * Gets the laptop model based on the laptop model number.
     *
     * @param number the laptop model number
     * @return the laptop model.
     */
    public String getLaptopModelForNumber(String number)
    {
        String returnModel = "";

        File myDoc = FileManager.getAppSupportPath();
        String myDocString = myDoc.getPath() + "/LaptopList.txt";

        Scanner scan;
        try
        {
            scan = new Scanner(new File(myDocString));
        }
        catch (IOException ex){return "";}

        while (scan.hasNext()) {
            String laptopModelName = scan.nextLine();
            String laptopModelSub = "";
            int index = laptopModelName.indexOf(":");
            laptopModelSub = laptopModelName.substring(index+1, laptopModelName.length());

            if(laptopModelSub.equals(number))
                returnModel = laptopModelName.substring(0,index);
        }

        return returnModel;
    }

     /**
     * Gets the string description of this ClaimSheet, used mainly in the table.
     *
     * @return the description string.
     */
    @Override
    public String toString()
    {
        String returnString = "EClaim #: " + this.getClaimNumber() + " | ID: " + this.getLaptopID() + " | TrackingNumber: " + this.getTrackingNumber() + " | Date Completed: " + this.getDate();
        return returnString;
    }
}

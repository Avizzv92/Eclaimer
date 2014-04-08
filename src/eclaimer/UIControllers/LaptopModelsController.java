/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.UIControllers;

import eclaimer.BaseObjects.Laptop;
import eclaimer.BaseObjects.Part;
import eclaimer.FileManager;
import eclaimer.GUI.AlertWindow;
import eclaimer.GUI.LaptopManager;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class LaptopModelsController
{
    private ArrayList<Laptop> laptops;
    private ArrayList<Part> parts;
    private LaptopManager laptopManager;

    /**
     * Creates a laptop models controller object with a reference to the laptop manager GUI.
     *
     * @param theLaptopManager the laptop manager GUI reference.
     * @return the laptopModelsController object
     */
    public LaptopModelsController(LaptopManager theLaptopManager)
    {
        laptopManager = theLaptopManager;
        laptops = new ArrayList();
        parts = new ArrayList();
        populateLaptopList();
    }

    /**
     * Populates the list of laptops being displayed in the laptop manager.
     */
    private void populateLaptopList()
    {
        laptops.clear();
        
        try
        {
            File myDoc = FileManager.getAppSupportPath();
            String myDocString = myDoc.getPath() + "/LaptopList.txt";

            Scanner scan = new Scanner(new File(myDocString));

            while (scan.hasNext()) {
              String laptopModel = scan.nextLine();
              int index = laptopModel.indexOf(":");
              String laptopNumber = laptopModel.substring(index+1, laptopModel.length());
              laptopModel = laptopModel.substring(0, index);

              Laptop newLaptop = new Laptop(laptopModel, laptopNumber, getLaptopPrefixesForModel(laptopModel));
              laptops.add(newLaptop);
            }

            updateLaptopModelTable();

            scan.close();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Could not properly read LaptopList.txt.\nDescription: " + ex.toString());
            window.setLocation(new Point(0,0));
            window.setVisible(true);
        }

        if(!laptops.isEmpty())populatePartListForModel(laptops.get(0).getLaptopModel());
    }

    /**
     * Populates the part list based on the model being selected.
     *
     * @param the laptop model.
     */
    public void populatePartListForModel(String model)
    {
        parts.clear();

        try
        {
            File myDoc = FileManager.getAppSupportPath();
            String myDocString = myDoc.getPath() + "/"+model+".txt";
            Scanner scan = new Scanner(new File(myDocString));

            while (scan.hasNext()) {
              String part = scan.nextLine();
              int index = part.indexOf(":");
              String fru = part.substring(index+1, part.length());
              part = part.substring(0, index);

              Part newPart = new Part(part, fru);

              parts.add(newPart);
            }

            scan.close();
            updatePartTable();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Could not properly read the part list.\nDescription: " + ex.toString());
            window.setLocation(new Point(0,0));
            window.setVisible(true);
        }
    }

    /**
     * Creates a new laptop.
     *
     * @param laptop the new laptop being added to file.
     */
    public void addLaptopModel(Laptop laptop)
    {
        for(Laptop oldLaptop : laptops)
        {
            //If there is duplicate model, assume they are editing the information
            if(laptop.getLaptopModel().equalsIgnoreCase(oldLaptop.getLaptopModel()))
            {
                laptops.remove(oldLaptop);
                oldLaptop.setLaptopModelNumber(laptop.getLaptopModelNumber());
                oldLaptop.setPrefixes(laptop.getPrefixes());
                laptops.add(oldLaptop);
                saveLaptopDataToFile();
                populateLaptopList();
                return;
            }
        }

        //Creating a new laptop model
        laptops.add(laptop);
        createPartFileForModel(laptop.getLaptopModel());
        saveLaptopDataToFile();
        populateLaptopList();
    }

    /**
     * Removes a given laptop from file.
     *
     * @return the laptop.
     */
    public void removeLaptopModel(Laptop laptop)
    {
        laptops.remove(laptop);
        removePartFileForModel(laptop.getLaptopModel());
        saveLaptopDataToFile();
        populateLaptopList();
    }

    /**
     * Adds a laptop part to file.
     *
     * @param thePart the part being created.
     */
    public void addLaptopPart(Part thePart)
    {
        for(Part oldPart : parts)
        {
            //If there is duplicate model, assume they are editing the information
            if(thePart.getName().equalsIgnoreCase(oldPart.getName()))
            {
                parts.remove(oldPart);
                oldPart.setFRU(thePart.getFRU());
                parts.add(oldPart);
                savePartDataToFile();
                populatePartListForModel(laptops.get(laptopManager.models.getSelectedIndex()).getLaptopModel());
                return;
            }
        }

        //Creating a new laptop model
        parts.add(thePart);
        savePartDataToFile();
        populatePartListForModel(laptops.get(laptopManager.models.getSelectedIndex()).getLaptopModel());
    }

    /**
     * Removes a given part from file.
     *
     * @param thePart the part to be removed.
     */
    public void removePart(Part thePart)
    {
        parts.remove(thePart);
        savePartDataToFile();
        populatePartListForModel(laptops.get(laptopManager.models.getSelectedIndex()).getLaptopModel());
    }

    /**
     * Updates the laptop model table, listing all of the current laptop models.
     */
    private void updateLaptopModelTable()
    {
        laptopManager.models.removeAll();
        Laptop[] tempLaptops = new Laptop[laptops.size()];
        for(Laptop e : laptops)tempLaptops[laptops.indexOf(e)] = e;
        laptopManager.models.setListData(tempLaptops);
    }

    /**
     * Updates the part table, listing all of the current parts for the current model.
     */
    private void updatePartTable()
    {
        laptopManager.parts.removeAll();
        Part[] tempParts = new Part[parts.size()];
        for(Part e : parts)tempParts[parts.indexOf(e)] = e;
        laptopManager.parts.setListData(tempParts);
    }

    /**
     * Gets the laptop prefixes for a given model.
     *
     * @param model the model for whom the prefixes belong to.
     * @return the array of prefixes.
     */
    private ArrayList getLaptopPrefixesForModel(String model)
    {
        ArrayList<String> identifiers = new ArrayList();

        try
        {
             File myDoc = FileManager.getAppSupportPath();
             String myDocString = myDoc.getPath() + "/" + "LaptopIdentifiers" + ".txt";
             Scanner scan = new Scanner(new File(myDocString));

             while (scan.hasNext()) {
                 String prefix = scan.nextLine();
                 model.toLowerCase();
                 prefix.toLowerCase();

                 int index = prefix.indexOf(":");
                 String name = prefix.substring(0, index);
                 name = name.toLowerCase();
                 
                 if(name.equalsIgnoreCase(model))
                 {
                     String id = prefix.substring(index+1, prefix.length());
                     id = id.toLowerCase();
                     identifiers.add(id);
                 }
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

        return identifiers;
    }

    /**
     * Saves all the laptop data to file, this includes any newly added/removed/changed laptops
     */
    private void saveLaptopDataToFile()
    {   
        String laptopModelsString = new String();
        String laptopPrefixesString = new String();

        for(Laptop tempLaptop : laptops)
        {
            laptopModelsString += tempLaptop.getLaptopModel() + ":" + tempLaptop.getLaptopModelNumber() + "\r\n";
            for(Object prefix : tempLaptop.getPrefixes())laptopPrefixesString += tempLaptop.getLaptopModel() + ":" + prefix + "\r\n";
        }

        File myDoc = FileManager.getAppSupportPath();
        String myLaptopListString = myDoc.getPath() + "/LaptopList.txt";
        String myLaptopPrefixesString = myDoc.getPath() + "/LaptopIdentifiers.txt";
        File laptopListFile = new File(myLaptopListString);
        File laptopPrefixesFile = new File(myLaptopPrefixesString);

        try
        {
            FileWriter fw = new FileWriter (laptopListFile);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter outFile = new PrintWriter (bw);
            System.out.println("call");
            outFile.println(laptopModelsString);
            outFile.close();

            FileWriter fw2 = new FileWriter (laptopPrefixesFile);
            BufferedWriter bw2 = new BufferedWriter (fw2);
            PrintWriter outFile2 = new PrintWriter (bw2);
            outFile2.println(laptopPrefixesString);
            outFile2.close();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: There was a problem saving laptop model.\nDescription: " + ex.toString());
            window.setVisible(true);
        }

    }

    /**
     * Saves the parts data to file, including any newly added/removed/changed parts.
     */
    private void savePartDataToFile()
    {
        String partsString = new String();

        for(Part tempPart : parts)
        {
            partsString += tempPart.getName() + ":" + tempPart.getFRU() + "\r\n";
        }

        File myDoc = FileManager.getAppSupportPath();
        String myPartListString = myDoc.getPath() + "/" + laptops.get(laptopManager.models.getSelectedIndex()).getLaptopModel() + ".txt";
        File partListFile = new File(myPartListString);

        try
        {
            FileWriter fw = new FileWriter (partListFile);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter outFile = new PrintWriter (bw);
            outFile.println(partsString);
            outFile.close();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: There was a problem saving the parts file.\nDescription: " + ex.toString());
            window.setVisible(true);
        }

    }

    /**
     * Creates a part file for a given laptop model if it does not already exist.
     *
     * @param the laptop model.
     */
    public void createPartFileForModel(String model)
    {
        File myDoc = FileManager.getAppSupportPath();
        String myLaptopListString = myDoc.getPath() + "\\" + model + ".txt";
        File laptopListFile = new File(myLaptopListString);

        if(laptopListFile.exists())return;

        try
        {
            FileWriter fw = new FileWriter (laptopListFile);
            BufferedWriter bw = new BufferedWriter (fw);
            PrintWriter outFile = new PrintWriter (bw);
            outFile.println("");
            outFile.close();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: There was a problem creating laptop part file.\nDescription: " + ex.toString());
            window.setVisible(true);
        }
    }

    /**
     * Removes the part file for a given laptop model.
     *
     * @param the laptop model.
     */
    public void removePartFileForModel(String model)
    {
        File myDoc = FileManager.getAppSupportPath();
        String myLaptopListString = myDoc.getPath() + "\\" + model + ".txt";
        File laptopListFile = new File(myLaptopListString);
        laptopListFile.delete();
    }

    /**
     * Gets the laptop list.
     *
     * @return the laptops list.
     */
    public ArrayList<Laptop>getLaptops()
    {
        return laptops;
    }

    /**
     * Gets the parts list.
     *
     * @return the parts list.
     */
    public ArrayList<Part>getParts()
    {
        return parts;
    }
}

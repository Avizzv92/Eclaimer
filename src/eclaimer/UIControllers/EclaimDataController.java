/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.UIControllers;

import eclaimer.BaseObjects.Eclaim;
import eclaimer.FileManager;
import eclaimer.GUI.EclaimDataPanel;
import eclaimer.GUI.AlertWindow;
import eclaimer.GlobalUpdater;

import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class EclaimDataController
{
    private EclaimDataPanel dataPanel;

     /**
     * Constructs an EclaimDataController object, passing the Eclaim Data Panel object it will be controlling.
     *
     * @param panel the EclaimDataPanel which contains all of the information going into the eclaim (claim number, laptop id, model, parts, ect...)
     * @return the EclaimDataController object.
     */
    public EclaimDataController(EclaimDataPanel panel)
    {
        dataPanel = panel;
        GlobalUpdater.getInstance().setDataPanel(panel);
        intialLoad();
    }

     /**
     * Called after the controller has been created. This gives the data panel default values for when Eclaimer first launches.
     */
    private void intialLoad()
    {
        try
        {
            File myDoc = FileManager.getAppSupportPath();
            String myDocString = myDoc.getPath() + "/LaptopList.txt";

            Scanner scan = new Scanner(new File(myDocString));

            while (scan.hasNext()) {
              String laptopModel = scan.nextLine();
              int index = laptopModel.indexOf(":");
              laptopModel = laptopModel.substring(0, index);
              dataPanel.laptopModelBox.addItem(laptopModel);
            }

            dataPanel.updatePartBoxes();

           scan.close();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Could not find any laptops, go to laptop management and add a new model.\nDescription: " + ex.toString());
            window.setLocation(new Point(0,0));
            window.setVisible(true);
        }

        clear();
    }

     /**
     * Creates a eclaim from the data collected from the eclaim data panel.
     *
     * @return the created eclaim.
     */
    public Eclaim getEclaim()
    {
        if(dataPanel.laptopID.getText().length() == 7 && dataPanel.descriptionTextArea.getText().length() > 0 && dataPanel.part1Box.getSelectedIndex() != 0
                && dataPanel.claimNumber.getText().length() > 0)
        {
            Eclaim claim = new Eclaim();

            claim.setClaimNumber(dataPanel.claimNumber.getText());

            claim.setLaptopID(dataPanel.laptopID.getText());

            claim.setLaptopModel(dataPanel.laptopModelBox.getSelectedItem().toString());

            if(dataPanel.part1Box.getSelectedIndex() != dataPanel.part1Box.getItemCount()-1)claim.setPart1(dataPanel.part1Box.getSelectedItem().toString());
            else claim.setPart1(":" + dataPanel.custom1.getText());

            if(dataPanel.part2Box.getSelectedIndex() != dataPanel.part2Box.getItemCount()-1)claim.setPart2(dataPanel.part2Box.getSelectedItem().toString());
            else claim.setPart2(":" + dataPanel.custom2.getText());

            if(dataPanel.part3Box.getSelectedIndex() != dataPanel.part3Box.getItemCount()-1)claim.setPart3(dataPanel.part3Box.getSelectedItem().toString());
            else claim.setPart3(":" + dataPanel.custom3.getText());

            claim.setIsProtec(dataPanel.protecCheck.isSelected());

            claim.setDescription(dataPanel.descriptionTextArea.getText());

            return claim;
        }

        else if(dataPanel.laptopID.getText().length() != 7)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Laptop ID is a 7 digit value.");
            window.setVisible(true);

            return null;
        }

        else if(dataPanel.descriptionTextArea.getText().length() <= 0)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: You must enter a description.");
            window.setVisible(true);

            return null;
        }

        else if(dataPanel.part1Box.getSelectedIndex() == 0)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: You must select atleast 1 part.");
            window.setVisible(true);

            return null;
        }

        else if(dataPanel.claimNumber.getText().length() <= 0)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: You must enter a Eclaim number.");
            window.setVisible(true);

            return null;
        }

        else return null;
    }

     /**
     * Loads the data panel to display the information contained within the eclaim.
     * This is basically used for editing an already created eclaim.
     *
     * @param eclaim the eclaim being edited and that the data panel should show data for.
     */
    public void setEclaim(Eclaim eclaim)
    {
        dataPanel.claimNumber.setText(eclaim.getClaimNumber());

       for(int i = 0; i < dataPanel.laptopModelBox.getItemCount(); i++)
       {
            if(dataPanel.laptopModelBox.getItemAt(i).toString().contains(eclaim.getLaptopModel()))dataPanel.laptopModelBox.setSelectedIndex(i);
       }

       dataPanel.laptopID.setText(eclaim.getLaptopID());

       for(int i = 0; i < dataPanel.part1Box.getItemCount(); i++)
           if(dataPanel.part1Box.getItemAt(i).toString().contains(eclaim.getPart1()))dataPanel.part1Box.setSelectedIndex(i);

       if(dataPanel.part1Box.getSelectedIndex() == 0 && !eclaim.getPart1().equalsIgnoreCase("None"))
       {
            dataPanel.part1Box.setSelectedIndex(dataPanel.part1Box.getItemCount()-1);
            dataPanel.custom1.setText(eclaim.getPart1().substring(1));
       }

       for(int i = 0; i < dataPanel.part2Box.getItemCount(); i++)
           if(dataPanel.part2Box.getItemAt(i).toString().contains(eclaim.getPart2()))dataPanel.part2Box.setSelectedIndex(i);

       if(dataPanel.part2Box.getSelectedIndex() == 0 && !eclaim.getPart2().equalsIgnoreCase("None"))
       {
            dataPanel.part2Box.setSelectedIndex(dataPanel.part2Box.getItemCount()-1);
            dataPanel.custom2.setText(eclaim.getPart2().substring(1));
       }

       for(int i = 0; i < dataPanel.part3Box.getItemCount(); i++)
           if(dataPanel.part3Box.getItemAt(i).toString().contains(eclaim.getPart3()))dataPanel.part3Box.setSelectedIndex(i);

       if(dataPanel.part3Box.getSelectedIndex() == 0 && !eclaim.getPart3().equalsIgnoreCase("None"))
       {
            dataPanel.part3Box.setSelectedIndex(dataPanel.part3Box.getItemCount()-1);
            dataPanel.custom3.setText(eclaim.getPart3().substring(1));
       }

        dataPanel.protecCheck.setSelected(eclaim.getIsProtec());
        dataPanel.descriptionTextArea.setText(eclaim.getProblemDescription());
    }

     /**
     * Gets the last used claim number from file. So when eclaimer launches it automatically
     * adjusts the claim number value for the user, so they don't have to remember.
     *
     * @return the last used claim number
     */
     public int getLastUsedClaimNumber()
    {
        Integer number = null;
        File fileName = new File(FileManager.getAppSupportPath().getPath()+"/ClaimNumberSetting");
	FileInputStream fis = null;
        ObjectInputStream in = null;

	try {
            fis = new FileInputStream(fileName);
            in = new ObjectInputStream(fis);
            number = (Integer) in.readObject();
            in.close();
	}

        catch (IOException ex) {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Missing support file, please restart program to regenerate file.");
            window.setVisible(true);
	}

        catch (ClassNotFoundException ex) {
	}

        return number.intValue();
    }

     /**
     * Saves the last used claim number to a file for later use, like when the program
     * re-launches. This will help the user not have to remember the last used claim number.
     *
     * @param number the claim number to save.
     */
    public void setLastUsedClaimNumber(int number)
    {
        File fileName = new File(FileManager.getAppSupportPath().getPath()+"/ClaimNumberSetting");

	FileOutputStream fos = null;
	ObjectOutputStream out = null;

        try {
		fos = new FileOutputStream(fileName);
		out = new ObjectOutputStream(fos);
		out.writeObject(new Integer(number));
                out.close();
	}

        catch (IOException ex) {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Missing support file, please restart program to regenerate file.");
            window.setVisible(true);
        }
    }

     /**
     * Resets all the values in the data panel to their defaults. 
     */
    public void clear()
    {
        dataPanel.laptopID.setText("");
        dataPanel.claimNumber.setText(""+(this.getLastUsedClaimNumber()+1));

        try
        {
            dataPanel.part1Box.setSelectedIndex(0);
            dataPanel.part2Box.setSelectedIndex(0);
            dataPanel.part3Box.setSelectedIndex(0);
        }

        catch(IllegalArgumentException e)
        {}

        dataPanel.custom1.setText("");
        dataPanel.custom2.setText("");
        dataPanel.custom3.setText("");
        dataPanel.protecCheck.setSelected(false);
        dataPanel.descriptionTextArea.setText("");
    }
}

/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.UIControllers;

import eclaimer.BaseObjects.ClaimSheet;
import eclaimer.FileManager;
import eclaimer.GUI.ClaimSheetDataPanel;
import eclaimer.GUI.AlertWindow;
import java.awt.Point;
import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class ClaimSheetDataController
{
    private ClaimSheetDataPanel dataPanel;
    private String editingClaimSheetDBID = null;

    /**
     * Creates a claim sheet data panel controller for a given claim sheet data panel.
     *
     * @param panel the panel to be controlled.
     */
    public ClaimSheetDataController(ClaimSheetDataPanel panel)
    {
        dataPanel = panel;
        intialLoad();
    }

    /**
     * Loads the UI in the data panel to default values.
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
      * Returns a generated claim sheet with the information gathered from the data panel.
      * @return the generated claim sheet.
      */

    public ClaimSheet getClaimSheet()
    {
        if(dataPanel.laptopID.getText().length() == 7 && dataPanel.descriptionTextArea.getText().length() > 0 && dataPanel.part1Box.getSelectedIndex() != 0)
        {
            ClaimSheet claim = new ClaimSheet();

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

            claim.setDate(dataPanel.date.getText());

            claim.setTrackingNumber("1Z-009-710-90-" + dataPanel.trackingNumber.getText());

            claim.setDBID(editingClaimSheetDBID);

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

        else return null;
    }

    /**
     * Sets the data panel to display the contents of a given claim sheet, used for editing a previously made claim sheet.
     *
     * @param claimSheet the claim sheet to edit.
     */
    public void setClaimSheet(ClaimSheet claimSheet)
    {
        dataPanel.claimNumber.setText(claimSheet.getClaimNumber());

       for(int i = 0; i < dataPanel.laptopModelBox.getItemCount(); i++)
       {
            if(dataPanel.laptopModelBox.getItemAt(i).toString().contains(claimSheet.getLaptopModel()))dataPanel.laptopModelBox.setSelectedIndex(i);
       }

       dataPanel.laptopID.setText(claimSheet.getLaptopID());

       for(int i = 0; i < dataPanel.part1Box.getItemCount(); i++)
           if(dataPanel.part1Box.getItemAt(i).toString().contains(claimSheet.getPart1()))dataPanel.part1Box.setSelectedIndex(i);

       if(dataPanel.part1Box.getSelectedIndex() == 0 && !claimSheet.getPart1().equalsIgnoreCase("None"))
       {
            dataPanel.part1Box.setSelectedIndex(dataPanel.part1Box.getItemCount()-1);
            dataPanel.custom1.setText(claimSheet.getPart1().substring(1));
       }

       for(int i = 0; i < dataPanel.part2Box.getItemCount(); i++)
           if(dataPanel.part2Box.getItemAt(i).toString().contains(claimSheet.getPart2()))dataPanel.part2Box.setSelectedIndex(i);

       if(dataPanel.part2Box.getSelectedIndex() == 0 && !claimSheet.getPart2().equalsIgnoreCase("None"))
       {
            dataPanel.part2Box.setSelectedIndex(dataPanel.part2Box.getItemCount()-1);
            dataPanel.custom2.setText(claimSheet.getPart2().substring(1));
       }

       for(int i = 0; i < dataPanel.part3Box.getItemCount(); i++)
           if(dataPanel.part3Box.getItemAt(i).toString().contains(claimSheet.getPart3()))dataPanel.part3Box.setSelectedIndex(i);

       if(dataPanel.part3Box.getSelectedIndex() == 0 && !claimSheet.getPart3().equalsIgnoreCase("None"))
       {
            dataPanel.part3Box.setSelectedIndex(dataPanel.part3Box.getItemCount()-1);
            dataPanel.custom3.setText(claimSheet.getPart3().substring(1));
       }

        dataPanel.protecCheck.setSelected(claimSheet.getIsProtec());
        dataPanel.descriptionTextArea.setText(claimSheet.getProblemDescription());
        dataPanel.date.setText(claimSheet.getDate());

        dataPanel.trackingNumber.setText(claimSheet.getTrackingNumber().replaceAll("1Z-009-710-90-", ""));

        editingClaimSheetDBID = claimSheet.getDBID();

        if(claimSheet.getClaimNumber().length() > 0)dataPanel.claimNumber.setEditable(true);
        else dataPanel.claimNumber.setEditable(false);
    }

    /**
     * Resets the data panel to default values and clears out text fields and such.
     */
    public void clear()
    {
        dataPanel.laptopID.setText("");
        dataPanel.claimNumber.setText("");

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
        dataPanel.date.setText("");
        dataPanel.trackingNumber.setText("");

        dataPanel.claimNumber.setEditable(false);
    }
}

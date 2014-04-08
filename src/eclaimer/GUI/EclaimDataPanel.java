/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.GUI;

import eclaimer.FileManager;
import java.awt.Point;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import eclaimer.Utilities.AutomaticLaptopIdentifier;
import eclaimer.Utilities.DamageDescriptionScreener;
import eclaimer.Utilities.HistoryCache;
import java.awt.Dimension;
import java.awt.Toolkit;

public class EclaimDataPanel extends javax.swing.JPanel {

    /** Creates new form EclaimDataPanel */
    public EclaimDataPanel()
    {
        initComponents();
        HistoryCache.loadCache();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        protecCheck = new javax.swing.JCheckBox();
        laptopModelBox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descriptionTextArea = new javax.swing.JTextArea();
        laptopID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        part1Box = new javax.swing.JComboBox();
        part2Box = new javax.swing.JComboBox();
        part3Box = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        custom1 = new javax.swing.JTextField();
        custom2 = new javax.swing.JTextField();
        custom3 = new javax.swing.JTextField();
        claimNumber = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setText("Laptop ID:");

        protecCheck.setText("Protec");
        protecCheck.setToolTipText("Is Protec Claim");

        laptopModelBox.setToolTipText("Laptop Model");
        laptopModelBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                laptopModelBoxActionPerformed(evt);
            }
        });

        jLabel2.setText("Laptop Model:");

        jLabel6.setText("Description");

        descriptionTextArea.setColumns(20);
        descriptionTextArea.setRows(5);
        descriptionTextArea.setToolTipText("Problem Description");
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                descriptionTextAreaKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(descriptionTextArea);

        laptopID.setToolTipText("7 Digit Laptop ID");
        laptopID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                laptopIDKeyTyped(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        part1Box.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                part1Selection(evt);
            }
        });

        part2Box.setToolTipText("Second Part");
        part2Box.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                part2Selection(evt);
            }
        });

        part3Box.setToolTipText("Third Part");
        part3Box.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                part3Selection(evt);
            }
        });

        jLabel3.setText("Part 1:");

        jLabel4.setText("Part 2:");

        jLabel5.setText("Part 3:");

        custom1.setToolTipText("Other FRU");
        custom1.setEnabled(false);

        custom2.setToolTipText("Other FRU");
        custom2.setEnabled(false);

        custom3.setToolTipText("Other FRU");
        custom3.setEnabled(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(part3Box, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(part2Box, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(part1Box, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(custom1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom2, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(custom3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(part1Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(custom1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(part2Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(custom2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(part3Box, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(custom3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        claimNumber.setToolTipText("Eclaim Number");

        jLabel7.setText("EClaim #:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(claimNumber)
                                    .addComponent(laptopModelBox, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(laptopID, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(protecCheck))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(claimNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laptopID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(laptopModelBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(protecCheck))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called when a laptop model has been selected.
     *
     * @param evt
     */
    private void laptopModelBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_laptopModelBoxActionPerformed
        this.updatePartBoxes();
        part2Box.setEnabled(false);
        part3Box.setEnabled(false);
    }//GEN-LAST:event_laptopModelBoxActionPerformed

    /**
     * Called when part 1 has been selected.
     *
     * @param evt
     */
    private void part1Selection(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_part1Selection

        if(part1Box.getSelectedIndex() > 0)
        {
            part2Box.setEnabled(true);
        }

        else
        {
            part2Box.setEnabled(false);
            if(part2Box.getItemCount()>0)part2Box.setSelectedIndex(0);
            part3Box.setEnabled(false);
            if(part3Box.getItemCount()>0)part3Box.setSelectedIndex(0);
        }
        
       if(part1Box.getSelectedIndex() == part1Box.getItemCount()-1 && part1Box.getItemCount() > 1)custom1.setEnabled(true);
       else
       {
            custom1.setEnabled(false);
            custom1.setText("");
       }
    }//GEN-LAST:event_part1Selection

    /**
     * Called when part 2 has been selected.
     *
     * @param evt
     */
    private void part2Selection(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_part2Selection

        if(part2Box.getSelectedIndex() > 0)
        {
            part3Box.setEnabled(true);
        }

        else
        {
            part3Box.setEnabled(false);
            if(part3Box.getItemCount()>0)part3Box.setSelectedIndex(0);
        }

        if(part2Box.getSelectedIndex() == part2Box.getItemCount()-1 && part2Box.getItemCount() > 1)custom2.setEnabled(true);

        else
        {
            custom2.setEnabled(false);
            custom2.setText("");
        }
    }//GEN-LAST:event_part2Selection

    /**
     * Called when part 3 is selected
     *
     * @param evt
     */
    private void part3Selection(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_part3Selection

       if(part3Box.getSelectedIndex() == part3Box.getItemCount()-1 && part3Box.getItemCount() > 1)custom3.setEnabled(true);
       else 
       {
           custom3.setEnabled(false);
           custom3.setText("");
       }
    }//GEN-LAST:event_part3Selection

    /**
     * Called when a laptop ID has been typed, checking the formatting and such.
     *
     * @param evt
     */
    private void laptopIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_laptopIDKeyTyped

        if(this.laptopID.getText().length() == 16) {
            int difference = this.laptopID.getText().length() - 7;
            laptopID.setText(this.laptopID.getText().substring(difference,this.laptopID.getText().length() - 0 ));
        }
        
        String laptopType = AutomaticLaptopIdentifier.idLaptopWithSN(laptopID.getText());
       if(laptopType != null)laptopModelBox.setSelectedItem(laptopType);
       
       if(this.laptopID.getText().length() >= 7 && evt.getKeyChar() != 8)
       {
           AutomaticLaptopIdentifier.isValid(laptopID.getText());
           HistoryCache.isOldEnough(laptopID.getText());
       }
    }//GEN-LAST:event_laptopIDKeyTyped

    /**
     * Called when a description has been typed, checking for proper wording.
     *
     * @param evt
     */
    private void descriptionTextAreaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descriptionTextAreaKeyReleased

        if(DamageDescriptionScreener.containsBadWord(descriptionTextArea.getText()) && !protecCheck.isSelected())
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Be careful with the words your using on a Non-Protec claim. You may want to use a different phrase... or make the claim a Protec if needed.");

            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
            int w = window.getSize().width;
            int h = window.getSize().height;
            int x = (dim.width-w)/2;
            int y = (dim.height-h)/2;
            window.setLocation(x, y);

            window.setVisible(true);
        }
    }//GEN-LAST:event_descriptionTextAreaKeyReleased

    /**
     * Updates the part boxes to the display the parts the correspond to the selected laptop model.
     */
    public void updatePartBoxes()
    {
        custom1.setEnabled(false);
        custom2.setEnabled(false);
        custom3.setEnabled(false);

        custom1.setText("");
        custom2.setText("");
        custom3.setText("");

        part1Box.removeAllItems();
        part2Box.removeAllItems();
        part3Box.removeAllItems();

        this.part1Box.addItem("None");
        this.part2Box.addItem("None");
        this.part3Box.addItem("None");

        try
        {
            File myDoc = FileManager.getAppSupportPath();
            String myDocString = myDoc.getPath() + "/"+this.laptopModelBox.getSelectedItem()+".txt";

            Scanner scan = new Scanner(new File(myDocString));

            ArrayList<String> tempPartList = new ArrayList();
            while (scan.hasNext()) {
                tempPartList.add(scan.nextLine());
            }
            Collections.sort(tempPartList);
            
            for(String part: tempPartList)
            {
                //int index = part.indexOf(":");
                //part = part.substring(0, index);
                
                this.part1Box.addItem(part);
                this.part2Box.addItem(part);
                this.part3Box.addItem(part);
            }
        }

        catch(IOException ex)
        {
            if(this.laptopModelBox.getSelectedItem() != null)
            {
                AlertWindow window = new AlertWindow();
                window.setErrorMessage("Error: Could not find the part list for the "+ this.laptopModelBox.getSelectedItem()+" model. Go to laptop management and add the desired parts for this model.\nDescription: " + ex.toString());
                window.setLocation(new Point(0,0));
                window.setVisible(true);
            }
        }

        this.part1Box.addItem("Other...");
        this.part2Box.addItem("Other...");
        this.part3Box.addItem("Other...");
    }

    /**
     * Updates the list of laptop models in the drop down menu.
     */
    public void updateLaptopList()
    {
        laptopModelBox.removeAllItems();
        
        try
        {
            File myDoc = FileManager.getAppSupportPath();
            String myDocString = myDoc.getPath() + "/LaptopList.txt";

            Scanner scan = new Scanner(new File(myDocString));

            while (scan.hasNext()) {
              String laptopModel = scan.nextLine();
              int index = laptopModel.indexOf(":");
              laptopModel = laptopModel.substring(0, index);
              laptopModelBox.addItem(laptopModel);
            }

            updatePartBoxes();
        }

        catch(IOException ex)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Could not find any laptops, go to laptop management and add a new model.\nDescription: " + ex.toString());
            window.setLocation(new Point(0,0));
            window.setVisible(true);
        }

        try {
            part1Box.setSelectedIndex(0);
            part2Box.setSelectedIndex(0);
            part3Box.setSelectedIndex(0);
        }

        catch(IllegalArgumentException e){}
        laptopID.setText("");
        custom1.setText("");
        custom2.setText("");
        custom3.setText("");
        protecCheck.setSelected(false);
        descriptionTextArea.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField claimNumber;
    public javax.swing.JTextField custom1;
    public javax.swing.JTextField custom2;
    public javax.swing.JTextField custom3;
    public javax.swing.JTextArea descriptionTextArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField laptopID;
    public javax.swing.JComboBox laptopModelBox;
    public javax.swing.JComboBox part1Box;
    public javax.swing.JComboBox part2Box;
    public javax.swing.JComboBox part3Box;
    public javax.swing.JCheckBox protecCheck;
    // End of variables declaration//GEN-END:variables

}

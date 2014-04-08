/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.GUI;

import eclaimer.GlobalUpdater;
import eclaimer.BaseObjects.Laptop;
import eclaimer.UIControllers.LaptopModelsController;
import eclaimer.BaseObjects.Part;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class LaptopManager extends javax.swing.JFrame {

    private LaptopModelsController laptopModelsController;

    public LaptopManager() {
        initComponents();
        laptopModelsController = new LaptopModelsController(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        description = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        parts = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        fru = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        models = new javax.swing.JList();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        model = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        modelNum = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        pref = new javax.swing.JTextField();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                didClose(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jButton1.setText("Save Part");
        jButton1.setToolTipText("Save part to file");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                savePart(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel2.setText("Part List:");

        jLabel4.setText("FRU:");

        jButton2.setText("Remove Part");
        jButton2.setToolTipText("Remove selected part");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removePart(evt);
            }
        });

        description.setToolTipText("Part description");

        parts.setToolTipText("Parts for selected model");
        parts.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                partSelected(evt);
            }
        });
        jScrollPane2.setViewportView(parts);

        jLabel3.setText("Description:");

        fru.setToolTipText("FRU number for the part");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(fru, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(description, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        models.setToolTipText("Current laptop models");
        models.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                laptopModelWasSelected(evt);
            }
        });
        jScrollPane1.setViewportView(models);

        jButton4.setText("Remove Model");
        jButton4.setToolTipText("Remove selected model");
        jButton4.setActionCommand("jButton3");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeModel(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11));
        jLabel1.setText("Laptop Models:");

        jLabel6.setText("Model #:");

        jLabel5.setText("Model:");

        model.setToolTipText("Model name");

        jLabel7.setText("Prefix Ident:");

        modelNum.setToolTipText("Model number");

        jButton3.setText("Save Model");
        jButton3.setToolTipText("Save the model to file");
        jButton3.setActionCommand("jButton3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addModel(evt);
            }
        });

        pref.setToolTipText("Prefix indentifiers");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(model, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modelNum, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pref, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(model, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(modelNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pref, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called when the use selects the add model button.
     *
     * @param evt
     */
    private void addModel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addModel

        if(this.model.getText().isEmpty() || this.modelNum.getText().isEmpty())
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Please be sure to fill in the model and model number.");
            window.setLocation(new Point(0,0));
            window.setVisible(true);
            return;
        }

        String prefsString = this.pref.getText().toUpperCase();

        String[] prefs = prefsString.split(" ");
        ArrayList tempPrefs = new ArrayList();
        tempPrefs.addAll(Arrays.asList(prefs));

        Laptop newLaptop = new Laptop(this.model.getText().toUpperCase(), this.modelNum.getText().toUpperCase(), tempPrefs);
        laptopModelsController.addLaptopModel(newLaptop);

        this.model.setText("");
        this.modelNum.setText("");
        this.pref.setText("");
    }//GEN-LAST:event_addModel

    /**
     * Called when the user selects the remove model button.
     *
     * @param evt
     */
    private void removeModel(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeModel
        int selectedIndices[] = models.getSelectedIndices();
        int chosenIndex = 0;
        if(selectedIndices.length > 0) chosenIndex = selectedIndices[0];
                
        Laptop chosenLaptop = laptopModelsController.getLaptops().get(chosenIndex);
        laptopModelsController.removeLaptopModel(chosenLaptop);

        this.model.setText("");
        this.modelNum.setText("");
        this.pref.setText("");
    }//GEN-LAST:event_removeModel

    /**
     * Called when the user selects the save part button.
     *
     * @param evt
     */
    private void savePart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savePart
        
        if(this.description.getText().isEmpty() || this.fru.getText().isEmpty())
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Error: Please be sure to fill in the part name and part FRU.");
            window.setLocation(new Point(0,0));
            window.setVisible(true);
            return;
        }

        Part newPart = new Part(this.description.getText(), this.fru.getText());
        laptopModelsController.addLaptopPart(newPart);

        this.description.setText("");
        this.fru.setText("");
    }//GEN-LAST:event_savePart

    /**
     * Called when the user selects the remove part button.
     *
     * @param evt
     */
    private void removePart(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removePart
        int selectedIndices[] = parts.getSelectedIndices();
        int chosenIndex = 0;
        if(selectedIndices.length > 0) chosenIndex = selectedIndices[0];

        Part chosenPart = laptopModelsController.getParts().get(chosenIndex);
        laptopModelsController.removePart(chosenPart);

        this.description.setText("");
        this.fru.setText("");
    }//GEN-LAST:event_removePart

    /**
     * Called when a laptop model was selected from the list of laptop models in the drop down menu.
     * @param evt
     */
    private void laptopModelWasSelected(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_laptopModelWasSelected
        int selectedIndices[] = models.getSelectedIndices();
        int chosenIndex = 0;
        if(selectedIndices.length > 0) chosenIndex = selectedIndices[0];
        if(laptopModelsController.getLaptops().isEmpty()) return;

        Laptop chosenLaptop = laptopModelsController.getLaptops().get(chosenIndex);

        model.setText(chosenLaptop.getLaptopModel());
        modelNum.setText(chosenLaptop.getLaptopModelNumber());

        String prefixString = new String();
        for(Object prefix : chosenLaptop.getPrefixes())prefixString += prefix + " ";
        pref.setText(prefixString);

        laptopModelsController.populatePartListForModel(chosenLaptop.getLaptopModel());
    }//GEN-LAST:event_laptopModelWasSelected

    /**
     * Called when a part has been selected from the drop down menu.
     *
     * @param evt
     */
    private void partSelected(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_partSelected
        int selectedIndices[] = parts.getSelectedIndices();
        int chosenIndex = 0;
        if(selectedIndices.length > 0) chosenIndex = selectedIndices[0];
        if(laptopModelsController.getParts().isEmpty()) return;

        Part chosenPart = laptopModelsController.getParts().get(chosenIndex);

        description.setText(chosenPart.getName());
        fru.setText(chosenPart.getFRU());
    }//GEN-LAST:event_partSelected

    /**
     * Called when the window has closed. This is used to update the main menu.
     */
    private void didClose(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_didClose
        GlobalUpdater.getInstance().getDataPanel().updateLaptopList();
    }//GEN-LAST:event_didClose


    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LaptopManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField description;
    private javax.swing.JTextField fru;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField model;
    private javax.swing.JTextField modelNum;
    public javax.swing.JList models;
    public javax.swing.JList parts;
    private javax.swing.JTextField pref;
    // End of variables declaration//GEN-END:variables

}

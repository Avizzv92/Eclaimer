/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.GUI;
import eclaimer.UIControllers.EclaimDataController;
import eclaimer.BaseObjects.Eclaim;
import java.util.ArrayList;
import eclaimer.*;

public class TablePanel extends javax.swing.JPanel {

    public EclaimDataController dataController;
    private ArrayList<Eclaim> allEclaims = new ArrayList();

    /** Creates new form TablePanel */
    public TablePanel() {
        initComponents();
        GlobalUpdater.getInstance().setTablePanel(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        addButton = new javax.swing.JButton();
        removeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        eclaimList = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        addButton.setText("Add / Update");
        addButton.setToolTipText("Add New EClaim");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setToolTipText("Remove Selected EClaim");
        removeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeButtonActionPerformed(evt);
            }
        });

        eclaimList.setMaximumSize(new java.awt.Dimension(90000000, 900000000));
        eclaimList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                eclaimListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(eclaimList);

        jLabel1.setText("All Eclaims");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(removeButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called when the user selects a new row from the table.
     */
    private void eclaimListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eclaimListValueChanged
        if(this.eclaimList.getSelectedValue()!=null)dataController.setEclaim((Eclaim)this.eclaimList.getSelectedValue());
    }//GEN-LAST:event_eclaimListValueChanged

    /**
     * Called when the mouse clicks the form. Resetting table selection and data panel information.
     *
     * @param evt
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.eclaimList.clearSelection();
        dataController.clear();
    }//GEN-LAST:event_formMouseClicked

    /**
     * Called to add an eclaim manually (bypassing the eclaim data panel entry method) this is a way of doing it with straight code.
     *
     * @param currentEclaim
     */
    public void addEclaimManually(Eclaim currentEclaim)
    {
        if(currentEclaim != null)
        {
            if(this.eclaimList.getSelectedValue() == null)
            {
                allEclaims.add(currentEclaim);

                if(allEclaims.size() > 30)
                {
                    AlertWindow window = new AlertWindow();
                    window.setErrorMessage("Caution: Adding more than 30 claims may not be supported.");
                    window.setVisible(true);
                }

                updateTable();
            }

            else
            {
                this.removeButtonActionPerformed(null);
                allEclaims.add(currentEclaim);

                updateTable();
            }

            dataController.setLastUsedClaimNumber(Integer.parseInt(currentEclaim.getClaimNumber()));
            dataController.clear();
        }
    }

    /**
     * Called when the user selects the add button.
     *
     * @param evt
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Eclaim currentEclaim = dataController.getEclaim();

        if(currentEclaim != null)
        {
            if(this.eclaimList.getSelectedValue() == null)
            {
                if(this.isDuplicate(currentEclaim.getLaptopID()))
                {
                    AlertWindow window = new AlertWindow();
                    window.setErrorMessage("Caution: A laptop with that serial number has already been used in this claim, consider deleting one of them.");
                    window.setVisible(true);
                }
                
                allEclaims.add(currentEclaim);

                if(allEclaims.size() > 30)
                {
                    AlertWindow window = new AlertWindow();
                    window.setErrorMessage("Caution: Adding more than 30 claims may not be supported.");
                    window.setVisible(true);
                }

                updateTable();
            }

            else
            {
                this.removeButtonActionPerformed(null);
                allEclaims.add(currentEclaim);
                
                updateTable();
            }
            
            dataController.setLastUsedClaimNumber(Integer.parseInt(currentEclaim.getClaimNumber()));
            dataController.clear();
        }
}//GEN-LAST:event_addButtonActionPerformed

    /**
     * Called when the user selects the remove button.
     *
     * @param evt
     */
    private void removeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeButtonActionPerformed

        if(this.eclaimList.getSelectedValue() != null)
        {
            allEclaims.remove((Eclaim)this.eclaimList.getSelectedValue());
            updateTable();
            dataController.clear();
        }
}//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Sets the data controller which will manage the UI and actions.
     *
     * @param controller the controller to be set.
     */
    public void setDataController(EclaimDataController controller)
    {
        dataController = controller;
    }

    /**
     * Gets all of the eclaims that are in the table.
     *
     * @return an array of eclaims.
     */
    public ArrayList<Eclaim> getAllEclaims()
    {
        return allEclaims;
    }

    /**
     * Sets all the eclaims to be in the table
     *
     * @param claims the array of eclaims.
     */
    public void setAllEclaims(ArrayList<Eclaim> claims)
    {
        allEclaims = claims;
        updateTable();
    }

    /**
     * Called to create a new eclaim.
     */
    public void newClaim()
    {
        allEclaims = new ArrayList();
        dataController.clear();
        updateTable();
    }

    /**
     * Updates the table data.
     */
    private void updateTable()
    {
        Eclaim[] tempEclaims = new Eclaim[allEclaims.size()];
        for(Eclaim e : allEclaims)tempEclaims[allEclaims.indexOf(e)] = e;
        this.eclaimList.setListData(tempEclaims);
    }
    
    private boolean isDuplicate(String sn)
    {
        for(Eclaim e : allEclaims)
        {
            if(e.getLaptopID().compareToIgnoreCase(sn) == 0)
            {
                return true;
            }
        }
        
        return false;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JList eclaimList;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton removeButton;
    // End of variables declaration//GEN-END:variables

}

/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.GUI;
import eclaimer.UIControllers.ClaimSheetDataController;
import eclaimer.BaseObjects.ClaimSheet;
import java.util.ArrayList;
import eclaimer.*;

public class ClaimTablePanel extends javax.swing.JPanel {

    public ClaimSheetDataController dataController;
    private ClaimSheetSearchPanel searchPanel;
    private ArrayList<ClaimSheet> allClaimSheets = new ArrayList();
    private DatabaseManager dm = new DatabaseManager();

    /** Creates new form TablePanel */
    public ClaimTablePanel() {
        initComponents();
        this.updateTable();
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
        addButton.setToolTipText("Add New Claim Sheet");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        removeButton.setText("Remove");
        removeButton.setToolTipText("Remove Selected ClaimSheet");
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

        jLabel1.setText("Claim Sheets For Search Parameters");

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
     * Called when a row from the table has been selected.
     *
     * @param evt
     */
    private void eclaimListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_eclaimListValueChanged
        if(this.eclaimList.getSelectedValue()!=null)dataController.setClaimSheet((ClaimSheet)this.eclaimList.getSelectedValue());
    }//GEN-LAST:event_eclaimListValueChanged

    /**
     * Called when the mouse clicks the form, resetting the selection of the table and values in data panel.
     *
     * @param evt
     */
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        this.eclaimList.clearSelection();
        dataController.clear();
    }//GEN-LAST:event_formMouseClicked

    /**
     * Called when the user select the Add/Update button
     *
     * @param evt
     */
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        ClaimSheet currentEclaim = dataController.getClaimSheet();

        if(currentEclaim != null)
        {
            if(this.eclaimList.getSelectedValue() == null)
            {
                dm.addClaimSheet(currentEclaim);

                updateTable();
            }

            else
            {
                dm.updateClaimSheet(currentEclaim);
                
                updateTable();
            }
            
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
            dm.removeClaimSheet((ClaimSheet)this.eclaimList.getSelectedValue());
            updateTable();
            dataController.clear();
        }
}//GEN-LAST:event_removeButtonActionPerformed

    /**
     * Sets the claim sheet data controller, giving us a reference to the object that manages the data panel.
     *
     * @param controller
     */
    public void setDataController(ClaimSheetDataController controller)
    {
        dataController = controller;
    }

    /**
     * Sets the search panel , giving us a reference to the search panel.
     *
     * @param theSearchPanel
     */
    public void setSearchPanel(ClaimSheetSearchPanel theSearchPanel)
    {
        searchPanel = theSearchPanel;
    }

    /**
     * Returns a list of all the claim sheets currently in the table.
     *
     * @return the claim sheets in the table.
     */
    public ArrayList<ClaimSheet> getAllClaimSheets()
    {
        return allClaimSheets;
    }

    /**
     * Sets all of the claim sheets that are to appear in the table.
     *
     * @param claims an array of claim sheets.
     */
    public void setAllClaimSheets(ArrayList<ClaimSheet> claims)
    {
        allClaimSheets = claims;
        updateTable();
    }

    /**
     * Unused, possibly should deprecate.
     */
    public void newClaim()
    {
        allClaimSheets = new ArrayList();
        dataController.clear();
        updateTable();
    }

    /**
     * Called to update the table and its contents.
     */
    public void updateTable()
    {
        allClaimSheets.removeAll(allClaimSheets);

        if(searchPanel != null)allClaimSheets = dm.getClaimSheetsForSearchParameters(searchPanel.startDate.getText(), searchPanel.endDate.getText(), searchPanel.startClaimNumber.getText(), searchPanel.endClaimNumber.getText(), searchPanel.laptopID.getText(), searchPanel.trackingNumber.getText(), searchPanel.hideClaimed.isSelected());
        else allClaimSheets = dm.getClaimSheetsForSearchParameters(null, null, null, null, null, null, true);

        ClaimSheet[] tempEclaims = new ClaimSheet[allClaimSheets.size()];
        for(ClaimSheet e : allClaimSheets)tempEclaims[allClaimSheets.indexOf(e)] = e;
        this.eclaimList.setListData(tempEclaims);
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

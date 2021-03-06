/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.GUI;

import eclaimer.FileManager;
import java.awt.Desktop;
import java.io.File;
import javax.swing.JFileChooser;

public class MenuBarPanel extends javax.swing.JPanel {

    /** Creates new form MenuBarPanel */
    public MenuBarPanel() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        save = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JToolBar.Separator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuBar4 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenu8 = new javax.swing.JMenu();
        jMenuBar5 = new javax.swing.JMenuBar();
        jMenu9 = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jFrame1 = new javax.swing.JFrame();
        jFrame2 = new javax.swing.JFrame();
        jMenuBar6 = new javax.swing.JMenuBar();
        jMenu11 = new javax.swing.JMenu();
        jMenu12 = new javax.swing.JMenu();
        jFrame3 = new javax.swing.JFrame();
        jFrame4 = new javax.swing.JFrame();
        jFrame5 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        jToolBar1 = new javax.swing.JToolBar();
        newClaim = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        open = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        jButton1 = new javax.swing.JButton();

        save.setText("Save");
        save.setToolTipText("Save Claim List");
        save.setFocusPainted(false);
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        jMenu7.setText("File");
        jMenuBar4.add(jMenu7);

        jMenu8.setText("Edit");
        jMenuBar4.add(jMenu8);

        jMenu9.setText("File");
        jMenuBar5.add(jMenu9);

        jMenu10.setText("Edit");
        jMenuBar5.add(jMenu10);

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jMenu11.setText("File");
        jMenuBar6.add(jMenu11);

        jMenu12.setText("Edit");
        jMenuBar6.add(jMenu12);

        javax.swing.GroupLayout jFrame3Layout = new javax.swing.GroupLayout(jFrame3.getContentPane());
        jFrame3.getContentPane().setLayout(jFrame3Layout);
        jFrame3Layout.setHorizontalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame3Layout.setVerticalGroup(
            jFrame3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame4Layout = new javax.swing.GroupLayout(jFrame4.getContentPane());
        jFrame4.getContentPane().setLayout(jFrame4Layout);
        jFrame4Layout.setHorizontalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame4Layout.setVerticalGroup(
            jFrame4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jFrame5Layout = new javax.swing.GroupLayout(jFrame5.getContentPane());
        jFrame5.getContentPane().setLayout(jFrame5Layout);
        jFrame5Layout.setHorizontalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame5Layout.setVerticalGroup(
            jFrame5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        jLabel1.setText("jLabel1");

        setBackground(new java.awt.Color(153, 153, 153));

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);
        jToolBar1.setFocusable(false);

        newClaim.setText("New");
        newClaim.setToolTipText("New Claim List");
        newClaim.setFocusPainted(false);
        newClaim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newClaimActionPerformed(evt);
            }
        });
        jToolBar1.add(newClaim);

        jButton3.setText("Laptop Management");
        jButton3.setToolTipText("Manage laptop models and parts");
        jButton3.setFocusable(false);
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openLaptopManagement(evt);
            }
        });
        jToolBar1.add(jButton3);

        jButton4.setText("Claim Sheets");
        jButton4.setFocusable(false);
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openClaimSheetsMenu(evt);
            }
        });
        jToolBar1.add(jButton4);
        jToolBar1.add(jSeparator1);

        open.setText("Open CSV");
        open.setToolTipText("Open Saved Claim List");
        open.setFocusPainted(false);
        open.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openCSVFile(evt);
            }
        });
        jToolBar1.add(open);

        jButton2.setText("Export CSV");
        jButton2.setToolTipText("Export Claim to CSV file");
        jButton2.setFocusable(false);
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportToCSV(evt);
            }
        });
        jToolBar1.add(jButton2);
        jToolBar1.add(jSeparator2);

        jButton1.setText("Help");
        jButton1.setToolTipText("Easy to follow instructions.");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                helpSelected(evt);
            }
        });
        jToolBar1.add(jButton1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Called when the user selects the new claim button.
     *
     * @param evt
     */
    private void newClaimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newClaimActionPerformed
        fm.shouldMakeNew();
    }//GEN-LAST:event_newClaimActionPerformed

    /*
     * Called when the user selects the save button.
     *
     */
    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        
    }//GEN-LAST:event_saveActionPerformed

    /**
     * Called when the user selects the open button.
     *
     * @param evt
     */
    private void openCSVFile(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openCSVFile
        File saveClaimFolder = new File(FileManager.getDocumentsPath().getPath());
        File saveToIDrivePath = new File("P:/Helpdesk/Eclaimer/Batch Claims");

        JFileChooser fc = new JFileChooser();
        if(saveToIDrivePath.exists())fc.setCurrentDirectory(saveToIDrivePath);
        else if(saveClaimFolder.exists())fc.setCurrentDirectory(saveClaimFolder);
        fc.showOpenDialog(null);

        if(fc.getSelectedFile() == null)return;
        
        if(fc.getSelectedFile().toString().contains(".csv") != true && fc.getSelectedFile().toString().contains(".CSV") != true)
        {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage("File type is unsupported.");
            window.setVisible(true);
            return;
        }

        if(fc.getSelectedFile()!=null)fm.shouldOpen(fc.getSelectedFile().getPath());
    }//GEN-LAST:event_openCSVFile

    /**
     * Called when the user selects the help button.
     *
     * @param evt
     */
    private void helpSelected(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_helpSelected

        try {
            Desktop.getDesktop().open(new File(FileManager.getAppSupportPath().getPath()+"/EclaimerHelp.pdf"));
        } catch (Exception ex) {
            AlertWindow window = new AlertWindow();
            window.setErrorMessage(ex.toString());
            window.setVisible(true);
        }

    }//GEN-LAST:event_helpSelected

    /**
     * Called when the user requests to export to a CSV file.
     *
     * @param evt
     */
    private void exportToCSV(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportToCSV
        File saveClaimFolder = new File(FileManager.getDocumentsPath().getPath());
        File saveToIDrivePath = new File("P:/Helpdesk/Eclaimer/Batch Claims");

        JFileChooser fc = new JFileChooser();
        if(saveToIDrivePath.exists())fc.setCurrentDirectory(saveToIDrivePath);
        else if(saveClaimFolder.exists())fc.setCurrentDirectory(saveClaimFolder);

        fc.showSaveDialog(null);
        if(fc.getSelectedFile()!=null)
        {
            fm.shouldExportCSV(fc.getSelectedFile().getPath());
        }
    }//GEN-LAST:event_exportToCSV

    /**
     * Called when the user selects the open laptop management button.
     *
     * @param evt
     */
    private void openLaptopManagement(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openLaptopManagement
        LaptopManager laptopManager = new LaptopManager();
        laptopManager.setTitle("Laptop Management");
        laptopManager.setVisible(true);
        laptopManager.setLocationRelativeTo(null);
    }//GEN-LAST:event_openLaptopManagement

    /**
     * Called when the user selects the open claim sheets button.
     * @param evt
     */
    private void openClaimSheetsMenu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openClaimSheetsMenu
        ClaimSheetManager claimSheetManager = new ClaimSheetManager();
        claimSheetManager.setTitle("Claim Sheet Management");
        claimSheetManager.setVisible(true);
        claimSheetManager.setLocationRelativeTo(null);
}//GEN-LAST:event_openClaimSheetsMenu

    /**
     * Sets a reference to a file manager.
     *
     * @param manager the file manager.
     */
    public void setFileManager(eclaimer.FileManager manager)
    {
        fm = manager;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JFrame jFrame3;
    private javax.swing.JFrame jFrame4;
    private javax.swing.JFrame jFrame5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenu jMenu11;
    private javax.swing.JMenu jMenu12;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenu jMenu8;
    private javax.swing.JMenu jMenu9;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JMenuBar jMenuBar4;
    private javax.swing.JMenuBar jMenuBar5;
    private javax.swing.JMenuBar jMenuBar6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar.Separator jSeparator3;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton newClaim;
    private javax.swing.JButton open;
    private javax.swing.JButton save;
    // End of variables declaration//GEN-END:variables
    private FileManager fm;
}

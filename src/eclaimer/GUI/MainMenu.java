/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.GUI;

import eclaimer.UIControllers.EclaimDataController;
import eclaimer.FileManager;
import eclaimer.Utilities.AutomaticLaptopIdentifier;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import javax.swing.ImageIcon;

public class MainMenu extends javax.swing.JFrame {

    /** Creates new form MainMenu */
    public MainMenu() {
        initComponents();
        setUpSupportFiles();
        
        dataController = new EclaimDataController(eclaimDataPanel);
        tablePanel.setDataController(dataController);
        fm = new FileManager(tablePanel);
        menuPanel.setFileManager(fm);

        try {
            ImageIcon icon = new javax.swing.ImageIcon(getClass().getResource("EC.png"));
            this.setIconImage(icon.getImage());
        } catch (Exception e) {
        }
    }

    /**
     * Sets up the basic support files and or checks there existence so Eclaimer can run properly.
     */
    private void setUpSupportFiles()
    {
        AutomaticLaptopIdentifier.loadData();
        
        File fileName = new File(FileManager.getAppSupportPath().getPath()+"/ClaimNumberSetting");

        if(!fileName.exists())
        {
            FileOutputStream fos = null;
            ObjectOutputStream out = null;

            try {
                    fos = new FileOutputStream(fileName);
                    out = new ObjectOutputStream(fos);
                    out.writeObject(new Integer(0));
                    out.close();
            }

            catch (IOException ex) {
            }
        }

        File appSupportFolder = FileManager.getAppSupportPath();
        if (! appSupportFolder.exists())
            appSupportFolder.mkdir();

        File saveClaimFolder = new File(appSupportFolder.getPath()+"/Claims");
        if(! saveClaimFolder.exists())
            saveClaimFolder.mkdir();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        eclaimDataPanel = new eclaimer.GUI.EclaimDataPanel();
        tablePanel = new eclaimer.GUI.TablePanel();
        menuPanel = new eclaimer.GUI.MenuBarPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("EClaimer");
        setBackground(new java.awt.Color(251, 249, 249));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setIconImages(null);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eclaimDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 876, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(eclaimDataPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addComponent(tablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, 432, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private eclaimer.GUI.EclaimDataPanel eclaimDataPanel;
    public eclaimer.GUI.MenuBarPanel menuPanel;
    public eclaimer.GUI.TablePanel tablePanel;
    // End of variables declaration//GEN-END:variables
    private EclaimDataController dataController;
    private FileManager fm;
}

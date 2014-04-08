/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer;

import eclaimer.BaseObjects.ClaimSheet;
import eclaimer.GUI.AlertWindow;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DatabaseManager
{
    //Database log in information, self explanatory.
    static final String URL = "jdbc:mysql://10.0.1.233/Eclaimer";
    static final String USER = "test";
    static final String PASSWORD = "evergreen";
    static final String DRIVER = "com.mysql.jdbc.Driver";

    static final String MAX_DATE_DEFAULT = "2200-01-01";
    static final String MIN_DATE_DEFAULT = "1776-01-01";

    Connection conn = null;

    /**
     * Creates a connection to the database using the login information provided above.
     *
     * @return the connection generated.
     * @throws SQLException
     */
    public Connection getConnection() throws SQLException {
      Connection con = null;
      try {
         Class.forName(DRIVER);
         con = DriverManager.getConnection(URL, USER, PASSWORD);
      }
      catch(ClassNotFoundException e) {
         System.out.println(e.getMessage());
         System.exit(-1);
      }

      return con;
   }

    /**
     * Returns a list of all claim sheets fitting the search parameters being passed in.
     *
     * @param startDate the start date for the search contents.
     * @param endDate the end date for the search contents.
     * @param claimNumber the claim number for the search contents.
     * @param laptopID the laptop id for the search contents.
     * @param trackingNumber the tracking number for the search contents.
     * @param claimed indicates whether to include claim sheets that have already been claimed.
     * @return the claim sheets fitting the pre-described descriptions.
     */
    public ArrayList<ClaimSheet> getClaimSheetsForSearchParameters(String startDate, String endDate, String startClaimNumber, String endClaimNumber, String laptopID, String trackingNumber, boolean claimed)
    {
        ArrayList<ClaimSheet> foundClaimedSheets = new ArrayList();

        String oldStartClaimNumber = startClaimNumber;
        String oldEndClaimNumber = endClaimNumber;
        
        startDate = (startDate == null || startDate.equalsIgnoreCase("")) ? MIN_DATE_DEFAULT : startDate;
        endDate = (endDate == null || endDate.equalsIgnoreCase("")) ? MAX_DATE_DEFAULT : endDate;
        startClaimNumber = (startClaimNumber == null || startClaimNumber.equalsIgnoreCase("")) ? "0" : startClaimNumber;
        endClaimNumber = (endClaimNumber == null || endClaimNumber.equalsIgnoreCase("")) ? "999999999999999" : endClaimNumber;
        laptopID = (laptopID == null || laptopID.equalsIgnoreCase("")) ? "" : laptopID;
        trackingNumber = (trackingNumber == null || trackingNumber.equalsIgnoreCase("")) ? "" : trackingNumber;

        String query;
        if(claimed)query = "SELECT * FROM claimsheets WHERE LaptopID LIKE '%" + laptopID + "%' AND trackingNumber LIKE '%" + trackingNumber + "%' AND LENGTH(EclaimNumber) = 0 " + " AND DateCompleted >= '" + startDate + "' AND DateCompleted <= '" + endDate + "'";
        else 
        {
            if(oldStartClaimNumber.length() > 0 && oldEndClaimNumber.length() > 0)query = "SELECT * FROM claimsheets WHERE (case when LENGTH(EclaimNumber) > 0 then case when EclaimNumber >= '" + startClaimNumber + "' AND EclaimNumber <= '" + endClaimNumber + "' then 1 else 0 end else 0 end) = 1 AND LaptopID LIKE '%" + laptopID + "%' AND trackingNumber LIKE '%" + trackingNumber + "%' AND DateCompleted >= '" + startDate + "' AND DateCompleted <= '" + endDate + "'";
            else query = "SELECT * FROM claimsheets WHERE (case when LENGTH(EclaimNumber) > 0 then case when EclaimNumber >= '" + startClaimNumber + "' AND EclaimNumber <= '" + endClaimNumber + "' then 1 else 0 end else 1 end) = 1 AND LaptopID LIKE '%" + laptopID + "%' AND trackingNumber LIKE '%" + trackingNumber + "%' AND DateCompleted >= '" + startDate + "' AND DateCompleted <= '" + endDate + "'";
        }

        try{
             Statement s = getConnection().createStatement();
             ResultSet rs = s.executeQuery(query);

              while (rs.next())
              {
                  ClaimSheet newClaimSheet = new ClaimSheet();
                  newClaimSheet.setDBID(""+rs.getInt("id"));
                  newClaimSheet.setClaimNumber(rs.getString("EclaimNumber"));
                  newClaimSheet.setLaptopID(rs.getString("LaptopID"));
                  newClaimSheet.setLaptopModel(rs.getString("LaptopModel"));
                  newClaimSheet.setPart1(rs.getString("Part1"));
                  newClaimSheet.setPart2(rs.getString("Part2"));
                  newClaimSheet.setPart3(rs.getString("Part3"));
                  String dateCompleted = (rs.getString("DateCompleted").equals(MAX_DATE_DEFAULT) || rs.getString("DateCompleted").equals(MIN_DATE_DEFAULT)) ? "" : rs.getString("DateCompleted");
                  newClaimSheet.setDate(dateCompleted);
                  newClaimSheet.setTrackingNumber(rs.getString("TrackingNumber"));
                  newClaimSheet.setIsProtec(rs.getBoolean("Protec"));
                  newClaimSheet.setDescription(rs.getString("ProblemDescription"));
                  foundClaimedSheets.add(newClaimSheet);
              }
              s.close();
        }

        catch (Exception e)
        {
            System.err.println(e.getMessage());

            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Problems interacting with the database, check your internet connection: " + e.toString());
            window.setVisible(true);
        }

        return foundClaimedSheets;
    }

    /**
     * Adds a new claim sheet to the database.
     *
     * @param newClaimSheet the claim sheet to add.
     */
    public void addClaimSheet(ClaimSheet newClaimSheet)
    {
        if(newClaimSheet.getDate().equals(""))newClaimSheet.setDate(MIN_DATE_DEFAULT);

        try {
            Statement s = getConnection().createStatement();
            s.executeUpdate("INSERT INTO `claimsheets`(`EclaimNumber`, `LaptopID`, `LaptopModel`, `Part1`, `Part2`, `Part3`, `DateCompleted`, `TrackingNumber`, `Protec`, `ProblemDescription`) VALUES ('"
                 + newClaimSheet.getClaimNumber() + "','" + newClaimSheet.getLaptopID() + "','" + newClaimSheet.getLaptopModel() + "','" + newClaimSheet.getPart1()
                    + "','" + newClaimSheet.getPart2() + "','" + newClaimSheet.getPart3() + "',STR_TO_DATE('" + newClaimSheet.getDate() + "', '%Y-%m-%d')" + ",'" + newClaimSheet.getTrackingNumber() + "',"
                    + newClaimSheet.getIsProtec() + ",'" + newClaimSheet.getProblemDescription() + "')");
            s.close();
        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());

            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Problems interacting with the database, check your internet connection: " + e.toString());
            window.setVisible(true);
        }
    }

    /**
     * Updates a claim sheet on the database.
     *
     * @param claimSheet the updated claim sheet to update on database.
     */
    public void updateClaimSheet(ClaimSheet claimSheet)
    {
        if(claimSheet.getDate() == null || claimSheet.getDate().equals(""))claimSheet.setDate(MIN_DATE_DEFAULT);
        
        try {
            Statement s = getConnection().createStatement();
            s.executeUpdate("UPDATE `claimsheets` SET " +
                 "`EclaimNumber`='" + claimSheet.getClaimNumber() + "',`LaptopID`='" + claimSheet.getLaptopID() + "',`LaptopModel`='" + claimSheet.getLaptopModel()
                    + "',`Part1`='" + claimSheet.getPart1() +  "',`Part2`='" + claimSheet.getPart2() +  "',`Part3`='" + claimSheet.getPart3()
                    + "',`DateCompleted`=" + "STR_TO_DATE('" + claimSheet.getDate() + "', '%Y-%m-%d')" + ",`TrackingNumber`='" + claimSheet.getTrackingNumber() + "',`Protec`=" + claimSheet.getIsProtec() + ",`ProblemDescription`='" + claimSheet.getProblemDescription() +  "' WHERE id =" + claimSheet.getDBID());
            s.close();
        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());

            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Problems interacting with the database, check your internet connection: " + e.toString());
            window.setVisible(true);
        }
    }

    /**
     * Removes a given claim sheet from the database.
     *
     * @param claimSheet the claim sheet to remove.
     */
    public void removeClaimSheet(ClaimSheet claimSheet)
    {
        try {
            Statement s = getConnection().createStatement();
            s.executeUpdate("DELETE FROM claimsheets WHERE id = " + claimSheet.getDBID());
            s.close();
        }

        catch(SQLException e)
        {
            System.out.println(e.getMessage());

            AlertWindow window = new AlertWindow();
            window.setErrorMessage("Problems interacting with the database, check your internet connection: " + e.toString());
            window.setVisible(true);
        }
    }

    /**
     * Returns a formatted date string indicating the current date.
     *
     * @return the formatted date string.
     */
    private String defaultStartDateString()
    {
        String DATE_FORMAT_NOW = "yyyy-MM-dd";

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);

        cal.set(Calendar.MONTH, Calendar.MONTH-1);

        return sdf.format(cal.getTime());
    }
}

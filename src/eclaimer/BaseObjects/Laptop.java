/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.BaseObjects;

import java.util.ArrayList;

public class Laptop implements Comparable<Laptop>
{
    private String laptopModel;
    private String laptopModelNumber;
    private ArrayList prefixes;
    private ArrayList parts;

    /**
     * The default Eclaim constructor
     *
     * @return a default Eclaim object.
     */
    public Laptop()
    {
        laptopModel = null;
        laptopModelNumber = null;
        prefixes = null;
        parts = null;
    }

    /**
     * Returns a fully defined laptop.
     *
     * @param model the model of the laptop.
     * @param number the model number of the laptop.
     * @param laptopPrefixes a list of all the possible prefixes in the laptop model number for this model.
     * @return a Laptop object.
     */
    public Laptop(String model, String number, ArrayList laptopPrefixes)
    {
        laptopModel = model;
        laptopModelNumber = number;
        prefixes = laptopPrefixes;
    }

    /**
     * Sets the laptop model.
     *
     * @param the laptop model.
     */
    public void setLaptopModel(String theLaptopModel)
    {
        laptopModel = theLaptopModel;
    }

    /**
     * Sets the laptop model number.
     *
     * @param the laptop model number.
     */
    public void setLaptopModelNumber(String theLaptopModelNumber)
    {
        laptopModelNumber = theLaptopModelNumber;
    }

    /**
     * Sets the laptop prefixes.
     *
     * @param the laptop prefixes.
     */
    public void setPrefixes(ArrayList thePrefixes)
    {
        prefixes = thePrefixes;
    }

    /**
     * Sets the laptop parts.
     *
     * @param the laptop parts.
     */
    public void setParts(ArrayList theParts)
    {
        parts = theParts;
    }

    /**
     * Gets the laptop model.
     *
     * @return the laptop model.
     */
    public String getLaptopModel()
    {
        return laptopModel;
    }

    /**
     * Gets the laptop model number.
     *
     * @return the laptop model number.
     */
    public String getLaptopModelNumber()
    {
        return laptopModelNumber;
    }

    /**
     * Gets the laptop prefixes.
     *
     * @return the laptop prefixes.
     */
    public ArrayList getPrefixes()
    {
        return prefixes;
    }

    /**
     * Gets the laptop parts.
     *
     * @return the laptop parts.
     */
    public ArrayList getParts()
    {
        return parts;
    }

    /**
     * Compares this laptop to another based on model, used in alpha ordering drop menu data.
     *
     * @param e the laptop being compared to.
     * @return the comparison result.
     */
    @Override
    public int compareTo(Laptop e)
    {
        return e.getLaptopModel().compareToIgnoreCase(getLaptopModel());
    }

    /**
     * Gets the laptop description string.
     *
     * @return the description string.
     */
    @Override
    public String toString()
    {
        return laptopModel + " " + laptopModelNumber;
    }
}

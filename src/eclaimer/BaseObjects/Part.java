/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 * @See eclaimer.Main for more information.
 */

package eclaimer.BaseObjects;

public class Part implements Comparable<Part>
{
    private String name;
    private String fru;

    /**
     * Creates a part object
     *
     * @param theName the name of the part.
     * @param theFRU the FRU of the part.
     */
    public Part(String theName, String theFRU)
    {
        name = theName;
        fru = theFRU;
    }

    /**
     * Sets the part name.
     *
     * @param the part name.
     */
    public void setName(String theName)
    {
        name = theName;
    }

    /**
     * Sets the part FRU.
     *
     * @param the part FRU.
     */
    public void setFRU(String theFRU)
    {
        fru = theFRU;
    }

    /**
     * Gets the part name.
     *
     * @return the part name.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Gets the part FRU.
     *
     * @return the part FRU.
     */
    public String getFRU()
    {
        return fru;
    }

    /**
     * Compares this part with another, used in ordering drop menu data.
     *
     * @param e the part being compared.
     * @return the comparison result.
     */
    @Override
    public int compareTo(Part e)
    {
        return e.getName().compareToIgnoreCase(getName());
    }

    /**
     * Gets the description string.
     *
     * @return the description string.
     */
    @Override
    public String toString()
    {
        return name + " " + fru;
    }
}

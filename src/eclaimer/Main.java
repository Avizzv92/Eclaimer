/**
 * Lovingly created (for free) by:
 * @author Aaron Vizzini
 *
 * Eclaimer:
 *
 * The entirety of this application has been developed, programmed, and maintained for free
 * by Aaron C. Vizzini; B.S. Computer Science, Saint Francis University Class of 2014. This program was designed
 * for the use at the Saint Francis University Laptop Helpdesk. The purpose is to aide in the Lenovo
 * warranty claim process.
 *
 * Upon Aaron C. Vizzini's graduation in the Spring of 2014, he will have been relieved of his duties to
 * maintain this application. If your reading this, it seems you have been the chosen successor to maintain this
 * piece of software or Aaron C. Vizzini is simply unavailable... Either way, good luck and don't screw
 * anything up; unless something already is and in that case, fix it :).
 *
 * PS: Make sure your coding changes are as clean or cleaner than Aaron C. Vizzini's. Update all code comments as
 * you deem fit and keep the version number updated.
 *
 * ~ IF AARON C. VIZZINI HAS GRADUATED & IT IS AN EMERGENCY ~
 * If Aaron V. Vizzini has graduated Saint Francis University and you have an emergency that
 * needs fixed, he may be kind of enough to help out... but he will expect more than Min. Wage...
 */

package eclaimer;

import eclaimer.GUI.PinEntry;
public class Main
{
    public static void main(String[] args) 
    {
        PinEntry frame = new PinEntry();
        frame.setDefaultCloseOperation(PinEntry.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

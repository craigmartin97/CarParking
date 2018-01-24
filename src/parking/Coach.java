/*
 Coach Class - Subclass of vehicle. Calculates the fee to be applied.
 */
package parking;

import javax.swing.ImageIcon;

/**
 * @author Craig Martin - Q5031372
 */
public class Coach extends Vehicle
{

    private int numOfPassengers;
    private boolean touristOperator;
    private ImageIcon image;

    /**
     * Sets Variables to Zero/Null and Calculates the total charge to be applied
     */
    public Coach()
    {
        numOfPassengers = 0;
        touristOperator = false;
        image = null;
    }

    /**
     * constructor sets the instance variables and calculates the charge and
     * sets the image dependant upon number of passengers and if the coach is a
     * tourist operator
     *
     * @param rn is the regNumber that will be passed in by the user @
     * @param np is the number of passengers that is passed in by the user
     * @param touristOp is if the user is a tourist operator
     */
    public Coach(String rn, int np, boolean touristOp)
    {
        super(rn);
        numOfPassengers = np;
        touristOperator = touristOp;

        if (numOfPassengers <= 20)
        {
            charge = 4.50;
            if (touristOperator == true)
            {
                charge = charge - (charge * 0.10);
            }
        } else if (numOfPassengers > 20)
        {
            charge = 6.00;
            if (touristOperator == true)
            {
                charge = charge - (charge * 0.10);
            }
        }

        image = new ImageIcon("./ParkingImages/coach.png");
    }

    /**
     * return touristOp
     *
     * @return true or false if they are tourist operator
     */
    public boolean getTouristCoach()
    {
        return touristOperator;
    }

    /**
     * return numPass
     *
     * @return the number of passengers that or on the coach
     */
    public int getPassengers()
    {
        return numOfPassengers;
    }

    /**
     * return image
     *
     * @return the image to be displayed
     */
    @Override
    public ImageIcon getImage()
    {
        return image;
    }

    /**
     *
     * @return the charge that is too be applied to the coach
     */
    @Override
    public double calcCharge()
    {
        return charge;
    }

    /**
     *
     * @return toString method returns the Registration Number, Charge and
     * Number of Passengers of the Coach. It overrides the Vehicle Classes
     * toString method
     */
    @Override
    public String toString()
    {
        return String.format("Registration: %s, Total Charge:  £%s, Number Of Passengers:  %s", regNumber, charge, numOfPassengers);
    }
}

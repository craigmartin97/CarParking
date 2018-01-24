/*
 Car Class - Subclass of vehicle. Calculates the fee to be applied.
 */
package parking;

import javax.swing.ImageIcon;

/**
 * @author Craig Martin - Q5031372
 */
public class Car extends Vehicle
{

    private double length;
    private boolean disabledBadge;
    private int numOfHours;
    private ImageIcon image;

    /**
     * Sets Variables to Zero/Null and Calculates the total charge to be applied
     */
    public Car()
    {
        length = 0.0;
        disabledBadge = false;
        numOfHours = 0;
        image = null;
    }

    /**
     * constructor sets the instance variables and calculates the charge and
     * sets the image dependant upon if they are disabled, length of stay and
     * size
     *
     * @param rn is the regNumber that will be passed in by the user
     * @param l is the length that will be passed in by the user
     * @param disBadge is if the user ha a disabled badge and will be passed in
     * @param hours that the user will be in the car park for
     */
    public Car(String rn, double l, boolean disBadge, int hours)
    {
        super(rn);
        length = l;
        disabledBadge = disBadge;
        numOfHours = hours;
        regNumber = rn;

        if (disabledBadge == true)
        {
            charge = 0.00;
        } else if (length <= 6)
        {
            charge = 1.00 * numOfHours;
        } else if (length > 6)
        {
            charge = 1.50 * numOfHours;
        }

        if (length <= 6)
        {
            image = new ImageIcon("./ParkingImages/car.png");
        } else if (length > 6)
        {
            image = new ImageIcon("./ParkingImages/campervan.png");
        }
    }

    /**
     * return length
     *
     * @return the length of the vehicle
     */
    public double getLength()
    {
        return length;
    }

    /**
     * return the correct image overrides the vehicles image method
     *
     * @return the required image dependant upon size of the car
     */
    @Override
    public ImageIcon getImage()
    {
        return image;
    }

    /**
     * return charge
     *
     * @return the charge that is to be applied
     */
    @Override
    public double calcCharge()
    {
        return charge;
    }

    /**
     * returns reg, charge and length
     *
     * @return toString method returns the Registration Number, Charge and
     * Length of the Car. It overrides the Vehicle Classes toString method
     */
    @Override
    public String toString()
    {
        return String.format("Registration: %s, Total Charge:  £%s, Vehicle Length:  %s", regNumber, charge, length);
    }
}

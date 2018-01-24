/*
 Coach Class - Subclass of vehicle. Calculates the fee to be applied.
 */
package parking;

import javax.swing.ImageIcon;

/**
 * @author Craig Martin - Q5031372
 */
public class Lorry extends Vehicle
{

    private double weight;
    private int numOfDays;
    private ImageIcon image;

    /**
     * Sets Variables to Zero/Null and Calculates the total charge to be applied
     */
    public Lorry()
    {
        weight = 0.0;
        numOfDays = 0;
        image = null;
    }

    /**
     * constructor sets the instance variables and calculates the charge and
     * sets the image dependant upon weight and the number of days the lorry
     * stays
     *
     * @param rn is the regNumber that will be passed in by the user
     * @param w is the weight passed in by the user
     * @param days is number of days lorry will stay for
     */
    public Lorry(String rn, double w, int days)
    {
        super(rn);
        weight = w;
        numOfDays = days;

        if (weight < 20)
        {
            charge = 5.00 * numOfDays;
        } else if (weight >= 20 && weight <= 35)
        {
            charge = 8.00 * numOfDays;
        } else if (weight > 35)
        {
            charge = -1;
        }

        image = new ImageIcon("./ParkingImages/lorry.png");
    }

    /**
     *
     * @return the weight of the lorry
     */
    public double getWeight()
    {
        return weight;
    }

    /**
     *
     * @return an image of a lorry to be displayed
     */
    @Override
    public ImageIcon getImage()
    {
        return image;
    }

    /**
     *
     * @return the charge that has been applied
     */
    @Override
    public double calcCharge()
    {
        return charge;
    }

    /**
     *
     * @return toString method returns the Registration Number, Charge and the
     * Weight of the Lorry. It overrides the Vehicle Classes toString method
     */
    @Override
    public String toString()
    {
        //return regNumber + "\t" + charge + "\t" + weight;
        return String.format("Registration: %s, Total Charge:  £%s, Weight:  %s", regNumber, charge, weight);
    }
}

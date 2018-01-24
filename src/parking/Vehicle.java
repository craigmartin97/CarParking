/*
 The SuperClass of Car, Coach and Lorry. Returns the instance variables and returns the toString Method.
 */
package parking;

import java.io.Serializable;
import javax.swing.ImageIcon;

/**
 * @author Craig Martin - Q5031372
 */
public abstract class Vehicle implements Serializable
{

    /**
     * protected so avaliable to the other classes, variable to ask for charge
     */
    protected double charge;

    /**
     * avaliable to other classes, variable to ask for reg Number
     */
    protected String regNumber;

    Vehicle()
    {
        charge = 0;
        regNumber = null;
    }

    /**
     *
     * sets the registration number @param rn
     */
    Vehicle(String rn)
    {
        regNumber = rn;
    }

    /**
     * return charge
     *
     * @return the charge
     */
    public double getCharge()
    {
        return charge;
    }

    /**
     * return image
     *
     * @return the image that has been applied
     */
    public abstract ImageIcon getImage();

    /**
     * calc charge
     *
     * @return calculates the charge that has too be applied
     */
    public abstract double calcCharge();

    /**
     * return reg and charge
     *
     * @return toString method that displays the registration number and the
     * charge
     */
    @Override
    public String toString()
    {
        return String.format("My Ref Number Is %s, Charge Is %s", regNumber, charge);
    }

}

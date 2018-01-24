/*
 * car subclass tests the car class and creates a newCar
 */
package parking;

/**
 *
 * @author q5031372
 */
public class testCar
{

    private Car testCar;

    /**
     * Method creates a new Car and prints it out
     */
    public testCar()
    {
        testCar = new Car("Car Reg", 2, false, 2);
        System.out.println("This is the car tester " + testCar.toString());
    }
}

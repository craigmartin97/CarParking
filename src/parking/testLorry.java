/*
* This class creates a newLorry in a seperate class to test the sub clsas is working
* correctly
 */
package parking;

/**
 *
 * @author q5031372
 */
public class testLorry
{

    private Lorry testLorry;

    /**
     * Creates a dummy lorry to test the subclasses of vehicle
     */
    public testLorry()
    {
        testLorry = new Lorry("Lorry Reg", 4, 4);
        System.out.println("This is the lorry tester " + testLorry.toString());
    }
}

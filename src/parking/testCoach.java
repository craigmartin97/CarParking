/*
 * This class creates a newCoach to test the coach subclass is working correctly
 */
package parking;

/**
 *
 * @author q5031372
 */
public class testCoach
{

    private Coach testCoach;

    /**
     * Method creates a new coach and prints it out
     */
    public testCoach()
    {
        testCoach = new Coach("Coach Reg", 4, false);
        System.out.println("This is the coach tester " + testCoach.toString());
    }
}

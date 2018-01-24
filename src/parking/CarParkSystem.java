/*
 A program that creates a virtual car parking system. Car's, Lorry's and Coach's can enter
 and leave the car park. They are prompted to enter there vehicles details
 and the fee is then calcualted. 
 */
package parking;

import javax.swing.*;

/**
 * @author Craig, Q5031372
 */
public class CarParkSystem extends JFrame
{

    /**
     * The main method, creates a JFrame and adds the JPanel from ButtonPanel
     * class
     *
     * @param args
     */
    public static void main(String[] args)
    {

        JFrame frame = new JFrame();

        CarParkGUI panel = new CarParkGUI();
        frame.add(panel);

        // set the frame to exit when it is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setSize(678, 600); // set the size of the frame
        frame.setSize(1800, 1000);
        frame.setResizable(false);
        frame.setVisible(true); // make the frame visible 

        testVehicles();
    }

    public static void testVehicles()
    {
        testCar cart = new testCar();
        testCoach coacht = new testCoach();
        testLorry lorryt = new testLorry();
    }
}

/*
 This class creates the panels to add to the main frame
 in the main class.

 creates buttons and adds them to the west side of the frame
 creates car parking for small and large vehicles and adds them to the frame in the center
 */
package parking;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.border.*;

/**
 * @author Craig, Q5031372
 */
public final class CarParkGUI extends JPanel implements ActionListener, MouseListener
{

    JLabel[] smallVehicleSpace = new JLabel[12]; // small vehicle spaces
    JLabel[] largeVehicleSpace = new JLabel[4]; // large vehicle spaces
    Vehicle[] listOfSmallVehicles = new Vehicle[12]; // array of small vehicles
    Vehicle[] listOfLargeVehicles = new Vehicle[4]; // array of large vehicles
    JPanel container;
    JTextField displayLabel;
    JButton buttonAddVehicle;
    JButton buttonClearAll;
    JButton buttonSave;
    JButton buttonLoad;
    JButton buttonCurrentTotal;
    JButton buttonOverallTotal;
    Car newCar;
    Lorry newLorry;
    Coach newCoach;

    /**
     * JPanel that holds all buttons
     */
    public JPanel panelButtons;

    /**
     * JPanel that holds all small vehicle spaces
     */
    public JPanel panelSpacesSmall;

    /**
     * JPanel that holds all large vehicle spaces
     */
    public JPanel panelSpacesLarge;

    /**
     * JPanel that will display car's information
     */
    public JPanel panelDisplay;

    private double currentTotal;
    private double overallTotal;

    CarParkGUI()
    {

        // Adding panels
        createPanels();

        //Adding buttons to this panel
        createButtons();
        addButtons();

        // Add labels to this panel
        createCarSpaces();

        // Add Panels Togheter
        addPanels();
    }

    /**
     * method to create panels, set there sizes and layouts
     */
    public void createPanels()
    {

        // Creating JPanel For The Buttons To Go In
        Dimension buttonPanelSize = new Dimension(250, 170);
        panelButtons = new JPanel();
        panelButtons.setLayout(new GridLayout(1, 6));
        panelButtons.setPreferredSize(buttonPanelSize);

        // Creating JPanel To Hold All Other JPanel Components (Overall Panel)
        container = new JPanel();

        // Setting the layout of the main JPanel
        this.setLayout(new BorderLayout());

        // Creating JPanel To Store Car Parking Spaces
        panelSpacesSmall = new JPanel();
        panelSpacesSmall.setLayout(new GridLayout(3, 4));
        panelSpacesSmall.setPreferredSize(new Dimension(1050, 470));

        // Creating JPanel To Store Lorry Parking Spaces
        panelSpacesLarge = new JPanel();
        panelSpacesLarge.setLayout(new GridLayout(1, 4));
        panelSpacesLarge.setPreferredSize(new Dimension(1050, 310));

        Color colorOfBlock = new Color(0, 153, 255);
        Color text = new Color(255, 255, 255, 255);
        Font font = new Font("Arial", Font.PLAIN, 14);
        int allignment = JLabel.CENTER;

        displayLabel = new JTextField();
        displayLabel.setBackground(colorOfBlock);
        displayLabel.setFont(font);
        displayLabel.setForeground(text);
        displayLabel.setHorizontalAlignment(allignment);
        displayLabel.setEditable(false);
        displayLabel.setOpaque(true);

        panelDisplay = new JPanel();
        panelDisplay.setLayout(new GridLayout(1, 1));
        panelDisplay.setPreferredSize(new Dimension(700, 750));
        panelDisplay.add(displayLabel);

    }

    /**
     * setting buttons text, action listeners and styling of buttons
     */
    public void createButtons()
    {
        // Setting colors, fonts and borders of all of the buttons
        Color btn = new Color(0, 153, 255);
        Color text = new Color(255, 255, 255, 255);
        Font font = new Font("Arial", Font.PLAIN, 30);
        Border whiteLine = BorderFactory.createLineBorder(Color.white);

        // Setting Buttons
        buttonAddVehicle = new JButton("Add Vehicle");
        buttonAddVehicle.setForeground(text);
        buttonAddVehicle.setFont(font);
        buttonAddVehicle.setFocusPainted(false);
        buttonAddVehicle.setBackground(btn);
        buttonAddVehicle.setBorder(whiteLine);
        buttonAddVehicle.addActionListener(this);

        buttonClearAll = new JButton("Clear All");
        buttonClearAll.setForeground(text);
        buttonClearAll.setFont(font);
        buttonClearAll.setFocusPainted(false);
        buttonClearAll.setBackground(btn);
        buttonClearAll.setBorder(whiteLine);
        buttonClearAll.addActionListener(this);

        buttonSave = new JButton("Save");
        buttonSave.setForeground(text);
        buttonSave.setFont(font);
        buttonSave.setFocusPainted(false);
        buttonSave.setBackground(btn);
        buttonSave.setBorder(whiteLine);
        buttonSave.addActionListener(this);

        buttonLoad = new JButton("Load");
        buttonLoad.setForeground(text);
        buttonLoad.setFont(font);
        buttonLoad.setFocusPainted(false);
        buttonLoad.setBackground(btn);
        buttonLoad.setBorder(whiteLine);
        buttonLoad.addActionListener(this);

        buttonCurrentTotal = new JButton("Current Total");
        buttonCurrentTotal.setForeground(text);
        buttonCurrentTotal.setFont(font);
        buttonCurrentTotal.setFocusPainted(false);
        buttonCurrentTotal.setBackground(btn);
        buttonCurrentTotal.setBorder(whiteLine);
        buttonCurrentTotal.addActionListener(this);

        buttonOverallTotal = new JButton("Overall Total");
        buttonOverallTotal.setForeground(text);
        buttonOverallTotal.setFont(font);
        buttonOverallTotal.setFocusPainted(false);
        buttonOverallTotal.setBackground(btn);
        buttonOverallTotal.setBorder(whiteLine);
        buttonOverallTotal.addActionListener(this);
    }

    /**
     * adding all of the created buttons to the JPanel panelButtons
     */
    public void addButtons()
    {
        // Add to JPanel
        panelButtons.add(buttonAddVehicle);
        panelButtons.add(buttonClearAll);
        panelButtons.add(buttonSave);
        panelButtons.add(buttonLoad);
        panelButtons.add(buttonCurrentTotal);
        panelButtons.add(buttonOverallTotal);
    }

    /**
     * creating all of the car spaces (JLabel's) including size, color,
     * alignment and border color
     */
    public void createCarSpaces()
    {
        // Creating Variables For All Of The Spaces
        Border blackLine = BorderFactory.createMatteBorder(5, 5, 5, 5, Color.RED);
        Color colorOfSpaces = new Color(242, 242, 242);
        int allignment = JLabel.CENTER;

        // Creating All Of The Small Vehicle Parking Spaces
        for (int i = 0; i < smallVehicleSpace.length; i++)
        {
            smallVehicleSpace[i] = new JLabel();
            smallVehicleSpace[i].setHorizontalAlignment(allignment);
            smallVehicleSpace[i].setBorder(blackLine);
            smallVehicleSpace[i].setBackground(colorOfSpaces);
            smallVehicleSpace[i].setOpaque(true);
            smallVehicleSpace[i].addMouseListener(this);
            panelSpacesSmall.add(smallVehicleSpace[i]);
        }

        //Creating All Of The Large Vehicle Parking Spaces
        for (int i = 0; i < largeVehicleSpace.length; i++)
        {
            largeVehicleSpace[i] = new JLabel();
            largeVehicleSpace[i].setHorizontalAlignment(allignment);
            largeVehicleSpace[i].setBorder(blackLine);
            largeVehicleSpace[i].setBackground(colorOfSpaces);
            largeVehicleSpace[i].setOpaque(true);
            largeVehicleSpace[i].addMouseListener(this);
            panelSpacesLarge.add(largeVehicleSpace[i]);
        }

    }

    /**
     * Adding JPanels to other panels
     */
    public void addPanels()
    {
        // adding both vehicle car spaces to the main container
        container.add(panelSpacesLarge, BorderLayout.NORTH);
        container.add(panelSpacesSmall, BorderLayout.CENTER);

        // adding the main container to the overall panel. When this class is then created in the main 
        // method this panel is added to the JFrame which contains all other components
        this.add(container, BorderLayout.CENTER);
        this.add(panelButtons, BorderLayout.SOUTH);
        this.add(panelDisplay, BorderLayout.EAST);
    }

    /**
     * when a button is pressed this method will give instructions of what to do
     *
     * e is the instance of the actionPerformed method. It tells the method what
     * type to expect (ActionEvent) @param e
     */
    @Override
    public void actionPerformed(ActionEvent e)
    {

        // If add vehiclebuttton is pressed
        if (e.getSource() == buttonAddVehicle)
        {
            addVehicle();
        } else if (e.getSource() == buttonClearAll)
        { // clear app button pressed
            clearApp();
        } else if (e.getSource() == buttonSave)
        { // if save app button is pressed
            saveApp();
        } else if (e.getSource() == buttonLoad)
        { // if load button is pressed
            loadApp();
        } else if (e.getSource() == buttonCurrentTotal)
        { // if current total button is pressed
            currentTotal();
        } else if (e.getSource() == buttonOverallTotal)
        { // if overall total button is pressed
            overallTotal();
        }
    }

    /**
     * prompts user to input the vehicle that that they have and then asks them
     * to input details about there vehicle.
     */
    public void addVehicle()
    {
        int optDialogBoxVehicleType = optDialogOptionVehicle("What Type Of Vehicle Do You Have?", "Please Select An Option");

        // if they have a car or campervan
        switch (optDialogBoxVehicleType)
        {
            case 0:
                carDetails();
                addCar();
                break;
            // if a lorry is selected
            case 1:
                lorryDetails();
                addLorry();
                break;
            // if a coach is selected
            case 2:
                coachDetails();
                addCoach();
                break;
            default:
                break;
        }
    }

    /**
     * Method to ask user to input data about there car that they are entering
     * the car park with
     */
    public void carDetails()
    {
        // Getting user inputs of there small vehicle
        String regNumber = optDialogInput("Please Enter Your Car's Registration Number");
        if (regNumber == null)
        {
            // display JOptionPane message showing "Cancelled"
            cancelMessage();
            newCarNull();

        } else
        {
            int optDialogBoxDisabledBadge = optDialogOption("Do You Have A Disabled Badge?", "Please Select An Option");

            boolean disabledBadge;
            disabledBadge = optDialogBoxDisabledBadge == 0;
            if (optDialogBoxDisabledBadge == JOptionPane.CLOSED_OPTION)
            {
                cancelMessage();
                newCarNull();
            } else
            {
                String inputBoxLength = optDialogInput("Please Enter Your Length Of Your Vehicle");
                if (inputBoxLength == null)
                {
                    cancelMessage();
                    newCarNull();
                } else
                {
                    double length = Integer.parseInt(inputBoxLength);
                    String inputBoxTime = optDialogInput("Please Enter The Number Of Hours Your Car Will Be Parked");

                    if (inputBoxTime == null)
                    {
                        cancelMessage();
                        newCarNull();
                    } else
                    {
                        //Send car information entered to the car class
                        int numOfHours = Integer.parseInt(inputBoxTime);
                        newCar = new Car(regNumber, length, disabledBadge, numOfHours);
                    }
                }
            }
        }
    }

    /**
     * Method to search for a free space and add a car image to that space,
     * otherwise it will display a message saying the car park is full
     */
    public void addCar()
    {

        // add an image to a jpanel everytime a vehicle is added
        if (smallVehicleSpace.length <= 12)
        {
            for (int i = 0; i < smallVehicleSpace.length; i++)
            {
                if (smallVehicleSpace[i].getIcon() == null)
                {
                    // if there is no newCar to add to the GUI
                    if (newCar == null)
                    {
                        break;
                    } else // if there is a free space and a newCar
                    {
                        smallVehicleSpace[i].setIcon(newCar.getImage());
                        listOfSmallVehicles[i] = newCar;
                        updateCarTotals();
                        break;
                    }
                    // if car park is full
                } else if (i == 11)
                {
                    fullMessage();
                }
            }
        }
    }

    /**
     * update the car totals, currentTotal and overallTotal
     */
    public void updateCarTotals()
    {
        // if newCar is empty
        if (newCar == null)
        {
            System.out.println("");
        } else
        {
            // updating overall and current total counters, increment loop counter
            newCar.calcCharge();

            // add the charge onto overall and current total
            overallTotal += newCar.getCharge();
            currentTotal += newCar.getCharge();
        }
    }

    /**
     * Method to ask user to input data about there lorry that they are entering
     * the car park with
     */
    public void lorryDetails()
    {
        String regNumber = optDialogInput("Please Enter Your Lorry's Registration Number");
        if (regNumber == null)
        {
            // display JOptionPane.message showing "Cancelled"
            cancelMessage();
            newLorryNull();
        } else
        {
            String inputBoxTime = optDialogInput("Please Enter The Number Of Hours Your Lorry Will Be Parked");
            if (inputBoxTime == null)
            {
                cancelMessage();
                newLorryNull();
            } else
            {
                int numOfDays = Integer.parseInt(inputBoxTime);

                String inputBoxWeight = optDialogInput("Please Enter The Weight Of Your Lorry");
                if (inputBoxWeight == null)
                {
                    cancelMessage();
                    newLorryNull();
                } else
                {
                    double weight = Integer.parseInt(inputBoxWeight);
                    if (weight > 35)
                    {
                        optDialogMess("Sorry You Exceed The Weight Limit Of 35 Tonnes And Cannot Enter");
                        newLorryNull();
                    } else
                    {
                        // Add lorry information to the lorry class
                        newLorry = new Lorry(regNumber, weight, numOfDays);
                    }
                }
            }
        }
    }

    /**
     * Method to to search for a free large vehicle space, else it will show a
     * message saying the car park is full
     */
    public void addLorry()
    {
        // add an image to a jpanel everytime a vehicle is added
        if (largeVehicleSpace.length <= 4)
        {
            for (int i = 0; i < largeVehicleSpace.length; i++)
            {
                if (largeVehicleSpace[i].getIcon() == null)
                {
                    // if there is no newLorry to add
                    if (newLorry == null)
                    {
                        newLorry = null;
                        break;
                    } else
                    {
                        largeVehicleSpace[i].setIcon(newLorry.getImage());
                        listOfLargeVehicles[i] = newLorry;
                        updateLorryTotals();
                        break;
                    }
                } else if (i == 3)
                {
                    // display a message saying the car park is full
                    fullMessage();
                }
            }
        }
    }

    /**
     * Updates current total and overall total, if lorry weighs more than 35
     * tonnes an error message will be displayed
     */
    public void updateLorryTotals()
    {
        // updating overall and current total counters, increment loop counter
        if (newLorry == null)
        {
            System.out.println("");
        } else
        {
            // get charge to be applied
            newLorry.calcCharge();

            // add the charge onto overall and current total
            overallTotal += newLorry.getCharge();
            currentTotal += newLorry.getCharge();
        }

    }

    /**
     * Method to ask the user for the details about there lorry
     */
    public void coachDetails()
    {
        String regNumber = optDialogInput("Please Enter Your Coach's Registration Number");
        if (regNumber == null)
        {
            cancelMessage();
            newCoachNull();
        } else
        {
            int optDialogBoxDisabledBadge = optDialogOption("Are You A Tourist Operator?", "Please Select An Option");

            boolean touristOperator;
            touristOperator = optDialogBoxDisabledBadge == 0;

            if (optDialogBoxDisabledBadge == JOptionPane.CLOSED_OPTION)
            {
                cancelMessage();
                newCoachNull();
            } else
            {
                String inputBoxNumOfPassengers = optDialogInput("Please Enter The Number Of Passengers On Your Coach: ");
                if (inputBoxNumOfPassengers == null)
                {
                    cancelMessage();
                    newCoachNull();
                } else
                {
                    int numOfPassengers = Integer.parseInt(inputBoxNumOfPassengers);

                    // Add coach information to the coach class
                    newCoach = new Coach(regNumber, numOfPassengers, touristOperator);
                }
            }
        }
    }

    /**
     * Method to search the large vehicle space and add a coach if theres a free
     * space. else a message saying the car park is full will be displayed
     */
    public void addCoach()
    {
        // add an image to a jpanel everytime a vehicle is added
        if (largeVehicleSpace.length <= 4)
        {
            // loop through the large vehicle spaces
            for (int i = 0; i < largeVehicleSpace.length; i++)
            {
                // if newCoach is empty
                if (newCoach == null)
                {
                    break;
                } else if (largeVehicleSpace[i].getIcon() == null)
                {
                    largeVehicleSpace[i].setIcon(newCoach.getImage());
                    listOfLargeVehicles[i] = newCoach;
                    updateCoachTotals();
                    break;
                } else if (i == 3)
                {
                    fullMessage();
                }
            }
        }
    }

    /**
     * Updates current total and overall totals
     */
    public void updateCoachTotals()
    {
        if (newCoach == null)
        {
            System.out.println("");
        } else
        {
            // update overall and current total counters, increment total counter
            newCoach.calcCharge();

            // add the charge onto overall and current total
            overallTotal += newCoach.getCharge();
            currentTotal += newCoach.getCharge();
        }
    }

    @Override
    public void mouseClicked(MouseEvent me)
    {
        // BLANK
    }

    @Override
    public void mouseReleased(MouseEvent me)
    {
        //Blank
    }

    @Override
    public void mousePressed(MouseEvent me)
    {
        if (SwingUtilities.isLeftMouseButton(me)) // if left mouse btn pressed
        {
            // loop through the spaces
            for (int i = 0; i < largeVehicleSpace.length; i++)
            {
                if (me.getSource() == largeVehicleSpace[i])
                {
                    // if large space is not empty
                    if (largeVehicleSpace[i].getIcon() != null)
                    {
                        // display the arrays text in the display label on the right hand side of the GUI
                        displayLabel.setText(listOfLargeVehicles[i].toString());
                        break;
                        // if large space is empty
                    } else if (largeVehicleSpace[i].getIcon() == null)
                    {
                        optDialogMess("This Lorry/Coach Space Is Empty");
                        break;
                    }
                }
            }

            // loop through small spaces
            for (int i = 0; i < smallVehicleSpace.length; i++)
            {
                if (me.getSource() == smallVehicleSpace[i])
                {
                    // if small spaces i not empty
                    if (smallVehicleSpace[i].getIcon() != null)
                    {
                        displayLabel.setText(listOfSmallVehicles[i].toString());
                        break;
                        // if smal space is empty
                    } else if (smallVehicleSpace[i].getIcon() == null)
                    {
                        optDialogMess("This Car/Campervan Space Is Empty");
                        break;
                    }
                }
            }

        } else if (SwingUtilities.isRightMouseButton(me)) // if right mouse btn is pressed
        {
            int pane = optDialogConfirm("Are You Sure You Want To Delete This Vehicle? ");

            if (pane == 0) // yes
            {
                for (int i = 0; i < 4; i++)
                {
                    // loop through the large vehicle sapces
                    if (me.getSource() == largeVehicleSpace[i])
                    {
                        // if no vehicle in space
                        if (largeVehicleSpace[i].getIcon() == null)
                        {
                            removeMessageFail();
                            break;
                        }

                        // if there is a vehicle in a space
                        currentTotal = currentTotal - listOfLargeVehicles[i].getCharge();

                        largeVehicleSpace[i].setIcon(null);
                        listOfLargeVehicles[i] = null;
                        removeMessageSuccess();
                        break;
                    }
                }
                for (int i = 0; i < 12; i++)
                {
                    if (me.getSource() == smallVehicleSpace[i])
                    {
                        // if no vehicle in space
                        if (smallVehicleSpace[i].getIcon() == null)
                        {
                            removeMessageFail();
                            break;
                        }

                        // if there is a vehicle in a space
                        currentTotal = currentTotal - listOfSmallVehicles[i].getCharge();

                        smallVehicleSpace[i].setIcon(null);
                        listOfSmallVehicles[i] = null;
                        removeMessageSuccess();
                        break;
                    }
                }
            }
            if (pane == 1 || pane == 2) // no or cancel
            {
                cancelMessage();
            }

        } else if (SwingUtilities.isMiddleMouseButton(me))
        {
            int confirmPane = optDialogConfirm("Are You Sure You Want To Edit This Vehicle?");

            if (confirmPane == 0)
            {
                if (largeVehicleSpace.length <= 4)
                {
                    // loop through the large vehicle space
                    for (int i = 0; i < largeVehicleSpace.length; i++)
                    {
                        // if large space is pressed
                        if (me.getSource() == largeVehicleSpace[i])
                        {
                            if (largeVehicleSpace[i].getIcon() != null)
                            {

                                if (newLorry == null)
                                {
                                    coachDetails();
                                    listOfLargeVehicles[i] = newCoach;
                                    // add current vehicle charge
                                    updateLargeVehicleCurrentTotalAdd(i);
                                    break;
                                } // minus current vehicle from the space
                                else if (listOfLargeVehicles[i].calcCharge() == newLorry.getCharge())
                                {
                                    updateLargeVehicleCurrentTotalSub(i);
                                    lorryDetails();
                                    listOfLargeVehicles[i] = newLorry;

                                    // add new charge to current total
                                    updateLargeVehicleCurrentTotalAdd(i);
                                    break;
                                } // minus current vehicle charge
                                else if (listOfLargeVehicles[i].calcCharge() == newCoach.getCharge())
                                {
                                    updateLargeVehicleCurrentTotalSub(i);
                                    coachDetails();
                                    listOfLargeVehicles[i] = newCoach;
                                    // add current vehicle charge
                                    updateLargeVehicleCurrentTotalAdd(i);
                                    break;
                                } else
                                {
                                    updateLargeVehicleCurrentTotalSub(i);
                                    lorryDetails();
                                    listOfLargeVehicles[i] = newLorry;

                                    // add new charge to current total
                                    updateLargeVehicleCurrentTotalAdd(i);
                                    break;
                                }
                            }
                        }
                    }
                }

                if (smallVehicleSpace.length <= 12)
                {
                    for (int i = 0; i < smallVehicleSpace.length; i++)
                    {
                        if (me.getSource() == smallVehicleSpace[i])
                        {
                            if (smallVehicleSpace[i].getIcon() != null)
                            {
                                // minus current charge from current total
                                currentTotal = currentTotal - listOfSmallVehicles[i].getCharge();

                                carDetails();
                                smallVehicleSpace[i].setIcon(newCar.getImage());
                                listOfSmallVehicles[i] = newCar;

                                // add new charge to current total
                                currentTotal = currentTotal + listOfSmallVehicles[i].getCharge();
                                updateOverallSmallTotal(i);
                                break;

                            }
                        }
                    }
                }
            } else
            {
                optDialogMess("Cancelled");
            }
        }

    }

    @Override
    public void mouseExited(MouseEvent me)
    {
        //Blank
    }

    @Override
    public void mouseEntered(MouseEvent me)
    {
        //Blank
    }

    /**
     * removes all image currently on the GUI interface, resets counters to zero
     * and clears arraylists
     */
    public void clearApp()
    {
        int clearAppConfirmation = optDialogConfirm("Are You Sure You Want To Clear All Vehicles?");

        // If yes selected
        if (clearAppConfirmation == 0) // yes
        {

            for (int i = 0; i < 12; i++)
            {
                smallVehicleSpace[i].setIcon(null);
                listOfSmallVehicles[i] = null;
            }

            for (int i = 0; i < 4; i++)
            {
                largeVehicleSpace[i].setIcon(null);
                listOfSmallVehicles[i] = null;
            }

            currentTotal = 0;

            optDialogMess("Sucessfully Cleared!");
        } else // if no or cancel selected
        {
            cancelMessage();
        }
    }

    /**
     * saves the current vehicles information into a .dat file which can be
     * opened later
     */
    public void saveApp()
    {

        FileOutputStream SaveApp;
        ObjectOutputStream SaveVehicleObjects;
        String fileNameInput = "";

        String fileNameSave = optDialogInput("Enter A Filename To Save");
        fileNameInput = fileNameSave;

        try
        {
            SaveApp = new FileOutputStream(fileNameInput + ".dat");
            SaveVehicleObjects = new ObjectOutputStream(SaveApp);

            // saving both small and large vehicle information into the users .dat file
            SaveVehicleObjects.writeObject(listOfSmallVehicles);
            SaveVehicleObjects.writeObject(listOfLargeVehicles);
            SaveVehicleObjects.writeDouble(currentTotal);
            SaveVehicleObjects.writeDouble(overallTotal);

            SaveVehicleObjects.close(); // close file
            optDialogMess("Successfully Saved " + fileNameInput + ".dat");
        } catch (Exception e)
        {
            optDialogMess("Error, Closing");
        }
    }

    /**
     * opens an exsisting file and reads the images to the GUI
     */
    public void loadApp()
    {

        clearApp(); // promps user to clear the application first
        if (largeVehicleSpace[0].getIcon() == null && smallVehicleSpace[0].getIcon() == null)
        {
            try
            {
                String fileNameLoad = optDialogInput("Enter A Filename To Load");
                FileInputStream fileLoad;
                ObjectInputStream objLoad;

                fileLoad = new FileInputStream(fileNameLoad + ".dat");
                objLoad = new ObjectInputStream(fileLoad);

                // reading both objects back
                listOfSmallVehicles = (Vehicle[]) objLoad.readObject();
                listOfLargeVehicles = (Vehicle[]) objLoad.readObject();
                currentTotal = objLoad.readDouble();
                overallTotal = objLoad.readDouble();

                objLoad.close(); // close the file

                // 2 for loops to readd the images back onto the car spaces
                for (int i = 0; i < 4; i++)
                {
                    if (listOfLargeVehicles[i] != null)
                    {
                        ImageIcon lvPic = listOfLargeVehicles[i].getImage();
                        largeVehicleSpace[i].setIcon(lvPic);
                    }

                }

                for (int i = 0; i < 12; i++)
                {
                    if (listOfSmallVehicles[i] != null)
                    {
                        ImageIcon cp = listOfSmallVehicles[i].getImage();
                        smallVehicleSpace[i].setIcon(cp);
                    }

                }

                optDialogMess("Successfully Loaded " + fileNameLoad + ".dat");
            } catch (Exception e)
            {
                optDialogMess("Error, Could Not Find That File Name");
            }
        } else
        {
            optDialogMess("Cannot Load Another App If Car Park Is Not Empty");
        }

    }

    /**
     * calculates and displays the current total from the vehicles that are in
     * the car park
     */
    public void currentTotal()
    {

        // user selects an option
        int opts = optDialogOption("Do You Want To View Current Total", "Please Select An Option");

        if (opts == 0)
        {
            roundCurrentTotal();
            optDialogMess("Current Total Is: £" + currentTotal);
        }
        if (opts == 1)
        {
            cancelMessage();
        }
    }

    /**
     * calculates the overall total of all the vehicles that have used the car
     * park that day (that application run)
     */
    public void overallTotal()
    {
        int opt = optDialogOption("Do You Want To View Todays Overall Total", "Please Select An Option");

        if (opt == 0)
        {
            roundOverallTotal();
            optDialogMess("Todays Total £" + overallTotal);
        }

        if (opt == 1)
        {
            cancelMessage();
        }
    }

    /**
     * JOptionPane method to display a message in a Pane
     *
     * @param m m passes a string into optDialogMess method
     */
    public void optDialogMess(String m)
    {
        JOptionPane.showMessageDialog(null, m);
    }

    /**
     * JOptionPane method to ask the user to input some data.
     *
     * @param i i passes a string into the optDialogInput method that tells the
     * user what to do
     * @return the users input that they have entered will be returned
     */
    public String optDialogInput(String i)
    {
        String var = JOptionPane.showInputDialog(i);
        return var;
    }

    /**
     * JOptionPane method to ask the user to confirm a message, yes or no
     *
     * @param n passes a string into the method optDialogConfirm that tells the
     * user what to do
     * @return the users option that they have entered will be returned
     */
    public int optDialogConfirm(String n)
    {
        int varI = JOptionPane.showConfirmDialog(null, n);
        return varI;
    }

    /**
     * JOptionPane method to ask to the user for an option, (Option are set to
     * yes or no)
     *
     * @param j is a string that will be passed into the method that is a header
     * message
     * @param k is a string that will be passed into the method that tells the
     * user what to do
     * @return the users option that they select
     */
    public int optDialogOption(String j, String k)
    {
        String[] opts
                =
                {
                    "Yes", "No"
                };

        int varOpt = JOptionPane.showOptionDialog(
                null,
                j,
                k,
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opts,
                opts[0]);

        return varOpt;
    }

    /**
     * Method asks the user for an option of the type of vehicle they have
     *
     * @param title title is a string that will be passed in. Displays the
     * header message
     * @param message is a string that will be passed in to display a message
     * what the user has to do
     * @return the users option of vehicle they have
     */
    public int optDialogOptionVehicle(String title, String message)
    {
        String[] options
                =
                {
                    "Car or Campervan", "Lorry", "Coach"
                };

        // ask user what type of vehicle they have 
        int varMessage = JOptionPane.showOptionDialog(null,
                title,
                message,
                JOptionPane.OK_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        return varMessage;
    }

    /**
     * Displays a message saying the vehicle has bee successfully entered into
     * the car park
     */
    public void removeMessageSuccess()
    {
        optDialogMess("Vehicle Successfully Removed From Car Park");
    }

    /**
     * Displays a messaging informing the user there is nothing to remove
     */
    public void removeMessageFail()
    {
        optDialogMess("Nothing To Remove");
    }

    /**
     * Displays a message saying "Cancelled" when the user presses a cancel or
     * cross button
     */
    public void cancelMessage()
    {
        optDialogMess("Cancelled");
    }

    /**
     * Displays a message saying the car park is full
     */
    public void fullMessage()
    {
        optDialogMess("Sorry No Space's, Come Again Soon");
    }

    /**
     * updates (minus) the large vehicles current total when the middle button
     * is pressed over an image
     *
     * @param i is an int that corresponds to the position in the loop
     */
    public void updateLargeVehicleCurrentTotalSub(int i)
    {
        currentTotal = currentTotal - listOfLargeVehicles[i].getCharge();
    }

    /**
     * updates (add) the large vehicles current total when the middle button is
     * pressed over an image
     *
     * @param i is an int that corresponds to the position in the loop
     */
    public void updateLargeVehicleCurrentTotalAdd(int i)
    {
        currentTotal = currentTotal + listOfLargeVehicles[i].getCharge();
        updateOverallLargeTotal(i);
    }

    /**
     * updates the overall charge when the middle button is pressed on a large
     * vehicle
     *
     * @param i is an int that corresponds to the position in the loop
     */
    public void updateOverallLargeTotal(int i)
    {
        overallTotal += listOfLargeVehicles[i].getCharge();
    }

    /**
     * updates the overall charge when the middle button is pressed on a small
     * vehicle
     *
     * @param i is an int that corresponds to the position in the loop
     */
    public void updateOverallSmallTotal(int i)
    {
        overallTotal += listOfSmallVehicles[i].getCharge();
    }

    public void newCarNull()
    {
        newCar = null;
    }

    public void newLorryNull()
    {
        newLorry = null;
    }

    public void newCoachNull()
    {
        newCoach = null;
    }

    public void roundCurrentTotal()
    {
        currentTotal = Math.round(currentTotal * 100);
        currentTotal = currentTotal / 100;
    }

    public void roundOverallTotal()
    {
        overallTotal = Math.round(overallTotal * 100);
        overallTotal = overallTotal / 100;
    }
}

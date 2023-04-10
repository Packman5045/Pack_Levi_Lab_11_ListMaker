import java.util.Scanner;

/**
 *
 * @author wulft
 */
public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = ""; //Set this to zero length. Loop runs until it isn't do
        {
            System.out.print("\n" + prompt + ":"); //show prompt add space
            retString = pipe.nextLine(); //clears buffer
        }
        while (retString.length() == 0) ;

        return retString;
    }




    //Get an int value with no constraints
    //@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt input prompt message should not include range information
    //@return unconstrained int value
    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        }while(!done);

        return retVal;

    }
    //Get an int value with constraints
    //@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt input prompt message should include range information
    //@return constrained int value

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int retVal = 0;
        String trash = "";
        boolean done = false;

        do {
            System.out.print("\n" + prompt + "[" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                pipe.nextLine();
                if (retVal >= low && retVal <= high) {
                    done = true;
                } else {
                    System.out.println("\nNumber is out of range [" + low + "-" + high + "]: " + retVal);
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("You must enter an int: " + trash);
            }
        } while (!done);

        return retVal;
    }
//get a Double value within a range
//@param pipe Scanner instance to read the data System.in in most cases
//@param prompt input prompt message should not contain range information
//@param low the low value is provided
//@param high the high value is provided
//@return double value withing specified range




//get an unconstrained double value
//@param pipe Scanner instance to read the data System.in in most cases
//@param prompt input prompt message should not contain range information
//@return an unconstrained double value

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        String trash = "";
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");
            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                trash = pipe.nextLine();
                System.out.println("You must enter a doubel: " + trash);
            }
        }while(!done);

        return retVal;

    }

//get a yes no confirmation from the user
//@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt input prompt message for user does not need yes or no
    //@return true for yes false for no

    public static boolean getYNConfirmation(Scanner pipe, String prompt)
    {
        boolean retVal = true;
        String response = "";
        boolean gotVal = false;

        do
        {
            System.out.print("\n" + prompt + " [Y/N] ");
            response = pipe.nextLine();
            if(response.equalsIgnoreCase("Y"))
            {
                gotVal = true;
                retVal = false;
            }
            else if(response.equalsIgnoreCase("N"))
            {
                gotVal = true;
                retVal = false;
            }
            else
            {
                System.out.println("You must answer [Y/N]! " + response);
            }

        }while(!gotVal);

        return gotVal;
    }

    //get a string that matches a RegEx pattern! This is a very powerful method
    //@param pipe Scanner instance to read the data System.in in most cases
    //@param prompt prompt for the user
    //@param regExPattern java style RegEx patter to constrain the input
    //@return a String that matches the RegEx pattern supplied

    public static String getRegExString(Scanner pipe, String prompt, String regExPattern)
    {
        String response = "";
        boolean gotVal = false;

        do
        {
            System.out.print("\n" + prompt + ": " + regExPattern);
            response = pipe.nextLine();
            if(response.matches(regExPattern))
            {
                gotVal = true;
            }
            else

            {
                System.out.println("\n" + response + " must match the pattern " + regExPattern);
                System.out.println("Try again!");
            }

        }while(!gotVal);

        return response;


    }






}


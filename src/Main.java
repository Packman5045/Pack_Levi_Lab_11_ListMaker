import java.util.ArrayList;
import java.util.Scanner;
//the scanner and array list for the program
public class Main {
    public static void main(String[] args) {

    ArrayList<String> menu = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        boolean process = true;
        //initializing our variable(s) and the imports

    do
    //the code to run our menu/menu options
    {
        switch (printList(in,menu))
        {
            case "A":
                addToMenu(in, menu);
                break;

            case "D":
                deleteFromMenu(in, menu);
                break;

            case "P":
                displayMenu(in, menu);
                break;

            case "Q":
                if (SafeInput.getYNConfirmation(in,"Do you want to quit now?"))
                {
                    process = false;
                }
                else
                {
                    System.out.println("Returning to start.");
                }
        }


    } while(process);

    }

    public static void addToMenu(Scanner in, ArrayList menu)
    //This is the method in order to add items to our list
    {
        String add = SafeInput.getNonZeroLenString(in, "What would you like to add?");
        menu.add(add);
    }

    public static void deleteFromMenu(Scanner in, ArrayList menu)
    //This is the method in order to delete items from our list
    {
        int delete = SafeInput.getRangedInt(in, "What would you like to remove?", 1, menu.size());
        menu.remove(delete - 1);
    }

    public static void displayMenu(Scanner in, ArrayList menu)
    //This is the method in order to show the items on our list
    {
        for(int x = 0; x < menu.size(); ++x)
        {
            System.out.println(menu.get(x));
        }
    }

    public static String printList(Scanner in, ArrayList menu)
    //This is the method is what shows our menu and gives our list.

    {

        if (menu.isEmpty()) {
            System.out.println("Your list is currently empty.");
        } else {
            System.out.println("Current list:");

            for(int x = 0; x < menu.size(); ++x) {
                System.out.printf("    %d. %s\n", x + 1, menu.get(x));
            }
        }

        return SafeInput.getRegExString(in, "Select a menu option:\n    A: Add\n    D: Delete\n    P: Print\n    Q: Quit\n", "[AaDdPpQq]").toUpperCase();
    }
}
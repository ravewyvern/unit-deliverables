/********************************************
*	AUTHORS:	Katelyn Nova Powers
* COLLABORATORS: <name of peer, tutor, instructor>
*	LAST MODIFIED:	12/3/2024
********************************************/

/********************************************
*	Inventory Management System Version 2.0
*********************************************
*	PROGRAM DESCRIPTION:
 *	Inventory Management System (IMS) is a command line interface (CLI) program
 *  that allows users to manage an inventory of items. The program allows users
 *  to add items to the inventory, view the inventory, remove items from the inventory,
 *  and update the information of items.
*********************************************
*	ALGORITHM:
 *   Initialize the Program
 *    Initialize array inventory with the size of 1.
 *     Display a welcome message and instructions.
 *     Ask the user if they want to add some items to the inventory.
 * Input Item Names
 *     Loop through adding items to the inventory.
 *     Prompt the user to input the name, price, quantity, and catagory for each item.
 * Optional Input A yes/no prompt to add more items to the inventory.
 * Command Loop
 *     Display a message to start the IMS and prompt the user to type a command.
 *     Enter a loop that continues until the continueProgram variable is false.
 *         Wait for user command input.
 *         Call commandSearch() method to process the command.
 * Process Commands
 *     Inside commandSearch():
 *         Use a switch-case statement to match the input command.
 *         Call the appropriate command method from the Commands class based on the input.
 *         If command is 'exit', set continueProgram to false.
*********************************************
 *	STATIC METHODS:
 * -----------------------------------------
 * UD3Main.java
 * -----------------------------------------
 * +continueProgram: boolean
 * +debugMode: boolean
 * +inventory: Item[]
 * -----------------------------------------
 * +commandSearch(inputCommand: String): void
 * +emptySlotChecker(items: Item[]): int
 * +resizeArray(array: Item[], changeSize: int): Item[]
 * -----------------------------------------
*********************************************
 *	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *	Scanner: used for CLI input
*********************************************/

import java.util.Scanner;

/*
NOTE FOR TEACHER: Disregard the following note as its just ideas if I want to mess with the program later
Ideas for future improvements:
add more commands to the IMS2 (like purchase item or low stock or switch items)
make the view inventory sort by catagory
add a list of catagories to choose from when adding an item
*/
public class UD3Main
{

  /***** CONSTANT SECTION *****/
  public static boolean continueProgram = true;
  public static final boolean debugMode = false; //set to true to enable debug mode for testing
  public static Item[] inventory;

  public static void Main()
  {

    /***** INITIALIZATION SECTION *****/
    String command;
    //initialize the inventory array with a size of 1
    inventory = new Item[1];
    inventory[0] = new Item();

    /***** OUTPUT SECTION *****/
    System.out.println("Welcome to the Inventory Management System 2.0 (IMS2)!");
    System.out.println();

    //prompt to see if user wants to add items to the inventory on startup
    char continueSetup = UtilityBelt.readChar("To get started, would you like to add some items to the inventory? (y/N): ", "YNyn");

    //loop through adding items to the inventory
    while (continueSetup == 'Y' || continueSetup == 'y') 
    {
      commands.addItem();
      continueSetup = UtilityBelt.readChar("Would you like to add another item to the inventory? (y/N): ", "YNyn");
    }

    System.out.println("Setup complete, starting IMS2...");
    System.out.println();
    System.out.println("Inventory manager CLI started, type 'help' to get command list");

    if (debugMode) System.out.println("Debug mode is enabled, additional text will be displayed");

    // enters a loop that will continue until the continueProgram variable is false
    while (continueProgram) 
    {
      Scanner commandReader = new Scanner(System.in);

      System.out.print("C:/IMS/V2>");
      command = commandReader.nextLine();

      if (debugMode) System.out.println("C:/IMS/Debug> command submitted: " + command);

      commandSearch(command);
    }
  }
  /***** STATIC METHODS *****/
  /**
   * Searches for a command and executes the corresponding method.
   *
   * @param inputCommand The command to search for.
   */
  public static void commandSearch (String inputCommand) {
    switch (inputCommand.toLowerCase()) {
      case "help":
        commands.help();
        break;
      case "add":
        commands.addItem();
        break;
      case "view":
        commands.viewInventory(inventory);
        break;
      case "remove":
        commands.removeItem();
        break;
      case "update":
        commands.updateItem();
        break;
      case "exit":
        System.out.println("Exiting IMS2...");
        continueProgram = false;
        break;
      case "debug-add":
      //debug commands
        if (debugMode) {
          //useful if you want to add items to the inventory without going through the prompts
          System.out.println("Debug mode is enabled, adding items to inventory...");
          commands.addItem("Apple", 0.99, 10, "Fruit");
          commands.addItem("Banana", 0.49, 20, "Yellow");
          commands.addItem("Orange", 0.79, 15, "Citrus");
          commands.addItem("Grapes", 2.99, 5, "Fruit");
          break;
        }
      case "debug-resize":
        if (debugMode) {
          //useful if you want to test the resizeArray method
          System.out.println("Debug mode is enabled, resizing inventory array...");
          inventory = resizeArray(inventory, 10);
          break;
        }
      case "debug-reset":
        if (debugMode) {
          //useful if you want to reset the inventory array without restarting the program
          System.out.println("Debug mode is enabled, resetting inventory array...");
          inventory = new Item[1];
          inventory[0] = new Item();
          break;
        }
      case "debug-empty":
        if (debugMode) {
          //useful if you want to check when it adds items
            int emptySlotNumber = UtilityBelt.readInt("Debug mode is enabled, please enter slot index to empty: ", 0, inventory.length - 1);
            inventory[emptySlotNumber] = new Item();
          break;
        }
      default:
        System.out.println("Command not found, type 'help' for a list of commands");
        break;
    }
  }

  /**
   * Checks for items with certain parameters and returns the index of the first slot with those.
   *
   * @param items The array of items to check.
   * @return The index of the first slot with the specified parameters.
   */
  public static int emptySlotChecker(Item[] items) 
  {
    for (int i = 0; i < items.length; i++) {
      if (items[i] == null || items[i].getName().equals("Unknown") || items[i].isOverwriteable()) {
        return i;
      }
    }
    return -1;
  }

  /**
   * Resizes an Item array by the specified amount.
   *
   * @param array      The array to resize.
   * @param changeSize The amount to resize the array by.
   * @return The resized array.
   */
  public static Item[] resizeArray(Item[] array, int changeSize) {
    //Checks if the array is being resized by 0
    if (changeSize == 0) {
      return array;
    }
    //Creates a new array with the new size and copies the elements
    //from the old array to the new array
    Item[] newArray = new Item[array.length + changeSize];

    int elementsToCopy = Math.min(array.length, newArray.length);
    for (int i = 0; i < elementsToCopy; i++) {
      newArray[i] = array[i];
    }
    return newArray;
  }
}

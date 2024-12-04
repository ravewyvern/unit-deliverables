/********************************************
 *	AUTHORS:	Katelyn Nova Powers
 * COLLABORATORS: N/A
 *	LAST MODIFIED:	11/7/2024
 ********************************************/

/********************************************
 *	Inventory Management System
 *********************************************
 *	PROGRAM DESCRIPTION:
 *	Inventory Management System (IMS) is a command line interface (CLI) program
 *  that allows users to manage an inventory of items. The program allows users
 *  to add items to the inventory, view the inventory, remove items from the inventory,
 *  update the price of items, update the quantity of items, purchase items, and view
 *  items with low stock.
 *********************************************
 *	ALGORITHM:
 *   Initialize the Program
 *     Display a welcome message and instructions.
 *     Ask the user to input the number of items to add to the inventory (limit between 1 and 200).
 *     Initialize arrays (items, quantities, prices) based on the number of items.
 * Input Item Names
 *     Loop through the number of items and prompt the user to input the name for each item.
 * Optional Input for Quantities and Prices
 *     Ask the user if they want to add the quantities and prices for the items immediately.
 *     If the user selects 'Y', loop through the items:
 *         Prompt the user to input the quantity and price for each item.
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
 *  -----------------------------------------
 * Main
 * -----------------------------------------
 * +commandSearch(inputCommand: String): void
 * +barLength(charLength: int): String
 * +mathMin(a: int, b: int): int
 * +calcArrayTotalInt(array: int[]): int
 * +calcArrayValueTotal(quantity: int[], price: double[]): int
 * -----------------------------------------
 *
 * -----------------------------------------
 * Commands
 * -----------------------------------------
 * +help(): void
 * +addItem(): void
 * +viewInventory(): void
 * +removeItem(): void
 * +updatePrice(): void
 * +updateQuantity(): void
 * +purchaseItem(): void
 * +lowStock(): void
 * +switchItems(): void
 * +sortquantities(): void
 * -----------------------------------------
 *
 * -----------------------------------------
 * ArrayMethods
 * -----------------------------------------
 * +arrayString(a: int[]): String
 * +swapInt(array: int[], a: int, b: int): void
 * +swapString(array: String[], a: int, b: int): void
 * +swapDouble(array: double[], a: int, b: int): void
 * +indexOfMinDouble(array: double[], startIndex: int): double
 * +indexOfMinInt(array: int[], startIndex: int): int
 * +reverse(array: int[]): void
 * +selectionSort(array: int[]): void
 * +resizeIntArray(array: int[], changeSize: int): int[]
 * +resizeDoubleArray(array: double[], changeSize: int): double[]
 * +resizeStringArray(array: String[], changeSize: int): String[]
 * -----------------------------------------
 *
 * -----------------------------------------
 *********************************************
 *	ALL IMPORTED PACKAGES NEEDED AND PURPOSE:
 *	Not used for UD1
 *	<ex: Scanner= used for console input>
 *********************************************/

public class Main
{

  /***** CONSTANT SECTION *****/
  public static boolean continueProgram = true;
  public static String[] items;
  public static int[] quantities;
  public static double[] prices;

  public static void main(String[] args)
  {
    /***** DECLARATION SECTION *****/

    /***** INITIALIZATION SECTION *****/
    String command;

    /***** INTRO SECTION *****/

    /***** INPUT SECTION *****/

    /***** PROCESSING SECTION *****/

    /***** OUTPUT SECTION *****/
    System.out.println("Welcome to the Inventory Management System (IMS)!");
    System.out.println();
    System.out.println("To get started, please input the number of items you would like to add to the inventory. (this can be changed later)");

    int numItems = UtilityBelt.readInt("Number of items: ", 1, 200);

    // Initialize arrays based on the number of items
    items = new String[numItems];
    quantities = new int[numItems];
    prices = new double[numItems];

    // Loop through the number of items and prompt the user to input the name for each item
    for (int i = 0; i < numItems; i++) {
      items[i] = UtilityBelt.readString("Enter the name of item " + (i + 1) + ": ", 1, 50);
    }

    char Continue = UtilityBelt.readChar("Would you like to add the quatities and prices to the inventory now? (y/N): " ,"YNyn");

    // If the user selects 'Y', loop through the items and prompt the user to input the quantity and price for each item
    if (Continue == 'Y' || Continue == 'y')
    {
      for (int i = 0; i < numItems; i++)
      {
        quantities[i] = UtilityBelt.readInt("Enter the quantity of " + items[i] + "s: ", 1, 1000);
        prices[i] = UtilityBelt.readDouble("Enter the price of " + items[i] + "s: ", 1, 1000);
      }
    }

    System.out.println("Setup complete, starting IMS...");
    System.out.println();
    System.out.println("Inventory manager CLI started, type 'help' to get command list");

    // enters a loop that will continue until the continueProgram variable is false
    while (continueProgram) {
      command = UtilityBelt.readString("C:/IMS>", 1, 20);
      commandSearch(command);
    }
  }
  /***** STATIC METHODS *****/

  /**
   * This method takes in a string inputCommand and runs a switch statement to determine which command to run
   *
   * @param inputCommand
   */
  public static void commandSearch (String inputCommand) {
    switch (inputCommand) {
      case "help":
        Commands.help();
        break;
      case "add-item":
        Commands.addItem();
        break;
      case "view-inventory":
        Commands.viewInventory();
        break;
      case "remove-item":
        Commands.removeItem();
        break;
      case "update-price":
        Commands.updatePrice();
        break;
      case "update-quantity":
        Commands.updateQuantity();
        break;
      case "purchase-item":
        Commands.purchaseItem();
        break;
      case "low-stock":
        Commands.lowStock();
        break;
      case "exit":
        System.out.println("Exiting IMS...");
        continueProgram = false;
        break;
      case "switch-items":
        Commands.switchItems();
        break;
      case "sort-quantities":
        Commands.sortquantities();
        break;
      default:
        System.out.println("Command not found, type 'help' for a list of commands");
        break;
    }
  }

  /**
   * This method takes in an int charLength and returns a string of bars that is the length of charLength
   * @param charLength The length of the bar
   * @return A string of bars that is the length of charLength
   */
  public static String barLength(int charLength)
  {

    int extraLength = 0;
    String output = "";

    //check if the length is greater than 500 and if so, set the extra length and the char length
    if (charLength > 500)
    {
      extraLength = charLength - 500;
      charLength = 500;
    }
    int saveCharLength = charLength;

    saveCharLength /= 8;

    while (saveCharLength > 0)
    {
      output += ("█");
      saveCharLength--;
    }

    charLength %= 8;

    switch (charLength)
    {
      case 0:
        output += ("");
        break;
      case 1:
        output += ("▏");
        break;
      case 2:
        output += ("▎");
        break;
      case 3:
        output += ("▍");
        break;
      case 4:
        output += ("▌");
        break;
      case 5:
        output += ("▋");
        break;
      case 6:
        output += ("▊");
        break;
      case 7:
        output += ("▉");
        break;

    }
    if (extraLength != 0)
    {
      output += (" + " + extraLength);
    }

    return output;
  }

  /**
   * This method takes in two integers and returns the smaller of the two
   * @param a The first integer
   * @param b The second integer
   * @return The smaller of the two integers
   */
  public static int mathMin(int a, int b) {
    if (a < b) {
      return a;
    } else {
      return b;
    }
  }

  /**
   * This method calculates the total of an array of integers
   * @param array The array of integers
   * @return The total of the array
   */
  public static int calcArrayTotalInt (int[] array) {
    int total = 0;

    for (int i = 0; i < array.length; i++) {
      total += array[i];
    }
    return total;
  }

  /**
   * This method calculates the total value of two arrays of integers and doubles
   * @param quantity The array of integers
   * @param price The array of doubles
   * @return The total value of the two arrays
   */
  public static double calcArrayValueTotal (int[] quantity, double[] price) {
    double total = 0;

    for (int i = 0; i < quantity.length; i++) {
      total += quantity[i] * price[i];
    }

    total = (int) (total * 100);
    total /= 100;
    return total;
  }
}


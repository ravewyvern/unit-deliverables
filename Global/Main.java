import java.util.Scanner;

public class Main
  {
    public static void main(String[] args)
    {
      System.out.println("Welcome To my UD Projects");
      runner();
    }
    public static void runner() {
      String[] UDNames = {"Sleep Score Calculator", "Inventory Manager", "Inventory Manager V2"};
      Class[] UDProjects = {UD1Main.class, UD2Main.class, UD3Main.class};
      Scanner scanner = new Scanner(System.in);

      System.out.println();
      System.out.println("Please select a UD to run");
      for (int i = 0; i < UDNames.length; i++) {
        System.out.println(i + 1 + ". " + UDNames[i]);
      }
      System.out.println(UDNames.length + 1 + ". Exit");


      // Get user input (1-based index)
      System.out.print("Input a Number: ");
      int userChoice = scanner.nextInt();

      if (userChoice < 1 || userChoice > UDProjects.length + 1) {
        System.out.println("Invalid choice. Exiting.");
      } else if (userChoice == UDNames.length + 1) {
        System.out.println("Exiting Program");
        return;
      }

      // Get the selected class and invoke its main method
      try {
        // Get the corresponding class for the user's choice
        Class selectedClass = UDProjects[userChoice - 1];

        // Call the main method of the selected class
        UDProjects[userChoice - 1].getDeclaredMethod("main", String[].class).invoke(null, (Object) new String[]{});
      } catch (Exception e) {
        System.out.println("Error running the selected project: " + e.getMessage());
    }
  }
}

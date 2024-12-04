public class Commands {

    /**
     * Displays a list of all available commands.
     */
    public static void help() {
        System.out.println("Commands:");
        System.out.println("add-item: Add an item to the inventory");
        System.out.println("remove-item: Remove an item from the inventory");
        System.out.println("view-inventory: View the current inventory");
        System.out.println("update-price: Update the price of an item in the inventory");
        System.out.println("update-quantity: Update the quantity of an item in the inventory");
        System.out.println("purchase-item: Purchase an item from the inventory");
        System.out.println("low-stock: View items with a quantity below a certain amount");
        System.out.println("switch-items: Switch the position of two items in the inventory");
        System.out.println("sort-quantities: Sort the inventory by quantities");
        System.out.println("exit: Exit the program");
    }
    /**
     * Adds an item to the inventory by resizing the array.
     */
    public static void addItem() {
        Main.items = ArrayMethods.resizeStringArray(Main.items, 1);
        Main.quantities = ArrayMethods.resizeIntArray(Main.quantities, 1);
        Main.prices = ArrayMethods.resizeDoubleArray(Main.prices, 1);

        Main.items[Main.items.length - 1] = UtilityBelt.readString("Enter the name of the item: ", 1, 50);
        Main.quantities[Main.quantities.length - 1] = UtilityBelt.readInt("Enter the quantity of " + Main.items[Main.items.length - 1] + "s: ", 1, 1000);
        Main.prices[Main.prices.length - 1] = UtilityBelt.readDouble("Enter the price of " + Main.items[Main.items.length - 1] + "s: ", 1, 1000);
    }
    /**
     * Displays all the items in the parallel arrays.
     */
    public static void viewInventory() {
        System.out.println("Inventory:");
        System.out.println("you have " + Main.calcArrayTotalInt(Main.quantities) + " items with a total value of $" + Main.calcArrayValueTotal(Main.quantities, Main.prices));
        System.out.println();
        System.out.println("Item Name Quantity Price");

        for (int i = 0; i < Main.items.length; i++)
        {
            System.out.println((i + 1) + ". " + Main.items[i] + " " + Main.quantities[i] + " $" + Main.prices[i]);
            System.out.println(Main.barLength(Main.quantities[i]));

            if (i < Main.items.length - 1) {
                System.out.println("--------------------");
            }
        }
    }
    /**
     * Removes an item from the inventory by shifting the elements in the arrays.
     */
    public static void removeItem() {
        int itemNumber = UtilityBelt.readInt("Enter the number of the item you would like to remove: ", 1, Main.items.length);
        char confirm = UtilityBelt.readChar("Are you sure you want to remove " + Main.items[itemNumber - 1] + "s? (y/N): ", "YNyn");

        if (confirm == 'Y' || confirm == 'y')
        {
            for (int i = itemNumber - 1; i < Main.items.length - 1; i++)
            {
                Main.items[i] = Main.items[i + 1];
                Main.quantities[i] = Main.quantities[i + 1];
                Main.prices[i] = Main.prices[i + 1];
            }

            Main.items = ArrayMethods.resizeStringArray(Main.items, -1);
            Main.quantities = ArrayMethods.resizeIntArray(Main.quantities, -1);
            Main.prices = ArrayMethods.resizeDoubleArray(Main.prices, -1);

            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Removal cancelled.");
        }
    }

    /**
     * Updates the price of an item in the inventory.
     */
    public static void updatePrice() {
        int itemNumberPrice = UtilityBelt.readInt("Enter the number of the item you would like to update the price of: ", 1, Main.items.length);
        Main.prices[itemNumberPrice - 1] = UtilityBelt.readDouble("Enter the new price of " + Main.items[itemNumberPrice - 1] + "s: ", 1, 1000);
    }
    /**
     * Updates the quantity of an item in the inventory.
     */
    public static void updateQuantity() {
        int itemNumberQuantity = UtilityBelt.readInt("Enter the number of the item you would like to update the quantity of: ", 1, Main.items.length);
        Main.quantities[itemNumberQuantity - 1] = UtilityBelt.readInt("Enter the new quantity of " + Main.items[itemNumberQuantity - 1] + "s: ", 1, 1000);
    }
    /**
     * Allows the user to purchase an item from the inventory and removes the purchased amount from the quantity.
     */
    public static void purchaseItem() {
        int itemNumberPurchase = UtilityBelt.readInt("Enter the number of the item you would like to purchase: ", 1, Main.items.length);
        int purchaseAmount = UtilityBelt.readInt("Enter the amount of " + Main.items[itemNumberPurchase - 1] + "s you would like to purchase: ", 1, Main.quantities[itemNumberPurchase - 1]);
        char purchaseConfirm = UtilityBelt.readChar("Confirm purchase of " + purchaseAmount + " " + Main.items[itemNumberPurchase - 1] + "s for $" + (Main.prices[itemNumberPurchase - 1] * purchaseAmount) + " (y/N): ", "YNyn");

        if (purchaseConfirm == 'Y' || purchaseConfirm == 'y') {
            Main.quantities[itemNumberPurchase - 1] -= purchaseAmount;
            System.out.println("Purchase successful, you spent $" + (Main.prices[itemNumberPurchase - 1] * purchaseAmount) + " on " + purchaseAmount + " " + Main.items[itemNumberPurchase - 1] + "s");
        }
        else {
            System.out.println("Purchase canelled");
        }
    }

    /**
     * Displays a low stock alert for items with a quantity below a certain amount.
     */
    public static void lowStock() {
        int lowStock = UtilityBelt.readInt("Enter the minimum quantity for a low stock alert: ", 1, 1000);

        for (int i = 0; i < Main.items.length; i++) {
            if (Main.quantities[i] < lowStock) {
                System.out.println("Low stock alert: " + Main.items[i] + " has less than " + lowStock + " items left");
            }
        }
    }

    /**
     * Switches the position of two items in the inventory.
     */
    public static void switchItems() {
        int item1 = UtilityBelt.readInt("Enter the number of the first item you would like to switch: ", 1, Main.items.length);
        int item2 = UtilityBelt.readInt("Enter the number of the item you want to switch with" + Main.items[item1] +": ", 1, Main.items.length);

        ArrayMethods.swapInt(Main.quantities, item1, item2);
        ArrayMethods.swapDouble(Main.prices, item1, item2);
        ArrayMethods.swapString(Main.items, item1, item2);

        System.out.println(Main.items[item1] + " and " + Main.items[item2] + " have been switched");
    }

    /**
     * Sorts the inventory by quantities using the swap method.
     */
    public static void sortquantities() {
        for (int i = 0; i < Main.prices.length; i++) {
            int minIndex = ArrayMethods.indexOfMin(Main.quantities, i);
            ArrayMethods.swapInt(Main.quantities, i, minIndex);
            ArrayMethods.swapDouble(Main.prices, i, minIndex);
            ArrayMethods.swapString(Main.items, i, minIndex);
        }

        System.out.println("Inventory sorted by quantities");
    }

}

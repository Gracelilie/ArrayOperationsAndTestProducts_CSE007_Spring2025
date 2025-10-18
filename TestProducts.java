/**
* @author Grace-lilie Acheampong
*@since March 26 2025
*@class CSE 007
*@IDE Java 11, VS Code
*@Descr: This program implements a product inventory system using a linear search.
*/

 public class TestProducts {
    public static void main(String[] args) {
        // Product data arrays
        String[] product_names = {"Laptop", "Mouse", "Keyboard", "Monitor", "Printer", "Tablet", "Phone", "Headphones", "Speaker", "Camera", "Smartwatch", "Charger", "Router", "Microphone", "SSD"};
        int[] product_IDs = {501, 203, 150, 789, 322, 605, 412, 908, 715, 256, 147, 889, 312, 722, 531};
        double[] product_prices = {999.99, 29.99, 49.99, 199.99, 129.99, 299.99, 699.99, 89.99, 59.99, 249.99, 199.99, 19.99, 79.99, 99.99, 149.99};
        int[] product_stock_levels = {5, 50, 30, 10, 7, 20, 15, 40, 35, 12, 8, 60, 25, 18, 22};
        
        // Validate command-line argument
        if (args.length != 1) {
            System.out.println("Usage: java TestProducts <Product ID>");
            return;
        }
        
        int prodKey = Integer.parseInt(args[0]);
        
        // Display the product inventory
        displayInventory(product_IDs, product_names, product_prices, product_stock_levels);
        
        // Perform the linear search
        linearSearch(prodKey, product_IDs, product_names, product_prices, product_stock_levels);
    }
    
    /**
     * Displays the complete product inventory in a formatted table.
     * @param product_IDs Array of product IDs.
     * @param product_names Array of product names.
     * @param product_prices Array of product prices.
     * @param product_stock_levels Array of product stock levels.
     */
    static void displayInventory(int[] product_IDs, String[] product_names, double[] product_prices, int[] product_stock_levels) {
        System.out.printf("%-10s %-15s %-10s %-10s%n", "ID", "Name", "Price ($)", "Stock");
        System.out.println("--------------------------------------------------");
        for (int i = 0; i < product_IDs.length; i++) {
            System.out.printf("%-10d %-15s %-10.2f %-10d%n", product_IDs[i], product_names[i], product_prices[i], product_stock_levels[i]);
        }
        System.out.println();
    }
    
    /**
     * Performs a linear search for a product by ID and displays the result.
     * Tracks and displays the number of comparisons made during the search.
     * 
     * @param searchID The product ID to search for.
     * @param ids Array of product IDs.
     * @param names Array of product names.
     * @param prices Array of product prices.
     * @param stock Array of product stock levels.
     */
    public static void linearSearch(int searchID, int[] ids, String[] names, double[] prices, int[] stock) {
        int[] result = {-1, 0}; // result[0] = index, result[1] = comparisons
        
        for (int i = 0; i < ids.length; i++) {
            result[1]++;
            if (ids[i] == searchID) {
                result[0] = i;
                break;
            }
        }
        
        if (result[0] != -1) {
            System.out.println("Product found:");
            System.out.printf("ID: %d\nName: %s\nPrice: $%.2f\nStock Level: %d\n", ids[result[0]], names[result[0]], prices[result[0]], stock[result[0]]);
        } else {
            System.out.println("Product not found.");
        }
        System.out.println("Comparisons made: " + result[1]);
    }
}

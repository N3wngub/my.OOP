import java.util.Scanner;

public class Ai_Tester {

    static Scanner kb = new Scanner(System.in);

    // ==================== MENU ITEMS ====================
    static Beverage[] beverages = {
            new Beverage("100", "Matcha",    100, 100, true),
            new Beverage("101", "Mocca",      80,  50, true),
            new Beverage("102", "Lemonade",   60,  75, false),
            new Beverage("103", "Green Tea",  50,  30, true)
    };

    static Food[] foods = {
            new Food("200", "Steak",        150, 50, false),
            new Food("201", "Potato",        90, 50, false),
            new Food("202", "Salad",         80,  0, true),
            new Food("203", "Spicy Pasta",  120, 80, false)
    };

    // ==================== TABLES ====================
    static Table[] tables = new Table[5];
    static int orderCounter = 1;

    // =====================================================
    //                     MAIN
    // =====================================================
    public static void main(String[] args) {
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(i + 1);
        }

        System.out.println("========================================");
        System.out.println("      Welcome to POS System v1.0        ");
        System.out.println("========================================");

        boolean running = true;
        while (running) {
            printMainMenu();
            int choice = getIntInput("Enter choice: ");
            switch (choice) {
                case 1 -> openTableMenu();
                case 2 -> orderMenu();
                case 3 -> checkoutMenu();
                case 4 -> viewAllTables();
                case 5 -> viewAllMenuItems();
                case 0 -> {
                    running = false;
                    System.out.println("\nThank you! Goodbye.");
                }
                default -> System.out.println("  [!] Invalid choice. Please try again.");
            }
        }
        kb.close();
    }

    // ==================== MAIN MENU ====================
    static void printMainMenu() {
        System.out.println("\n========================================");
        System.out.println("              MAIN MENU                 ");
        System.out.println("========================================");
        System.out.println("  1. Open Table");
        System.out.println("  2. Add Items to Order");
        System.out.println("  3. Checkout & Payment");
        System.out.println("  4. View All Tables Status");
        System.out.println("  5. View All Menu Items");
        System.out.println("  0. Exit");
        System.out.println("----------------------------------------");
    }

    // ==================== 1. OPEN TABLE ====================
    static void openTableMenu() {
        System.out.println("\n--- Open Table ---");
        viewAllTables();
        int tableNum = getIntInput("Enter table number to open (1-" + tables.length + "): ");
        if (!isValidTable(tableNum)) return;

        Table t = tables[tableNum - 1];
        if (t.isOccupied) {
            System.out.println("  [!] Table " + tableNum + " is already occupied.");
            return;
        }
        String orderId = String.format("ORD%03d", orderCounter++);
        t.openTable(orderId);
        System.out.println("  [✓] Table " + tableNum + " opened. Order ID: " + orderId);
    }

    // ==================== 2. ORDER MENU ====================
    static void orderMenu() {
        System.out.println("\n--- Add Items to Order ---");
        viewOccupiedTables();
        int tableNum = getIntInput("Enter table number: ");
        if (!isValidTable(tableNum)) return;

        Table t = tables[tableNum - 1];
        if (!t.isOccupied) {
            System.out.println("  [!] Table " + tableNum + " is not open. Please open the table first.");
            return;
        }

        boolean ordering = true;
        while (ordering) {
            System.out.println("\n  -- Add Item to Table " + tableNum + " [" + t.currentOrder.orderId + "] --");
            System.out.println("  1. Add Food");
            System.out.println("  2. Add Beverage");
            System.out.println("  3. View Current Order");
            System.out.println("  0. Back to Main Menu");
            int choice = getIntInput("  Choice: ");
            switch (choice) {
                case 1 -> addFoodToOrder(t);
                case 2 -> addBeverageToOrder(t);
                case 3 -> printCurrentOrder(t);
                case 0 -> ordering = false;
                default -> System.out.println("  [!] Invalid choice.");
            }
        }
    }

    static void addFoodToOrder(Table t) {
        System.out.println("\n  === Food Menu ===");
        System.out.printf("  %-6s %-16s %8s %10s %8s%n", "ID", "Name", "Price", "Spiciness", "Vegan");
        System.out.println("  " + "-".repeat(54));
        for (Food f : foods) {
            System.out.printf("  %-6s %-16s %8.2f %10d %8s%n",
                    f.id, f.name, f.price, f.spicinessLevel, f.isVegan ? "Yes" : "No");
        }
        String id = getStringInput("  Enter Food ID to add (or 0 to cancel): ");
        if (id.equals("0")) return;
        Food found = findFood(id);
        if (found == null) { System.out.println("  [!] Food ID not found."); return; }
        t.currentOrder.addItem(found);
        System.out.println("  [✓] Added: " + found.name + " (฿" + String.format("%.2f", found.price) + ")");
    }

    static void addBeverageToOrder(Table t) {
        System.out.println("\n  === Beverage Menu ===");
        System.out.printf("  %-6s %-16s %8s %10s %8s%n", "ID", "Name", "Price", "Sweetness", "Hot/Cold");
        System.out.println("  " + "-".repeat(54));
        for (Beverage b : beverages) {
            System.out.printf("  %-6s %-16s %8.2f %10d %8s%n",
                    b.id, b.name, b.price, b.sweetnessLevel, b.isHot ? "Hot" : "Cold");
        }
        String id = getStringInput("  Enter Beverage ID to add (or 0 to cancel): ");
        if (id.equals("0")) return;
        Beverage found = findBeverage(id);
        if (found == null) { System.out.println("  [!] Beverage ID not found."); return; }
        t.currentOrder.addItem(found);
        System.out.println("  [✓] Added: " + found.name + " (฿" + String.format("%.2f", found.price) + ")");
    }

    static void printCurrentOrder(Table t) {
        Order o = t.currentOrder;
        System.out.println("\n  === Current Order [" + o.orderId + "] - Table " + t.tableNumber + " ===");
        if (o.itemCount == 0) {
            System.out.println("  (No items yet)");
            return;
        }
        System.out.printf("  %-6s %-18s %8s%n", "ID", "Name", "Price");
        System.out.println("  " + "-".repeat(35));
        for (int i = 0; i < o.itemCount; i++) {
            System.out.printf("  %-6s %-18s %8.2f%n",
                    o.items[i].id, o.items[i].name, o.items[i].price);
        }
        System.out.println("  " + "-".repeat(35));
        System.out.printf("  %-24s %8.2f%n", "Subtotal (excl. tax):", o.calculateTotal());
    }

    // ==================== 3. CHECKOUT ====================
    static void checkoutMenu() {
        System.out.println("\n--- Checkout ---");
        viewOccupiedTables();
        int tableNum = getIntInput("Enter table number to checkout: ");
        if (!isValidTable(tableNum)) return;

        Table t = tables[tableNum - 1];
        if (!t.isOccupied) {
            System.out.println("  [!] Table " + tableNum + " has no active order.");
            return;
        }
        if (t.currentOrder.itemCount == 0) {
            System.out.println("  [!] No items in order. Please add items first.");
            return;
        }

        printCurrentOrder(t);

        System.out.println("\n  Select tax rate:");
        System.out.println("  1. VAT 7%");
        System.out.println("  2. No Tax (0%)");
        int taxChoice = getIntInput("  Choice: ");
        double taxRate = (taxChoice == 1) ? 0.07 : 0.0;

        Payment payment = new Payment(t.currentOrder, taxRate);

        double grandTotal = payment.calculateGrandTotal();
        System.out.printf("%n  Grand Total (incl. tax): ฿%.2f%n", grandTotal);

        double cash = 0;
        boolean validCash = false;
        while (!validCash) {
            cash = getDoubleInput("  Enter cash amount: ฿");
            if (cash >= grandTotal) {
                validCash = true;
            } else {
                System.out.printf("  [!] Insufficient cash. Need ฿%.2f more.%n", grandTotal - cash);
            }
        }

        // BUG FIX: คำนวณ change โดยตรง ไม่ผ่าน processPayment เพื่อป้องกัน double-call
        double change = cash - grandTotal;
        printReceipt(t, payment, cash, change);
        t.closeTable();
        System.out.println("\n  [✓] Table " + tableNum + " closed. Thank you!");
    }

    static void printReceipt(Table t, Payment p, double cash, double change) {
        Order o = t.currentOrder;
        System.out.println("\n  ╔══════════════════════════════════╗");
        System.out.println("  ║             RECEIPT              ║");
        System.out.println("  ╠══════════════════════════════════╣");
        System.out.printf( "  ║  Order  : %-23s║%n", o.orderId);
        System.out.printf( "  ║  Table  : %-23s║%n", "Table " + t.tableNumber);
        System.out.println("  ╠══════════════════════════════════╣");
        System.out.printf( "  ║  %-20s %12s║%n", "Item", "Price (฿)");
        System.out.println("  ║  " + "-".repeat(32) + "║");
        for (int i = 0; i < o.itemCount; i++) {
            System.out.printf("  ║  %-20s %11.2f ║%n",
                    o.items[i].name, o.items[i].price);
        }
        System.out.println("  ╠══════════════════════════════════╣");
        System.out.printf( "  ║  %-20s %11.2f ║%n", "Subtotal:", o.calculateTotal());
        System.out.printf( "  ║  %-20s %11.2f ║%n",
                "Tax (" + (int)(p.taxRate * 100) + "%):", o.calculateTotal() * p.taxRate);
        System.out.printf( "  ║  %-20s %11.2f ║%n", "Grand Total:", p.calculateGrandTotal());
        System.out.println("  ╠══════════════════════════════════╣");
        System.out.printf( "  ║  %-20s %11.2f ║%n", "Cash:", cash);
        System.out.printf( "  ║  %-20s %11.2f ║%n", "Change:", change);
        System.out.println("  ╚══════════════════════════════════╝");
    }

    // ==================== 4. VIEW TABLES ====================
    static void viewAllTables() {
        System.out.println("\n  === Table Status ===");
        System.out.printf("  %-10s %-12s %-10s %-6s%n", "Table", "Status", "Order ID", "Items");
        System.out.println("  " + "-".repeat(42));
        for (Table t : tables) {
            System.out.printf("  %-10s %-12s %-10s %-6s%n",
                    "Table " + t.tableNumber,
                    t.isOccupied ? "🟠 Occupied" : "🟢 Available",
                    t.isOccupied ? t.currentOrder.orderId : "-",
                    t.isOccupied ? t.currentOrder.itemCount : "-");
        }
    }

    static void viewOccupiedTables() {
        System.out.println("\n  Active Tables:");
        boolean any = false;
        for (Table t : tables) {
            if (t.isOccupied) {
                System.out.printf("    Table %d  →  Order: %s  (%d items)%n",
                        t.tableNumber, t.currentOrder.orderId, t.currentOrder.itemCount);
                any = true;
            }
        }
        if (!any) System.out.println("    (No active tables)");
    }

    // ==================== 5. VIEW MENU ====================
    static void viewAllMenuItems() {
        System.out.println("\n  ===== FOOD MENU =====");
        System.out.printf("  %-6s %-16s %8s %10s %8s%n", "ID", "Name", "Price", "Spiciness", "Vegan");
        System.out.println("  " + "-".repeat(54));
        for (Food f : foods) {
            System.out.printf("  %-6s %-16s %8.2f %10d %8s%n",
                    f.id, f.name, f.price, f.spicinessLevel, f.isVegan ? "Yes" : "No");
        }
        System.out.println("\n  ===== BEVERAGE MENU =====");
        System.out.printf("  %-6s %-16s %8s %10s %8s%n", "ID", "Name", "Price", "Sweetness", "Hot/Cold");
        System.out.println("  " + "-".repeat(54));
        for (Beverage b : beverages) {
            System.out.printf("  %-6s %-16s %8.2f %10d %8s%n",
                    b.id, b.name, b.price, b.sweetnessLevel, b.isHot ? "Hot" : "Cold");
        }
    }

    // ==================== HELPER METHODS ====================
    static boolean isValidTable(int num) {
        if (num < 1 || num > tables.length) {
            System.out.println("  [!] Invalid table number. Please enter 1-" + tables.length);
            return false;
        }
        return true;
    }

    static Food findFood(String id) {
        for (Food f : foods) if (f.id.equals(id)) return f;
        return null;
    }

    static Beverage findBeverage(String id) {
        for (Beverage b : beverages) if (b.id.equals(id)) return b;
        return null;
    }

    static int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!kb.hasNextInt()) {
            kb.next();
            System.out.print("  [!] Please enter a valid number: ");
        }
        int val = kb.nextInt();
        kb.nextLine();
        return val;
    }

    static double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!kb.hasNextDouble()) {
            kb.next();
            System.out.print("  [!] Please enter a valid amount: ");
        }
        double val = kb.nextDouble();
        kb.nextLine();
        return val;
    }

    static String getStringInput(String prompt) {
        System.out.print(prompt);
        return kb.next();
    }
}
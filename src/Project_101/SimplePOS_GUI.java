import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimplePOS_GUI {

    // ==================== ข้อมูลที่มีอยู่เดิม ====================
    static Beverage[] beverages = {
            new Beverage("100", "Matcha", 100, 100, true),
            new Beverage("101", "Mocca", 80, 50, true),
            new Beverage("102", "Lemonade", 60, 75, false),
            new Beverage("103", "Green Tea", 50, 30, true)
    };

    static Food[] foods = {
            new Food("200", "Steak", 150, 50, false),
            new Food("201", "Potato", 90, 50, false),
            new Food("202", "Salad", 80, 0, true),
            new Food("203", "Spicy Pasta", 120, 80, false)
    };

    static Table[] tables = new Table[5];
    static int orderCounter = 1;

    public static void main(String[] args) {
        // สร้างโต๊ะ
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(i + 1);
        }

        // ==================== สร้าง GUI แบบเดียวกับ Lab_13 ====================
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(100, 100, 600, 500);
        fr.setTitle("Simple POS System");
        fr.getContentPane().setLayout(null); // ใช้ Absolute Layout แบบที่คุณเคยทำ

        // --- ส่วนแสดงผล (JTextArea) ---
        JTextArea display = new JTextArea();
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setBounds(30, 20, 520, 250);
        fr.getContentPane().add(scroll);

        display.setText("Welcome to POS System\nClick 'View Menu' or 'View Tables' to start.");

        // --- แถวที่ 1: จัดการโต๊ะ ---
        JLabel lblTable = new JLabel("Table No (1-5):");
        lblTable.setBounds(30, 290, 100, 20);
        fr.getContentPane().add(lblTable);

        JTextField txtTable = new JTextField();
        txtTable.setBounds(130, 290, 50, 20);
        fr.getContentPane().add(txtTable);

        JButton btnOpen = new JButton("Open Table");
        btnOpen.setBounds(190, 290, 110, 20);
        fr.getContentPane().add(btnOpen);

        // --- แถวที่ 2: สั่งอาหาร ---
        JLabel lblItem = new JLabel("Item ID:");
        lblItem.setBounds(30, 320, 100, 20);
        fr.getContentPane().add(lblItem);

        JTextField txtItem = new JTextField();
        txtItem.setBounds(130, 320, 50, 20);
        fr.getContentPane().add(txtItem);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.setBounds(190, 320, 110, 20);
        fr.getContentPane().add(btnAdd);

        // --- แถวที่ 3: จ่ายเงิน ---
        JLabel lblCash = new JLabel("Cash:");
        lblCash.setBounds(30, 350, 100, 20);
        fr.getContentPane().add(lblCash);

        JTextField txtCash = new JTextField();
        txtCash.setBounds(130, 350, 50, 20);
        fr.getContentPane().add(txtCash);

        JButton btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(190, 350, 110, 20);
        fr.getContentPane().add(btnCheckout);

        // --- ปุ่มดูข้อมูลด้านขวา ---
        JButton btnViewMenu = new JButton("View Menu");
        btnViewMenu.setBounds(350, 290, 150, 30);
        fr.getContentPane().add(btnViewMenu);

        JButton btnViewTables = new JButton("View Tables");
        btnViewTables.setBounds(350, 330, 150, 30);
        fr.getContentPane().add(btnViewTables);


        // ==================== การใส่ Event ให้ปุ่ม (Action Listener) ====================

        // ปุ่มดูเมนู
        btnViewMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                display.setText("=== MENU ===\n");
                display.append("-- Food --\n");
                for (int i = 0; i < foods.length; i++) {
                    display.append(foods[i].id + "  " + foods[i].name + "  " + foods[i].price + " Baht\n");
                }
                display.append("\n-- Beverage --\n");
                for (int i = 0; i < beverages.length; i++) {
                    display.append(beverages[i].id + "  " + beverages[i].name + "  " + beverages[i].price + " Baht\n");
                }
            }
        });

        // ปุ่มดูสถานะโต๊ะ
        btnViewTables.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                display.setText("=== TABLE STATUS ===\n");
                for (int i = 0; i < tables.length; i++) {
                    Table t = tables[i];
                    if (t.isOccupied) {
                        display.append("Table " + t.tableNumber + " : Occupied (Order: " + t.currentOrder.orderId + ")\n");
                    } else {
                        display.append("Table " + t.tableNumber + " : Available\n");
                    }
                }
            }
        });

        // ปุ่มเปิดโต๊ะ
        btnOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int tNum = Integer.parseInt(txtTable.getText());
                    if (tNum >= 1 && tNum <= 5) {
                        Table t = tables[tNum - 1];
                        if (t.isOccupied) {
                            JOptionPane.showMessageDialog(fr, "Table " + tNum + " is already occupied.");
                        } else {
                            String orderId = "ORD" + String.format("%03d", orderCounter++);
                            t.openTable(orderId);
                            display.setText("Opened Table " + tNum + "\nOrder ID: " + orderId);
                        }
                    } else {
                        JOptionPane.showMessageDialog(fr, "Table must be 1-5");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fr, "Invalid Table Number");
                }
            }
        });

        // ปุ่มเพิ่มไอเทม
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int tNum = Integer.parseInt(txtTable.getText());
                    String itemId = txtItem.getText();
                    if (tNum >= 1 && tNum <= 5) {
                        Table t = tables[tNum - 1];
                        if (!t.isOccupied) {
                            JOptionPane.showMessageDialog(fr, "Table is not open. Please open table first.");
                            return;
                        }

                        // ค้นหาว่าตรงกับ Food หรือ Beverage
                        MenuItem found = null;
                        for (int i = 0; i < foods.length; i++) {
                            if (foods[i].id.equals(itemId)) found = foods[i];
                        }
                        for (int i = 0; i < beverages.length; i++) {
                            if (beverages[i].id.equals(itemId)) found = beverages[i];
                        }

                        if (found != null) {
                            t.currentOrder.addItem(found);
                            display.setText("Added: " + found.getName() + " to Table " + tNum + "\n");
                            display.append("Total Items: " + t.currentOrder.itemCount + "\n");
                            display.append("Current Subtotal: " + t.currentOrder.calculateTotal() + " Baht");
                        } else {
                            JOptionPane.showMessageDialog(fr, "Item ID not found!");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fr, "Invalid Input");
                }
            }
        });

        // ปุ่มจ่ายเงิน
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int tNum = Integer.parseInt(txtTable.getText());
                    double cash = Double.parseDouble(txtCash.getText());

                    if (tNum >= 1 && tNum <= 5) {
                        Table t = tables[tNum - 1];
                        if (!t.isOccupied) {
                            JOptionPane.showMessageDialog(fr, "Table is not open.");
                            return;
                        }
                        if (t.currentOrder.itemCount == 0) {
                            JOptionPane.showMessageDialog(fr, "No items in order.");
                            return;
                        }

                        Payment p = new Payment(t.currentOrder, 0.07); // ภาษี 7%
                        double grandTotal = p.calculateGrandTotal();

                        if (cash >= grandTotal) {
                            double change = cash - grandTotal;
                            display.setText("=== RECEIPT ===\n");
                            display.append("Table: " + tNum + "   Order: " + t.currentOrder.orderId + "\n");
                            display.append("---------------------------------\n");
                            for (int i = 0; i < t.currentOrder.itemCount; i++) {
                                display.append(t.currentOrder.items[i].getName() + " \t" + t.currentOrder.items[i].getPrice() + "\n");
                            }
                            display.append("---------------------------------\n");
                            display.append("Subtotal: \t" + t.currentOrder.calculateTotal() + "\n");
                            display.append("Grand Total(inc. tax): \t" + grandTotal + "\n");
                            display.append("Cash: \t" + cash + "\n");
                            display.append("Change: \t" + change + "\n");
                            display.append("====================\nThank You!");

                            t.closeTable(); // ปิดโต๊ะ
                            txtItem.setText("");
                            txtCash.setText("");
                        } else {
                            JOptionPane.showMessageDialog(fr, "Not enough cash! Need " + (grandTotal - cash) + " more.");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fr, "Invalid Input / Missing Cash");
                }
            }
        });

        fr.setVisible(true);
    }
}
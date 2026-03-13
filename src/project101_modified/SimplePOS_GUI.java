import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * GUI อย่างง่ายสำหรับระบบ POS
 *
 * สร้างหน้าต่าง Swing เพื่อเปิดโต๊ะ เพิ่มรายการ และชำระเงิน
 */
public class SimplePOS_GUI {

    // ข้อมูลเมนูตัวอย่าง
    /** รายการเครื่องดื่มตัวอย่าง */
    static Beverage[] beverages = {
            new Beverage("100", "Matcha", 100, 100, true),
            new Beverage("101", "Mocca", 80, 50, true),
            new Beverage("102", "Lemonade", 60, 75, false),
            new Beverage("103", "Green Tea", 50, 30, true)
    };

    /** รายการอาหารตัวอย่าง */
    static Food[] foods = {
            new Food("200", "Steak", 150, 50, false),
            new Food("201", "Potato", 90, 50, false),
            new Food("202", "Salad", 80, 0, true),
            new Food("203", "Spicy Pasta", 120, 80, false)
    };

    /** โต๊ะในร้านอาหาร */
    static Table[] tables = new Table[5];

    /** ตัวนับสร้างรหัสออร์เดอร์ */
    static int orderCounter = 1;

    /**
     * รายการพนักงานตัวอย่าง
     */
    static Staff[] staffMembers = {
            new Staff("S001", "Alice", "Smith"),
            new Staff("S002", "Bob", "Jones"),
            new Staff("S003", "Carol", "Davis")
    };

    /**
     * เมธอดหลักที่ตั้งค่า GUI และ event listener
     *
     * @param args ไม่ใช้
     */
    public static void main(String[] args) {
        // สร้าง instance ของโต๊ะ
        for (int i = 0; i < tables.length; i++) {
            tables[i] = new Table(i + 1);
        }

        // ==================== สร้าง GUI ====================
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(100, 100, 600, 500);
        fr.setTitle("Simple POS System");
        fr.getContentPane().setLayout(null); // ใช้เลย์เอาต์ระบุตำแหน่งแบบเด็ดขาดเพื่อความเรียบง่าย

        // --- พื้นที่แสดงผลสำหรับข้อความและใบเสร็จ ---
        JTextArea display = new JTextArea();
        display.setEditable(false);
        JScrollPane scroll = new JScrollPane(display);
        scroll.setBounds(30, 20, 520, 230);
        fr.getContentPane().add(scroll);
        display.setText("Welcome to POS System\nClick 'View Menu' or 'View Tables' to start.");

        // --- แถวสำหรับเลือกพนักงาน ---
        JLabel lblStaff = new JLabel("Staff:");
        lblStaff.setBounds(30, 260, 100, 20);
        fr.getContentPane().add(lblStaff);

        // สร้างรายการชื่อพนักงานสำหรับ combobox แต่ละรายการแสดงรหัสและชื่อเต็ม
        String[] staffOptions = new String[staffMembers.length];
        for (int i = 0; i < staffMembers.length; i++) {
            staffOptions[i] = staffMembers[i].getStaffId() + " - " + staffMembers[i].getFullName();
        }
        JComboBox<String> cmbStaff = new JComboBox<>(staffOptions);
        cmbStaff.setBounds(130, 260, 170, 20);
        fr.getContentPane().add(cmbStaff);

        // --- แถวที่ 1: การจัดการโต๊ะ ---
        JLabel lblTable = new JLabel("Table No (1-5):");
        lblTable.setBounds(30, 290, 100, 20);
        fr.getContentPane().add(lblTable);

        JTextField txtTable = new JTextField();
        txtTable.setBounds(130, 290, 50, 20);
        fr.getContentPane().add(txtTable);

        JButton btnOpen = new JButton("Open Table");
        btnOpen.setBounds(190, 290, 110, 20);
        fr.getContentPane().add(btnOpen);

        // --- แถวที่ 2: เพิ่มรายการลงในออร์เดอร์ ---
        JLabel lblItem = new JLabel("Item ID:");
        lblItem.setBounds(30, 320, 100, 20);
        fr.getContentPane().add(lblItem);

        JTextField txtItem = new JTextField();
        txtItem.setBounds(130, 320, 50, 20);
        fr.getContentPane().add(txtItem);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.setBounds(190, 320, 110, 20);
        fr.getContentPane().add(btnAdd);

        // --- แถวที่ 3: ชำระเงิน ---
        JLabel lblCash = new JLabel("Cash:");
        lblCash.setBounds(30, 350, 100, 20);
        fr.getContentPane().add(lblCash);

        JTextField txtCash = new JTextField();
        txtCash.setBounds(130, 350, 50, 20);
        fr.getContentPane().add(txtCash);

        JButton btnCheckout = new JButton("Checkout");
        btnCheckout.setBounds(190, 350, 110, 20);
        fr.getContentPane().add(btnCheckout);

        // --- ปุ่มด้านขวาสำหรับดูเมนูและสถานะโต๊ะ ---
        JButton btnViewMenu = new JButton("View Menu");
        btnViewMenu.setBounds(350, 290, 150, 30);
        fr.getContentPane().add(btnViewMenu);

        JButton btnViewTables = new JButton("View Tables");
        btnViewTables.setBounds(350, 330, 150, 30);
        fr.getContentPane().add(btnViewTables);

        // การตั้งค่า Event Listener

        // ปุ่มดูเมนู: แสดงรายการอาหารและเครื่องดื่ม
        btnViewMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                display.setText("=== MENU ===\n");
                display.append("-- Food --\n");
                for (int i = 0; i < foods.length; i++) {
                    // ใช้ getter แทนการเข้าถึงฟิลด์โดยตรง
                    display.append(foods[i].getId() + "  " + foods[i].getName() + "  "
                            + foods[i].getPrice() + " Baht\n");
                }
                display.append("\n-- Beverage --\n");
                for (int i = 0; i < beverages.length; i++) {
                    display.append(beverages[i].getId() + "  " + beverages[i].getName() + "  "
                            + beverages[i].getPrice() + " Baht\n");
                }
            }
        });

        // ปุ่มดูโต๊ะ: แสดงสถานะของแต่ละโต๊ะ
        btnViewTables.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                display.setText("=== TABLE STATUS ===\n");
                for (int i = 0; i < tables.length; i++) {
                    Table t = tables[i];
                    // ใช้ข้อมูลจาก Table เพื่อสร้างข้อความ
                    if (t.isOccupied()) {
                        String staffName = (t.getAssignedStaff() != null)
                                ? t.getAssignedStaff().getFullName() + " (" + t.getAssignedStaff().getStaffId() + ")"
                                : "Unassigned";
                        display.append("Table " + t.getTableNumber() + " : Occupied (Order: "
                                + t.getCurrentOrder().getOrderId() + ", Staff: " + staffName + ")\n");
                    } else {
                        display.append("Table " + t.getTableNumber() + " : Available\n");
                    }
                }
            }
        });

        // ปุ่มเปิดโต๊ะ
        btnOpen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int tNum = Integer.parseInt(txtTable.getText());
                    if (tNum >= 1 && tNum <= tables.length) {
                        Table t = tables[tNum - 1];
                        if (t.isOccupied()) {
                            JOptionPane.showMessageDialog(fr, "Table " + tNum + " is already occupied.");
                        } else {
                            String orderId = "ORD" + String.format("%03d", orderCounter++);
                            t.openTable(orderId);
                            // มอบหมายพนักงานที่เลือก
                            int staffIndex = cmbStaff.getSelectedIndex();
                            Staff selectedStaff = staffMembers[staffIndex];
                            t.setAssignedStaff(selectedStaff);
                            display.setText("Opened Table " + tNum + "\nOrder ID: " + orderId
                                    + "\nStaff: " + selectedStaff.getFullName() + " (" + selectedStaff.getStaffId() + ")");
                        }
                    } else {
                        JOptionPane.showMessageDialog(fr, "Table must be 1-" + tables.length);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fr, "Invalid Table Number");
                }
            }
        });

        // ปุ่มเพิ่มรายการ
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int tNum = Integer.parseInt(txtTable.getText());
                    String itemId = txtItem.getText();
                    if (tNum >= 1 && tNum <= tables.length) {
                        Table t = tables[tNum - 1];
                        if (!t.isOccupied()) {
                            JOptionPane.showMessageDialog(fr, "Table is not open. Please open table first.");
                            return;
                        }

                        // ค้นหา item ID ในรายการอาหารและเครื่องดื่ม
                        MenuItem found = null;
                        for (int i = 0; i < foods.length; i++) {
                            if (foods[i].getId().equals(itemId)) {
                                found = foods[i];
                                break;
                            }
                        }
                        if (found == null) {
                            for (int i = 0; i < beverages.length; i++) {
                                if (beverages[i].getId().equals(itemId)) {
                                    found = beverages[i];
                                    break;
                                }
                            }
                        }

                        if (found != null) {
                            t.getCurrentOrder().addItem(found);
                            display.setText("Added: " + found.getName() + " to Table " + tNum + "\n");
                            display.append("Total Items: " + t.getCurrentOrder().getItemCount() + "\n");
                            display.append("Current Subtotal: " + t.getCurrentOrder().calculateTotal() + " Baht");
                        } else {
                            JOptionPane.showMessageDialog(fr, "Item ID not found!");
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(fr, "Invalid Input");
                }
            }
        });

        // ปุ่มชำระเงิน
        btnCheckout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int tNum = Integer.parseInt(txtTable.getText());
                    double cash = Double.parseDouble(txtCash.getText());

                    if (tNum >= 1 && tNum <= tables.length) {
                        Table t = tables[tNum - 1];
                        if (!t.isOccupied()) {
                            JOptionPane.showMessageDialog(fr, "Table is not open.");
                            return;
                        }
                        if (t.getCurrentOrder().getItemCount() == 0) {
                            JOptionPane.showMessageDialog(fr, "No items in order.");
                            return;
                        }

                            Payment p = new Payment(t.getCurrentOrder(), 0.07); // ใช้ภาษี 7%
                        double grandTotal = p.calculateGrandTotal();

                        if (cash >= grandTotal) {
                            double change = cash - grandTotal;
                            display.setText("=== RECEIPT ===\n");
                            display.append("Table: " + tNum + "   Order: " + t.getCurrentOrder().getOrderId() + "\n");
                            display.append("---------------------------------\n");
                            // วนผ่านรายการในลิสต์
                            List<MenuItem> orderItems = t.getCurrentOrder().getItems();
                            for (MenuItem item : orderItems) {
                                display.append(item.getName() + " \t" + item.getPrice() + "\n");
                            }
                            display.append("---------------------------------\n");
                            // แสดงข้อมูลพนักงานในใบเสร็จ
                            if (t.getAssignedStaff() != null) {
                                display.append("Staff: \t" + t.getAssignedStaff().getFullName()
                                        + " (" + t.getAssignedStaff().getStaffId() + ")\n");
                            }
                            display.append("Subtotal: \t" + t.getCurrentOrder().calculateTotal() + "\n");
                            display.append("Grand Total(inc. tax): \t" + grandTotal + "\n");
                            display.append("Cash: \t" + cash + "\n");
                            display.append("Change: \t" + change + "\n");
                            display.append("====================\nThank You!");

                            // ปิดโต๊ะและรีเซ็ตช่องกรอก
                            t.closeTable();
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
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

// =====================================================================
//  POS SYSTEM — Java Swing GUI
//
//  วิธีรันบน GitHub Codespace (noVNC port 6080):
//  ──────────────────────────────────────────────
//  Terminal พิมพ์:
//    cd <โฟลเดอร์ที่เก็บไฟล์>
//    javac *.java
//    DISPLAY=:1 java POS_GUI
//
//  แล้วเปิด PORTS tab → คลิก URL ของ port 6080
// =====================================================================

public class POS_GUI extends JFrame {

```
// ── Colour palette ───────────────────────────────────────────────
static final Color C_BG        = new Color(245, 247, 250);
static final Color C_PRIMARY    = new Color(37,  99, 235);
static final Color C_SUCCESS    = new Color(22, 163,  74);
static final Color C_DANGER     = new Color(220,  38,  38);
static final Color C_WARNING    = new Color(234, 179,   8);
static final Color C_SIDEBAR    = new Color(15,  23,  42);
static final Color C_SIDEBAR_LT = new Color(30,  41,  59);
static final Color C_CARD       = Color.WHITE;
static final Color C_BORDER     = new Color(226, 232, 240);

// ── Static data ──────────────────────────────────────────────────
static final Food[] FOODS = {
    new Food("200", "Steak",        150, 50, false),
    new Food("201", "Potato",        90, 50, false),
    new Food("202", "Salad",         80,  0, true),
    new Food("203", "Spicy Pasta",  120, 80, false)
};
static final Beverage[] BEVERAGES = {
    new Beverage("100", "Matcha",    100, 100, true),
    new Beverage("101", "Mocca",      80,  50, true),
    new Beverage("102", "Lemonade",   60,  75, false),
    new Beverage("103", "Green Tea",  50,  30, true)
};

static final int TABLE_COUNT = 5;
Table[] tables = new Table[TABLE_COUNT];
int orderCounter = 1;

// ── UI state ─────────────────────────────────────────────────────
int selectedTable = -1;
CardLayout cardLayout;
JPanel mainPanel;
JPanel tableGridPanel;
JLabel statusBar;
JLabel orderTitleLabel;
DefaultTableModel orderTableModel;

// ── Constructor ──────────────────────────────────────────────────
public POS_GUI() {
    super("POS System v1.0");
    for (int i = 0; i < TABLE_COUNT; i++) tables[i] = new Table(i + 1);

    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(1100, 700);
    setMinimumSize(new Dimension(900, 600));
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    add(buildSidebar(), BorderLayout.WEST);

    cardLayout = new CardLayout();
    mainPanel  = new JPanel(cardLayout);
    mainPanel.setBackground(C_BG);
    mainPanel.add(buildDashboard(),  "dashboard");
    mainPanel.add(buildOrderPanel(), "order");
    mainPanel.add(buildMenuPanel(),  "menu");
    add(mainPanel, BorderLayout.CENTER);

    statusBar = new JLabel("  Welcome to POS System");
    statusBar.setFont(new Font("SansSerif", Font.PLAIN, 12));
    statusBar.setForeground(Color.GRAY);
    statusBar.setBorder(new EmptyBorder(4, 10, 4, 10));
    add(statusBar, BorderLayout.SOUTH);

    setVisible(true);
}

// ── SIDEBAR ──────────────────────────────────────────────────────
JPanel buildSidebar() {
    JPanel p = new JPanel();
    p.setBackground(C_SIDEBAR);
    p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
    p.setPreferredSize(new Dimension(200, 0));

    JLabel logo = new JLabel("POS System", SwingConstants.CENTER);
    logo.setFont(new Font("SansSerif", Font.BOLD, 16));
    logo.setForeground(Color.WHITE);
    logo.setBorder(new EmptyBorder(24, 16, 24, 16));
    logo.setAlignmentX(Component.CENTER_ALIGNMENT);
    p.add(logo);

    JSeparator sep = new JSeparator();
    sep.setForeground(C_SIDEBAR_LT);
    sep.setMaximumSize(new Dimension(200, 1));
    p.add(sep);
    p.add(Box.createVerticalStrut(8));

    p.add(navBtn("Dashboard",   "dashboard"));
    p.add(navBtn("Order",       "order"));
    p.add(navBtn("Menu Items",  "menu"));
    p.add(Box.createVerticalGlue());

    JLabel ver = new JLabel("v1.0", SwingConstants.CENTER);
    ver.setFont(new Font("SansSerif", Font.PLAIN, 11));
    ver.setForeground(new Color(100, 116, 139));
    ver.setAlignmentX(Component.CENTER_ALIGNMENT);
    ver.setBorder(new EmptyBorder(0, 0, 12, 0));
    p.add(ver);
    return p;
}

JButton navBtn(String text, String card) {
    JButton b = new JButton(text);
    b.setFont(new Font("SansSerif", Font.PLAIN, 14));
    b.setForeground(new Color(148, 163, 184));
    b.setBackground(C_SIDEBAR);
    b.setBorderPainted(false);
    b.setFocusPainted(false);
    b.setHorizontalAlignment(SwingConstants.LEFT);
    b.setBorder(new EmptyBorder(10, 20, 10, 20));
    b.setMaximumSize(new Dimension(200, 44));
    b.setAlignmentX(Component.LEFT_ALIGNMENT);
    b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) {
            b.setBackground(C_SIDEBAR_LT); b.setForeground(Color.WHITE);
        }
        public void mouseExited(MouseEvent e) {
            b.setBackground(C_SIDEBAR); b.setForeground(new Color(148, 163, 184));
        }
    });
    b.addActionListener(e -> {
        cardLayout.show(mainPanel, card);
        if (card.equals("order")) refreshOrderPanel();
    });
    return b;
}

// ── DASHBOARD ────────────────────────────────────────────────────
JPanel buildDashboard() {
    JPanel root = new JPanel(new BorderLayout());
    root.setBackground(C_BG);
    root.add(pageHeader("Dashboard - Table Overview"), BorderLayout.NORTH);

    tableGridPanel = new JPanel(new GridLayout(2, 3, 16, 16));
    tableGridPanel.setBackground(C_BG);
    tableGridPanel.setBorder(new EmptyBorder(16, 24, 24, 24));
    refreshTableGrid();

    root.add(new JScrollPane(tableGridPanel,
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
    return root;
}

void refreshTableGrid() {
    tableGridPanel.removeAll();
    for (int i = 0; i < TABLE_COUNT; i++) tableGridPanel.add(buildTableCard(i));
    tableGridPanel.revalidate();
    tableGridPanel.repaint();
}

JPanel buildTableCard(int idx) {
    Table t = tables[idx];
    JPanel card = new JPanel(new BorderLayout(0, 8));
    card.setBackground(C_CARD);
    card.setBorder(BorderFactory.createCompoundBorder(
            new LineBorder(t.isOccupied ? C_WARNING : C_BORDER, 2, true),
            new EmptyBorder(16, 16, 16, 16)));

    // Title + badge
    JLabel title = new JLabel("Table " + t.tableNumber);
    title.setFont(new Font("SansSerif", Font.BOLD, 18));
    JLabel badge = new JLabel(t.isOccupied ? " Occupied " : " Available ");
    badge.setFont(new Font("SansSerif", Font.BOLD, 11));
    badge.setForeground(Color.WHITE);
    badge.setOpaque(true);
    badge.setBackground(t.isOccupied ? C_WARNING : C_SUCCESS);
    badge.setBorder(new EmptyBorder(2, 6, 2, 6));
    JPanel titleRow = new JPanel(new BorderLayout());
    titleRow.setOpaque(false);
    titleRow.add(title, BorderLayout.WEST);
    titleRow.add(badge, BorderLayout.EAST);
    card.add(titleRow, BorderLayout.NORTH);

    // Info
    JPanel info = new JPanel(new GridLayout(0, 1, 2, 2));
    info.setOpaque(false);
    if (t.isOccupied) {
        info.add(infoLabel("Order: " + t.currentOrder.orderId));
        info.add(infoLabel("Items: " + t.currentOrder.itemCount));
        info.add(infoLabel(String.format("Subtotal: %.2f baht", t.currentOrder.calculateTotal())));
    } else {
        info.add(infoLabel("No active order"));
    }
    card.add(info, BorderLayout.CENTER);

    // Buttons
    JPanel btnRow = new JPanel(new GridLayout(1, 2, 8, 0));
    btnRow.setOpaque(false);
    if (!t.isOccupied) {
        JButton open = styledBtn("Open Table", C_PRIMARY);
        open.addActionListener(e -> openTable(idx));
        btnRow.add(open);
        btnRow.add(new JLabel()); // spacer
    } else {
        JButton order = styledBtn("+ Order", C_SUCCESS);
        order.addActionListener(e -> {
            selectedTable = idx;
            cardLayout.show(mainPanel, "order");
            refreshOrderPanel();
        });
        JButton checkout = styledBtn("Checkout", C_DANGER);
        checkout.addActionListener(e -> showCheckout(idx));
        btnRow.add(order);
        btnRow.add(checkout);
    }
    card.add(btnRow, BorderLayout.SOUTH);
    return card;
}

// ── ORDER PANEL ──────────────────────────────────────────────────
JPanel buildOrderPanel() {
    JPanel root = new JPanel(new BorderLayout());
    root.setBackground(C_BG);
    root.add(pageHeader("Add Items to Order"), BorderLayout.NORTH);

    JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    split.setResizeWeight(0.45);
    split.setBorder(new EmptyBorder(0, 16, 16, 16));
    split.setDividerSize(8);
    split.setLeftComponent(buildCurrentOrderPanel());
    split.setRightComponent(buildMenuPickerPanel());

    root.add(split, BorderLayout.CENTER);
    return root;
}

JPanel buildCurrentOrderPanel() {
    JPanel p = new JPanel(new BorderLayout(0, 8));
    p.setBackground(C_BG);

    orderTitleLabel = new JLabel("Select a table first");
    orderTitleLabel.setFont(new Font("SansSerif", Font.BOLD, 15));
    orderTitleLabel.setBorder(new EmptyBorder(8, 0, 4, 0));
    p.add(orderTitleLabel, BorderLayout.NORTH);

    String[] cols = {"ID", "Name", "Price (Baht)"};
    orderTableModel = new DefaultTableModel(cols, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
    };
    JTable tbl = new JTable(orderTableModel);
    styleTable(tbl);
    JScrollPane sp = new JScrollPane(tbl);
    sp.setBorder(new LineBorder(C_BORDER));
    p.add(sp, BorderLayout.CENTER);
    return p;
}

JPanel buildMenuPickerPanel() {
    JPanel p = new JPanel(new BorderLayout(0, 8));
    p.setBackground(C_BG);

    JLabel lbl = new JLabel("Menu Items");
    lbl.setFont(new Font("SansSerif", Font.BOLD, 15));
    lbl.setBorder(new EmptyBorder(8, 0, 4, 0));
    p.add(lbl, BorderLayout.NORTH);

    JTabbedPane tabs = new JTabbedPane();
    tabs.setFont(new Font("SansSerif", Font.PLAIN, 13));

    // Food tab
    JPanel foodTab = new JPanel(new BorderLayout());
    String[] foodCols = {"ID", "Name", "Price", "Spicy", "Vegan"};
    DefaultTableModel foodModel = new DefaultTableModel(foodCols, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
    };
    for (Food f : FOODS)
        foodModel.addRow(new Object[]{f.id, f.name,
            String.format("%.2f", f.price), f.spicinessLevel, f.isVegan ? "Yes" : "No"});
    JTable foodTbl = new JTable(foodModel);
    styleTable(foodTbl);
    foodTab.add(new JScrollPane(foodTbl), BorderLayout.CENTER);
    JButton addFood = styledBtn("+ Add Selected Food", C_SUCCESS);
    addFood.addActionListener(e -> {
        int row = foodTbl.getSelectedRow();
        if (row < 0) { showMsg("Please select a food item first.", "No Selection"); return; }
        addItemToOrder(FOODS[row]);
    });
    foodTab.add(addFood, BorderLayout.SOUTH);
    tabs.addTab("Food", foodTab);

    // Beverage tab
    JPanel bevTab = new JPanel(new BorderLayout());
    String[] bevCols = {"ID", "Name", "Price", "Sweet", "Temp"};
    DefaultTableModel bevModel = new DefaultTableModel(bevCols, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
    };
    for (Beverage b : BEVERAGES)
        bevModel.addRow(new Object[]{b.id, b.name,
            String.format("%.2f", b.price), b.sweetnessLevel, b.isHot ? "Hot" : "Cold"});
    JTable bevTbl = new JTable(bevModel);
    styleTable(bevTbl);
    bevTab.add(new JScrollPane(bevTbl), BorderLayout.CENTER);
    JButton addBev = styledBtn("+ Add Selected Beverage", C_PRIMARY);
    addBev.addActionListener(e -> {
        int row = bevTbl.getSelectedRow();
        if (row < 0) { showMsg("Please select a beverage first.", "No Selection"); return; }
        addItemToOrder(BEVERAGES[row]);
    });
    bevTab.add(addBev, BorderLayout.SOUTH);
    tabs.addTab("Beverage", bevTab);

    p.add(tabs, BorderLayout.CENTER);
    return p;
}

void refreshOrderPanel() {
    orderTableModel.setRowCount(0);
    if (selectedTable < 0 || !tables[selectedTable].isOccupied) {
        orderTitleLabel.setText("Select a table from Dashboard");
        return;
    }
    Table t = tables[selectedTable];
    orderTitleLabel.setText("Table " + t.tableNumber + "  |  Order: " + t.currentOrder.orderId);
    Order o = t.currentOrder;
    for (int i = 0; i < o.itemCount; i++)
        orderTableModel.addRow(new Object[]{
            o.items[i].id, o.items[i].name, String.format("%.2f", o.items[i].price)});
    setStatus("Table " + t.tableNumber + " | " + o.itemCount +
              " items | Subtotal: " + String.format("%.2f", o.calculateTotal()) + " baht");
}

void addItemToOrder(MenuItem item) {
    if (selectedTable < 0 || !tables[selectedTable].isOccupied) {
        showMsg("Please open a table first.\nGo to Dashboard -> Open a table.", "No Table Selected");
        return;
    }
    tables[selectedTable].currentOrder.addItem(item);
    refreshOrderPanel();
    refreshTableGrid();
    setStatus("Added: " + item.name + " to Table " + tables[selectedTable].tableNumber);
}

// ── MENU PAGE ────────────────────────────────────────────────────
JPanel buildMenuPanel() {
    JPanel root = new JPanel(new BorderLayout());
    root.setBackground(C_BG);
    root.add(pageHeader("Menu Items"), BorderLayout.NORTH);

    JTabbedPane tabs = new JTabbedPane();
    tabs.setFont(new Font("SansSerif", Font.PLAIN, 13));
    tabs.setBorder(new EmptyBorder(0, 24, 24, 24));

    String[] fc = {"ID", "Name", "Price (Baht)", "Spiciness", "Vegan"};
    DefaultTableModel fm = new DefaultTableModel(fc, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
    };
    for (Food f : FOODS)
        fm.addRow(new Object[]{f.id, f.name, String.format("%.2f", f.price),
            f.spicinessLevel + " / 100", f.isVegan ? "Yes" : "No"});
    JTable ft = new JTable(fm); styleTable(ft);
    tabs.addTab("Food (" + FOODS.length + ")", new JScrollPane(ft));

    String[] bc = {"ID", "Name", "Price (Baht)", "Sweetness", "Temperature"};
    DefaultTableModel bm = new DefaultTableModel(bc, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
    };
    for (Beverage b : BEVERAGES)
        bm.addRow(new Object[]{b.id, b.name, String.format("%.2f", b.price),
            b.sweetnessLevel + " / 100", b.isHot ? "Hot" : "Cold"});
    JTable bt = new JTable(bm); styleTable(bt);
    tabs.addTab("Beverage (" + BEVERAGES.length + ")", new JScrollPane(bt));

    root.add(tabs, BorderLayout.CENTER);
    return root;
}

// ── OPEN TABLE ───────────────────────────────────────────────────
void openTable(int idx) {
    String orderId = String.format("ORD%03d", orderCounter++);
    tables[idx].openTable(orderId);
    refreshTableGrid();
    setStatus("Table " + tables[idx].tableNumber + " opened. Order ID: " + orderId);
}

// ── CHECKOUT DIALOG ──────────────────────────────────────────────
void showCheckout(int idx) {
    Table t = tables[idx];
    if (t.currentOrder.itemCount == 0) {
        showMsg("No items in order.\nPlease add items first.", "Empty Order");
        return;
    }

    JDialog dlg = new JDialog(this, "Checkout - Table " + t.tableNumber, true);
    dlg.setSize(480, 560);
    dlg.setLocationRelativeTo(this);
    dlg.setLayout(new BorderLayout());
    dlg.getContentPane().setBackground(C_BG);

    // Order summary
    JPanel top = new JPanel(new BorderLayout(0, 8));
    top.setBackground(C_BG);
    top.setBorder(new EmptyBorder(16, 20, 0, 20));
    JLabel titleLbl = new JLabel("Order: " + t.currentOrder.orderId);
    titleLbl.setFont(new Font("SansSerif", Font.BOLD, 15));
    top.add(titleLbl, BorderLayout.NORTH);

    String[] cols = {"Name", "Price (Baht)"};
    DefaultTableModel m = new DefaultTableModel(cols, 0) {
        public boolean isCellEditable(int r, int c) { return false; }
    };
    Order o = t.currentOrder;
    for (int i = 0; i < o.itemCount; i++)
        m.addRow(new Object[]{o.items[i].name, String.format("%.2f", o.items[i].price)});
    JTable tbl = new JTable(m); styleTable(tbl);
    JScrollPane sp = new JScrollPane(tbl);
    sp.setPreferredSize(new Dimension(440, 160));
    top.add(sp, BorderLayout.CENTER);
    dlg.add(top, BorderLayout.NORTH);

    // Payment form
    JPanel form = new JPanel(new GridBagLayout());
    form.setBackground(C_BG);
    form.setBorder(new EmptyBorder(12, 20, 12, 20));
    GridBagConstraints g = new GridBagConstraints();
    g.insets = new Insets(6, 4, 6, 4);
    g.anchor = GridBagConstraints.WEST;

    g.gridx = 0; g.gridy = 0; form.add(boldLabel("Tax Rate:"), g);
    JComboBox<String> taxBox = new JComboBox<>(new String[]{"VAT 7%", "No Tax (0%)"});
    taxBox.setFont(new Font("SansSerif", Font.PLAIN, 13));
    g.gridx = 1; form.add(taxBox, g);

    JLabel subtotalVal = new JLabel(String.format("%.2f baht", o.calculateTotal()));
    subtotalVal.setFont(new Font("SansSerif", Font.PLAIN, 13));
    g.gridx = 0; g.gridy = 1; form.add(boldLabel("Subtotal:"), g);
    g.gridx = 1; form.add(subtotalVal, g);

    JLabel taxVal = new JLabel(String.format("%.2f baht", o.calculateTotal() * 0.07));
    taxVal.setFont(new Font("SansSerif", Font.PLAIN, 13));
    g.gridx = 0; g.gridy = 2; form.add(boldLabel("Tax:"), g);
    g.gridx = 1; form.add(taxVal, g);

    JLabel grandVal = new JLabel(String.format("%.2f baht", o.calculateTotal() * 1.07));
    grandVal.setFont(new Font("SansSerif", Font.BOLD, 16));
    grandVal.setForeground(C_PRIMARY);
    g.gridx = 0; g.gridy = 3; form.add(boldLabel("Grand Total:"), g);
    g.gridx = 1; form.add(grandVal, g);

    JTextField cashField = new JTextField("0.00", 10);
    cashField.setFont(new Font("SansSerif", Font.PLAIN, 14));
    g.gridx = 0; g.gridy = 4; form.add(boldLabel("Cash (Baht):"), g);
    g.gridx = 1; form.add(cashField, g);

    JLabel changeVal = new JLabel("0.00 baht");
    changeVal.setFont(new Font("SansSerif", Font.BOLD, 14));
    changeVal.setForeground(C_SUCCESS);
    g.gridx = 0; g.gridy = 5; form.add(boldLabel("Change:"), g);
    g.gridx = 1; form.add(changeVal, g);

    Runnable recalc = () -> {
        double taxRate = taxBox.getSelectedIndex() == 0 ? 0.07 : 0.0;
        double grand   = o.calculateTotal() * (1 + taxRate);
        taxVal.setText(String.format("%.2f baht", o.calculateTotal() * taxRate));
        grandVal.setText(String.format("%.2f baht", grand));
        try {
            double cash   = Double.parseDouble(cashField.getText());
            double change = cash - grand;
            if (change >= 0) {
                changeVal.setText(String.format("%.2f baht", change));
                changeVal.setForeground(C_SUCCESS);
            } else {
                changeVal.setText(String.format("Need %.2f more", -change));
                changeVal.setForeground(C_DANGER);
            }
        } catch (NumberFormatException ex) {
            changeVal.setText("--");
        }
    };
    taxBox.addActionListener(e -> recalc.run());
    cashField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
        public void insertUpdate (javax.swing.event.DocumentEvent e) { recalc.run(); }
        public void removeUpdate (javax.swing.event.DocumentEvent e) { recalc.run(); }
        public void changedUpdate(javax.swing.event.DocumentEvent e) { recalc.run(); }
    });
    dlg.add(form, BorderLayout.CENTER);

    // Buttons
    JPanel btnRow = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 12));
    btnRow.setBackground(C_BG);
    JButton cancel = styledBtn("Cancel", new Color(107, 114, 128));
    cancel.addActionListener(e -> dlg.dispose());
    JButton pay = styledBtn("Confirm Payment", C_SUCCESS);
    pay.addActionListener(e -> {
        double taxRate = taxBox.getSelectedIndex() == 0 ? 0.07 : 0.0;
        double grand   = o.calculateTotal() * (1 + taxRate);
        double cash;
        try {
            cash = Double.parseDouble(cashField.getText());
        } catch (NumberFormatException ex) {
            showMsg("Please enter a valid cash amount.", "Invalid Input");
            return;
        }
        if (cash < grand) {
            showMsg(String.format("Insufficient cash.\nNeed %.2f more.", grand - cash), "Insufficient Cash");
            return;
        }
        double change = cash - grand;
        dlg.dispose();
        showReceipt(t, taxRate, cash, change);
        t.closeTable();
        if (selectedTable == idx) selectedTable = -1;
        refreshTableGrid();
        setStatus("Table " + t.tableNumber + " checked out. Change: " + String.format("%.2f", change) + " baht");
    });
    btnRow.add(cancel);
    btnRow.add(pay);
    dlg.add(btnRow, BorderLayout.SOUTH);
    dlg.setVisible(true);
}

// ── RECEIPT ──────────────────────────────────────────────────────
void showReceipt(Table t, double taxRate, double cash, double change) {
    Order o = t.currentOrder;
    JDialog dlg = new JDialog(this, "Receipt", true);
    dlg.setSize(380, 540);
    dlg.setLocationRelativeTo(this);
    dlg.getContentPane().setBackground(Color.WHITE);
    dlg.setLayout(new BorderLayout());

    JTextArea area = new JTextArea();
    area.setFont(new Font("Monospaced", Font.PLAIN, 13));
    area.setEditable(false);
    area.setBackground(Color.WHITE);
    area.setBorder(new EmptyBorder(16, 20, 16, 20));

    double sub   = o.calculateTotal();
    double tax   = sub * taxRate;
    double grand = sub + tax;

    StringBuilder sb = new StringBuilder();
    sb.append("====================================\n");
    sb.append("             RECEIPT                \n");
    sb.append("====================================\n");
    sb.append(String.format("  Order : %-22s\n", o.orderId));
    sb.append(String.format("  Table : %-22s\n", "Table " + t.tableNumber));
    sb.append("------------------------------------\n");
    sb.append(String.format("  %-20s %9s\n", "Item", "Price"));
    sb.append("  ----------------------------------\n");
    for (int i = 0; i < o.itemCount; i++)
        sb.append(String.format("  %-20s %9.2f\n", o.items[i].name, o.items[i].price));
    sb.append("------------------------------------\n");
    sb.append(String.format("  %-20s %9.2f\n", "Subtotal:", sub));
    sb.append(String.format("  %-20s %9.2f\n", "Tax (" + (int)(taxRate*100) + "%):", tax));
    sb.append(String.format("  %-20s %9.2f\n", "Grand Total:", grand));
    sb.append("------------------------------------\n");
    sb.append(String.format("  %-20s %9.2f\n", "Cash:", cash));
    sb.append(String.format("  %-20s %9.2f\n", "Change:", change));
    sb.append("====================================\n");
    sb.append("      Thank you! Come again.        \n");
    sb.append("====================================\n");

    area.setText(sb.toString());
    dlg.add(new JScrollPane(area), BorderLayout.CENTER);

    JPanel btns = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 10));
    btns.setBackground(Color.WHITE);
    JButton close = styledBtn("Close", new Color(107, 114, 128));
    close.addActionListener(e -> dlg.dispose());
    btns.add(close);
    dlg.add(btns, BorderLayout.SOUTH);
    dlg.setVisible(true);
}

// ── HELPERS ──────────────────────────────────────────────────────
JPanel pageHeader(String title) {
    JPanel h = new JPanel(new BorderLayout());
    h.setBackground(C_CARD);
    h.setBorder(BorderFactory.createCompoundBorder(
            new MatteBorder(0, 0, 1, 0, C_BORDER),
            new EmptyBorder(16, 24, 16, 24)));
    JLabel l = new JLabel(title);
    l.setFont(new Font("SansSerif", Font.BOLD, 20));
    l.setForeground(new Color(15, 23, 42));
    h.add(l, BorderLayout.WEST);
    return h;
}

JButton styledBtn(String text, Color bg) {
    JButton b = new JButton(text);
    b.setFont(new Font("SansSerif", Font.BOLD, 13));
    b.setBackground(bg);
    b.setForeground(Color.WHITE);
    b.setFocusPainted(false);
    b.setBorderPainted(false);
    b.setOpaque(true);
    b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    b.setBorder(new EmptyBorder(8, 16, 8, 16));
    b.addMouseListener(new MouseAdapter() {
        public void mouseEntered(MouseEvent e) { b.setBackground(bg.darker()); }
        public void mouseExited (MouseEvent e) { b.setBackground(bg); }
    });
    return b;
}

void styleTable(JTable t) {
    t.setFont(new Font("SansSerif", Font.PLAIN, 13));
    t.setRowHeight(28);
    t.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 13));
    t.getTableHeader().setBackground(new Color(241, 245, 249));
    t.setSelectionBackground(new Color(219, 234, 254));
    t.setGridColor(C_BORDER);
    t.setShowGrid(true);
    t.setIntercellSpacing(new Dimension(1, 1));
}

JLabel infoLabel(String text) {
    JLabel l = new JLabel(text);
    l.setFont(new Font("SansSerif", Font.PLAIN, 13));
    l.setForeground(new Color(71, 85, 105));
    return l;
}

JLabel boldLabel(String text) {
    JLabel l = new JLabel(text);
    l.setFont(new Font("SansSerif", Font.BOLD, 13));
    return l;
}

void showMsg(String msg, String title) {
    JOptionPane.showMessageDialog(this, msg, title, JOptionPane.INFORMATION_MESSAGE);
}

void setStatus(String msg) { statusBar.setText("  " + msg); }

// ── ENTRY POINT ──────────────────────────────────────────────────
public static void main(String[] args) {
    try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
    catch (Exception ignored) {}
    SwingUtilities.invokeLater(POS_GUI::new);
}
```

}
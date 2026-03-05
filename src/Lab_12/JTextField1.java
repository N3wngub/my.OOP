package Lab_12;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class JTextField1 {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(100, 100, 400, 620);
        //fr.setBounds(100, 100, 343, 273);
        fr.setTitle("Welcome to Java GUI");
        fr.getContentPane().setLayout(null);

        JLabel label1 = new JLabel("Name  ");
        label1.setBounds(50, 50, 200, 14);
        fr.getContentPane().add(label1);

        JTextField txt = new JTextField();
        txt.setBounds(120, 50, 144, 20);
        fr.getContentPane().add(txt);


        JLabel label2 = new JLabel("Password  ");
        label2.setBounds(50, 80, 200, 14);
        fr.getContentPane().add(label2);

        JTextField pass_txt2 = new JPasswordField();
        pass_txt2.setBounds(120, 80, 144, 20);
        fr.getContentPane().add(pass_txt2);


        JLabel label3 = new JLabel("Address  ");
        label3.setBounds(50, 110, 200, 14);
        fr.getContentPane().add(label3);


        JTextArea ta = new JTextArea(5, 120);
        ta.setBounds(120, 110, 144, 60);
        fr.getContentPane().add(ta);
        //create scrollPane
        JScrollPane scroll = new JScrollPane(ta);
        scroll.setBounds(120, 110, 144, 60);
        fr.getContentPane().add(scroll);


        JLabel label4 = new JLabel("Gender  ");
        label4.setBounds(50, 180, 200, 14);
        fr.getContentPane().add(label4);

        JRadioButton radio1 = new JRadioButton("Male");
        radio1.setBounds(120, 180, 80, 23);
        fr.getContentPane().add(radio1);
        JRadioButton radio2 = new JRadioButton("Female");
        radio2.setBounds(200, 180, 80, 23);
        fr.getContentPane().add(radio2);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);


        JLabel label5 = new JLabel("Skills  ");
        label5.setBounds(50, 210, 200, 14);
        fr.getContentPane().add(label5);

        JCheckBox cb1 = new JCheckBox("C");
        cb1.setBounds(120, 210, 100, 14);
        fr.getContentPane().add(cb1);

        JCheckBox cb2 = new JCheckBox("C++");
        cb2.setBounds(120, 240, 100, 14);
        fr.getContentPane().add(cb2);

        JCheckBox cb3 = new JCheckBox("Java");
        cb3.setBounds(120, 270, 100, 14);
        fr.getContentPane().add(cb3);

        JCheckBox cb4 = new JCheckBox("Python");
        cb4.setBounds(120, 300, 100, 14);
        fr.getContentPane().add(cb4);

        JCheckBox cb5 = new JCheckBox("PHP");
        cb5.setBounds(120, 330, 100, 14);
        fr.getContentPane().add(cb5);

        JCheckBox cb6 = new JCheckBox("R");
        cb6.setBounds(120, 360, 100, 14);
        fr.getContentPane().add(cb6);

        JLabel label6 = new JLabel("Education");
        label6.setBounds(50, 390, 200, 14);
        fr.getContentPane().add(label6);

        String[] Education = {"High school", "Bacherlor", "Master's Degree", "Ph.D"};
        JComboBox cb = new JComboBox(Education);
        cb.setBounds(120, 390, 100, 20);
        fr.getContentPane().add(cb);
        fr.setVisible(true);

        JButton btn1 = new JButton("OK");
        btn1.setBounds(120, 498, 60, 23);
        fr.getContentPane().add(btn1);

        fr.setVisible(true);
    }
}


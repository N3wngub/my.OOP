package Lab_13;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(100, 100, 400, 200);
        //fr.setBounds(100, 100, 343, 273);
        fr.setTitle("My Calculator");
        fr.getContentPane().setLayout(null);

        JLabel label1 = new JLabel("Number1");
        label1.setBounds(50, 30, 200, 14);
        fr.getContentPane().add(label1);

        JTextField txt = new JTextField();
        txt.setBounds(50, 50, 60, 20);
        fr.getContentPane().add(txt);

        JLabel label2 = new JLabel("Operator");
        label2.setBounds(170, 30, 200, 14);
        fr.getContentPane().add(label2);
        String[] Operator = {"+", "-", "x", "/"};
        JComboBox cb = new JComboBox(Operator);
        cb.setBounds(170, 50, 50, 20);
        fr.getContentPane().add(cb);
        fr.setVisible(true);

        JLabel label3 = new JLabel("Number2");
        label3.setBounds(270, 30, 200, 14);
        fr.getContentPane().add(label3);

        JTextField txt2 = new JTextField();
        txt2.setBounds(270, 50, 60, 20);
        fr.getContentPane().add(txt2);

        JButton btn1 = new JButton("Calculate");
        btn1.setBounds(145, 100, 100, 20);
        fr.getContentPane().add(btn1);
        btn1.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                int cal = 0;
                String t1 = txt.getText();
                String t2 = txt2.getText();
                int num1 = Integer.parseInt(t1);
                int num2 = Integer.parseInt(t2);
                String op = cb.getSelectedItem().toString();
                if (op == "+"){
                    cal = num1 + num2;
                } else if ( op == "-") {
                    cal = num1 - num2;
                }else if ( op == "x") {
                    cal = num1 * num2;
                }else if ( op == "/") {
                    cal = num1 / num2;
                }

                JOptionPane.showMessageDialog(fr,txt.getText() + cb.getSelectedItem() + txt2.getText() + " = " + cal );
            }
        });
        fr.setVisible(true);
    }

}

package Lab_13;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Swing based UI for registering a new {@link Person}.  This class extends
 * {@code Person} so that it inherits the setters and validation logic.  The
 * form collects a username, password, confirm password, name and eâ€‘mail.  On
 * save the values are pushed into a new {@code Person} instance and
 * validated.  A message dialog is shown to the user based on the result.
 */
public class Member extends Person {
    public static void main(String[] args) {
        JFrame fr = new JFrame();
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fr.setBounds(100, 100, 400, 300);
        fr.setTitle("Member register");
        fr.getContentPane().setLayout(null);

        JLabel label = new JLabel("Register Data");
        label.setBounds(150, 20, 200, 14);
        fr.getContentPane().add(label);

        JLabel label1 = new JLabel("Username : ");
        label1.setBounds(50, 50, 200, 14);
        fr.getContentPane().add(label1);

        JTextField txt = new JTextField();
        txt.setBounds(180, 50, 144, 20);
        fr.getContentPane().add(txt);

        JLabel label2 = new JLabel("Password : ");
        label2.setBounds(50, 80, 200, 14);
        fr.getContentPane().add(label2);

        JPasswordField pass_txt2 = new JPasswordField();
        pass_txt2.setBounds(180, 80, 144, 20);
        fr.getContentPane().add(pass_txt2);

        JLabel label22 = new JLabel("Confirm Password : ");
        label22.setBounds(50, 110, 200, 14);
        fr.getContentPane().add(label22);

        JPasswordField pass_txt22 = new JPasswordField();
        pass_txt22.setBounds(180, 110, 144, 20);
        fr.getContentPane().add(pass_txt22);

        JLabel labelname = new JLabel("Name : ");
        labelname.setBounds(50, 140, 200, 14);
        fr.getContentPane().add(labelname);

        JTextField txtname = new JTextField();
        txtname.setBounds(180, 140, 144, 20);
        fr.getContentPane().add(txtname);

        JLabel labelm = new JLabel("Email : ");
        labelm.setBounds(50, 170, 200, 14);
        fr.getContentPane().add(labelm);

        JTextField txtm = new JTextField();
        txtm.setBounds(180, 170, 144, 20);
        fr.getContentPane().add(txtm);

        JButton btn1 = new JButton("Save");
        btn1.setBounds(180, 200, 100, 23);
        fr.getContentPane().add(btn1);
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                // Populate a new Person instance with form values
                Person person = new Person();
                person.setUsername(txt.getText());
                // convert password fields to strings; getPassword returns char[]
                person.setPassword(new String(pass_txt2.getPassword()));
                person.setCpassword(new String(pass_txt22.getPassword()));
                person.setName(txtname.getText());
                person.setEmail(txtm.getText());

                String status = person.Check();
                switch (status) {
                    case "missUser":
                        JOptionPane.showMessageDialog(fr, "Please enter a username.");
                        break;
                    case "missPass":
                        JOptionPane.showMessageDialog(fr, "Please enter a password.");
                        break;
                    case "missCpass":
                        JOptionPane.showMessageDialog(fr, "Please confirm your password.");
                        break;
                    case "passMissmatch":
                        JOptionPane.showMessageDialog(fr, "Passwords do not match.");
                        break;
                    case "missName":
                        JOptionPane.showMessageDialog(fr, "Please enter your name.");
                        break;
                    case "missEmail":
                        JOptionPane.showMessageDialog(fr, "Please enter your email.");
                        break;
                    case "correct":
                    default:
                        // All fields valid; show confirmation
                        JOptionPane.showMessageDialog(fr,
                                "Register Data Successfully\n" + person.toString());
                        break;
                }
            }
        });

        fr.setVisible(true);
    }
}


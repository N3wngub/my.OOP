package Lab_13;
import javax.swing.JFrame;
import javax.swing.JLabel;
public class Main{
public static void main(String[] args) {
JFrame fr = new JFrame();
fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
fr.setBounds(100, 100, 343, 273);
fr.setTitle("Welcome to Java GUI");
fr.getContentPane().setLayout(null);
JLabel label1 = new JLabel("My name is nong new."); //สราง Label พรอมระบุขอความ
label1.setBounds(50, 50, 200, 14); //กําหนดให Lable นี้ปรากฎอยู่ที่ตําแหนง x = 50, y = 50, width = 200, height = 14
fr.getContentPane().add(label1); // เพิ่ม Label นี้ลงไปใน frame
fr.setVisible(true); // กําหนดให frame ถูกมองเห็น
}
}

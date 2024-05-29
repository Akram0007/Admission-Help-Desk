
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class AHD {

    public static void main(String[] args) {
        new body();
    }
}

class body extends JFrame implements ActionListener {

    JLabel jl1, jl2, jl3, jl4, jl5, jl6;
    ImageIcon ii;
    JRadioButton rb1, rb2;
    JTextField jt1, jt2, jt3;
    JButton btn, btn1, btn2, btn3;
    JTextArea area;
    JScrollPane sp;

    body() {
        super("AHD");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(350, 100, 1200, 800);
        setLayout(null);

        ii = new ImageIcon(getClass().getResource("trans.png"));
        jl1 = new JLabel(ii);
        jl1.setBounds(332, 0, ii.getIconWidth(), ii.getIconHeight());
        add(jl1);

        Font fnt = new Font("Times New Roman", Font.BOLD, 14);
        
        jl2 = new JLabel("Choose Your Group:");
        jl2.setBounds(10, 150, 130, 30);
        jl2.setFont(fnt);
        add(jl2);

        rb1 = new JRadioButton("Science");
        rb1.setBounds(140, 150, 80, 30);
        rb1.setFont(fnt);

        rb2 = new JRadioButton("Commerce");
        rb2.setBounds(140, 180, 100, 30);
        rb2.setFont(fnt);

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1);
        bg.add(rb2);
        add(rb1);
        add(rb2);

        jl3 = new JLabel("Enter Your GPA:");
        jl3.setBounds(285, 150, 110, 30);
        jl3.setFont(fnt);
        add(jl3);
        
        jl4 = new JLabel("SSC");
        jl4.setBounds(400, 150, 30, 30);
        jl4.setFont(fnt);
        add(jl4);
        jl5 = new JLabel("HSC");
        jl5.setBounds(400, 180, 30, 30);
        jl5.setFont(fnt);
        add(jl5);

        jt1 = new JTextField();
        jt1.setBounds(430, 155, 40, 20);
        add(jt1);
        jt2 = new JTextField();
        jt2.setBounds(430, 185, 40, 20);
        add(jt2);

        jl6 = new JLabel("Enter A University Name:");
        jl6.setBounds(10, 250, 200, 30);
        jl6.setFont(fnt);
        add(jl6);
        
        jt3 = new JTextField();
        jt3.setBounds(50, 296, 420, 25);
        jt3.setFont(fnt);
        add(jt3);

        btn = new JButton("Search");
        btn.setBounds(240, 335, 80, 25);
        btn.addActionListener(this);
        btn.setActionCommand("find");
        btn.setFont(fnt);
        add(btn);

        btn1 = new JButton("All Eligible University List");
        btn1.setBounds(180, 400, 210, 30);
        btn1.addActionListener(this);
        btn1.setActionCommand("list");
        btn1.setFont(fnt);
        add(btn1);
        
        btn2 = new JButton("Form Fee & Seat Number");
        btn2.setBounds(180, 450, 210, 30);
        btn2.addActionListener(this);
        btn2.setActionCommand("fee");
        btn2.setFont(fnt);
        add(btn2);
        btn3 = new JButton("Admin Panel");
        btn3.setBounds(180, 500, 210, 30);
        btn3.addActionListener(this);
        btn3.setActionCommand("admin");
        btn3.setFont(fnt);
        add(btn3);

        Font fnt2 = new Font("Times New Roman", Font.PLAIN, 18);
        area = new JTextArea();
        area.setBackground(Color.lightGray);
        area.setFont(fnt2);
        sp = new JScrollPane(area);
        sp.setBounds(520, 150, 650, 598);
        add(sp);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        double a = Double.parseDouble(jt1.getText());
        double b = Double.parseDouble(jt2.getText());
        double c = a + b;

        String FileName = null;
        String DirectoryName = null;
        Line obj = new Line();
        int x = 0;
        if (rb1.isSelected()) {
            DirectoryName = "E:\\Versity\\SEm 5 Assign\\Oop\\AHD)";
            FileName = "science.txt";
            x = obj.box(1);
        }

        if (rb2.isSelected()) {
            DirectoryName = "E:\\Versity\\SEm 5 Assign\\Oop\\AHD";
            FileName = "commerce.txt";
            x = obj.box(2);
        }

        String[] vName = new String[x];
        double ssc[] = new double[x];
        double hsc[] = new double[x];
        double tgpa[] = new double[x];
        int fee[] = new int[x];
        int seat[] = new int[x];

        File myFile = new File(DirectoryName, FileName); 
        FileReader fr = null;
        try {
            fr = new FileReader(myFile);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(body.class.getName()).log(Level.SEVERE, null, ex);
        }
        Scanner scan = new Scanner(fr);

        int p = 0;
        while (scan.hasNext()) {
            String st = scan.nextLine();
            String[] res = st.split("//");
            String[] res2 = res[1].split("\\s");

            vName[p] = res[0];
            ssc[p] = Double.parseDouble(res2[0]);
            hsc[p] = Double.parseDouble(res2[1]);
            tgpa[p] = Double.parseDouble(res2[2]);
            fee[p] = Integer.parseInt(res2[3]);
            seat[p] = Integer.parseInt(res2[4]);
            p++;
        }

        if (ae.getActionCommand() == "find") {
            System.out.println("1st Button is pressed");
            String name = jt3.getText();
            int flag = 0;
            area.setText("");
            for (int i = 0; i < vName.length; i++) {
                if (name.equalsIgnoreCase(vName[i])) {
                    if ((a >= ssc[i] && b >= hsc[i] && c >= tgpa[i])) {
                        area.append("<<<<<<<< You Are Eligible >>>>>>>>\n\n");
                        area.append(" "+vName[i] + "\n");
                        area.append(" SSC:"+ssc[i] + "\n");
                        area.append(" HSC:"+hsc[i] + "\n");
                        area.append(" Total GPA:"+tgpa[i] + "\n");
                    } 
                    else {
                        area.append("<<<<<<<< You Are Not Eligible >>>>>>>>\n");
                    }
                    flag = 1;
                }
            }
            if (flag == 0) {
                area.append("This Varsity is Not in Database\n");
            }
        }

        if (ae.getActionCommand() == "list") {
            System.out.println("2nd Button is pressed");
            int flag = 0;
            area.setText("");
            for (int i = 0; i < vName.length; i++) {
                if ((a >= ssc[i] && b >= hsc[i] && c >= tgpa[i])) {
                    area.append(vName[i] + "\n");
                    area.append(ssc[i] + "\n");
                    area.append(hsc[i] + "\n");
                    area.append(tgpa[i] + "\n");
                    flag = 1;
                }
            }
            if (flag == 0) {
                area.append("Sorry! You are not Eligible\n");
            }
        }

        if (ae.getActionCommand() == "fee") {
            area.setText("");
            for (int i = 0; i < vName.length; i++) {
                area.append(vName[i] + "\n");
                area.append(fee[i] + "\n");
                area.append(seat[i] + "\n");
            }
        }

        if (ae.getActionCommand() == "admin") {
            String pass = "12345";
            String name = null;
            area.setText("");
            int j = 1;
            while (j != 0) {
                name = JOptionPane.showInputDialog("Provide Password:");
                JOptionPane.showMessageDialog(null, "Entered: " + name);
                if (pass.equals(name)) {
                    j = 0;
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong password, try again");
                }
            }

            String name2 = JOptionPane.showInputDialog("Enter Versity Name:");
            JOptionPane.showMessageDialog(null, name2);
            String name3 = JOptionPane.showInputDialog("Enter SSC HSC & Total gpa");
            JOptionPane.showMessageDialog(null, name3);
            String name4 = JOptionPane.showInputDialog("Enter Fee & Seat");
            JOptionPane.showMessageDialog(null, name4);

            FileWriter fw = null;
            try {
                fw = new FileWriter(myFile, true);
            } catch (IOException ex) {
                Logger.getLogger(body.class.getName()).log(Level.SEVERE, null, ex);
            }

            try {
                fw.write("\n" + name2 + "//" + name3 + " " + name4);
            } catch (IOException ex) {
                Logger.getLogger(body.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fw.flush();
            } catch (IOException ex) {
                Logger.getLogger(body.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                fw.close();
            } catch (IOException ex) {
                Logger.getLogger(body.class.getName()).log(Level.SEVERE, null, ex);
            }
            area.setText("File Edit is Complete");
        }
    }
}


package first;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Registration {
	JFrame f;
	public static void main(String[] args) {
		Registration r= new Registration();
		}
	public Registration() {
        f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JLabel l1=new JLabel("Add Employee");
		l1.setBounds(620,0,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel l2 = new JLabel("EmployeeId");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(550,50,200,30);
		JLabel l3 = new JLabel("Name");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(550,100,150,50);
		JLabel l4= new JLabel("DOJ");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(550,150,150,50);
		JLabel l5=new JLabel("Department");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(550,200,150,50);
		JLabel l6=new JLabel("Designation");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setBounds(550,250,150,50);
		JLabel l8=new JLabel("Address");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l8.setBounds(550,300,150,70);
		JLabel l9=new JLabel("Contact NO");
		l8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l9.setBounds(550,410,150,50);
		JLabel l10=new JLabel("sex");
		l10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l10.setBounds(550,460,150,50);
		JLabel l11=new JLabel("Password");
		l11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l11.setBounds(550,510,150,50);
		
		JTextField t1=new JTextField();
		t1.setBounds(700,60,170,25);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t2=new JTextField();
		t2.setBounds(700,110,170,25);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t3=new JTextField();
		t3.setBounds(700,160,170,20);
		t3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		String department[]={" ","Production","Marketing","Finance"};
		JComboBox cb1=new JComboBox(department);
		cb1.setBounds(700,210,100,20);
		String designation[]={" ","Manager","Supervisor","Worker","Accountant"};
		JComboBox cb2=new JComboBox(designation);
		cb2.setBounds(700,260,100,20);
		JTextArea t4=new JTextArea();
		t4.setBounds(700,300,170,70);
		t4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JScrollPane sc=new JScrollPane(t4,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(700,300,170,70);
		JTextField t5=new JTextField();
		t5.setBounds(700,420,170,20);
		t5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		String sex[]={" ","male","Female"};
		JComboBox cb3=new JComboBox(sex);
		cb3.setBounds(700,470,100,20);
		
		JPasswordField p1=new JPasswordField();
		p1.setBounds(700,520,170,20);
		JButton b1=new JButton("Submit");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b1.setBounds(550,610,100,30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String eid=t1.getText();
			String name=t2.getText();
			String doj=t3.getText();
			String department=String.valueOf(cb1.getSelectedItem());
			String designation=String.valueOf(cb2.getSelectedItem());
			String address=t4.getText();
			String contact=t5.getText();
			String sex=String.valueOf(cb3.getSelectedItem());
			String password=String.valueOf(p1.getPassword());
			int i=EmployeeDB.save(eid, name, doj,department,designation,address,contact,sex, password);
			if(i>0){
				JOptionPane.showMessageDialog(f,"Employee added successfully!");
				EmployeeLogin em=new EmployeeLogin();
				f.dispose();
				
			}else{
				JOptionPane.showMessageDialog(f,"Sorry, unable to save!");
			}
			}
		});
		JButton b2=new JButton("Cancel");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(750,610,100,30);
		b2.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       { 
	    	   EmployeeLogin em=new EmployeeLogin();
	    	   f.dispose();
	       }
		});
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(l8);
		f.add(l9);
		f.add(l10);
		f.add(l11);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(sc);
		f.add(t5);
		f.add(cb1);
		f.add(cb2);
		f.add(cb3);
		f.add(p1);
		f.add(b1);
		f.add(b2);
		}

}





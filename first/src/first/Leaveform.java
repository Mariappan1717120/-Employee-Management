package first;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class Leaveform {

	JFrame f;
	public static void main(String[] args) {
		Leaveform l= new Leaveform();
		}
	public Leaveform() {
        f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JLabel l1=new JLabel("LEAVE FORM");
		l1.setBounds(620,75,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel l2 = new JLabel("Department");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(550,140,200,30);
		JLabel l3 = new JLabel("Designation");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(550,205,150,50);
		JLabel l4= new JLabel("Employee Id");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(550,270,150,50);
		JLabel l5=new JLabel("Employee name");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(550,335,150,50);
		JLabel l6=new JLabel("Leave Type");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setBounds(550,400,150,50);
		JLabel l7=new JLabel("Date");
		l7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l7.setBounds(550,475,150,50);
		JLabel l9=new JLabel("Description");
		l9.setBounds(550,525,150,50);
		String department[]={" ","Production","Marketing","Finance"};
		JComboBox cb1=new JComboBox(department);
		cb1.setBounds(700,150,100,20);
		String designation[]={" ","Manager","Supervisor","Worker","Accountant"};
		JComboBox cb2=new JComboBox(designation);
		cb2.setBounds(700,215,100,20);
		JTextField t1=new JTextField();
		t1.setBounds(700,280,100,25);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t2=new JTextField();
		t2.setBounds(700,345,100,25);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		String leave[]={" ","Company Leave"," Medical Leave","Non-Salary Leave"};
		JComboBox cb3=new JComboBox(leave);
		cb3.setBounds(700,410,100,20);
		JTextField t3=new JTextField();
		t3.setBounds(700,485,100,25);
		t3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextArea t5=new JTextArea();
		t5.setBounds(700,535,170,80);
		t5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JScrollPane sc=new JScrollPane(t5,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setBounds(700,535,170,80);
		JButton b1=new JButton("Submit");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		b1.setBounds(550,650,100,30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String eid=t1.getText();
			String name=t2.getText();
			String Leavetype=String.valueOf(cb3.getSelectedItem());
			String department=String.valueOf(cb1.getSelectedItem());
			String designation=String.valueOf(cb2.getSelectedItem());
			String description=t5.getText();
			String date=t3.getText();
			int i=LeaveDB.save(eid, name,department,designation,Leavetype,date,description);
			if(i>0){
				JOptionPane.showMessageDialog(f,"Leave Registered successfully!");
				EmployeeSuccess es=new EmployeeSuccess();
				f.dispose();
				
			}else{
				JOptionPane.showMessageDialog(f,"Sorry, unable to Register!");
			}
			}
		});
		JButton b2=new JButton("Cancel");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(750,650,100,30);
		b2.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       { 
	    	   EmployeeSuccess es=new EmployeeSuccess();
	    	   f.dispose();
	       }
		});
	f.add(l1);
	f.add(l2);
	f.add(l3);
	f.add(l4);
	f.add(l5);
	f.add(l6);
	f.add(l7);
	f.add(l9);
	f.add(cb1);
	f.add(cb2);
	f.add(cb3);
	f.add(t1);
	f.add(t2);
	f.add(t3);
	f.add(sc);
	f.add(b1);
	f.add(b2);
}
}

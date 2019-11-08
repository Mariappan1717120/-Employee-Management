package first;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Attendance {
	JFrame f;
	public static void main(String[] args) {
		Attendance l= new Attendance();
		}
	public Attendance() {
        f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JLabel l1=new JLabel("ATTENDENCE  ENTRY");
		l1.setBounds(620,75,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel l2 = new JLabel("Employee ID");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l2.setBounds(550,140,200,30);
		JLabel l3 = new JLabel("Name");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l3.setBounds(550,205,150,50);
		JLabel l4= new JLabel("IN Time");
		l4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l4.setBounds(550,270,150,50);
		JLabel l5=new JLabel("OUT Time");
		l5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l5.setBounds(550,335,150,50);
		JLabel l6=new JLabel("Date");
		l6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		l6.setBounds(550,400,150,50);
		JTextField t1=new JTextField();
		t1.setBounds(700,150,170,25);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t2=new JTextField();
		t2.setBounds(700,215,170,25);
		t2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t3=new JTextField();
		t3.setBounds(700,280,100,25);
		t3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t4=new JTextField();
		t4.setBounds(700,345,100,25);
		t4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JTextField t5=new JTextField();
		t5.setBounds(700,410,100,25);
		t5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JButton b1=new JButton("Submit");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		b1.setBounds(550,490,100,30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String eid=t1.getText();
			String name=t2.getText();
			String intime=t3.getText();
			String outtime=t4.getText();
			String date1=t5.getText();
			int i=WorkDB.save(eid, name,intime,outtime,date1);
			if(i>0){
				JOptionPane.showMessageDialog(f," Registered successfully!");
				 AdminSuccess as=new  AdminSuccess();
				f.dispose();
				
			}else{
				JOptionPane.showMessageDialog(f,"Sorry, unable to Register!");
			}
			}
		});
		JButton b2=new JButton("Cancel");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(750,490,100,30);
		b2.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       { 
	    	   AdminSuccess as=new AdminSuccess();
	    	   f.dispose();
	       }
		});
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(l4);
		f.add(l5);
		f.add(l6);
		f.add(t1);
		f.add(t2);
		f.add(t3);
		f.add(t4);
		f.add(t5);
		f.add(b1);
		f.add(b2);
}

}




package first;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
public class Company{
	 JFrame f;
	public static void main(String[] args) {
		Company c= new Company();
		}
	public Company() {
        f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JLabel l1 = new JLabel("Company Management");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 40));
		l1.setBounds(400,100,500,50);
		JButton b1=new JButton("Admin Login");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b1.setBounds(500,200,250,80);
		b1.addActionListener(new ActionListener() 
				{
			       public void actionPerformed(ActionEvent e)
			       {
			    	   AdminLogin b= new AdminLogin();
			    	   f.dispose();
			       }
				});
		JButton b2=new JButton("Employee Login");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b2.setBounds(500,350,250,80);
		b2.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   EmployeeLogin el=new EmployeeLogin();
	    	   f.dispose();
	       }
		});
		f.add(l1);
		f.add(b1);
		f.add(b2);
	}
}
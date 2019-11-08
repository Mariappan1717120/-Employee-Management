package first;
	import java.awt.Color;
	import java.awt.event.*;
	import java.awt.Font;
	import javax.swing.*;
	public class EmployeeSuccess{
		public EmployeeSuccess() {
	        JFrame f =new JFrame();
			f.setBounds(0, 0,1400,750);
			f.setVisible(true);	
			f.setLayout(null);
			JLabel l1 = new JLabel("Employee Activity");
			l1.setFont(new Font("Tahoma", Font.PLAIN, 50));
			l1.setBounds(470,100,500,90);
			JButton b1=new JButton("Employee");
			b1.setFont(new Font("Tahoma", Font.PLAIN, 25));
			b1.setBounds(200,250,250,80);
			b1.addActionListener(new ActionListener() 
					{
				       public void actionPerformed(ActionEvent e)
				       {
				    	   ViewProfile vp=new ViewProfile();
				    	   f.dispose();
				       }
					});
			JButton b2=new JButton("Salary");
			b2.setFont(new Font("Tahoma", Font.PLAIN, 25));
			b2.setBounds(550,250,250,80);
			b2.addActionListener(new ActionListener() 
			{
		       public void actionPerformed(ActionEvent e)
		       {
		    	   //AdminLogin.main(new String[] {});
		    	   f.dispose();
		       }
			});
			JButton b3=new JButton("Attendance");
			b3.setFont(new Font("Tahoma", Font.PLAIN, 25));
			b3.setBounds(900,250,250,80);
			b3.addActionListener(new ActionListener() 
			{
		       public void actionPerformed(ActionEvent e)
		       {
		    	   //AdminLogin.main(new String[] {});
		    	   f.dispose();
		       }
			});
			JButton b4=new JButton("Leave");
			b4.setFont(new Font("Tahoma", Font.PLAIN, 25));
			b4.setBounds(200,400,250,80);
			b4.addActionListener(new ActionListener() 
			{
		       public void actionPerformed(ActionEvent e)
		       {
		    	  Leaveform lf=new Leaveform();
		    	   f.dispose();
		       }
			});
			JButton b5=new JButton("Log OFF");
			b5.setFont(new Font("Tahoma", Font.PLAIN, 25));
			b5.setBounds(550,400,250,80);
			b5.addActionListener(new ActionListener() 
			{
		       public void actionPerformed(ActionEvent e)
		       {
		    	   Company.main(new String[] {});
		    	   f.dispose();
		       }
			});
			f.add(l1);
			f.add(b1);
			f.add(b2);
			f.add(b3);
			f.add(b4);
			f.add(b5);
		}
	}




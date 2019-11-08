package first;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
public class AdminLogin
{
	public AdminLogin() {
        JFrame f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JLabel l1 = new JLabel("Admin Login Entry");
		l1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		l1.setBounds(450,100,500,80);		
		JLabel l2 = new JLabel("Username");
		l2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l2.setBounds(500,220,150,50);
		JLabel l3=new JLabel("Password");
		l3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		l3.setBounds(500,320,150,50);
		
		JTextField t1=new JTextField();
		t1.setBounds(670,230,170,30);
		JPasswordField p1=new JPasswordField();
		p1.setBounds(670,330,170,30);
		JButton b1=new JButton("Login");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		b1.setBounds(600,430,150,40);
		b1.addActionListener(new ActionListener()
				{
	               public void actionPerformed(ActionEvent e)
	               {
	            	   String name=t1.getText();
	            	   String password=String.valueOf(p1.getPassword());
	            	   if(name.equals("mari")&&password.equals("3393")){
	       				AdminSuccess b=new AdminSuccess();
	       				f.dispose();
	       			}else{
	       				JOptionPane.showMessageDialog(f ,"Sorry, Username or Password Error");
	       				t1.setText("");
	       				p1.setText("");
	       			}
	               }
				}
				);
		JButton b2=new JButton("Back");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(1000,550,120,30);
		b2.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   Company c= new Company();
	    	   f.dispose();
	       }
		});
		f.add(l1);
		f.add(l2);
		f.add(l3);
		f.add(t1);
		f.add(p1);
		f.add(b1);
		f.add(b2);
	}
}

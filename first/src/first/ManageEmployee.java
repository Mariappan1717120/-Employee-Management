package first;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class ManageEmployee {
	JFrame f;
	public ManageEmployee() {
         f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JPanel p1=new JPanel();
		p1.setBounds(0,0,1400,70);
		p1.setLayout(null);
		JLabel l1=new JLabel("Employee Management");
		l1.setBounds(450,0,700,60);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		JMenuBar mb=new JMenuBar();
		mb.setBounds(0,70,1400,50);
		JMenu m1=new JMenu("BACK");
		m1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JMenuItem m11=new JMenuItem("Previous page");
		m11.setFont(new Font("Tahoma", Font.PLAIN, 10));
		m11.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   AdminSuccess es=new AdminSuccess();
	    	   f.dispose();  
	    	   
	       }
		});
		m1.add(m11);
		
		JMenu m2=new JMenu("VIEW");
		m2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JMenuItem m21=new JMenuItem("View Employee");
		m21.setFont(new Font("Tahoma", Font.PLAIN, 10));
		m21.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   ManageEmployee a=new ManageEmployee();
	    	   a.ViewEmployee();
	    	   f.dispose();  
	    	   
	       }
		});
		m2.add(m21);
		JMenu m3=new JMenu("DELETE");
		JMenuItem m31=new JMenuItem("Delete Employee");
		m3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		m31.setFont(new Font("Tahoma", Font.PLAIN, 10));
		m31.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       {
	    	   ManageEmployee a=new ManageEmployee();
	    	   a.DeleteEmployee();
	    	   f.dispose();  
	    	   
	       }
		});
		m3.add(m31);
		mb.add(m2);
		mb.add(m3);
		mb.add(m1);
		p1.add(l1);
		f.add(p1);
		f.add(mb);
}
	
	public void ViewEmployee()
	{
		JPanel p2=new JPanel();
		p2.setBounds(0,110,1400,900);
		p2.setLayout(null);
		JScrollPane s=new JScrollPane();
		s.setBounds(100,100,1150,200);
		JLabel l1=new JLabel("View Employee Details");
		l1.setBounds(620,0,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select eid,name,doj,department,designation,address,contact from Employee",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs=ps.executeQuery();
			
			ResultSetMetaData rsmd=rs.getMetaData();
			int cols=rsmd.getColumnCount();
			column=new String[cols];
			for(int i=1;i<=cols;i++){
				column[i-1]=rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows=rs.getRow();
			rs.beforeFirst();

			data=new String[rows][cols];
			int count=0;
			while(rs.next()){
				for(int i=1;i<=cols;i++){
					data[count][i-1]=rs.getString(i);
				}
				count++;
			}
			con.close();
		}catch(Exception e){System.out.println(e);}
		
		 JTable tb  = new JTable(data,column);
		 tb.setFont(new Font("Tahoma", Font.PLAIN, 15));
			s.setViewportView(tb);
			
		p2.add(s);
		f.add(p2);
	}
	public void DeleteEmployee()
	{
		JPanel p2=new JPanel();
		p2.setBounds(0,110,1200,900);
		p2.setLayout(null);
		JLabel l1=new JLabel("Delete Employee");
		l1.setBounds(520,225,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JLabel l2=new JLabel("Employee Id");
		l2.setBounds(420,275,200,40);
		l2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JTextField t1=new JTextField();
		t1.setBounds(580,285,170,20);
		t1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		JButton b1=new JButton("Delete");
		b1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		b1.setBounds(450,350,100,30);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eid=t1.getText();
				if(eid==null||eid.trim().equals("")){
					JOptionPane.showMessageDialog(f,"Id can't be blank");
				}else{
					int id=Integer.parseInt(eid);
					int i=EmployeeDB.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(f,"Record deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(f,"Unable to delete given id!");
					}
				}
			}
		});
		JButton b2=new JButton("Back");
		b2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		b2.setBounds(650,350,100,30);
		b2.addActionListener(new ActionListener() 
		{
	       public void actionPerformed(ActionEvent e)
	       { 
	    	   ManageEmployee em=new ManageEmployee();
	    	   f.dispose();
	       }
		});
		p2.add(l1);
		p2.add(l2);
		p2.add(t1);
		p2.add(b1);
		p2.add(b2);
		
		f.add(p2);
	}
	public static void main(String args[])
	{
		ManageEmployee a=new ManageEmployee();
	}
}


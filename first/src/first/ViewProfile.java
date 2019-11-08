package first;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
class ViewProfile{
	public ViewProfile()
	{
		JFrame f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JScrollPane s=new JScrollPane();
		s.setBounds(100,100,1150,40);
		JLabel l1=new JLabel("Profile");
		l1.setBounds(620,0,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		String data[][]=null;
		String column[]=null;
		 String st=null;
		 String user=null;
		try
		   {
			   File f1=new File("username.txt");
			   BufferedReader br=new BufferedReader(new FileReader(f1));
			   while((st=br.readLine())!=null)
			   {
				   user=st;
			   }
		   }
		   catch(IOException ioe)
		   {
			   System.out.println(ioe);
			   System.exit(-1);
			   
		   }
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from Employee where name=?");
			ps.setString(1,user);
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
		
		 JTable tb = new JTable(data,column);
		 tb.setFont(new Font("Tahoma", Font.PLAIN, 15));
			s.setViewportView(tb);
			JButton b1=new JButton("Back");
			b1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			b1.setBounds(600,600,75,20);
			b1.addActionListener(new ActionListener() 
			{
		       public void actionPerformed(ActionEvent e)
		       {
		    	   EmployeeSuccess el=new EmployeeSuccess();
		    	   f.dispose();
		       }
			});
			f.add(l1);
			f.add(b1);
		f.add(s);
	}
	public static void main(String[] args) {
		ViewProfile vp= new ViewProfile();
		}


}

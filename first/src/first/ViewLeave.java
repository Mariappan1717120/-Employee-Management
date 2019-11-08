package first;
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Font;
import javax.swing.*;
public class ViewLeave
{
	public static void main(String[] args) {
		ViewLeave vl= new ViewLeave();
		}
	public ViewLeave() {
        JFrame f =new JFrame();
		f.setBounds(0, 0,1400,750);
		f.setVisible(true);	
		f.setLayout(null);
		JScrollPane s=new JScrollPane();
		s.setBounds(100,100,1150,200);
		JLabel l1=new JLabel("Leave History");
		l1.setBounds(620,0,700,40);
		l1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		String data[][]=null;
		String column[]=null;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select *from Leaves",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
			JButton b1=new JButton("Back");
			b1.setFont(new Font("Tahoma", Font.PLAIN, 10));
			b1.setBounds(600,600,75,20);
			b1.addActionListener(new ActionListener() 
			{
		       public void actionPerformed(ActionEvent e)
		       {
		    	   AdminLogin el=new AdminLogin();
		    	   f.dispose();
		       }
			});
			f.add(l1);
			f.add(b1);
			
		f.add(s);
	}
}

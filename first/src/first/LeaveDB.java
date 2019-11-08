package first;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class LeaveDB {
	public static int save(String eid,String name,String department,String designation,String Leavetype,String date,String description){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into leaves values(?,?,?,?,?,?,?)");
			ps.setString(1,eid);
			ps.setString(2,name);
			ps.setString(3,department);
			ps.setString(4,designation);
			ps.setString(5,Leavetype);
			ps.setString(6,date);
			ps.setString(7,description);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
}
}

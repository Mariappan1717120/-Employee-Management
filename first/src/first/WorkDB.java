package first;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class WorkDB {
	public static int save(String eid,String name,String intime,String outtime,String date){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into work values(?,?,?,?,?)");
			ps.setString(1,eid);
			ps.setString(2,name);
			ps.setString(3,intime);
			ps.setString(4,outtime);
			ps.setString(5,date);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
}
}


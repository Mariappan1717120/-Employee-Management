package first;
import java.sql.*;
public class EmployeeDB {

	
	public static int save(String eid,String name,String doj,String department,String designation,String address,String contact,String sex,String password){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into Employee values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1,eid);
			ps.setString(2,name);
			ps.setString(3,doj);
			ps.setString(4,department);
			ps.setString(5,designation);
			ps.setString(6,address);
			ps.setString(7,contact);
			ps.setString(8,sex);
			ps.setString(9,password);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}
	public static int delete(int eid){
		int status=0;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("delete from employee where eid=?");
			ps.setInt(1,eid);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

	public static boolean validate(String username,String password){
		boolean status=false;
		try{
			Connection con=DB.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee where name=? and password=?");
			ps.setString(1,username);
			ps.setString(2,password);
			ResultSet rs=ps.executeQuery();
			status=rs.next();
			con.close();
		}catch(Exception e){System.out.println(e);}
		return status;
	}

}



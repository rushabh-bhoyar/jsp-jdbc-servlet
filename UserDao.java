package in.edac.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
  public static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";
  public static final String DB_URL="jdbc:mysql://localhost:3306/rabhoyar";
  public static final String DB_USER="root";
  public static final String DB_PASSWORD="edac20";
  
  public void checkConnection() {
	  try(Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);){
		  System.out.println("Success try with resources!!");
	  }
	  catch(Exception e) {
		  e.printStackTrace();
	  }
  }
  
  public boolean createUser(User user)throws Exception{
	    Class.forName(DB_DRIVER);
	    try (Connection con=DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);){
			String sql="INSERT INTO USER(USERNAME,EMAIL,PASSWORD,MOBILE)VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getEmail());
			ps.setString(4,user.getMobile());
			
			ps.executeUpdate();
			System.out.println("Insert success");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
  }
  
  public boolean updateUser(User user) throws Exception {
		Class.forName(DB_DRIVER);
		
		try(Connection con = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);)
			{
				String sql = "UPDATE USER SET USERNAME=?,PASSWORD=?,MOBILE=? ,EMAIL=? WHERE ID=?";
				PreparedStatement ps =con.prepareStatement(sql);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
				ps.setString(3,user.getMobile());
				ps.setString(4,user.getEmail());
				ps.setInt(5,user.getId());	
				
				ps.executeUpdate();
				System.out.println("Ghantavar");
				return true;
				
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			throw e;
		}
	
	}
  
  public List<User> readAllUser() throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
			String sql = "SELECT * FROM USER";
			PreparedStatement ps =  con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			List<User> list = new ArrayList<User>();
			while(rs.next()) {
				// ROW :: Reading columns of row
				int colId = rs.getInt("ID");
				String colUsername = rs.getString("USERNAME");
				String colEmail = rs.getString("EMAIL");
				String colMobile = rs.getString("MOBILE");
				
				// ROW :: User We are conveting the row into User object
				User user = new User();
				user.setId(colId);
				user.setUsername(colUsername);
				user.setEmail(colEmail);
				user.setMobile(colMobile);
				
				// Add row/user to list
				list.add(user);
			}
			
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
  
  public boolean deleteUser(User user) throws Exception {
		Class.forName(DB_DRIVER);
		try (Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);){
		
			String sql = "DELETE FROM USER WHERE ID=?";
			PreparedStatement ps =  con.prepareStatement(sql);
			ps.setInt(1, user.getId());
			
			ps.executeUpdate();
			System.out.println("Kotkar");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

  
  public static void main(String []args) throws Exception{
	UserDao dao=new UserDao();
	//User user=new User("rushabh","rushabh@gmail.com","123456789","987654321");
	//dao.createUser(user);
	  
	  //UserDao dao=new UserDao();
	  //User user=new User("virat","virat@gmail.com","8765432345678","fsdgbdgb");
	  //user.setId(3);
	  //dao.updateUser(user);
	  
	 // User user = new User();
	  //user.setId(2);
	  //dao.deleteUser(user);
	

	List<User> list = dao.readAllUser();
	System.out.println(list);
	
	
	  
  }
  }

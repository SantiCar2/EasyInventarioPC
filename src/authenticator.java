import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class authenticator {
	private static final String CONN = "jdbc:mysql://190.249.57.11:25565/login";
	public static boolean payment = false;
	public static String connect(String user, String pass) {
		String ret = null;
		boolean email = false;
		boolean password = false;
		int row = 0;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection CON = DriverManager.getConnection(CONN, "auth", "4815162342");
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM main");
			boolean go = false;
			while(rs.next() && !go) {
				row++;
				//System.out.println(rs.getString("email"));
				if(user.contains(rs.getString("email"))) {
					email = true;
					go = true;
				}
			}
			CON.close();
			if(email) {
				Connection CON0 = DriverManager.getConnection(CONN, "auth", "4815162342");
				Statement stmt0 = CON0.createStatement();
				ResultSet rs0 = stmt0.executeQuery("SELECT * FROM main");
				for (int i = 0; i < row; i++) {
					rs0.next();					
				}
				//System.out.println(rs0.getString("password"));
				if(pass.contains(rs0.getString("password"))) {
					password = true;
					
				}
				CON.close();
			}
			if(email && password) {
				Connection CON1 = DriverManager.getConnection(CONN, "auth", "4815162342");
				Statement stmt1 = CON1.createStatement();
				ResultSet rs1 = stmt1.executeQuery("SELECT * FROM main");
				for (int i = 0; i < row; i++) {
					rs1.next();					
				}
				ret = Integer.toString(rs1.getInt("tableId"));
				payment = rs1.getBoolean("payment");
				CON.close();
			}
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			ret = "E " + e.toString(); 
		}
		
		
		
		
		return ret;
	}
}

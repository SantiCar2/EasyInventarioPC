import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class updateTable {
	final static String CONN = "jdbc:mysql://190.249.57.11:25565/databases";
	
	public static void editTable(String tableid, String columnName, String newInfo, int productId) {
		Connection CON;
		String query = "UPDATE `databases`.`" + tableid + "` SET `" + columnName + "` = '" + newInfo + "' WHERE (`id` = '" + productId + "');";
		
		
		try {
			CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			
			Statement stmt = CON.createStatement();
			System.out.println(query);
			int rs = stmt.executeUpdate(query);
			System.out.println(rs);
			CON.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static boolean addTable(String tableId, String[] columnName, String[] newInfo) {
		boolean ok = false;
		
		return ok;
	}
}

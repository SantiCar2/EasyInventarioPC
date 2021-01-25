import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.x.ResultMessageListener;

public class getTableInfo {
	final static String CONN = "jdbc:mysql://190.249.57.11:25565/databases";
	final static String CONN1 = "jdbc:mysql://190.249.57.11:25565/login";
	public static String[][] getValues(String tabliId){
		String list[][] = null;
		int row = 0;
		
	try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
		Statement stmt = CON.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tabliId + "`");
		while(rs.next()) {
			row++;
			}
		list = new String[row][rs.getMetaData().getColumnCount()];
		CON.close();
		
		int row0 = 0;
		Connection CON0 = DriverManager.getConnection(CONN, "mainApp", "4815162342");
		Statement stmt0 = CON0.createStatement();
		ResultSet rs0 = stmt0.executeQuery("SELECT * FROM `" + tabliId + "`");
		while(rs0.next()) {
			row0++;
			for (int i = 1; i <= list[0].length; i++) {
				list[row0 - 1][i - 1] = rs0.getString(i);
			}
		}
		CON.close();
		
		
		}catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			list = new String[1][1]; 
			list[0][0] = "E " + e.toString(); 
		}
		return list;
	}
	
	public static String[] getColumnNames(String tableId, boolean id) {
		String list[] = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tableId + "`");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			list = new String[rsmd.getColumnCount()];
			for (int i = 0; i < rsmd.getColumnCount(); i++) {
				list[i] = rsmd.getColumnLabel(i + 1).toString();
			}
			CON.close();
		}catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			list = new String[1]; 
			list[0] = "E " + e.toString(); 
		}
		if(!id) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
				Statement stmt = CON.createStatement();
				ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tableId + "`");
				ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
				list = new String[rsmd.getColumnCount() - 1];
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					if(i != 0) {
						list[i - 1] = rsmd.getColumnLabel(i + 1).toString();
					}
				}
				CON.close();
			}catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				list = new String[1]; 
				list[0] = "E " + e.toString(); 
			}
		}
		return list;
	}
	public static String getMail(String tableId) { 
		String ret = null;
		try {
			//Class.forName("com.mysql.jbdc.Driver");
			Connection CON = DriverManager.getConnection(CONN1, "auth", "4815162342");
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT email FROM main WHERE (tableid = '" + tableId + "');");
			rs.next();
			ret = rs.getString(1);
			CON.close();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		return ret;
	}
	
	
	public static String[][] getTableInforID(String tableId, String columName) {
		String list[][] = null;
		int row = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id,`" + columName + "` FROM `" + tableId + "`");
			while(rs.next()) {
				row++;
				}
			list = new String[row][rs.getMetaData().getColumnCount()];
			CON.close();
			
			int row0 = 0;
			Connection CON0 = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			Statement stmt0 = CON0.createStatement();
			ResultSet rs0 = stmt0.executeQuery("SELECT id,`" + columName + "` FROM `" + tableId + "`");
			while(rs0.next()) {
				row0++;
				for (int i = 1; i <= list[0].length; i++) {
					list[row0 - 1][i - 1] = rs0.getString(i);
				}
			}
			ResultSetMetaData rsmd = (ResultSetMetaData) rs0.getMetaData();
			System.out.println(rsmd.getColumnName(2) + "        " + rsmd.getColumnType(2));
			CON.close();
			
			
			}catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				list = new String[1][1]; 
				list[0][0] = "E " + e.toString(); 
			}
		return list;
	}
	
	public static String getOldInfo(String tableId, String columName, int ID) {
		String list = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id,`" + columName + "` FROM `" + tableId + "` WHERE id=" + ID);
			rs.next();
			list = rs.getString(columName);
			CON.close();
			}catch (SQLException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println(e);
				list = "E " + e.toString(); 
			}
		return list;
	}
	
	public static boolean isID(String tableId, int ID) {
		boolean isID = false;
		Connection CON;
		try {
			CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM `" + tableId + "`");
			while(rs.next()) {
				if(rs.getInt("id") == ID) {
					isID = true;
				}
			}
			CON.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isID;
	}
	
	public static int getColumnType(String tableid, String columnName) {
		Connection CON;
		int columnType = 0;
		try {
			CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM `" + tableid + "`");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();
			int count = rsmd.getColumnCount();
			for (int i = 1; i <= count; i++)
			{
			    if (rsmd.getColumnName(i).equals(columnName))
			    {
			        columnType = rsmd.getColumnType(i);
			    }
			}
			CON.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return columnType;
	}
	
	public static int generateId(String tableId) {
		Connection CON;
		Connection CON1;
		int numberOfRows = 0;
		int[] idList = null;
		int grande = 0;
		
		try {
			CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			
			Statement stmt = CON.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT id FROM `" + tableId + "`");
			while(rs.next()) {
				numberOfRows++;
			}
			CON.close();
			idList = new int[numberOfRows];
			int x = 0;
			
			CON1 = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			Statement stmt2 = CON1.createStatement();
			ResultSet rs2 = stmt2.executeQuery("SELECT id FROM `" + tableId + "`");
			while(rs2.next()) {
				idList[x] = rs2.getInt("id");
				x++;
			}
			CON1.close();
			for (int i = 0; i < idList.length; i++) {
				if(idList[i] > grande) {
					grande = idList[i];
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(grande);
		return grande + 1;
	}
	public static int columnCount(String tableId) {
		Connection CON;
		int columnsNumber = 0;
		try {
			CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
			
			Statement st = CON.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM `" + tableId + "`");
			ResultSetMetaData rsmd = (ResultSetMetaData) rs.getMetaData();

			columnsNumber = rsmd.getColumnCount();
		} catch(Exception e) {
			
		}
		return columnsNumber;
	}
}

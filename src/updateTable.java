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
	public static boolean addTable(String tableId, String[] columnNameWID, String[] newInfo, String[] columnName) {
		boolean ok = true;
		int i = 0;
		String q = null;
		try {
			for(i = 0; i < newInfo.length; i++) {
				if(i == 0) {
					if(getTableInfo.getColumnType(login.buf, columnNameWID[i]) == 4) {
						Integer.parseInt(newInfo[i]);
					} else {
						//textField_6.setText("String");
					}
					System.out.println(newInfo[i]);
				} if(i == 1) {
					if(getTableInfo.getColumnType(login.buf, columnNameWID[i]) == 4) {
						Integer.parseInt(newInfo[i]);
					} else {
						//textField_7.setText("String");
					}
					System.out.println(newInfo[i]);
				} if(i == 2) {
					if(getTableInfo.getColumnType(login.buf, columnNameWID[i]) == 4) {
						Integer.parseInt(newInfo[i]);
					} else {
						//textField_8.setText("String");
					}
					System.out.println(newInfo[i]);
				} if(i == 3) {
					if(getTableInfo.getColumnType(login.buf, columnNameWID[i]) == 4) {
						Integer.parseInt(newInfo[i]);
					} else {
						//textField_9.setText("String");
					}
					System.out.println(newInfo[i]);
				} if(i == 4) {
					if(getTableInfo.getColumnType(login.buf, columnNameWID[i]) == 4) {
						Integer.parseInt(newInfo[i]);
					} else {
						//textField_10.setText("String");
					}
						System.out.println(newInfo[i]);
					}	
				}
			}
			catch (Exception e) {
				System.out.println(i);
				e.printStackTrace();
				ok = false;
			}
		if(ok) {
			if(newInfo.length == 2) {
				q = "INSERT INTO `databases`.`" + tableId
						+ "` (`" + columnNameWID[0] + "`, `" + columnNameWID[1] + "`)"
						+ " VALUES ('" + newInfo[0] + "', '" + newInfo[1] + "');";
			}if(newInfo.length == 3) {
				q = "INSERT INTO `databases`.`" + tableId
						+ "` (`" + columnNameWID[0] + "`, `" + columnNameWID[1] + "`, `" + columnNameWID[2] + "`)"
						+ " VALUES ('" + newInfo[0] + "', '" + newInfo[1] + "', '" + newInfo[2] + "');";
			}if(newInfo.length == 4) {
				q = "INSERT INTO `databases`.`" + tableId
						+ "` (`" + columnNameWID[0] + "`, `" + columnNameWID[1] + "`, `" + columnNameWID[2] + "`,"
						+ " `" + columnNameWID[3] + "`)"
						+ " VALUES ('" + newInfo[0] + "', '" + newInfo[1] + "', '" + newInfo[2] + "', '" + newInfo[3] + "');";
			}if(newInfo.length == 5) {
				q = "INSERT INTO `databases`.`" + tableId
						+ "` (`" + columnNameWID[0] + "`, `" + columnNameWID[1] + "`, `" + columnNameWID[2] + "`,"
						+ " `" + columnNameWID[3] + "`, `" + columnNameWID[4] + "`)"
						+ " VALUES ('" + newInfo[0] + "', '" + newInfo[1] + "', '" + newInfo[2] + "', '" + newInfo[3] + "', '" + newInfo[4] + "');";
			}if(newInfo.length == 1) {
				q = "INSERT INTO `databases`.`" + tableId
						+ "` (`" + columnNameWID[0] + "`)"
						+ " VALUES ('" + newInfo[0] + "');";
			}
			System.out.println(q);
			Connection CON;	
			try {
				CON = DriverManager.getConnection(CONN, "mainApp", "4815162342");
				Statement stmt = CON.createStatement();
				int rs = stmt.executeUpdate(q);
				System.out.println(rs);
				CON.close();
			} catch (SQLException e) {
				ok = false;
			}
		}
		
		return ok;
	}
	public static void changePayment(String tableId) {
		final String CONN1 = "jdbc:mysql://190.249.57.11:25565/login";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection CON = DriverManager.getConnection(CONN1, "auth", "4815162342");
			Statement stmt = CON.createStatement();
			int rs = stmt.executeUpdate("UPDATE `login`.`main` SET `payment` = '1' WHERE (`tableId` = '" + tableId + "');");
			CON.close();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}

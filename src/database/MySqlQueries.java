package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.DataProvider;

//import com.theopentutorials.jdbc.db.DbUtil;

public class MySqlQueries {

	// public static void main(String[] args) {
	//
	// try {
	//
	// CopyOfJDBCMySQLDemo demo = new CopyOfJDBCMySQLDemo();
	// demo.getAccounts();
	// } catch (NumberFormatException e) {
	// e.printStackTrace();
	// }
	// }

	@DataProvider(name = "MySQL-provider")
	public static String[][] getAccounts() {
		ResultSet rs = null;
		Connection connection = null;
		Statement statement = null;

		String myData[][] = null;

		String query = "SELECT * FROM User";
		try {
			connection = JDBCMySQLConnection.getConnection();
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			int rowCount = 0;
			int columnCount = 0;

			// Get Column count
			ResultSetMetaData resultSet_metaData = rs.getMetaData();
			columnCount = resultSet_metaData.getColumnCount();

			// Get Row Count
			while (rs.next())
				rowCount++;

			// Initialize data structure
			myData = new String[rowCount][columnCount];

			rs.beforeFirst();

			// populate data structure
			for (int row = 0; row < rowCount; row++) {
				rs.next();
				System.out.println("name: " + rs.getString("name") + " -- "
						+ rs.getString("email"));

				for (int col = 1; col <= columnCount; col++)
					myData[row][col - 1] = rs.getString(col);
			}
			System.out.println("out 1/3: " + myData[1][3] + "length: "
					+ myData.length);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return myData;

	}
}

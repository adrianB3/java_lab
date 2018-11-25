package lab7;
import java.sql.*;

public class DbContext {
	public static Connection conn;
	public static void connect() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/facultate";
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		conn = DriverManager.getConnection(url, "adrianb3", "wrappi5nG!@#");
	}
	public static void disconnect() throws SQLException {
		conn.close();
	}
}

 
package adotego.jdbc;
 
import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
      private MysqlDataSource pool ;

	public ConnectionPool() {
		pool = new MysqlDataSource();
		pool.setURL(ConnectionProperty_enum.URL.getValue());
		pool.setUser(ConnectionProperty_enum.USERNAME.getValue());
		pool.setPassword(ConnectionProperty_enum.PASSWORD.getValue());
	}
	
	public Connection getConnection() throws SQLException{
		return pool.getConnection();
	}
}

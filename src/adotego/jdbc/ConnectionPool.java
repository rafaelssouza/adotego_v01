package adotego.jdbc;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {
    
    private final MysqlDataSource pool ;

    /*
        Já setamos os valores necessários para a conexão no construtor da classe
        utilizamos do EnumConnectionProperty para recuperar usuario,senha e url,
    */
    public ConnectionPool() {
            pool = new MysqlDataSource();
            pool.setURL(ConnectionProperty_enum.URL.getValue());
            pool.setUser(ConnectionProperty_enum.USERNAME.getValue());
            pool.setPassword(ConnectionProperty_enum.PASSWORD.getValue());
    }
    
    /*
        Método responsável por retornar um objeto do tipo sql.Connection 
        com todos os valores e propriedades definidas
    */
    public Connection getConnection() throws SQLException{
            return pool.getConnection();
    }
}

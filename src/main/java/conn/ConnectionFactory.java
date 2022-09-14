package conn;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection con;
    public PreparedStatement stmt;
    public ResultSet rs;
    public CallableStatement call;

    public void open() throws Exception {
        String url = "jdbc:mysql://localhost:3306/cadastros";
        String username = "root";
        String password = "";
        try {
            con =  DriverManager.getConnection(url, username, password);
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar o banco");
        }
    }

    public void close() throws Exception{
        con.close();
    }
}

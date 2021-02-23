package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author JULIO PASCHOAL
 */
public class Conexao {

    private static final String URL = "jdbc:mysql://localhost/java2";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConexao() {
        try {
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (Exception e) {
            return null;
        }
    }
}

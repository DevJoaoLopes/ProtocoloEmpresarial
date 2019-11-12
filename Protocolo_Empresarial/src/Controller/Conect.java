package Controller;
/**
 *
 * @author piga
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conect {
    protected Connection conn;
    public static String status = "Não conectou...";
    
    public static java.sql.Connection getConexaoMySQL() {
        Connection connection = null;
        try {
            String driverName = "com.mysql.cj.jdbc.Driver";                        
            Class.forName(driverName);  
            String serverName = "localhost"; 
            String mydatabase ="";       
            String url = "jdbc:mysql://" + serverName + "/" + mydatabase+"?useTimezone=true&serverTimezone=UTC";
            String username = "root";    
            String password = ""; 
            connection = DriverManager.getConnection(url, username, password);
            if (connection != null) {
                status = ("STATUS---> Conectado com sucesso!");
            } else {
                status = ("STATUS---> Não foi possivel realizar conexão");
            }
            return connection;
        
        } catch (ClassNotFoundException e) {
            System.out.println("O driver expecificado nao foi encontrado.");
            return null;
        } catch (SQLException e) {
            System.out.println("Nao foi possivel conectar ao Banco de Dados." +e);
            return null;
        }
    }
    public static String statusConection() {
        return status;
    }
    public static void main(String[] args) {
        Conect c = new Conect();
        c.getConexaoMySQL();
        System.out.println(c.statusConection());
    }
}

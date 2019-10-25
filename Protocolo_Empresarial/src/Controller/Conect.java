package Controller;
/**
 *
 * @author piga
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conect {
    protected Connection conn;
    public static String status = "Não conectou...";
    
    
    
    public static java.sql.Connection getConexaoMySQL() {
 
        Connection connection = null; //atributo do tipo Connection
        try {
        // Carregando o JDBC Driver padrão
        String driverName = "com.mysql.cj.jdbc.Driver";                        
        Class.forName(driverName);  
        // Configurando a nossa conexão com um banco de dados//
 
        
        String serverName = "";    //caminho do servidor do BD
        String mydatabase ="trabalho";        //nome do seu banco de dados
        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
        String username = "";        //nome de um usuário de seu BD      
        String password = "mysql";      //sua senha de acesso
        connection = DriverManager.getConnection(url, username, password);
        //Testa sua conexão
        if (connection != null) {
            status = ("STATUS--->Conectado com sucesso!");
        } else {
            status = ("STATUS--->Não foi possivel realizar conexão");
        }
        return connection;
        
        } catch (ClassNotFoundException e) {  //Driver não encontrado
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

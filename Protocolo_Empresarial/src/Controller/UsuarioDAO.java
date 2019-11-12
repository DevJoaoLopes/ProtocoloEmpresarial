package Controller;

import java.sql.PreparedStatement;
import Controller.Conect;
import Model.Usuario;
import java.sql.Connection;
import java.sql.SQLException;
 
/**
 *
 * @author piga
 */
public class UsuarioDAO {
    
    Conect con = new Conect();
    Connection connection = con.getConexaoMySQL();
    
    String sqlInsert = "INSERT INTO usuario(nome,email,rg,cpf) VALUES(?,?,?,?)";
   
   public void insertUsuario(Usuario element){
    try {    
        PreparedStatement stmt = connection.prepareStatement(sqlInsert);    
        stmt.setString(1,element.getNome());
        stmt.setString(2,element.getEmail());
        stmt.setString(3,element.getRg());
        stmt.setString(4,element.getCpf());
        stmt.execute();   
        stmt.close();
    }catch (SQLException u) {    
        throw new RuntimeException(u);         
    }    
    }
 
}

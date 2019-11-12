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
public class ControllerUsuario {
    
    Conect con = new Conect();
    Connection connection = con.getConexaoMySQL();
    
    String sqlInsert = "INSERT INTO usuario(nome) VALUES(?)";
   
   public void insertUsuario(Usuario usuario){
    try {    
        PreparedStatement stmt = connection.prepareStatement(sqlInsert);    
        stmt.setString(1,usuario.getNome());    
        stmt.execute();   
        stmt.close();
    }catch (SQLException u) {    
        throw new RuntimeException(u);         
    }    
    }
 
}

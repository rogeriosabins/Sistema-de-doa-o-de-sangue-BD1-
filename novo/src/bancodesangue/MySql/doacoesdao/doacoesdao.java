
package bancodesangue.MySql.doacoesdao;

import Connection.MySql.ConnectionFactory;
import Connection.Classes.doacoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class doacoesdao {
    
    public void criarRegistroNoBancoDeDados(doacoes dd){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into DOACAO (";
        try{
            stmt = con.prepareStatement(sql);
        }catch(SQLException e){
            
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
}

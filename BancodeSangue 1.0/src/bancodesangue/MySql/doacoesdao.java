
package bancodesangue.MySql;

import Connection.MySql.ConnectionFactory;
import Connection.Classes.doacoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class doacoesdao {
    
    public void criarRegistroNoBancoDeDados(doacoes d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into DOACAO (";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(2, d.getData());
            stmt.setString(3, d.getHorario());
            stmt.setString(4, d.getColetor());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos no Sistema!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar todos os dados!" +e.toString());
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
}


////////////////


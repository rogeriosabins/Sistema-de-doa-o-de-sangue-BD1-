
package bancodesangue.MySql;

import Connection.MySql.ConnectionFactory;
import Connection.Classes.doadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class doadoresdao {
    
    public void criarRegistroNoBancoDeDados(doadores d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into DOADOR (nome_doador,rg,tipo_sanguineo,idade_doador,telefone_doador,endereco_doador, email_doador) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(0, d.getNome());
            stmt.setString(1, d.getRG());
            stmt.setString(2, d.getTiposangue());
            stmt.setString(3, d.getIdade());
            stmt.setString(4, d.getTelefone());
            stmt.setString(5, d.getEndereco());
            stmt.setString(6, d.getEmail());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos no Sistema!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar todos os dados!" +e.toString());
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
}

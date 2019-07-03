
package bancodesangue.MySql;

import Connection.MySql.ConnectionFactory;
import Connection.Classes.doadores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class doadoresdao {
    
    public void criarRegistroNoBancoDeDados(doadores d) throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "insert into DOADOR(nome_doador,rg,tipo_sanguineo,idade_doador,telefone_doador,endereco_doador, email_doador) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, d.getNome());
            stmt.setInt(2, d.getRG());
            stmt.setString(3, d.getTiposangue());
            stmt.setString(4, d.getIdade());
            stmt.setString(5, d.getTelefone());
            stmt.setString(6, d.getEndereco());
            stmt.setString(7, d.getEmail());
            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos no Sistema!");
        }catch(SQLException e){
            System.out.println("Erro ao Salvar"+e.toString());
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
    public void deletarRegistroNoBancoDeDados(doadores d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM DOADOR WHERE rg = ?";
        try{
            stmt.setInt(1, d.getRG());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Doador deletado do sistema!");
        }catch(SQLException e){
            System.out.println("Erro ao deletar"+e.toString());
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        
    

}
    }

    public List<doadores> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<doadores> doador = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM DOADOR");
            rs = stmt.executeQuery();

            while (rs.next()) {

                doadores d = new doadores();

                d.setRG(rs.getInt("rg"));
                d.setNome(rs.getString("nome_doador"));
                d.setIdade(rs.getString("idade_doador"));
                d.setTelefone(rs.getString("telefone_doador"));
                d.setEmail(rs.getString("email_doador"));
                d.setEndereco(rs.getString("endereco_doador"));
                d.setTiposangue(rs.getString("tipo_doador"));
                doador.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(doadoresdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return doador;

    }
    
        public void update(doadores d) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE DOADOR SET nome_doador = ? ,tipo_doador = ?,idade_doador = ?,telefone_doador = ?, endereco_doador = ?, email_doador = ? WHERE rg = ?");
            
            stmt.setString(1, d.getNome());
            stmt.setString(2, d.getTiposangue());
            stmt.setString(3, d.getIdade());
            stmt.setString(4, d.getTelefone());
            stmt.setString(5, d.getEndereco());
            stmt.setString(6, d.getEmail());
            stmt.setInt(7, d.getRG());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}


package bancodesangue.MySql;

import Connection.MySql.ConnectionFactory;
import Connection.Classes.doacoes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class doacoesdao {
    
    public void criarRegistroNoBancoDeDados(doacoes d)throws SQLException{
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        String sql = "INSERT INTO DOACAO (data_doacao, hora_doacao) values (?,?)";
        stmt = con.prepareStatement("INSERT INTO FAZ (rg) values(?)");
        try{
            stmt = con.prepareStatement(sql);
            stmt.setString(1, d.getData());
            stmt.setString(2, d.getHorario());
            
            stmt.setInt(2, d.getRG());
            stmt.setInt(5, d.getColetor());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Dados inseridos no Sistema!");
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Erro ao salvar todos os dados!" +e.toString());
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        }
        
    }
        public List<doacoes> read() {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<doacoes> doacao = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM DOACAO");
            rs = stmt.executeQuery();

            while (rs.next()) {

                doacoes d = new doacoes();

                d.setRG(rs.getInt("SELECT RG FROM FAZ"));
                
                d.setData(rs.getString("data_doacao"));
                
                d.setHorario(rs.getString("horaio_doacao"));
                
                d.setColetor(rs.getInt("id_coletor"));
                
                doacao.add(d);
            }

        } catch (SQLException ex) {
            Logger.getLogger(doacoesdao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return doacao;

    }
            public void deletarRegistroNoBancoDeDados(doacoes d){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "DELETE FROM DOACAO WHERE id_doacao = ?";
        try{
            stmt.setInt(1, d.getId());

            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Doador deletado do sistema!");
        }catch(SQLException e){
            System.out.println("Erro ao deletar"+e.toString());
        
        }finally{
            ConnectionFactory.closeConnection(con,stmt);
        
    

}
    }
public void update(doacoes d) {

        Connection con = ConnectionFactory.getConnection();
        
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("UPDATE DOACAO SET data_doacao = ? , hora_doacao = ?  WHERE id_doacao = ?");
            
            
            stmt.setString(1, d.getData());
            stmt.setString(2, d.getHorario());
            stmt.setInt(3, d.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }

    }
}


////////////////


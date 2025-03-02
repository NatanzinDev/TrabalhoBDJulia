package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import dominio.Cosmetico;

public class CosmeticoDao {
	public void cadastrarComestico(String nome,String tipo, double valor) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();

		

		String sql = "INSERT INTO cosmetico (nome, tipo, valor,idmarca) VALUES (?,?,?,?)";

		Cosmetico c = new Cosmetico();
		c.setNome(nome);
		c.setTipo(tipo);
		c.setValor(valor);
		System.out.println(c.getIdmarca());

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTipo());
		comando.setDouble(3, c.getValor());
		comando.setInt(4, 1);
		
		comando.execute();

		JOptionPane.showMessageDialog(null, "Cosmético cadastrado.");


		comando.close();
		conexao.close();
	}
	
	public void updateCosmetico(String nome,String tipo, double valor) throws ClassNotFoundException, SQLException {
		Cosmetico c = new Cosmetico();
		c.setNome(nome);
		c.setTipo(tipo);
		c.setValor(valor);
		
		
		Connection conexao = FabricaConexao.criarConexao();

		
		String sql = "UPDATE cosmetico SET nome=?, tipo=?, valor=?";
		
		PreparedStatement comando  = conexao.prepareStatement(sql);
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTipo());
		comando.setDouble(3, c.getValor());
		comando.executeUpdate();
		
		JOptionPane.showMessageDialog(null, "Cosmético atualizado.");
		
		
		comando.close();
		conexao.close();
	}
}

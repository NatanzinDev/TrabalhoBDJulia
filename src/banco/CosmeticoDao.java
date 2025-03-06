package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import dominio.Cosmetico;

import dominio.Marca;

public class CosmeticoDao {
	public void cadastrarComestico(String nome, String tipo, double valor, Marca m) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();


		String sql = "INSERT INTO cosmetico (nome, tipo, valor,idmarca) VALUES (?,?,?,?)";

		Cosmetico c = new Cosmetico();
		c.setNome(nome);
		c.setTipo(tipo);
		c.setValor(valor);
		c.setIdmarca(m.getId());
		System.out.println(c.getIdmarca());

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTipo());
		comando.setDouble(3, c.getValor());
		comando.setInt(4, c.getIdmarca());

		comando.execute();

		JOptionPane.showMessageDialog(null, "Cosmético cadastrado.");

		comando.close();
		conexao.close();
	}

	

	public void updateCosmetico(Cosmetico c) throws ClassNotFoundException, SQLException {

		Connection conexao = FabricaConexao.criarConexao();

		String sql = "UPDATE cosmetico SET nome=?, tipo=?, valor=? WHERE id = ?";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, c.getNome());
		comando.setString(2, c.getTipo());
		comando.setDouble(3, c.getValor());
		comando.setInt(4, c.getId());
		comando.executeUpdate();

		JOptionPane.showMessageDialog(null, "Cosmético atualizado.");

		comando.close();
		conexao.close();
	}

	public void deleteCosmetico(Cosmetico c) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();

		String sql = "DELETE FROM cosmetico WHERE ID = ?";

		PreparedStatement comando = conexao.prepareStatement(sql);

		comando.setInt(1, c.getId());
		comando.executeUpdate();

		comando.close();
		conexao.close();
	}

	public List<Cosmetico> buscarCosmeticos() throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();

		String sql = "SELECT * FROM cosmetico";

		PreparedStatement comando = conexao.prepareStatement(sql);

		ResultSet resultado = comando.executeQuery();

		List<Cosmetico> cosmeticosCadastrados = new ArrayList<>();

		while (resultado.next()) {
			Cosmetico c = new Cosmetico();
			c.setNome(resultado.getString("nome"));
			c.setId(resultado.getInt("id"));
			c.setIdmarca(resultado.getInt("idmarca"));
			c.setTipo(resultado.getString("tipo"));
			c.setValor(resultado.getDouble("valor"));

			cosmeticosCadastrados.add(c);
		}

		return cosmeticosCadastrados;
	}

	public List<Cosmetico> buscaCosmeticoPeloNome(String nome) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		System.out.println("Buscando");
		String sql = " SELECT * FROM cosmetico WHERE 1 = 1 ";

		if (nome != null && !nome.isEmpty()) {
			sql += " AND upper(nome) LIKE ? ";

		}

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		int i = 1;

		if (nome != null && !nome.isEmpty()) {
			comando.setString(i++, "%" + nome.toUpperCase() + "%");

		}

		ResultSet resultado = comando.executeQuery();

		List<Cosmetico> ce = new ArrayList<>();

		while (resultado.next()) {
			Cosmetico m = new Cosmetico();
			m.setId(resultado.getInt("id"));
			m.setNome(resultado.getString("nome"));
			m.setIdmarca(resultado.getInt("idmarca"));
			m.setTipo(resultado.getString("tipo"));
			m.setValor(resultado.getDouble("valor"));

			ce.add(m);
		}

		System.out.println("Achou");
		return ce;

	}

	public List<Cosmetico> buscarCosmetico(String s, String s1) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		String sql = "SELECT c.nome, c.tipo, c.valor,  m.nome AS nomemarca  FROM cosmetico c JOIN marca m ON c.idmarca= m.idmarca";

		boolean temFiltro = false;

		if (s != null && !s.isEmpty()) {
			sql += " WHERE c.nome LIKE ?";
			temFiltro = true;
		}

		if (s1 != null && !s1.isEmpty()) {
			sql += temFiltro ? " AND c.tipo LIKE ?" : " WHERE c.tipo LIKE ?";
			temFiltro = true;
		}

		

		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;

		if (s != null && !s.isEmpty()) {
			comando.setString(i, "%" + s.toUpperCase() + "%");
			i++;
		}

		if (s1 != null && !s1.isEmpty()) {
			comando.setString(i, "%" + s.toUpperCase() + "%");
			i++;
		}

		


		ResultSet resultado = comando.executeQuery();

		List<Cosmetico> ce = new ArrayList<>();

		while (resultado.next()) {
			Cosmetico c = new Cosmetico();
			c.setNome(resultado.getString("nome"));
			c.setTipo(resultado.getString("tipo"));
			c.setValor(resultado.getDouble("valor"));

			Marca m = new Marca();
			m.setNome(resultado.getString("nomemarca"));
			c.setMarca(m);

			ce.add(c);

		}
		
		return ce;
	}
}

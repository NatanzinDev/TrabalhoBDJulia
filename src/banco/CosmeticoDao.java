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
	public void cadastrarComestico(String nome, String tipo, double valor) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();

		int idmarca = verificarOuCriarMarcaGenerica();

		String sql = "INSERT INTO cosmetico (nome, tipo, valor,idmarca) VALUES (?,?,?,?)";

		Cosmetico c = new Cosmetico();
		c.setNome(nome);
		c.setTipo(tipo);
		c.setValor(valor);
		c.setIdmarca(idmarca);
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

	private int verificarOuCriarMarcaGenerica() throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		String sqlVerifica = "SELECT idmarca FROM marca WHERE idmarca = 1";
		PreparedStatement comando = conexao.prepareStatement(sqlVerifica);
		ResultSet resultado = comando.executeQuery();

		if (resultado.next()) {
			return resultado.getInt("idmarca");
		}

		String sqlInsere = "INSERT INTO marca(nome, seguemento) VALUES (?, ?)";
		PreparedStatement comandoInsere = conexao.prepareStatement(sqlInsere, PreparedStatement.RETURN_GENERATED_KEYS);
		comandoInsere.setString(1, "Generico");
		comandoInsere.setString(2, "Generico");
		comandoInsere.executeUpdate();

		ResultSet chaves = comandoInsere.getGeneratedKeys();
		if (chaves.next()) {
			return chaves.getInt(1);
		}

		throw new SQLException("Falha ao criar marca genérica.");
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
}

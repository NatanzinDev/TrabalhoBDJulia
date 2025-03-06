package banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;


import dominio.Marca;



public class MarcaDao {
	public void addMarca(Marca m) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		
		String sql = " INSERT INTO  marca (nome,seguemento) VALUES (?,?) ";

		PreparedStatement comando = conexao.prepareStatement(sql);
		comando.setString(1, m.getNome());
		comando.setString(2, m.getSegmento());
		comando.execute();

		comando.close();
		conexao.close();

		JOptionPane.showMessageDialog(null, "Marca Castrada");
	}
	
	public void cadastrarCosmetico() {
		
	}
	
	public List<Marca> buscaMarcaPeloNome(String nome) throws ClassNotFoundException, SQLException{
		Connection conexao = FabricaConexao.criarConexao();

		String sql = " SELECT * FROM marca WHERE 1 = 1 ";

		if (nome != null && !nome.isEmpty()) {
			sql += " AND upper(nome) LIKE ? ";

		}

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		int i = 1;

		if (nome != null && !nome.isEmpty()) {
			comando.setString(i++, "%" + nome.toUpperCase() + "%");

		}

		ResultSet resultado = comando.executeQuery();

		List<Marca> me = new ArrayList<>();

		while (resultado.next()) {
			Marca m = new Marca();
			m.setId(resultado.getInt("idmarca"));
			m.setNome(resultado.getString("nome"));
			m.setSegmento(resultado.getString("seguemento"));

			me.add(m);
		}

		return me;
	}

	public List<Marca> buscarMarca(String text, String text2) throws ClassNotFoundException, SQLException {
		Connection conexao = FabricaConexao.criarConexao();
		String sql = " SELECT * FROM marca WHERE 1 = 1 ";

		if (text != null && !text.isEmpty()) {
			sql += " AND nome LIKE ? ";
		}
		
		if(text2 != null && !text2.isEmpty()) {
			sql += "AND seguemento LIKE ?";
		}

		

		

		PreparedStatement comando = conexao.prepareStatement(sql.toString());
		int i = 1;

		if (text != null && !text.isEmpty()) {
			comando.setString(i, "%" + text.toUpperCase() + "%");
			i++;
		}

		if (text2 != null && !text2.isEmpty()) {
			comando.setString(i, "%" + text.toUpperCase() + "%");
			i++;
		}

		

		ResultSet resultado = comando.executeQuery();

		List<Marca> mc = new ArrayList<>();

		while (resultado.next()) {
			Marca m = new Marca();
			m.setNome(resultado.getString("nome"));
			m.setSegmento(resultado.getString("seguemento"));
			
			mc.add(m);
		
		}

		return mc;
	}

	public List<Marca> buscarMarcaPeloNome(String nome) throws ClassNotFoundException, SQLException {
		
		Connection conexao = FabricaConexao.criarConexao();

		String sql = " SELECT * FROM marca WHERE 1 = 1 ";

		if (nome != null && !nome.isEmpty()) {
			sql += " AND upper(nome) LIKE ? ";

		}

		PreparedStatement comando = conexao.prepareStatement(sql.toString());

		int i = 1;

		if (nome != null && !nome.isEmpty()) {
			comando.setString(i++, "%" + nome.toUpperCase() + "%");

		}

		ResultSet resultado = comando.executeQuery();

		List<Marca> achado = new ArrayList<>();

		while (resultado.next()) {
			Marca m = new Marca();
			m.setId(resultado.getInt("idmarca"));
			m.setNome(resultado.getString("nome"));
			m.setSegmento(resultado.getString("seguemento"));

			achado.add(m);
		}

		return achado;
	}
}

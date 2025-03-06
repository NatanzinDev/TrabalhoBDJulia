package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import banco.CosmeticoDao;
import banco.MarcaDao;
import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import dominio.Cosmetico;
import dominio.Marca;


public class CadastraCosmetico extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtTipo;
	private JTextField txtValor;
	private JButton btCadastrar;
	private JList list;
	private JComboBox comboBox;
	private SortedList<Marca> setores = new SortedList<Marca>(new BasicEventList<Marca>());
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastraCosmetico frame = new CadastraCosmetico();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public CadastraCosmetico() throws ClassNotFoundException, SQLException {
		setTitle("Cadastrar Cosmético");
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(CadastraCosmetico.class.getResource("/imagens/cosmeticos.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 471);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		panel.setBounds(29, 39, 371, 339);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Cadastre o coméstico");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(53, 10, 242, 30);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(26, 71, 69, 20);
		panel.add(lblNewLabel_1);

		txtNome = new JTextField();
		txtNome.setBounds(105, 71, 200, 25);
		panel.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("Tipo:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(26, 136, 69, 20);
		panel.add(lblNewLabel_1_1);

		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(105, 136, 200, 25);
		panel.add(txtTipo);

		JLabel lblNewLabel_1_1_1 = new JLabel("Valor:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(26, 202, 69, 20);
		panel.add(lblNewLabel_1_1_1);

		txtValor = new JTextField();
		txtValor.setColumns(10);
		txtValor.setBounds(105, 202, 200, 25);
		panel.add(txtValor);

		btCadastrar = new JButton("Cadastrar");
		btCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarCosmeticos();
				} catch (NumberFormatException | ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCadastrar.setBounds(124, 296, 161, 21);
		panel.add(btCadastrar);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Marca:");
		lblNewLabel_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(26, 245, 69, 20);
		panel.add(lblNewLabel_1_1_1_1);
		
		comboBox = new JComboBox();
		comboBox.setBounds(104, 247, 201, 21);
		panel.add(comboBox);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 64));
		panel_1.setBounds(487, 39, 414, 339);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(56, 55, 309, 197);
		panel_1.add(scrollPane);

		list = new JList();
		list.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Cosm\u00E9ticos Cadastrados", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		scrollPane.setViewportView(list);

		JButton btnNewButton_1 = new JButton("Exibir");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cosmetico c = (Cosmetico) list.getSelectedValue();
				String s = "Nome: "+c.getNome()+"\nTipo: "+ c.getTipo()+"\nValor: "+c.getValor();
				JOptionPane.showMessageDialog(null, s);
			}
		});
		btnNewButton_1.setBounds(31, 287, 85, 21);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_1_1 = new JButton("Editar");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				editar();
				
			}
		});
		btnNewButton_1_1.setBounds(175, 287, 85, 21);
		panel_1.add(btnNewButton_1_1);

		JButton btnNewButton_1_1_1 = new JButton("Remover");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					removerCosmetico();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1_1_1.setBounds(295, 287, 109, 21);
		panel_1.add(btnNewButton_1_1_1);
		
	AutoCompleteSupport.install(comboBox, setores);
		
		comboBox.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					buscarMarca();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		atualizarLista();
	}

	protected void buscarMarca() throws ClassNotFoundException {
		if (comboBox.getEditor().getItem() != null
				&& comboBox.getEditor().getItem().toString().length() >= 3) {
			MarcaDao dao = new MarcaDao();
			List<Marca> marcaEncontrados = new ArrayList<>();

			try {
				String nome = comboBox.getEditor().getItem().toString();
				marcaEncontrados = dao.buscarMarcaPeloNome(nome);

				setores.clear();
				setores.addAll(marcaEncontrados);

				comboBox.showPopup();
				
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro no Sistema");
			}
		}
		
	}

	protected void editar() {
		if(list.getSelectedIndex() == -1) {
			exibirMensagemErro("Selecione um cosmético.");
		}
		Cosmetico c = (Cosmetico) list.getSelectedValue();
		
		txtNome.setText(c.getNome());
		txtValor.setText(String.valueOf(c.getValor()));
		txtTipo.setText(c.getTipo());
		btCadastrar.setText("Editar");
		
	}

	protected void removerCosmetico() throws ClassNotFoundException, SQLException {
		if(list.getSelectedIndex() == -1) {
			exibirMensagemErro("Selecione o cosmético");
			return;
		}
		
		CosmeticoDao dao = new CosmeticoDao();
		Cosmetico c = (Cosmetico) list.getSelectedValue();
		
		dao.deleteCosmetico(c);
		atualizarLista();
		
	}

	protected void cadastrarCosmeticos() throws NumberFormatException, ClassNotFoundException, SQLException {
		if (txtNome.getText() == null || txtNome.getText().isEmpty()) {
			exibirMensagemErro("Nome não pode ser vazio");
			return;
		}

		if (txtTipo.getText() == null || txtTipo.getText().isEmpty()) {
			exibirMensagemErro("Matrícula não pode ser vazio");
			return;
		}

		if (txtValor.getText() == null || txtValor.getText().isEmpty()) {
			exibirMensagemErro("Curso não pode ser vazio");
			return;
		}
		if(comboBox.getSelectedItem() == null || comboBox.getSelectedItem().toString().isEmpty()) {
			exibirMensagemErro("Marca não pode estar vazia");
			return;
		}
		
		Marca m = (Marca) comboBox.getSelectedItem();
		
		if(btCadastrar.getText().equals("Cadastrar")) {
			CosmeticoDao dao = new CosmeticoDao();
			try {
				dao.cadastrarComestico(txtNome.getText(), txtTipo.getText(), Double.parseDouble(txtValor.getText()),m);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar cadastrar cosmético, tente novamente.");
				System.out.println(e.getMessage());
			}
		}else if(btCadastrar.getText().equals("Editar")) {
			CosmeticoDao dao = new CosmeticoDao();
			Cosmetico c = (Cosmetico) list.getSelectedValue();
			c.setNome(txtNome.getText());
			c.setTipo(txtTipo.getText());
			c.setValor(Double.parseDouble(txtValor.getText()));
			try {
				dao.updateCosmetico(c);
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Erro ao tentar editar cosmético, tente novamente.");
			}
			
			
		}
		
		atualizarLista();
		
		btCadastrar.setText("Cadastrar");
		txtNome.setText("");
		txtTipo.setText("");
		txtValor.setText("");
	}

	private void atualizarLista() throws ClassNotFoundException, SQLException {
		CosmeticoDao dao = new CosmeticoDao();
		List<Cosmetico> l = dao.buscarCosmeticos();
		
		DefaultListModel<Cosmetico> modelo = new DefaultListModel<>();
		
		for(int i = 0; i < l.size(); i++) {
			Cosmetico c = l.get(i);
			modelo.addElement(c);
		}
		
		list.setModel(modelo);
		
	}
	
	

	private void exibirMensagemErro(String string) {
		JOptionPane.showMessageDialog(contentPane, string);
	}
}

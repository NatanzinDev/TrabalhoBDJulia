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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import banco.CosmeticoDao;
import banco.MarcaDao;
import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.SortedList;
import ca.odell.glazedlists.swing.AutoCompleteSupport;
import dominio.Cosmetico;
import dominio.Marca;


public class CadastrarMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSeguemento;
	
	private SortedList<Marca> marcas = new SortedList<Marca>(new BasicEventList<Marca>());
	private SortedList<Cosmetico> cosmeticos = new SortedList<Cosmetico>(new BasicEventList<Cosmetico>());
	private JComboBox cbMarca;
	private JComboBox cbCosmetico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastrarMarca frame = new CadastrarMarca();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CadastrarMarca() {
		setTitle("Cadastrar Marca");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastrarMarca.class.getResource("/imagens/cosmeticos.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 843, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		panel.setBounds(48, 45, 291, 287);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR MARCA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(39, 10, 210, 28);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(71, 59, 75, 20);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Seguemento:");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(21, 127, 114, 20);
		panel.add(lblNewLabel_2_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(153, 62, 96, 19);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtSeguemento = new JTextField();
		txtSeguemento.setColumns(10);
		txtSeguemento.setBounds(153, 130, 96, 19);
		panel.add(txtSeguemento);
		
		JButton btCadastrarMarca = new JButton("Cadastrar");
		btCadastrarMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cadastrarMarca();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btCadastrarMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCadastrarMarca.setBounds(94, 217, 109, 21);
		panel.add(btCadastrarMarca);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 64));
		panel_1.setBounds(430, 45, 370, 287);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAR MARCA");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1.setBounds(92, 10, 210, 28);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("NO COSMÉTICO");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(92, 35, 210, 28);
		panel_1.add(lblNewLabel_1_1);
		
		cbMarca = new JComboBox();
		cbMarca.setBounds(49, 90, 284, 21);
		panel_1.add(cbMarca);
		
		JLabel lblNewLabel_2_2 = new JLabel("Marca:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(147, 60, 75, 20);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Cosmético:");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(147, 143, 92, 20);
		panel_1.add(lblNewLabel_2_2_1);
		
		cbCosmetico = new JComboBox();
		cbCosmetico.setBounds(49, 173, 284, 21);
		panel_1.add(cbCosmetico);
		
		JButton btCadastrarMarcaNoCosmetico = new JButton("Cadastrar");
		btCadastrarMarcaNoCosmetico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCadastrarMarcaNoCosmetico.setBounds(130, 223, 109, 21);
		panel_1.add(btCadastrarMarcaNoCosmetico);
		
	AutoCompleteSupport.install(cbMarca, marcas);
		
		cbMarca.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {

			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					buscarMarca();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
		
		AutoCompleteSupport.install(cbCosmetico, cosmeticos);
		cbCosmetico.getEditor().getEditorComponent().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					buscarCosmetico();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		});
	}

	protected void buscarCosmetico() throws ClassNotFoundException {
		if(cbCosmetico.getEditor().getItem() != null && cbCosmetico.getEditor().getItem().toString().length() >= 3) {
			
			CosmeticoDao dao = new CosmeticoDao();
			List<Cosmetico> ce = new ArrayList<>();
			
			try {
				String nome = cbCosmetico.getEditor().getItem().toString();
				dao.buscaCosmeticoPeloNome(nome);
				
				cosmeticos.clear();
				cosmeticos.addAll(ce);
				
				cbCosmetico.showPopup();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro no Sistema");
			}
		}
		
	}

	protected void buscarMarca() throws ClassNotFoundException {
		if(cbMarca.getEditor().getItem() != null && cbMarca.getEditor().getItem().toString().length() >= 3) {
			MarcaDao dao = new MarcaDao();
			List<Marca> me = new ArrayList<>();
			
			try {
				String nome = cbMarca.getEditor().getItem().toString();
				me = dao.buscaMarcaPeloNome(nome);
				
				marcas.clear();
				marcas.addAll(me);
				
				cbMarca.showPopup();
			}catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro no Sistema");
			}
		}
		
	}

	protected void cadastrarMarca() throws ClassNotFoundException, SQLException {
		Marca m = new Marca();
		MarcaDao dao = new MarcaDao();
		m.setNome(txtNome.getText());
		m.setSegmento(txtSeguemento.getText());
		
		dao.addMarca(m);
		
	}
}

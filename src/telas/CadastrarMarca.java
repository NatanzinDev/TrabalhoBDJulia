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
		setBounds(100, 100, 611, 436);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		panel.setBounds(109, 58, 339, 287);
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
	}

	

	protected void cadastrarMarca() throws ClassNotFoundException, SQLException {
		Marca m = new Marca();
		MarcaDao dao = new MarcaDao();
		m.setNome(txtNome.getText());
		m.setSegmento(txtSeguemento.getText());
		
		dao.addMarca(m);
		
	}
}

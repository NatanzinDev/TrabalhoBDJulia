package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import banco.MarcaDao;
import dominio.Marca;


public class BuscarMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtSeguemento;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarMarca frame = new BuscarMarca();
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
	public BuscarMarca() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(BuscarMarca.class.getResource("/imagens/cosmeticos.jpg")));
		setTitle("Buscar Marca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 617, 386);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		panel.setBounds(32, 38, 256, 257);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BUSCAR MARCA");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(22, 10, 184, 25);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 45, 75, 25);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(135, 50, 96, 19);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		txtSeguemento = new JTextField();
		txtSeguemento.setColumns(10);
		txtSeguemento.setBounds(135, 131, 96, 19);
		panel.add(txtSeguemento);
		
		JLabel lblNewLabel_1_1 = new JLabel("Seguemento:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(10, 126, 106, 25);
		panel.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Buscar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					buscarMarca();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(71, 197, 85, 21);
		panel.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 255, 64));
		panel_1.setBounds(327, 38, 241, 257);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(26, 53, 185, 194);
		panel_1.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nome da Marca", "Seguemento"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblResultados = new JLabel("RESULTADOS");
		lblResultados.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultados.setForeground(Color.WHITE);
		lblResultados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblResultados.setBounds(27, 10, 184, 25);
		panel_1.add(lblResultados);
	}

	protected void buscarMarca() throws ClassNotFoundException, SQLException {
		if((txtNome.getText() == null || txtNome.getText().isEmpty()) && (txtSeguemento.getText() == null || txtSeguemento.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Algum campo precisa está preenchido para buscar.");
			return;
		}
		
		MarcaDao dao = new MarcaDao();
		List<Marca> encontrados = new ArrayList<>();
		
		encontrados = dao.buscarMarca(txtNome.getText(), txtSeguemento.getText());
		
		DefaultTableModel modelo = new DefaultTableModel(new String[] {  "Nome ", "Seguemento" }, 0);
		
		for (int i = 0; i < encontrados.size(); i++) {
			Marca m = encontrados.get(i);
			

			modelo.addRow(new String[] { m.getNome(), m.getSegmento() ,});
		}

		table.setModel(modelo);
		
	}
}

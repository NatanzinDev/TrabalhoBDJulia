package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class CadastrarMarca extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

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
		
		textField = new JTextField();
		textField.setBounds(153, 62, 96, 19);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(153, 130, 96, 19);
		panel.add(textField_1);
		
		JButton btCadastrarMarca = new JButton("Cadastrar");
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
		
		JComboBox cbMarca = new JComboBox();
		cbMarca.setBounds(49, 112, 284, 21);
		panel_1.add(cbMarca);
		
		JLabel lblNewLabel_2_2 = new JLabel("Marca:");
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2.setBounds(147, 82, 75, 20);
		panel_1.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Cosmético:");
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2_2_1.setBounds(147, 143, 92, 20);
		panel_1.add(lblNewLabel_2_2_1);
		
		JComboBox cbCosmetico = new JComboBox();
		cbCosmetico.setBounds(49, 173, 284, 21);
		panel_1.add(cbCosmetico);
		
		JButton btCadastrarMarcaNoCosmetico = new JButton("Cadastrar");
		btCadastrarMarcaNoCosmetico.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btCadastrarMarcaNoCosmetico.setBounds(130, 223, 109, 21);
		panel_1.add(btCadastrarMarcaNoCosmetico);
	}
}

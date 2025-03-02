package telas;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import banco.UsuarioDao;
import dominio.Usuario;
import utils.CriptografiaUtils;

public class Login extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 647, 432);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 64));
		panel.setBounds(26, 30, 583, 335);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("FAÇA SEU LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(120, 22, 315, 36);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(28, 92, 90, 27);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Senha:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(28, 176, 90, 27);
		panel.add(lblNewLabel_1_1);

		txtEmail = new JTextField();
		txtEmail.setBounds(143, 95, 301, 25);
		panel.add(txtEmail);
		txtEmail.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(143, 182, 301, 25);
		panel.add(passwordField);

		JButton btnNewButton = new JButton("Entrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					entrar();
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(217, 249, 162, 21);
		panel.add(btnNewButton);
	}

	protected void entrar() throws ClassNotFoundException, SQLException {
		String email = txtEmail.getText();
		String senha = new String(passwordField.getPassword());
		String senhaCriptografada = CriptografiaUtils.criptografarMD5(senha);

		UsuarioDao dao = new UsuarioDao();

		Usuario u = dao.encontrarUsuarioPorEmailESenha(email, senhaCriptografada);

		if (u == null) {

			JOptionPane.showMessageDialog(null, "Não foi encontrado usuários");
		} else {

			Principal ba = new Principal();
			ba.setLocationRelativeTo(null);
			ba.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			ba.setVisible(true);

		}
	}

}

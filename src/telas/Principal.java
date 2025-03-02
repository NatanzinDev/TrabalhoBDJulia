package telas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
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
	public Principal() {
		setTitle("Página Principal");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/imagens/cosmeticos.jpg")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 499, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btCadastrarCosmetico = new JButton("Cadastrar Cosmético");
		btCadastrarCosmetico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btCadastrarCosmetico.setForeground(new Color(0, 255, 64));
		btCadastrarCosmetico.setBackground(new Color(255, 255, 255));
		btCadastrarCosmetico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCadastrarCosmetico.setBounds(50, 87, 174, 47);
		contentPane.add(btCadastrarCosmetico);
		
		JButton btCadastrarMarca = new JButton("Cadastrar Marcar");
		btCadastrarMarca.setForeground(new Color(0, 255, 64));
		btCadastrarMarca.setBackground(new Color(255, 255, 255));
		btCadastrarMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btCadastrarMarca.setBounds(50, 192, 174, 47);
		contentPane.add(btCadastrarMarca);
		
		JButton btBuscarCosmetico = new JButton("BuscarCosmetico");
		btBuscarCosmetico.setForeground(new Color(0, 255, 64));
		btBuscarCosmetico.setBackground(new Color(255, 255, 255));
		btBuscarCosmetico.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btBuscarCosmetico.setBounds(281, 87, 174, 47);
		contentPane.add(btBuscarCosmetico);
		
		JButton btBuscarMarca = new JButton("BuscarMarca");
		btBuscarMarca.setForeground(new Color(0, 255, 64));
		btBuscarMarca.setBackground(new Color(255, 255, 255));
		btBuscarMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btBuscarMarca.setBounds(281, 192, 174, 47);
		contentPane.add(btBuscarMarca);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/imagens/cosmeticos2.jpg")));
		lblNewLabel.setBounds(-61, 0, 560, 410);
		contentPane.add(lblNewLabel);
		
		
	}
}

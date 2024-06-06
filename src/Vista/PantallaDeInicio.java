package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PantallaDeInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaDeInicio frame = new PantallaDeInicio();
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
	public PantallaDeInicio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 661, 580);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bienvenido = new JLabel("Bienvenido a TravelEasy");
		bienvenido.setBounds(54, 60, 534, 37);
		bienvenido.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 35));
		bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenido.setForeground(new Color(0, 0, 0));
		contentPane.add(bienvenido);
		
		textField = new JTextField();
		textField.setBounds(202, 184, 211, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 156, 10, 0);
		contentPane.add(panel);
		
		JLabel usuarioIngreso = new JLabel("Usuario");
		usuarioIngreso.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 18));
		usuarioIngreso.setBounds(202, 146, 81, 26);
		contentPane.add(usuarioIngreso);
		
		JLabel contrasena_1 = new JLabel("Contraseña ");
		contrasena_1.setFont(new Font("Candara Light", Font.BOLD, 18));
		contrasena_1.setBounds(202, 273, 161, 26);
		contentPane.add(contrasena_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(202, 307, 211, 42);
		contentPane.add(passwordField);
		
		JLabel p_inicio_error = new JLabel("Error, intente otra vez");
		p_inicio_error.setForeground(new Color(255, 0, 0));
		p_inicio_error.setFont(new Font("Candara Light", Font.BOLD, 12));
		p_inicio_error.setBounds(202, 231, 211, 16);
		contentPane.add(p_inicio_error);
		p_inicio_error.setVisible(false);
		
		JLabel p_inicio_error_2 = new JLabel("Error, intente otra vez");
		p_inicio_error_2.setForeground(Color.RED);
		p_inicio_error_2.setFont(new Font("Candara Light", Font.BOLD, 12));
		p_inicio_error_2.setBounds(202, 356, 211, 16);
		contentPane.add(p_inicio_error_2);
		p_inicio_error_2.setVisible(false);
		
		
		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.setBounds(240, 384, 123, 26);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag= true;
				//USUARIO
				if(textField.getText().isEmpty()) {
					p_inicio_error.setVisible(true);
					flag=false;
				}else {
					p_inicio_error.setVisible(false);
					
				}
				// CONTRASENA
				if(passwordField.getText().isEmpty()) {
					p_inicio_error_2.setVisible(true);	
					flag=false;
				}else {
					p_inicio_error_2.setVisible(false);
					
				}
				
				if(flag){
					Pantalla_2 nueva = new Pantalla_2();
					
							
				}
				
				
			}
		});
		contentPane.add(btnNewButton);
		

	}
}

package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
import javax.swing.JTable;

public class PantallaDeInicio extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Email_IngresoINPUT;
	private JPasswordField ContrasenaINPUT;
	private JTextField nombreUsuarioINPUT;

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
		setBounds(100, 100, 509, 602);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(238, 238, 238));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bienvenido = new JLabel("Bienvenido a TravelEasy");
		bienvenido.setBounds(-12, 49, 534, 37);
		bienvenido.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 35));
		bienvenido.setHorizontalAlignment(SwingConstants.CENTER);
		bienvenido.setForeground(new Color(0, 0, 0));
		contentPane.add(bienvenido);
		
		Email_IngresoINPUT = new JTextField();
		Email_IngresoINPUT.setBounds(129, 270, 246, 42);
		contentPane.add(Email_IngresoINPUT);
		Email_IngresoINPUT.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 156, 10, 0);
		contentPane.add(panel);
		
		JLabel usuarioIngreso = new JLabel("Nombre usuario");
		usuarioIngreso.setBounds(129, 128, 174, 26);
		usuarioIngreso.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(usuarioIngreso);
		
		//Peticion de mail
		JLabel email_Ingreso = new JLabel("Email");
		email_Ingreso.setBounds(128, 249, 161, 26);
		email_Ingreso.setFont(new Font("Candara Light", Font.BOLD, 18));
		contentPane.add(email_Ingreso);
	
		// notificacion de error
		JLabel nombre_input_error = new JLabel("Error, ingrese nombre valido");
		nombre_input_error.setBounds(129, 203, 211, 16);
		nombre_input_error.setForeground(new Color(255, 0, 0));
		nombre_input_error.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(nombre_input_error);
		nombre_input_error.setVisible(false);
		
		JLabel email_Input_error = new JLabel("Error, intente otra vez email invalido");
		email_Input_error.setBounds(129, 319, 211, 16);
		email_Input_error.setForeground(Color.RED);
		email_Input_error.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(email_Input_error);
		email_Input_error.setVisible(false);
		
		JLabel usuarioIngreso_1 = new JLabel("Contraseña ");
		usuarioIngreso_1.setBounds(129, 359, 120, 26);
		usuarioIngreso_1.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(usuarioIngreso_1);
		
		ContrasenaINPUT = new JPasswordField();
		ContrasenaINPUT.setBounds(129, 383, 246, 42);
		contentPane.add(ContrasenaINPUT);
		
		JLabel contrasena_Input_error = new JLabel("Error ingrese una contraseña valida");
		contrasena_Input_error.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 13));
		contrasena_Input_error.setForeground(new Color(255, 0, 0));
		contrasena_Input_error.setBounds(129, 426, 232, 16);
		contentPane.add(contrasena_Input_error);
		contrasena_Input_error.setVisible(false);
		
		
		nombreUsuarioINPUT = new JTextField();
		nombreUsuarioINPUT.setColumns(10);
		nombreUsuarioINPUT.setBounds(129, 156, 246, 42);
		contentPane.add(nombreUsuarioINPUT);
		
		
		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.setBounds(176, 496, 140, 37);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean flag= true;
				//USUARIO
				
				Usuario.Ingresar(nombreUsuarioINPUT.getText(),Email_IngresoINPUT.getText(),Integer.parseInt(ContrasenaINPUT.getText()));
				
				//NOMBRE
				if(nombreUsuarioINPUT.getText().isEmpty()) {
					nombre_input_error.setVisible(true);
					flag=false;
				}else {
					nombre_input_error.setVisible(false);
					
				}
				
				// EMAIL
				if(Email_IngresoINPUT.getText().isEmpty()) {
					email_Input_error.setVisible(true);
					flag=false;
				}else {
					email_Input_error.setVisible(false);
					
				}
				
				// CONTRASENA
				if(ContrasenaINPUT.getText().isEmpty()) {
					contrasena_Input_error.setVisible(true);	
					flag=false;
				}else {
					contrasena_Input_error.setVisible(false);
					
				}
				
				if(flag){
					Pantalla_2 nueva = new Pantalla_2();
					dispose();
				}else {
					
					JOptionPane.showMessageDialog(null, "Error, intente otra vez");
					
					
				}
						
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		
		

	}
}

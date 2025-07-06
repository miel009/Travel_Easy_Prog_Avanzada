package Vista;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controlador.UsuarioControlador;
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
		Email_IngresoINPUT.setBounds(121, 142, 246, 42);
		contentPane.add(Email_IngresoINPUT);
		Email_IngresoINPUT.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(202, 156, 10, 0);
		contentPane.add(panel);
		
		
		JLabel email_Ingreso = new JLabel("Email");
		email_Ingreso.setBounds(121, 115, 161, 26);
		email_Ingreso.setFont(new Font("Candara Light", Font.BOLD, 18));
		contentPane.add(email_Ingreso);
	
		
		
		JLabel email_Input_error = new JLabel("Error, intente otra vez email invalido");
		email_Input_error.setBounds(121, 194, 211, 16);
		email_Input_error.setForeground(Color.RED);
		email_Input_error.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 13));
		contentPane.add(email_Input_error);
		email_Input_error.setVisible(false);
		
		JLabel usuarioIngreso_1 = new JLabel("Contraseña");
		usuarioIngreso_1.setBounds(121, 237, 120, 26);
		usuarioIngreso_1.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 18));
		contentPane.add(usuarioIngreso_1);
		
		ContrasenaINPUT = new JPasswordField();
		ContrasenaINPUT.setBounds(121, 269, 246, 42);
		contentPane.add(ContrasenaINPUT);
		
		JLabel contrasena_Input_error = new JLabel("Error ingrese una contraseña valida");
		contrasena_Input_error.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 13));
		contrasena_Input_error.setForeground(new Color(255, 0, 0));
		contrasena_Input_error.setBounds(121, 322, 232, 16);
		contentPane.add(contrasena_Input_error);
		contrasena_Input_error.setVisible(false);
		


		JLabel lblError = new JLabel("");
		lblError.setBounds(88, 98, 333, 18);
		contentPane.add(lblError);
		
		JButton btnNewButton = new JButton("INICIAR");
		btnNewButton.setBounds(177, 371, 140, 37);
		btnNewButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        boolean flag = true;

		        String email = Email_IngresoINPUT.getText();
		        String contrasena = ContrasenaINPUT.getText();

		        // EMAIL
		        if (email.isEmpty()) {
		            email_Input_error.setVisible(true);
		            flag = false;
		        } else {
		            email_Input_error.setVisible(false);
		        }

		        // CONTRASEÑA
		        if (contrasena.isEmpty()) {
		            contrasena_Input_error.setVisible(true);
		            flag = false;
		        } else {
		            contrasena_Input_error.setVisible(false);
		        }

		        if (flag) {
		            String respuesta = Usuario.Ingresar(email, contrasena);
		            if (respuesta.equals("Ingreso con exito!")) {
		                Pantalla_2 nueva = new Pantalla_2();
		                nueva.setVisible(true);
		                dispose();
		            } else {
		                lblError.setText(respuesta);
		                lblError.setVisible(true);
		                JOptionPane.showMessageDialog(null, "Error, intente otra vez");
		            }
		        }
		    }
		});

		
		contentPane.add(btnNewButton);
		
		
		

	}
}

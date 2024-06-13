package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pantalla_2 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Pantalla_2() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bienvenido al sistema de gestion");
		lblNewLabel.setBounds(39, 12, 559, 41);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 34));
		contentPane.add(lblNewLabel);
		
		JButton boton_Destinos = new JButton("Destinos");
		boton_Destinos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		boton_Destinos.setBounds(238, 124, 140, 41);
		contentPane.add(boton_Destinos);
		
		JButton Boton_Paquete = new JButton("Paquetes");
		Boton_Paquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		Boton_Paquete.setBounds(238, 195, 140, 41);
		contentPane.add(Boton_Paquete);
		
		JLabel opciones_para_tabla = new JLabel("Elija una opcion:");
		opciones_para_tabla.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 18));
		opciones_para_tabla.setBounds(238, 87, 209, 26);
		contentPane.add(opciones_para_tabla);
	}
}

package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JTabbedPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.CardLayout;
import javax.swing.JToolBar;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.CompoundBorder;
import javax.swing.JSeparator;

public class Tablas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;

	private JTable table_destino;

	
	



	/**
	 * Create the frame.
	 */
	public Tablas() {
		this.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 492);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		table_destino = new JTable();
		table_destino.setBounds(36, 78, 846, 43);
		contentPane.add(table_destino);
		
		JLabel Destino_Titulo = new JLabel("Destinos");
		Destino_Titulo.setFont(new Font("Candara Light", Font.BOLD | Font.ITALIC, 14));
		Destino_Titulo.setToolTipText("");
		Destino_Titulo.setBounds(39, 22, 172, 36);
		contentPane.add(Destino_Titulo);

		

		    
	
		
		

	}
}

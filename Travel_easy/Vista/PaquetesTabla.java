package Vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.util.List;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import Controlador.PaqueteControlador;
import Modelo.Destino;
import Modelo.Paquete;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaquetesTabla extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private PaqueteControlador controlador;
    private JLabel imagenLabel;
    private Paquete seleccionado;
 
    private JTextField filtrar;

    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	PaquetesTabla frame = new PaquetesTabla();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    
    public PaquetesTabla() {
    	 // Inicializar controlador y producto seleccionado
        
        controlador = new PaqueteControlador();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1166, 491);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // atras 
        JButton btnVolver = new JButton("Volver");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pantalla_2 pantalla2 = new Pantalla_2();
                dispose(); // Cierra la ventana actual
            }
        });
        btnVolver.setBounds(955, 346, 128, 30);
        contentPane.add(btnVolver);

        // Crear la tabla y el modelo
        String[] columnNames = {"id_paquete", "nombre" , "Descripcion", "Tipo de turismo","Precio", "id_destino"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        contentPane.setLayout(null);

        // Crear el JScrollPane y agregar la tabla
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 5, 1137, 300);
        contentPane.add(scrollPane);

        // Crear el JLabel para mostrar la imagen
        imagenLabel = new JLabel();
        imagenLabel.setBounds(620, 5, 250, 250);
        contentPane.add(imagenLabel);

        // Configurar el modelo de selección
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        // Agregar un escuchador de selección
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                    	Paquete nuevoP = new Paquete();
                        int id_paquete = (int) table.getValueAt(selectedRow, 0);
                        String nombre = (String) table.getValueAt(selectedRow, 1);
                        String descripcion = (String) table.getValueAt(selectedRow, 2);                                                           
                        String tipo_turismo = (String) table.getValueAt(selectedRow, 3);
                        double precio = (double) table.getValueAt(selectedRow, 4);
                  
                        String nombreDestino = (String) table.getValueAt(selectedRow, 5);
                        Destino destino = controlador.buscarDestinoPorNombre(nombreDestino);
                        
                        
                        seleccionado = controlador.getPaqueteById(id_paquete);
                        
                    }
                }
            }
        });

      
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(580, 346, 120, 30);
        contentPane.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getId_paquete() != 0) {
                    controlador.deletePaquete(seleccionado.getId_paquete());
                    JOptionPane.showMessageDialog(null, "Paquete eliminado");
                    actualizarTabla();
                    imagenLabel.setIcon(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un paquete");
                }
            }
        });

        // Botón para editar el producto seleccionado
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(428, 346, 120, 30);
        contentPane.add(btnEditar);
        
        filtrar = new JTextField();
        filtrar.setBounds(25, 349, 101, 25);
        contentPane.add(filtrar);
        filtrar.setColumns(10);
        
        JLabel lblNewLabel = new JLabel("Criterio");
        lblNewLabel.setBounds(27, 324, 62, 14);
        contentPane.add(lblNewLabel);
        
        JButton btnNewButton = new JButton("Filtrar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		Filtrar(filtrar.getText());
        		
        	}
        });
        
     // Botón para agregar nuevo paquete
        JButton btnNuevo = new JButton("Nuevo");
        btnNuevo.setBounds(288, 346, 120, 30);
        contentPane.add(btnNuevo);
        btnNuevo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EditarPaquete nuevoPaquete = new EditarPaquete(null, controlador, PaquetesTabla.this);
                nuevoPaquete.setVisible(true);
            }
        });
        
        btnNewButton.setBounds(140, 347, 113, 28);
        contentPane.add(btnNewButton);
        btnEditar.addActionListener(new ActionListener() {   
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionado != null && seleccionado.getId_paquete() != 0) {
                   EditarPaquete editarFrame = new EditarPaquete(seleccionado, controlador, PaquetesTabla.this);
                    editarFrame.setVisible(true);
             
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto");
                }
            }
        });
    }
    
    

    
    private void Filtrar(String criterio) {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);

        // Obtener la lista actualizada de productos
        List<Paquete> paquetes = controlador.listarPaquete();

        // Agregar los datos al modelo
        for (Paquete paquete : paquetes) {
        	if(paquete.getNombreP().contains(criterio)) {
                model.addRow(new Object[]{paquete.getId_paquete(), paquete.getNombreP(), paquete.getDescripcion(),
                		paquete.getTipo_turismo(), paquete.getPrecio(), paquete.getDestino()});
        	}
        }
    }

    
    public void actualizarTabla() {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);
        seleccionado = null;

        List<Paquete> paquetes = controlador.listarPaquete();

        for (Paquete paquete : paquetes ) {
            model.addRow(new Object[]{
            		paquete.getId_paquete(),
            		paquete.getNombreP(),
            		paquete.getDescripcion(),
            		paquete.getTipo_turismo(),
            		paquete.getPrecio(),
            		paquete.getDestino().getNombre()
            
            });
        }
    }
    
    
    
    private void mostrarImagen(byte[] imagen) {
        if (imagen != null) {
            ImageIcon icon = new ImageIcon(imagen);
            Image img = icon.getImage();
            Image scaledImg = img.getScaledInstance(imagenLabel.getWidth(), imagenLabel.getHeight(), Image.SCALE_SMOOTH);
            imagenLabel.setIcon(new ImageIcon(scaledImg));
        } else {
            imagenLabel.setIcon(null);
        }
    }
    
    
}
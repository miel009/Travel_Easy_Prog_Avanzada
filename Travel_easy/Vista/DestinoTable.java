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

import Controlador.DestinosControlador;
import Modelo.Destino;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DestinoTable extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    private DefaultTableModel model;
    private DestinosControlador controlador;
    private JLabel imagenLabel;
    private Destino seleccionado;

    private JTextField filtrar;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	DestinoTable frame = new DestinoTable();
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
    public DestinoTable() {



        controlador = new DestinosControlador();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1166, 491);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        // Crear la tabla y el modelo
        String[] columnNames = {"id_destino", "Nombre", "descripcion", "pais","ZonaGeo", "recomendaciones", "temporada_ideal", "rango_edad" ,"transporte", "tipo_turismo", "servicios_requeridos"};
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
                        int id_destino = (int) table.getValueAt(selectedRow, 0);
                        String nombre = (String) table.getValueAt(selectedRow, 1);
                        String descripcion = (String) table.getValueAt(selectedRow, 2);
                        String pais = (String) table.getValueAt(selectedRow, 3);
                        String zonaGeo = (String) table.getValueAt(selectedRow, 4);
                        String recomendaciones = (String) table.getValueAt(selectedRow, 5);
                        String temporada_ideal = (String) table.getValueAt(selectedRow, 6);
                        int rango_edad = (int) table.getValueAt(selectedRow, 7);
                        String transporte = (String) table.getValueAt(selectedRow, 8);
                       // int cantidad = (int) table.getValueAt(selectedRow, 9); // Obtener la cantidad de productos
                        String tipo_turismo = (String) table.getValueAt(selectedRow, 9);
                        String servicios_requeridos = (String) table.getValueAt(selectedRow, 10);
                        seleccionado = controlador.getDestinoById(id_destino);
                        //mostrarImagen(seleccionado.getImagen());
                    }
                }
            }
        });

        // Botón para eliminar el producto seleccionado
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(539, 366, 120, 30);
        contentPane.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionado.getId_destino() != 0) {
                    controlador.deleteDestino(seleccionado.getId_destino());
                    JOptionPane.showMessageDialog(null, "Destino eliminado");
                    actualizarTabla();
                    imagenLabel.setIcon(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un destino");
                }
            }
        });
        // Botón Deshacer Filtros por id
        JButton btnDeshacerFiltros = new JButton("Deshacer Filtros");
        btnDeshacerFiltros.setBounds(372, 406, 120, 30);
        contentPane.add(btnDeshacerFiltros);
        btnDeshacerFiltros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
            }
        });

        // Botón para editar el producto seleccionado
        JButton btnEditar = new JButton("Editar");
        btnEditar.setBounds(669, 366, 120, 30);
        contentPane.add(btnEditar);

        filtrar = new JTextField();
        filtrar.setBounds(266, 369, 96, 25);
        contentPane.add(filtrar);
        filtrar.setColumns(10);

        JLabel lblNewLabel = new JLabel("Criterio");
        lblNewLabel.setBounds(266, 346, 62, 14);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Filtrar");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                FiltroFrame filtroFrame = new FiltroFrame(DestinoTable.this);
                filtroFrame.setVisible(true);

        	}
        });

        btnNewButton.setBounds(372, 366, 120, 30);
        contentPane.add(btnNewButton);

        // Inicializar controlador y producto seleccionado

        // boton atras
        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(798, 366, 120, 30);
        contentPane.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pantalla_2 pantalla2 = new Pantalla_2();
                dispose(); // Cierra la ventana actual
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionado != null && seleccionado.getId_destino() != 0) {
                    EditarDestinoFrame editarFrame = new EditarDestinoFrame(seleccionado, controlador, DestinoTable.this);
                    editarFrame.setVisible(true);

                    // Aquí puedes llamar a tu ventana de edición, pasando el producto seleccionado
                    // new EditarProducto(seleccionado).setVisible(true);
                    JOptionPane.showMessageDialog(null, "Funcionalidad de editar aún no implementada");
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto");
                }
            }
        });
    }

    public void actualizarTabla() {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);

        // Obtener la lista actualizada de productos

        List<Destino> destinos = controlador.listarDestinos();

        // Agregar los datos al modelo
        for (Destino destino : destinos) {
            model.addRow(new Object[]{
            		destino.getId_destino(),
            		destino.getNombre(),
            		destino.getDescripcion(),
            		destino.getPais(),
            		destino.getZonaGeo(),
            		destino.getRecomendaciones(),
            		destino.getTemporada_ideal(),
            		destino.getRango_edad(),
            		destino.getTransporte(),
            		destino.getTipo_turismo(),
            		destino.getServicios_requeridos()
            });
        }
    }
    public void Filtrar(String criterio) {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);

        // Obtener la lista actualizada de productos
        List<Destino> destinos = controlador.listarDestinos();

        // Agregar los datos al modelo
        for (Destino destino : destinos ) {
        	if(destino.getNombre().contains(criterio)) {
                model.addRow(new Object[]{destino.getId_destino(), destino.getNombre(), destino.getDescripcion(),
                destino.getPais(), destino.getZonaGeo() , destino.getRecomendaciones(), destino.getTemporada_ideal(),destino.getRango_edad(),destino.getTransporte(), destino.getTipo_turismo(),destino.getServicios_requeridos()});
        	}
        }
    }
    public void filtrarPorId(Integer id) {
        // Limpiar el modelo de la tabla
        model.setRowCount(0);

        // Obtener la lista actualizada de destinos
        List<Destino> destinos = controlador.listarDestinos();

        // Agregar los datos al modelo
        for (Destino destino : destinos) {
            boolean coincideId = id == null || destino.getId_destino() == id;

            if (coincideId) {
                model.addRow(new Object[]{
                        destino.getId_destino(),
                        destino.getNombre(),
                        destino.getDescripcion(),
                        destino.getPais(),
                        destino.getZonaGeo(),
                        destino.getRecomendaciones(),
                        destino.getTemporada_ideal(),
                        destino.getRango_edad(),
                        destino.getTransporte(),
                        destino.getTipo_turismo(),
                        destino.getServicios_requeridos()
                });
            }
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
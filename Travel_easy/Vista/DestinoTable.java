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

   
    public DestinoTable() {


        controlador = new DestinosControlador();
        this.setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1166, 491);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        String[] columnNames = {"id_destino", "Nombre", "descripcion", "pais","ZonaGeo", "recomendaciones", "temporada_ideal", "rango_edad" ,"transporte", "tipo_turismo"};
        model = new DefaultTableModel(columnNames, 0);
        table = new JTable(model);
        actualizarTabla();
        contentPane.setLayout(null);

        
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(5, 5, 1137, 300);
        contentPane.add(scrollPane);

        
        imagenLabel = new JLabel();
        imagenLabel.setBounds(620, 5, 250, 250);
        contentPane.add(imagenLabel);

        
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        
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
                        String tipo_turismo = (String) table.getValueAt(selectedRow, 9);
                        seleccionado = controlador.getDestinoById(id_destino);
                        //mostrarImagen(seleccionado.getImagen());
                    }
                }
            }
        });

        
        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(539, 366, 120, 30);
        contentPane.add(btnEliminar);
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if (seleccionado != null && seleccionado.getId_destino() != 0) {
                    controlador.deleteDestino(seleccionado.getId_destino());
                    JOptionPane.showMessageDialog(null, "Destino eliminado");
                    actualizarTabla();
                    imagenLabel.setIcon(null);
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un destino");
                }
            }
        });
        
        JButton btnDeshacerFiltros = new JButton("Deshacer Filtros");
        btnDeshacerFiltros.setBounds(372, 406, 120, 30);
        contentPane.add(btnDeshacerFiltros);
        btnDeshacerFiltros.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTabla();
            }
        });

       
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

        JButton btnVolver = new JButton("Volver");
        btnVolver.setBounds(798, 366, 120, 30);
        contentPane.add(btnVolver);
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Pantalla_2 pantalla2 = new Pantalla_2();
                dispose(); 
            }
        });
        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (seleccionado != null && seleccionado.getId_destino() != 0) {
                    EditarDestinoFrame editarFrame = new EditarDestinoFrame(seleccionado, controlador, DestinoTable.this);
                    editarFrame.setVisible(true);                
                } else {
                    JOptionPane.showMessageDialog(null, "Seleccione un producto");
                }
            }
        });
    }

    public void actualizarTabla() {
     
        model.setRowCount(0);
        seleccionado = null;

        List<Destino> destinos = controlador.listarDestinos();

        
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
            });
        }
    }
    public void Filtrar(String criterio) {
        
        model.setRowCount(0);

        
        List<Destino> destinos = controlador.listarDestinos();

        
        for (Destino destino : destinos ) {
        	if(destino.getNombre().contains(criterio)) {
                model.addRow(new Object[]{destino.getId_destino(), destino.getNombre(), destino.getDescripcion(),
                destino.getPais(), destino.getZonaGeo() , destino.getRecomendaciones(), destino.getTemporada_ideal(),destino.getRango_edad(),destino.getTransporte(), destino.getTipo_turismo()});
        	}
        }
    }
    public void filtrarPorId(Integer id) {
        
        model.setRowCount(0);

       
        List<Destino> destinos = controlador.listarDestinos();

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
                        
                });
            }
        }
        
        JButton btnAgregar = new JButton("Agregar");
        btnAgregar.setBounds(409, 326, 120, 30);
        contentPane.add(btnAgregar);

        btnAgregar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AgregarDestinoFrame agregarFrame = new AgregarDestinoFrame(DestinoTable.this, controlador);
                agregarFrame.setVisible(true);
            }
        });

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
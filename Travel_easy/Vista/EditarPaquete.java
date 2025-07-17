package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.PaqueteControlador;
import Modelo.Paquete;
import java.util.List;

public class EditarPaquete extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombrePField;
    private JTextField descripcionField;
    private JTextField tipo_turismoField;
    private JTextField  precioField;
    private JComboBox<String> destinoCombo;
    private PaquetesTabla tabla;
   

 
    private Paquete paquete;
    private PaqueteControlador controlador;
    

    public EditarPaquete(Paquete paquete, PaqueteControlador controlador, PaquetesTabla tabla) {
    	this.paquete = (paquete == null) ? new Paquete() : paquete;
        this.controlador = controlador;
        this.tabla=tabla;
        

        setTitle("Editar Paquete");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(11, 2, 5, 5));


        contentPane.add(new JLabel("Nombre:"));
        nombrePField = new JTextField(this.paquete.getNombreP() != null ? this.paquete.getNombreP() : "");
        contentPane.add(nombrePField);

        contentPane.add(new JLabel("Descripción:"));
        descripcionField = new JTextField(this.paquete.getDescripcion() != null ? this.paquete.getDescripcion() : "");
        contentPane.add(descripcionField);

        contentPane.add(new JLabel("Tipo de turismo:"));
        tipo_turismoField = new JTextField(this.paquete.getTipo_turismo() != null ? this.paquete.getTipo_turismo() : "");
        contentPane.add(tipo_turismoField);

        contentPane.add(new JLabel("Precio:"));
        precioField = new JTextField(String.valueOf(this.paquete.getPrecio())); 
        contentPane.add(precioField);


        contentPane.add(new JLabel("Destino:"));
        destinoCombo = new JComboBox<>();
        cargarDestinosEnCombo();
        if (this.paquete.getDestino() != null) {
            destinoCombo.setSelectedItem(this.paquete.getDestino().getNombre());
        }
        contentPane.add(destinoCombo);


        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
                dispose();

            }
        });
        contentPane.add(btnGuardar);
    }
    private void cargarDestinosEnCombo() {
        List<String> destinos = controlador.getNombresDestinos();
        for (String nombre : destinos) {
            destinoCombo.addItem(nombre);
        }
    }
    



    private void guardarCambios() {
        try {
            String nombre = nombrePField.getText();
            String descripcion = descripcionField.getText();
            String tipoTurismo = tipo_turismoField.getText();
            double precio = Double.parseDouble(precioField.getText());
            String destinoNombre = (String) destinoCombo.getSelectedItem();

            paquete.setNombreP(nombre);
            paquete.setDescripcion(descripcion);
            paquete.setTipo_turismo(tipoTurismo);
            paquete.setPrecio(precio);

            // Este es el fix del destino:
            paquete.setDestino(controlador.buscarDestinoPorNombre(destinoNombre));

            if (paquete.getId_paquete() == 0) {
                controlador.addPaquete(paquete); // <-- INSERT
                JOptionPane.showMessageDialog(this, "Paquete agregado correctamente");
            } else {
                controlador.updatePaquete(paquete); // <-- UPDATE
                JOptionPane.showMessageDialog(this, "Paquete actualizado correctamente");
            }

            tabla.actualizarTabla();
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

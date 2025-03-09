package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.PaqueteControlador;
import Modelo.Paquete;

public class EditarPaquete extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombrePField;
    private JTextField descripcionField;
    private JTextField tipo_turismoField;
    private JTextField  precioField;
 
    private Paquete paquete;
    private PaqueteControlador controlador;

    public EditarPaquete(Paquete paquete, PaqueteControlador controlador) {
        this.paquete = paquete;
        this.controlador = controlador;

        setTitle("Editar Paquete");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(11, 2, 5, 5));

        contentPane.add(new JLabel("Nombre:"));
        nombrePField = new JTextField(paquete.getNombreP());
        contentPane.add(nombrePField);

        contentPane.add(new JLabel("Descripción:"));
        descripcionField = new JTextField(paquete.getDescripcion());
        contentPane.add(descripcionField);

        contentPane.add(new JLabel("Tipo de turismo:"));
        tipo_turismoField = new JTextField(paquete.getTipo_turismo());
        contentPane.add(tipo_turismoField);

        contentPane.add(new JLabel("Precio:"));
        precioField = new JTextField(String.valueOf(paquete.getPrecio())); // Añadido el campo de texto para el precio
        contentPane.add(precioField);



        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
                PaquetesTabla paqueteTabla = new PaquetesTabla();
                paqueteTabla.actualizarTabla();

            }
        });
        contentPane.add(btnGuardar);
    }

    private void guardarCambios() {

        try {
            String nombre = nombrePField.getText();
            String descripcion = descripcionField.getText();
            String tipoTurismo = tipo_turismoField.getText();
            double precio = Double.parseDouble(precioField.getText()); // Conversión de texto a double

            paquete.setNombreP(nombre);
            paquete.setDescripcion(descripcion);
            paquete.setTipo_turismo(tipoTurismo);
            paquete.setPrecio(precio);

            controlador.updatePaquete(paquete);
            JOptionPane.showMessageDialog(this, "Paquete actualizado correctamente");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un valor numérico válido para el precio.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import Controlador.ReservaControlador;
import Modelo.Paquete;
import Modelo.Reserva;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ReservaForm extends JFrame {
    private JTextField nombreField;
    private JTextField apellidoField;
    private JTextField cantidadField;

    private Paquete paqueteSeleccionado;
    private ReservaControlador controlador;

    public ReservaForm(Paquete paquete, ReservaControlador controlador) {
        this.paqueteSeleccionado = paquete;
        this.controlador = controlador;

        setTitle("Realizar Reserva para: " + paquete.getNombreP());
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 400, 250);
        JPanel contentPane = new JPanel(new GridLayout(5, 2, 10, 10));
        contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);

        contentPane.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        contentPane.add(nombreField);

        contentPane.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        contentPane.add(apellidoField);

        contentPane.add(new JLabel("Cantidad de personas:"));
        cantidadField = new JTextField();
        contentPane.add(cantidadField);

        JButton btnReservar = new JButton("Confirmar Reserva");
        btnReservar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarReserva();
            }
        });
        contentPane.add(new JLabel()); // espaciador
        contentPane.add(btnReservar);
    }

    private void guardarReserva() {
        try {
            String nombre = nombreField.getText().trim();
            String apellido = apellidoField.getText().trim();
            int cantidad = Integer.parseInt(cantidadField.getText());

            if (nombre.isEmpty() || apellido.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Reserva reserva = new Reserva();
            reserva.setNombre(nombre);
            reserva.setApellido(apellido);
            reserva.setCantidadPersonas(cantidad);
            reserva.setPaquete(paqueteSeleccionado);

            controlador.insertarReserva(reserva); 

            JOptionPane.showMessageDialog(this, "Reserva confirmada para " + nombre + " " + apellido + "!");
            dispose();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "La cantidad debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar la reserva: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}

package Vista;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Controlador.DestinosControlador;
import Modelo.Destino;

public class AgregarDestinoFrame extends JFrame {

    private JTextField nombreField, descripcionField, paisField, zonaGeoField, recomendacionesField, temporadaField, rangoEdadField, transporteField, tipoTurismoField;
    private DestinosControlador controlador;
    private DestinoTable destinoTable;

    public AgregarDestinoFrame(DestinoTable destinoTable, DestinosControlador controlador) {
        this.controlador = controlador;
        this.destinoTable = destinoTable;

        setTitle("Agregar Destino");
        setSize(400, 500);
        setLayout(null);
        setLocationRelativeTo(null);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(20, 20, 100, 25);
        add(lblNombre);
        nombreField = new JTextField();
        nombreField.setBounds(130, 20, 200, 25);
        add(nombreField);

        JLabel lblDescripcion = new JLabel("Descripción:");
        lblDescripcion.setBounds(20, 60, 100, 25);
        add(lblDescripcion);
        descripcionField = new JTextField();
        descripcionField.setBounds(130, 60, 200, 25);
        add(descripcionField);

        JLabel lblPais = new JLabel("País:");
        lblPais.setBounds(20, 100, 100, 25);
        add(lblPais);
        paisField = new JTextField();
        paisField.setBounds(130, 100, 200, 25);
        add(paisField);

        JLabel lblZona = new JLabel("Zona:");
        lblZona.setBounds(20, 140, 100, 25);
        add(lblZona);
        zonaGeoField = new JTextField();
        zonaGeoField.setBounds(130, 140, 200, 25);
        add(zonaGeoField);

        JLabel lblRecomendaciones = new JLabel("Recomendaciones:");
        lblRecomendaciones.setBounds(20, 180, 120, 25);
        add(lblRecomendaciones);
        recomendacionesField = new JTextField();
        recomendacionesField.setBounds(150, 180, 180, 25);
        add(recomendacionesField);

        JLabel lblTemporada = new JLabel("Temporada ideal:");
        lblTemporada.setBounds(20, 220, 120, 25);
        add(lblTemporada);
        temporadaField = new JTextField();
        temporadaField.setBounds(150, 220, 180, 25);
        add(temporadaField);

        JLabel lblEdad = new JLabel("Rango edad:");
        lblEdad.setBounds(20, 260, 100, 25);
        add(lblEdad);
        rangoEdadField = new JTextField();
        rangoEdadField.setBounds(130, 260, 200, 25);
        add(rangoEdadField);

        JLabel lblTransporte = new JLabel("Transporte:");
        lblTransporte.setBounds(20, 300, 100, 25);
        add(lblTransporte);
        transporteField = new JTextField();
        transporteField.setBounds(130, 300, 200, 25);
        add(transporteField);

        JLabel lblTurismo = new JLabel("Tipo turismo:");
        lblTurismo.setBounds(20, 340, 100, 25);
        add(lblTurismo);
        tipoTurismoField = new JTextField();
        tipoTurismoField.setBounds(130, 340, 200, 25);
        add(tipoTurismoField);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(130, 400, 100, 30);
        add(btnGuardar);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String nombre = nombreField.getText();
                    String descripcion = descripcionField.getText();
                    String pais = paisField.getText();
                    String zonaGeo = zonaGeoField.getText();
                    String recomendaciones = recomendacionesField.getText();
                    String temporada = temporadaField.getText();
                    int rangoEdad = Integer.parseInt(rangoEdadField.getText());
                    String transporte = transporteField.getText();
                    String tipoTurismo = tipoTurismoField.getText();

                    Destino destino = new Destino(nombre, descripcion, pais, zonaGeo, recomendaciones, temporada, rangoEdad, transporte, tipoTurismo);

                    boolean result = controlador.addDestino(destino);
                    if (result) {
                        JOptionPane.showMessageDialog(null, "Destino agregado con éxito");
                        destinoTable.actualizarTabla();
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al agregar destino");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido para el rango de edad");
                }
            }
        });
    }
}

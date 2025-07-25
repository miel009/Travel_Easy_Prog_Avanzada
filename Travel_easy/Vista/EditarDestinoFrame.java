package Vista;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Controlador.DestinosControlador;
import Modelo.Destino;

public class EditarDestinoFrame extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nombreField;
    private JTextField descripcionField;
    private JTextField paisField;
    private JTextField zonaGeoField;
    private JTextField recomendacionesField;
    private JTextField temporadaIdealField;
    private JTextField rangoEdadField;
    private JTextField transporteField;
    private JTextField tipoTurismoField;
    private Destino destino;
    private DestinosControlador controlador;
    private DestinoTable destinoTable;

    public EditarDestinoFrame(Destino destino, DestinosControlador controlador , DestinoTable destinoTable) {
        this.destino = destino;
        this.controlador = controlador;
        this.destinoTable = destinoTable;

        setTitle("Editar Destino");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 508, 505);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(11, 2, 5, 5));

        contentPane.add(new JLabel("Nombre:"));
        nombreField = new JTextField(destino.getNombre());
        contentPane.add(nombreField);

        contentPane.add(new JLabel("Descripción:"));
        descripcionField = new JTextField(destino.getDescripcion());
        contentPane.add(descripcionField);

        contentPane.add(new JLabel("País:"));
        paisField = new JTextField(destino.getPais());
        contentPane.add(paisField);

        contentPane.add(new JLabel("Zona Geográfica:"));
        zonaGeoField = new JTextField(destino.getZonaGeo());
        contentPane.add(zonaGeoField);

        contentPane.add(new JLabel("Recomendaciones:"));
        recomendacionesField = new JTextField(destino.getRecomendaciones());
        contentPane.add(recomendacionesField);

        contentPane.add(new JLabel("Temporada Ideal:"));
        temporadaIdealField = new JTextField(destino.getTemporada_ideal());
        contentPane.add(temporadaIdealField);

        contentPane.add(new JLabel("Rango de Edad:"));
        rangoEdadField = new JTextField(String.valueOf(destino.getRango_edad()));
        contentPane.add(rangoEdadField);

        contentPane.add(new JLabel("Transporte:"));
        transporteField = new JTextField(destino.getTransporte());
        contentPane.add(transporteField);

        contentPane.add(new JLabel("Tipo de Turismo:"));
        tipoTurismoField = new JTextField(destino.getTipo_turismo());
        contentPane.add(tipoTurismoField);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarCambios();
            }
        });
        contentPane.add(btnGuardar);
    }

    private void guardarCambios() {
        destino.setNombre(nombreField.getText());
        destino.setDescripcion(descripcionField.getText());
        destino.setPais(paisField.getText());
        destino.setZonaGeo(zonaGeoField.getText());
        destino.setRecomendaciones(recomendacionesField.getText());
        destino.setTemporada_ideal(temporadaIdealField.getText());
        destino.setRango_edad(Integer.parseInt(rangoEdadField.getText()));
        destino.setTransporte(transporteField.getText());
        destino.setTipo_turismo(tipoTurismoField.getText());
        

        controlador.updateDestino(destino);
        JOptionPane.showMessageDialog(this, "Destino actualizado");
        destinoTable.actualizarTabla();
        dispose();
    }
}

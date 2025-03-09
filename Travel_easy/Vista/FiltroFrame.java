package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FiltroFrame extends JFrame {
    private JTextField idField;
    private DestinoTable destinoTable;

    public FiltroFrame(DestinoTable destinoTable) {
        this.destinoTable = destinoTable;

        setTitle("Filtrar Destinos");
        setBounds(100, 100, 300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(3, 2, 5, 5));

        JLabel lblId = new JLabel("ID:");
        getContentPane().add(lblId);

        idField = new JTextField();
        getContentPane().add(idField);



        JButton btnAplicar = new JButton("Aplicar Filtro");
        btnAplicar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                aplicarFiltro();
            }
        });
        getContentPane().add(btnAplicar);
    }

    private void aplicarFiltro() {
        String idText = idField.getText();

        Integer id = null;
        if (!idText.isEmpty()) {
            try {
                id = Integer.parseInt(idText);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "ID inválido");
                return;
            }
        }

        destinoTable.filtrarPorId(id);
        dispose();
    }
}

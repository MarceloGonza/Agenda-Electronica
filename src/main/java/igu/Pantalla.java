package igu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pantalla extends JFrame {

//variables globales 
    String dnis[] = new String [10];
    String nombres[] = new String [10];
    String apellidos[] = new String [10];
    String direcciones[] = new String [10];
    String telefonos[] = new String [10];
    String fechanac[] = new String [10];

    // campos de texto
    JTextField txtDnis;
    JTextField txtNombres;
    JTextField txtApellidos;
    JTextField txtDirecciones;
    JTextField txtTelefonos;
    JTextField txtFechanac;

    public Pantalla() {
        setTitle("Agenda Electronica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout(10, 10));

        // ======== TITULO ========
        JLabel titulo = new JLabel("Agenda Electronica", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        add(titulo, BorderLayout.NORTH);

        // ======== PANEL CENTRAL ========
        JPanel panelCentral = new JPanel(new GridLayout(1, 2, 40, 0)); // 1 fila, 2 columnas, espacio entre columnas
        panelCentral.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        // Panel izquierdo
        JPanel panelIzquierdo = new JPanel(new GridBagLayout());
        GridBagConstraints gbcIzq = new GridBagConstraints();
        gbcIzq.insets = new Insets(8, 5, 8, 5);
        gbcIzq.fill = GridBagConstraints.HORIZONTAL;

        int fila = 0;
        fila = agregarCampo(panelIzquierdo, gbcIzq, fila, "DNI:");
        fila = agregarCampo(panelIzquierdo, gbcIzq, fila, "Nombre:");
        fila = agregarCampo(panelIzquierdo, gbcIzq, fila, "Apellido:");

        // Panel derecho
        JPanel panelDerecho = new JPanel(new GridBagLayout());
        GridBagConstraints gbcDer = new GridBagConstraints();
        gbcDer.insets = new Insets(8, 5, 8, 5);
        gbcDer.fill = GridBagConstraints.HORIZONTAL;

        fila = 0;
        fila = agregarCampo(panelDerecho, gbcDer, fila, "Direccion:");
        fila = agregarCampo(panelDerecho, gbcDer, fila, "Telefono:");
        fila = agregarCampo(panelDerecho, gbcDer, fila, "F. Nac:");

        // Agregar columnas al panel central
        panelCentral.add(panelIzquierdo);
        panelCentral.add(panelDerecho);

        // ======== PANEL CON SEPARADORES ========
        JPanel panelConSeparadores = new JPanel(new BorderLayout());

        // Separador superior con margen
        JPanel separadorSuperior = new JPanel(new BorderLayout());
        separadorSuperior.setBorder(BorderFactory.createEmptyBorder(25, 0, 10, 0)); 
        separadorSuperior.add(new JSeparator(), BorderLayout.CENTER);

        // Separador inferior con margen
        JPanel separadorInferior = new JPanel(new BorderLayout());
        separadorInferior.setBorder(BorderFactory.createEmptyBorder(10, 0, 25, 0)); 
        separadorInferior.add(new JSeparator(), BorderLayout.CENTER);

        panelConSeparadores.add(separadorSuperior, BorderLayout.NORTH);
        panelConSeparadores.add(panelCentral, BorderLayout.CENTER);
        panelConSeparadores.add(separadorInferior, BorderLayout.SOUTH);

        add(panelConSeparadores, BorderLayout.CENTER);


        // ======== PANEL DE BOTONES ========
        JPanel panelBotones = new JPanel(new GridLayout(1, 3, 20, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JButton btnAtras = new JButton("Atras");
        JButton btnGuardar = new JButton("Guardar");
        JButton btnSiguiente = new JButton("Siguiente");

        panelBotones.add(btnAtras);
        panelBotones.add(btnGuardar);
        panelBotones.add(btnSiguiente);

        // ======== PANEL INFERIOR ========
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelBotones, BorderLayout.NORTH);

        JPanel panelIndice = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JButton btnIndice = new JButton("Indice");
        JButton btnContador = new JButton("1");
        btnContador.setEnabled(false);

        panelIndice.add(btnIndice);
        panelIndice.add(btnContador);
        panelInferior.add(panelIndice, BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);

        setLocationRelativeTo(null);

btnSiguiente.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String indice = btnContador.getText();  
        int indi = Integer.parseInt(indice);

        if(indi < 9){
        indi++; 
        btnContador.setText(String.valueOf(indi));

        txtDnis.setText(dnis[indi]);
        txtNombres.setText(nombres[indi]);
        txtApellidos.setText(apellidos[indi]);
        txtDirecciones.setText(direcciones[indi]);
        txtTelefonos.setText(telefonos[indi]);
        txtFechanac.setText(fechanac[indi]);
        }
    }
});

btnAtras.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        String indice = btnContador.getText();  
        int indi = Integer.parseInt(indice);

        if(indi > 0){
        indi --; 
        btnContador.setText(String.valueOf(indi));
                txtDnis.setText(dnis[indi]);
        txtNombres.setText(nombres[indi]);
        txtApellidos.setText(apellidos[indi]);
        txtDirecciones.setText(direcciones[indi]);
        txtTelefonos.setText(telefonos[indi]);
        txtFechanac.setText(fechanac[indi]);
        }
    }
});

btnGuardar.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        String indice = btnContador.getText();  
        int indi = Integer.parseInt(indice);

        dnis[indi] = txtDnis.getText();
        nombres[indi] = txtNombres.getText();
        apellidos[indi] = txtApellidos.getText();
        direcciones[indi] = txtDirecciones.getText();
        telefonos[indi] = txtTelefonos.getText();
        fechanac[indi] = txtFechanac.getText();
        }
});
    }
    // Método para agregar una fila (label + campo de texto)
    private int agregarCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;
        panel.add(new JLabel(etiqueta), gbc);

        //CAMPO DE TEXTO
        gbc.gridx = 1;
        gbc.weightx = 1;
        JTextField campo = new JTextField();
        campo.setPreferredSize(new Dimension(200, 25)); // ANCHO 200px, ALTO 25px
        panel.add(campo, gbc);

        //ASIGNAR REFERENCIA DEL CAMPO SEGUN ETIQUETA
        if(etiqueta.equals("DNI:")){
            txtDnis = campo;
        } else if(etiqueta.equals("Nombre:")){
            txtNombres = campo;
        } else if(etiqueta.equals("Apellido:")){
            txtApellidos = campo;
        } else if(etiqueta.equals("Direccion:")){
            txtDirecciones = campo;
        } else if(etiqueta.equals("Telefono:")){
            txtTelefonos = campo;
        } else if(etiqueta.equals("F. Nac:")){
            txtFechanac = campo;
        }

        return fila + 1;
    }
}


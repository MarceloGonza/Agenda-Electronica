package igu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Pantalla extends JFrame {

    public Pantalla() {
        setTitle("Agenda Electronica");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 500);
        setLayout(new BorderLayout(10, 10));

        // ======== TITULO ========
        JLabel titulo = new JLabel("Agenda Electronica", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 28));
        add(titulo, BorderLayout.NORTH);

        // ======== PANEL CENTRAL (con 2 columnas) ========
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
        panelBotones.add(new JButton("Atras"));
        panelBotones.add(new JButton("Guardar"));
        panelBotones.add(new JButton("Siguiente"));

        // ======== PANEL INFERIOR ========
        JPanel panelInferior = new JPanel(new BorderLayout());
        panelInferior.add(panelBotones, BorderLayout.NORTH);

        JPanel panelIndice = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelIndice.add(new JLabel("Indice:"));
        JTextField campoIndice = new JTextField("1", 3);
        campoIndice.setHorizontalAlignment(JTextField.CENTER);
        panelIndice.add(campoIndice);

        panelInferior.add(panelIndice, BorderLayout.SOUTH);
        add(panelInferior, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
    }

    // Método para agregar una fila (label + campo de texto)
    private int agregarCampo(JPanel panel, GridBagConstraints gbc, int fila, String etiqueta) {
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;
        panel.add(new JLabel(etiqueta), gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;
        JTextField campo = new JTextField();
        campo.setPreferredSize(new Dimension(200, 25)); // ANCHO 200px, ALTO 25px
        panel.add(campo, gbc);

        return fila + 1;
    }
}


package com.journaldev.maven.maven_test.jar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Gui {
    private JFrame frmBuscadorDeExtensiones;
    private JTextField input;
    private JTextArea output;
    private JButton buscar;

    public static void main(String[] args) {
        try {
            // Establecer el aspecto del sistema operativo
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Gui window = new Gui();
                    window.frmBuscadorDeExtensiones.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Gui() {
        initialize();
    }

    private void initialize() {
        frmBuscadorDeExtensiones = new JFrame();
        frmBuscadorDeExtensiones.setResizable(false);
        frmBuscadorDeExtensiones.setType(Window.Type.UTILITY);
        frmBuscadorDeExtensiones.setTitle("Buscador de extensiones");
        frmBuscadorDeExtensiones.setBounds(100, 100, 450, 300);
        frmBuscadorDeExtensiones.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmBuscadorDeExtensiones.getContentPane().setLayout((LayoutManager) null);

        // Cargar la imagen de fondo
        ImageIcon backgroundImage = new ImageIcon("\\\\\\\\server01\\\\Cobendai\\\\It\\\\logo.png");
        Image scaledImage = backgroundImage.getImage().getScaledInstance(450, 300, Image.SCALE_SMOOTH);
        ImageIcon scaledBackgroundImage = new ImageIcon(scaledImage);

        JLabel backgroundLabel = new JLabel(scaledBackgroundImage);
        backgroundLabel.setBounds(0, 0, 435, 280);
        frmBuscadorDeExtensiones.getContentPane().add(backgroundLabel);

        JLabel lblNewLabel = new JLabel("Búsqueda de contactos por nombre, extensión o correo");
        lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 402, 19);
        backgroundLabel.add(lblNewLabel);

        input = new JTextField();
        input.setToolTipText("Rellene para buscar");
        input.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        input.setBounds(10, 41, 322, 29);
        backgroundLabel.add(input);
        input.setColumns(10);

        output = new JTextArea();
        output.setToolTipText("Desliza para ver el resto de los resultados");
        output.setRows(5);
        output.setEditable(false);
        output.setLineWrap(true);
        output.setWrapStyleWord(true);
        output.setBounds(10, -5, 409, 123);
        output.setBorder(null);
        output.setBackground(new Color(0, 0, 0, 0));
        output.setOpaque(false);
        output.setForeground(Color.WHITE);
        
        Font resultFont = new Font("Segoe UI", Font.BOLD, 14);
        output.setFont(resultFont);

        JScrollPane scrollPane = new JScrollPane(output);
        scrollPane.setBounds(10, 127, 425, 133);
        scrollPane.setOpaque(false); // Hacer el JScrollPane transparente
        scrollPane.getViewport().setOpaque(false); // Hacer la vista del JScrollPane transparente
        scrollPane.setBorder(null);
        scrollPane.setViewportBorder(null);
        backgroundLabel.add(scrollPane);

        buscar = new JButton("Buscar");
        buscar.setForeground(Color.BLACK);
        buscar.setBackground(new Color(0, 123, 255));
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoBuscado = input.getText();
                output.setText("");
                try {
                    app2.main(new String[] {}, textoBuscado);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                output.append(app2.Salida);
                output.setCaretPosition(0); // Set view position to top

                // Comprobación de la frase exacta
                if (textoBuscado.equals("00Config00")) {
                    openNewWindow();
                }
            }
        });
        buscar.setBounds(335, 41, 89, 29);
        backgroundLabel.add(buscar);

        JLabel lblNewLabel_1 = new JLabel("Resultados");
        lblNewLabel_1.setBounds(10, 92, 89, 24);
        backgroundLabel.add(lblNewLabel_1);

        frmBuscadorDeExtensiones.getRootPane().setDefaultButton(buscar);
        
        backgroundLabel.setOpaque(false); // Hacer el contenedor padre transparente
    }

    private void openNewWindow() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewWindow window = new NewWindow();
                    window.getFrame().setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
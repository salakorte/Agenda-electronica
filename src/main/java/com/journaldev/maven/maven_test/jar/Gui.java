package com.journaldev.maven.maven_test.jar;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.BorderLayout;

public class Gui {
    private JFrame frmBuscadorDeExtensiones;
    private JTextField input;
    public JLabel Gui;

    public static void main(String[] args) {
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

        JLabel lblNewLabel = new JLabel("Búsqueda de contactos por nombre, extensión o correo");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(10, 11, 402, 19);
        frmBuscadorDeExtensiones.getContentPane().add(lblNewLabel, BorderLayout.NORTH);

        input = new JTextField();
        input.setToolTipText("Rellene para buscar");
        input.setFont(new Font("Tahoma", 0, 16));
        input.setBounds(10, 41, 322, 29);
        frmBuscadorDeExtensiones.getContentPane().add(input, BorderLayout.WEST);
        input.setColumns(10);

        final JTextArea output2 = new JTextArea();
        output2.setRows(5);
        output2.setEditable(false);
        output2.setLineWrap(true);
        output2.setWrapStyleWord(true);
        output2.setBackground(SystemColor.menu);
        output2.setBounds(10, -5, 409, 123);
        frmBuscadorDeExtensiones.getContentPane().add(output2);
        JScrollPane scrollPane = new JScrollPane(output2);
        scrollPane.setBounds(10, 127, 409, 123);
        frmBuscadorDeExtensiones.getContentPane().add(scrollPane);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); // Set scroll bar policy

        JButton buscar = new JButton("Buscar");
        buscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String textoBuscado = input.getText();
                output2.setText("");
                try {
                    app2.main(new String[] {}, textoBuscado);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                output2.append(app2.Salida);
                output2.setCaretPosition(0); // Set view position to top

                // Comprobación de la frase exacta
                if (textoBuscado.equals("00Config00")) {
                    openNewWindow();
                }
            }
        });
        buscar.setBounds(335, 41, 89, 29);
        frmBuscadorDeExtensiones.getContentPane().add(buscar);

        JLabel lblNewLabel_1 = new JLabel("Resultados");
        lblNewLabel_1.setBounds(10, 92, 89, 24);
        frmBuscadorDeExtensiones.getContentPane().add(lblNewLabel_1);

        frmBuscadorDeExtensiones.getRootPane().setDefaultButton(buscar);
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
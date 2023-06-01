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
    this.frmBuscadorDeExtensiones = new JFrame();
    this.frmBuscadorDeExtensiones.setResizable(false);
    this.frmBuscadorDeExtensiones.setType(Window.Type.UTILITY);
    this.frmBuscadorDeExtensiones.setTitle("Buscador de extensiones");
    this.frmBuscadorDeExtensiones.setBounds(100, 100, 450, 300);
    this.frmBuscadorDeExtensiones.setDefaultCloseOperation(3);
    this.frmBuscadorDeExtensiones.getContentPane().setLayout((LayoutManager)null);
    JLabel lblNewLabel = new JLabel("Búsqueda de contactos por nombre,extension o correo");
    lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
    lblNewLabel.setBounds(10, 11, 402, 19);
    this.frmBuscadorDeExtensiones.getContentPane().add(lblNewLabel, BorderLayout.NORTH);
    this.input = new JTextField();
    this.input.setToolTipText("Rellene para buscar");
    this.input.setFont(new Font("Tahoma", 0, 16));
    this.input.setBounds(10, 41, 322, 29);
    this.frmBuscadorDeExtensiones.getContentPane().add(this.input, BorderLayout.WEST);
    this.input.setColumns(10);
    final JTextArea Output2 = new JTextArea();
    Output2.setRows(5);
    Output2.setEditable(false);
    Output2.setLineWrap(true);
    Output2.setWrapStyleWord(true);
    Output2.setBackground(SystemColor.menu);
    Output2.setBounds(10, -5, 409, 123);
    this.frmBuscadorDeExtensiones.getContentPane().add(Output2);
    JScrollPane scrollPane = new JScrollPane(Output2);
    scrollPane.setBounds(10, 127, 409, 123);
    this.frmBuscadorDeExtensiones.getContentPane().add(scrollPane);
    scrollPane.setVerticalScrollBarPolicy(22);
    JButton Buscar = new JButton("Buscar");
    Buscar.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            String textoBuscado = Gui.this.input.getText();
            Output2.setText("");
            try {
            	app2.main(new String[]{}, textoBuscado);
            } catch (Exception ex) {
              ex.printStackTrace();
            } 
            Output2.append(app2.Salida);
          }
        });
    Buscar.setBounds(335, 41, 89, 29);
    this.frmBuscadorDeExtensiones.getContentPane().add(Buscar);
    JLabel lblNewLabel_1 = new JLabel("Resultados");
    lblNewLabel_1.setBounds(10, 92, 89, 24);
    this.frmBuscadorDeExtensiones.getContentPane().add(lblNewLabel_1);
    this.frmBuscadorDeExtensiones.getRootPane().setDefaultButton(Buscar);
    
  }
}

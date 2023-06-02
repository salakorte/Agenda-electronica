package com.journaldev.maven.maven_test.jar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class NewWindow extends JFrame {
    private JTextField textFieldManual;
    private JLabel labelDirectory;
    private String filePath;

    public void setFilePath(String filePath) {
        this.filePath = filePath;
        labelDirectory.setText(filePath); // Mostrar la ruta del archivo en el JLabel
    }

    public NewWindow() {
        initialize();
    }
    public JFrame getFrame() {
        return this;
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Directorio");
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Directorio actual:");
        lblNewLabel.setBounds(10, 28, 100, 14);
        getContentPane().add(lblNewLabel);

        labelDirectory = new JLabel("");
        labelDirectory.setBounds(120, 101, 304, 14);
        getContentPane().add(labelDirectory);

        textFieldManual = new JTextField();
        textFieldManual.setBounds(10, 68, 414, 20);
        getContentPane().add(textFieldManual);
        textFieldManual.setColumns(10);

        JButton btnManualSearch = new JButton("Buscar manualmente");
        btnManualSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String directory = textFieldManual.getText();
                labelDirectory.setText(directory);
            }
        });
        btnManualSearch.setBounds(242, 101, 182, 23);
        getContentPane().add(btnManualSearch);

        JButton btnFileChooser = new JButton("Buscar archivo");
        btnFileChooser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setCurrentDirectory(new File(".")); // Establecer el directorio actual del buscador
                int result = fileChooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    setFilePath(selectedFile.getAbsolutePath()); // Establecer la ruta del archivo seleccionado en el JLabel
                }
            }
        });
        btnFileChooser.setBounds(10, 101, 182, 23);
        getContentPane().add(btnFileChooser);
        
        JLabel lblNewLabel_1 = new JLabel("Made by Alex Villen for Cobendai V1.2");
        lblNewLabel_1.setBounds(10, 236, 316, 14);
        getContentPane().add(lblNewLabel_1);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewWindow frame = new NewWindow();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
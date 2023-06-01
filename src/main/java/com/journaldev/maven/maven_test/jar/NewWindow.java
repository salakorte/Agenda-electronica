package com.journaldev.maven.maven_test.jar;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class NewWindow {

    private JFrame frame;
    private JTextField textFieldDirectory;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    NewWindow window = new NewWindow();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public NewWindow() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setTitle("Nueva Ventana");
        frame.setBounds(150, 150, 400, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Directorio actual:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(20, 25, 150, 20);
        frame.getContentPane().add(lblNewLabel);

        JLabel labelDirectory = new JLabel();
        labelDirectory.setBounds(20, 55, 350, 25);
        frame.getContentPane().add(labelDirectory);

        // Obtener el directorio actual
        String currentDirectory = System.getProperty("user.dir");
        labelDirectory.setText(currentDirectory);

        textFieldDirectory = new JTextField();
        textFieldDirectory.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String directory = textFieldDirectory.getText();
                labelDirectory.setText(directory);
            }
        });
        textFieldDirectory.setBounds(20, 95, 350, 25);
        frame.getContentPane().add(textFieldDirectory);
        textFieldDirectory.setColumns(10);
    }

    public JFrame getFrame() {
        return frame;
    }
}

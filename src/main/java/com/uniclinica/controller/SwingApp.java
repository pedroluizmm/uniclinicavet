package com.uniclinica.controller;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;

/**
 * Ponto de entrada da interface gráfica Swing.
 */
public class SwingApp {

    private static void createAndShowGui() {
        JFrame frame = new JFrame("UniClinicaVet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("UniClinicaVet - Swing", JLabel.CENTER), BorderLayout.CENTER);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingApp::createAndShowGui);
    }
}

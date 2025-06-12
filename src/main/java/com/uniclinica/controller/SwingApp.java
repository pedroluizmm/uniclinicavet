package com.uniclinica.controller;

import javax.swing.SwingUtilities;
import com.uniclinica.controller.AgendamentoFrame;


public class SwingApp {

    private static void createAndShowGui() {
        AgendamentoFrame frame = new AgendamentoFrame();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingApp::createAndShowGui);
    }
}

package com.uniclinica.controller;

import javax.swing.SwingUtilities;
import com.uniclinica.controller.MainFrame;

public class SwingApp {

    private static void createAndShowGui() {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingApp::createAndShowGui);
    }
}

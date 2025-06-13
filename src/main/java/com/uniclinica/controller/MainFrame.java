package com.uniclinica.controller;

import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame {

    public MainFrame() {
        super("UniClinicaVet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Agendamento", new AgendamentoPanel());
        tabs.addTab("Admin", new AdminPanel());
        add(tabs, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
    }
}

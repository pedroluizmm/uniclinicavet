package com.uniclinica.controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import com.uniclinica.model.*;
import com.uniclinica.service.*;


public class AgendamentoPanel extends JPanel {

    private final JTextField tutorField = new JTextField();
    private final JTextField animalField = new JTextField();
    private final JTextField dataField = new JTextField("yyyy-MM-dd");
    private final JTextField horaField = new JTextField("HH:mm");
    private final JTextField veterinarioField = new JTextField();
    private final JTextField exameField = new JTextField();
    private final JTextArea outputArea = new JTextArea();
    private final ConsultaService consultaService = new ConsultaService();
    private final ExameService exameService = new ExameService();

    public AgendamentoPanel() {
        createLayout();
    }

    private void createLayout() {
        JPanel form = new JPanel(new GridLayout(0, 2, 5, 5));
        form.add(new JLabel("Tutor:"));
        form.add(tutorField);
        form.add(new JLabel("Animal:"));
        form.add(animalField);
        form.add(new JLabel("Data:"));
        form.add(dataField);
        form.add(new JLabel("Hora:"));
        form.add(horaField);
        form.add(new JLabel("Veterinário:"));
        form.add(veterinarioField);
        form.add(new JLabel("Tipo de Exame:"));
        form.add(exameField);

        JButton agendarBtn = new JButton("Agendar");
        agendarBtn.addActionListener(new ScheduleListener());

        JPanel top = new JPanel(new BorderLayout());
        top.add(form, BorderLayout.CENTER);
        top.add(agendarBtn, BorderLayout.SOUTH);

        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        scroll.setPreferredSize(new Dimension(400, 200));

        setLayout(new BorderLayout(5, 5));
        add(top, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private class ScheduleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String tutor = tutorField.getText();
                String animal = animalField.getText();
                LocalDate data = LocalDate.parse(dataField.getText(), DateTimeFormatter.ISO_LOCAL_DATE);
                LocalTime hora = LocalTime.parse(horaField.getText(), DateTimeFormatter.ofPattern("HH:mm"));
                String vet = veterinarioField.getText();
                String exame = exameField.getText();
                LocalDateTime dt = LocalDateTime.of(data, hora);

                Consulta consulta = new Consulta(0, Integer.parseInt(animal), dt, vet, "");
                consultaService.agendarConsulta(consulta);
                if (!exame.isBlank()) {
                    Exame ex = new Exame(0, consulta.getId(), exame, "Pendente", null);
                    exameService.solicitarExame(ex);
                }

                String resumo = String.format("%s - %s\n  Consulta: %s com %s\n  Exame: %s\n", tutor, animal, dt, vet, exame);
                outputArea.append(resumo + "\n");

                // limpa campos
                tutorField.setText("");
                animalField.setText("");
                dataField.setText("yyyy-MM-dd");
                horaField.setText("HH:mm");
                veterinarioField.setText("");
                exameField.setText("");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(AgendamentoPanel.this,
                        "Dados inválidos: " + ex.getMessage(),
                        "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}

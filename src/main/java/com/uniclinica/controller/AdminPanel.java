package com.uniclinica.controller;

import com.uniclinica.model.*;
import com.uniclinica.service.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


public class AdminPanel extends JPanel {

    public AdminPanel() {
        setLayout(new BorderLayout());
        JTabbedPane tabs = new JTabbedPane();
        tabs.addTab("Tutores", new TutorCrudPanel());
        tabs.addTab("Animais", new AnimalCrudPanel());
        tabs.addTab("Consultas", new ConsultaCrudPanel());
        tabs.addTab("Exames", new ExameCrudPanel());
        add(tabs, BorderLayout.CENTER);
    }


    private static class TutorCrudPanel extends JPanel {
        private final TutorService service = new TutorService();
        private final JTextField id = new JTextField(5);
        private final JTextField nome = new JTextField(15);
        private final JTextField tel = new JTextField(10);
        private final JTextField email = new JTextField(15);
        private final JTextArea out = new JTextArea();

        TutorCrudPanel() {
            setLayout(new BorderLayout(5,5));
            JPanel form = new JPanel(new GridLayout(0,2,5,5));
            form.add(new JLabel("ID:"));
            form.add(id);
            form.add(new JLabel("Nome:"));
            form.add(nome);
            form.add(new JLabel("Telefone:"));
            form.add(tel);
            form.add(new JLabel("Email:"));
            form.add(email);

            JPanel btns = new JPanel();
            JButton add = new JButton("Adicionar");
            add.addActionListener(e -> {
                service.cadastrarTutor(new Tutor(0,nome.getText(),tel.getText(),email.getText()));
                listar();
            });
            JButton upd = new JButton("Atualizar");
            upd.addActionListener(e -> {
                service.atualizarTutor(new Tutor(Integer.parseInt(id.getText()),nome.getText(),tel.getText(),email.getText()));
                listar();
            });
            JButton del = new JButton("Remover");
            del.addActionListener(e -> {
                service.removerTutor(Integer.parseInt(id.getText()));
                listar();
            });
            JButton list = new JButton("Listar");
            list.addActionListener(e -> listar());
            btns.add(add);btns.add(upd);btns.add(del);btns.add(list);

            add(form, BorderLayout.NORTH);
            add(btns, BorderLayout.CENTER);
            out.setEditable(false);
            add(new JScrollPane(out), BorderLayout.SOUTH);
            listar();
        }
        private void listar() {
            List<Tutor> t = service.listarTutores();
            out.setText("");
            for (Tutor tu : t) {
                out.append(tu.getId()+" - "+tu.getNome()+"\n");
            }
        }
    }


    private static class AnimalCrudPanel extends JPanel {
        private final AnimalService service = new AnimalService();
        private final JTextField id = new JTextField(5);
        private final JTextField tutorId = new JTextField(5);
        private final JTextField nome = new JTextField(10);
        private final JTextField especie = new JTextField(10);
        private final JTextField raca = new JTextField(10);
        private final JTextField nasc = new JTextField("yyyy-MM-dd",10);
        private final JTextArea out = new JTextArea();
        AnimalCrudPanel(){
            setLayout(new BorderLayout(5,5));
            JPanel form = new JPanel(new GridLayout(0,2,5,5));
            form.add(new JLabel("ID:"));form.add(id);
            form.add(new JLabel("TutorId:"));form.add(tutorId);
            form.add(new JLabel("Nome:"));form.add(nome);
            form.add(new JLabel("Espécie:"));form.add(especie);
            form.add(new JLabel("Raça:"));form.add(raca);
            form.add(new JLabel("Nascimento:"));form.add(nasc);

            JPanel btns = new JPanel();
            JButton add = new JButton("Adicionar");
            add.addActionListener(e->{
                service.cadastrarAnimal(new Animal(0,Integer.parseInt(tutorId.getText()),nome.getText(),especie.getText(),raca.getText(),LocalDate.parse(nasc.getText())));
                listar();
            });
            JButton upd = new JButton("Atualizar");
            upd.addActionListener(e->{
                service.atualizarAnimal(new Animal(Integer.parseInt(id.getText()),Integer.parseInt(tutorId.getText()),nome.getText(),especie.getText(),raca.getText(),LocalDate.parse(nasc.getText())));
                listar();
            });
            JButton del = new JButton("Remover");
            del.addActionListener(e->{ service.removerAnimal(Integer.parseInt(id.getText())); listar();});
            JButton list = new JButton("Listar");
            list.addActionListener(e->listar());
            btns.add(add);btns.add(upd);btns.add(del);btns.add(list);

            add(form,BorderLayout.NORTH);
            add(btns,BorderLayout.CENTER);
            out.setEditable(false);
            add(new JScrollPane(out),BorderLayout.SOUTH);
            listar();
        }
        private void listar(){
            List<Animal> list=service.listarAnimais();
            out.setText("");
            for(Animal a:list){
                out.append(a.getId()+" - "+a.getNome()+"\n");
            }
        }
    }


    private static class ConsultaCrudPanel extends JPanel {
        private final ConsultaService service = new ConsultaService();
        private final JTextField id = new JTextField(5);
        private final JTextField animalId = new JTextField(5);
        private final JTextField data = new JTextField("yyyy-MM-dd HH:mm",15);
        private final JTextField vet = new JTextField(10);
        private final JTextField diag = new JTextField(10);
        private final JTextArea out = new JTextArea();
        ConsultaCrudPanel(){
            setLayout(new BorderLayout(5,5));
            JPanel form=new JPanel(new GridLayout(0,2,5,5));
            form.add(new JLabel("ID:"));form.add(id);
            form.add(new JLabel("AnimalId:"));form.add(animalId);
            form.add(new JLabel("DataHora:"));form.add(data);
            form.add(new JLabel("Veterinário:"));form.add(vet);
            form.add(new JLabel("Diagnóstico:"));form.add(diag);

            JPanel btns=new JPanel();
            JButton add=new JButton("Adicionar");
            add.addActionListener(e->{
                LocalDateTime dt=LocalDateTime.parse(data.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                service.agendarConsulta(new Consulta(0,Integer.parseInt(animalId.getText()),dt,vet.getText(),diag.getText()));
                listar();
            });
            JButton upd=new JButton("Atualizar");
            upd.addActionListener(e->{
                LocalDateTime dt=LocalDateTime.parse(data.getText(),DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                service.atualizarConsulta(new Consulta(Integer.parseInt(id.getText()),Integer.parseInt(animalId.getText()),dt,vet.getText(),diag.getText()));
                listar();
            });
            JButton del=new JButton("Remover");
            del.addActionListener(e->{ service.cancelarConsulta(Integer.parseInt(id.getText())); listar(); });
            JButton list=new JButton("Listar");
            list.addActionListener(e->listar());
            btns.add(add);btns.add(upd);btns.add(del);btns.add(list);

            add(form,BorderLayout.NORTH);
            add(btns,BorderLayout.CENTER);
            out.setEditable(false);
            add(new JScrollPane(out),BorderLayout.SOUTH);
            listar();
        }
        private void listar(){
            List<Consulta> list=service.listarConsultas();
            out.setText("");
            for(Consulta c:list){
                out.append(c.getId()+" - "+c.getVeterinario()+"\n");
            }
        }
    }


    private static class ExameCrudPanel extends JPanel {
        private final ExameService service = new ExameService();
        private final JTextField id = new JTextField(5);
        private final JTextField consultaId = new JTextField(5);
        private final JTextField tipo = new JTextField(10);
        private final JTextField status = new JTextField(10);
        private final JTextField entrega = new JTextField("yyyy-MM-dd",10);
        private final JTextArea out = new JTextArea();
        ExameCrudPanel(){
            setLayout(new BorderLayout(5,5));
            JPanel form=new JPanel(new GridLayout(0,2,5,5));
            form.add(new JLabel("ID:"));form.add(id);
            form.add(new JLabel("ConsultaId:"));form.add(consultaId);
            form.add(new JLabel("Tipo:"));form.add(tipo);
            form.add(new JLabel("Status:"));form.add(status);
            form.add(new JLabel("Entrega:"));form.add(entrega);

            JPanel btns=new JPanel();
            JButton add=new JButton("Adicionar");
            add.addActionListener(e->{
                LocalDate d=LocalDate.parse(entrega.getText());
                service.solicitarExame(new Exame(0,Integer.parseInt(consultaId.getText()),tipo.getText(),status.getText(),d));
                listar();
            });
            JButton upd=new JButton("Atualizar");
            upd.addActionListener(e->{
                LocalDate d=LocalDate.parse(entrega.getText());
                service.atualizarExame(new Exame(Integer.parseInt(id.getText()),Integer.parseInt(consultaId.getText()),tipo.getText(),status.getText(),d));
                listar();
            });
            JButton del=new JButton("Remover");
            del.addActionListener(e->{ service.removerExame(Integer.parseInt(id.getText())); listar();});
            JButton list=new JButton("Listar");
            list.addActionListener(e->listar());
            btns.add(add);btns.add(upd);btns.add(del);btns.add(list);

            add(form,BorderLayout.NORTH);
            add(btns,BorderLayout.CENTER);
            out.setEditable(false);
            add(new JScrollPane(out),BorderLayout.SOUTH);
            listar();
        }
        private void listar(){
            List<Exame> list=service.listarExames();
            out.setText("");
            for(Exame ex:list){
                out.append(ex.getId()+" - "+ex.getTipo()+"\n");
            }
        }
    }
}

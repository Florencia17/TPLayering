package ar.unrn.tp3.ui;

import ar.unrn.tp3.bd.JdbcPartipante;
import ar.unrn.tp3.modelo.Participante;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UI extends JFrame {

        private JTextField nombre;
        private JTextField telefono;
        private JTextField region;

        private void setupUIComponents() {
            setTitle("Add Participant");
            setSize(400, 400);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.nombre = new JTextField(10);
            this.telefono = new JTextField(10);
            this.region = new JTextField(10);
            this.nombre.setText("");
            this.telefono.setText("");
            this.region.setText("China");
            JPanel contentPane = new JPanel();
            contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
            contentPane.setLayout(new FlowLayout());
            contentPane.add(new JLabel("Nombre: "));
            contentPane.add(nombre);
            contentPane.add(new JLabel("Telefono: "));
            contentPane.add(telefono);
            contentPane.add(new JLabel("Region: "));
            contentPane.add(region);
            JButton botonCargar = new JButton("Cargar");
            botonCargar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {

                    onBotonCargar();
                }});

                    contentPane.add(botonCargar);
                    setContentPane(contentPane);
                    contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                    pack();
                    setVisible(true);

        }

      private void onBotonCargar(){

          Participante participante = new Participante(nombre.getText(), telefono.getText(), region.getText());
          JdbcPartipante jdbcPartipante= new JdbcPartipante();
          jdbcPartipante.createParticipante(participante);


        }
    }



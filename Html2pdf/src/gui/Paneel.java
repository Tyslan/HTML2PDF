/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import logic.PdfGenerator;

/**
 *
 * @author Lorenz
 */
public class Paneel extends JPanel {

    private JFrame ouder;
    private JLabel lblBron, lblDoel;
    private JTextField txtBron, txtDoel;
    private JButton btnBron, btnDoel, btnConvert;
    JFileChooser chooser;

    public Paneel(JFrame ouder) {
        this.ouder = ouder;
        init();

    }

    private void init() {
        chooser = new JFileChooser(".");

        lblBron = new JLabel("Source:");
        lblBron.setPreferredSize(new Dimension(100, 25));
        lblDoel = new JLabel("Destination:");
        lblDoel.setPreferredSize(new Dimension(100, 25));
        txtBron = new JTextField();
        txtBron.setPreferredSize(new Dimension(400, 25));
        txtDoel = new JTextField();
        txtDoel.setPreferredSize(new Dimension(400, 25));
        btnBron = new JButton("Select");
        btnDoel = new JButton("Select");
        btnConvert = new JButton("Convert");

        btnBron.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bronClicked(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        btnDoel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doelClicked(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        btnConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertClicked(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        add(lblBron);
        add(txtBron);
        add(btnBron);
        add(lblDoel);
        add(txtDoel);
        add(btnDoel);
        add(btnConvert);
    }

    private void bronClicked() {
        chooser.addChoosableFileFilter(new ExtentionFilter(".htm"));
        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        int antwoord = chooser.showDialog(ouder, "Select");
        if (antwoord == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getPath().toString();
            txtBron.setText(path);
        }
    }

    private void doelClicked() {
        chooser.resetChoosableFileFilters();
        int antwoord = chooser.showSaveDialog(ouder);
        if (antwoord == JFileChooser.APPROVE_OPTION) {
            File file = chooser.getSelectedFile();
            String path = file.getPath().toString();
            int i = path.lastIndexOf(".");            int j = path.indexOf(".");
            if (i == j) {
                path = path.substring(0, i);
            }
            path = path + ".pdf";
            txtDoel.setText(path);
        }
    }

    private void convertClicked() {
        PdfGenerator gen = new PdfGenerator(txtBron.getText(), txtDoel.getText());
        try {
            gen.generatePDF();
        } catch (Exception e) {
        }
        txtBron.setText("");
        txtDoel.setText("");
    }
}

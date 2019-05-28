package com.erika.consultorio;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DoctorsOffice {
    private JButton eraseBtn;
    private JButton registerBtn;
    private JButton searchBtn;
    public JPanel doctorsView;
    private JTextField registerTxt;
    private JTextField idTxt;
    private JButton showBtn;
    HashTableJava hash = new HashTableJava();


    public DoctorsOffice() {
        registerBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String register =registerTxt.getText();
                hash.Start(register);
                registerTxt.setText("");
            }
        });
        eraseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =idTxt.getText();
                hash.Erase(id);
                idTxt.setText("");
            }
        });
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id =idTxt.getText();
                hash.Search(id);
                idTxt.setText("");
            }
        });
        showBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hash.showStudents();
            }
        });
    }
}

package com.ifpb.aplicacao.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JDialog {
    private JPanel contentPane;
    private JButton listarUsuáriosButton;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JLabel label1;

    public TelaPrincipal() {

        setContentPane(contentPane);
        setTitle("Tela principal");
        setModal(true);

        listarUsuáriosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListarUsuarios listarUsuarios = new TelaListarUsuarios();
                listarUsuarios.pack();
                listarUsuarios.setVisible(true);
            }
        });
    }

    private void createUIComponents() {
        label1 = new JLabel();

        ImageIcon icon = new ImageIcon("imagens/Logo.jpg");
        label1.setIcon(icon);

    }
}
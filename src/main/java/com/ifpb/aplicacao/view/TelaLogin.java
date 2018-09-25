package com.ifpb.aplicacao.view;

import javax.swing.*;
import java.awt.event.*;

public class TelaLogin extends JFrame {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton criarContaButton;
    private JLabel labelImagem;

    public TelaLogin() {
        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Tela de Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        criarContaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaCadastroUsuario cadastroUsuario = new TelaCadastroUsuario();
                cadastroUsuario.pack();
                cadastroUsuario.setVisible(true);
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    public static void main(String[] args) {
        TelaLogin dialog = new TelaLogin();
        dialog.pack();
        dialog.setVisible(true);
    }

    private void createUIComponents() {
        labelImagem = new JLabel();
        ImageIcon imageIcon = new ImageIcon("imagens/cadeado.png");
        labelImagem.setIcon(imageIcon);
    }
}

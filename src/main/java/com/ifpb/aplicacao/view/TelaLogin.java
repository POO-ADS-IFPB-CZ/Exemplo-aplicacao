package com.ifpb.aplicacao.view;

import com.ifpb.aplicacao.dao.UsuarioDao;
import com.ifpb.aplicacao.dao.UsuarioDaoArquivoImpl;
import com.ifpb.aplicacao.model.Usuario;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;

public class TelaLogin extends JFrame {

    private UsuarioDao dao;

    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton criarContaButton;
    private JLabel labelImagem;

    public TelaLogin() {

        try {
            dao = new UsuarioDaoArquivoImpl();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha ao abrir arquivo", "Mensagem de Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        getRootPane().setDefaultButton(buttonOK);
        setTitle("Tela de Login");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String login = textField1.getText();
                String senha = new String(passwordField1.getPassword());

                Usuario usuario = null;

                try {
                    usuario = dao.buscarPorLogin(login);
                } catch (IOException | ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Falha na conexão com o arquivo",
                            "Mensagem de Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

                if(usuario!=null){
                    if(usuario.autenticar(login, senha)){

                        TelaPrincipal principal = new TelaPrincipal();
                        principal.pack();
                        dispose();
                        principal.setVisible(true);
                        System.exit(0);

                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Senha incorreta",
                                "Mensagem de erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }else{
                    JOptionPane.showMessageDialog(null,
                            "Usuário não cadastrado",
                            "Mensagem de erro",
                            JOptionPane.ERROR_MESSAGE);
                }

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

package com.ifpb.aplicacao.view;

import com.ifpb.aplicacao.dao.UsuarioDao;
import com.ifpb.aplicacao.dao.UsuarioDaoArquivoImpl;
import com.ifpb.aplicacao.enumeration.Cargo;
import com.ifpb.aplicacao.model.Usuario;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TelaCadastroUsuario extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JTextField textField1;
    private JFormattedTextField formattedTextField1;
    private JRadioButton masculinoRadioButton;
    private JRadioButton femininoRadioButton;
    private JComboBox comboBox1;
    private JTextField textField2;
    private JPasswordField passwordField1;

    private UsuarioDao dao;

    public TelaCadastroUsuario() {
        try {
            dao = new UsuarioDaoArquivoImpl();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha ao abrir arquivo", "Mensagem de Erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        setContentPane(contentPane);
        setTitle("Cadastro de usuários");
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = textField1.getText();
                String login = textField2.getText();
                String senha = new String(passwordField1.getPassword());
                Cargo cargo = (Cargo) comboBox1.getSelectedItem();

                char sexo = 'M';
                if(femininoRadioButton.isSelected()){
                    sexo = 'F';
                }

                DateTimeFormatter formatter = DateTimeFormatter
                        .ofPattern("dd/MM/yyyy");

                LocalDate nascimento = LocalDate
                        .parse(formattedTextField1.getText(), formatter);

                Usuario usuario = new Usuario(nome, nascimento,
                        sexo, cargo, login, senha);

                try {
                    if(dao.salvar(usuario)){
                        JOptionPane.showMessageDialog(null,
                                "Salvo com sucesso");
                    }else{
                        JOptionPane.showMessageDialog(null,
                                "Já existe um usuário com esse login",
                                "Mensagem de Erro",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } catch (IOException | ClassNotFoundException e1) {
                    JOptionPane.showMessageDialog(null,
                            "Falha na conexão com o arquivo",
                            "Mensagem de Erro",
                            JOptionPane.ERROR_MESSAGE);
                }

            }
        });
    }

    private void createUIComponents() {

        MaskFormatter formatter = null;

        try {
            formatter = new MaskFormatter("##/##/####");
        } catch (ParseException e) {
            e.printStackTrace();
        }

        formattedTextField1 = new JFormattedTextField();

        if(formatter!= null){
            formatter.install(formattedTextField1);
        }

        ButtonGroup group = new ButtonGroup();
        femininoRadioButton = new JRadioButton();
        masculinoRadioButton = new JRadioButton();
        group.add(femininoRadioButton);
        group.add(masculinoRadioButton);

        comboBox1 = new JComboBox(Cargo.values());

    }
}

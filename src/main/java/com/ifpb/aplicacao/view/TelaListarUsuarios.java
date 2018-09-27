package com.ifpb.aplicacao.view;

import com.ifpb.aplicacao.dao.UsuarioDao;
import com.ifpb.aplicacao.dao.UsuarioDaoArquivoImpl;
import com.ifpb.aplicacao.model.Usuario;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Set;

public class TelaListarUsuarios extends JDialog {

    private UsuarioDao dao;
    private Set<Usuario> usuarios;
    private JPanel contentPane;
    private JTable table1;

    public TelaListarUsuarios() {
        setContentPane(contentPane);
        setTitle("Listar usuários");
        setModal(true);
    }

    private void createUIComponents() {

        try {
            dao = new UsuarioDaoArquivoImpl();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o arquivo",
                    "Mensagem de erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        try {
            usuarios = dao.getUsuarios();
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Falha na conexão com o arquivo",
                    "Mensagem de erro",
                    JOptionPane.ERROR_MESSAGE);
        }

        System.out.println(usuarios);

        table1 = new JTable();

        String titulos[] = {"Nome", "Nascimento", "Sexo", "Cargo", "Login"};

        int contador = 0;
        Object dados[][] = new Object[usuarios.size()][5];

        for(Usuario u : usuarios){
            dados[contador][0] = u.getNome();
            dados[contador][1] = u.getNascimento();
            dados[contador][2] = u.getSexo();
            dados[contador][3] = u.getCargo();
            dados[contador][4] = u.getLogin();
        }

        DefaultTableModel model = new DefaultTableModel(dados, titulos);

        table1.setModel(model);


    }
}

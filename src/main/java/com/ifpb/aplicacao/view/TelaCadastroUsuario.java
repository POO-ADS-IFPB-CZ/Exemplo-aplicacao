package com.ifpb.aplicacao.view;

import com.ifpb.aplicacao.enumeration.Cargo;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.text.ParseException;

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

    public TelaCadastroUsuario() {
        setContentPane(contentPane);
        setTitle("Cadastro de usuários");
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
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

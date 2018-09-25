package com.ifpb.aplicacao.view;

import com.ifpb.aplicacao.dao.UsuarioDao;
import com.ifpb.aplicacao.dao.UsuarioDaoArquivoImpl;
import com.ifpb.aplicacao.enumeration.Cargo;
import com.ifpb.aplicacao.model.Usuario;

import java.io.IOException;
import java.time.LocalDate;

public class App {

    public static void main(String[] args) {

        UsuarioDao dao = null;

        try{
            dao = new UsuarioDaoArquivoImpl();

            System.out.println("Salvar:");
            dao.salvar(new Usuario("Joao", LocalDate.now(),
                    'M', Cargo.GERENTE, "joao", "123456"));

            System.out.println("Listar:");
            System.out.println(dao.getUsuarios());

            System.out.println("Buscar por login:");
            Usuario u = dao.buscarPorLogin("joao");
            System.out.println(u);

            System.out.println("Atualizar:");
            u.setNome("João Paulo");
            dao.atualizar(u);
            System.out.println(dao.getUsuarios());

            System.out.println("Deletar:");
            dao.deletarPorLogin("joao");
            System.out.println(dao.getUsuarios());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}

package com.ifpb.aplicacao.dao;

import com.ifpb.aplicacao.model.Usuario;

import java.io.IOException;
import java.util.Set;

public interface UsuarioDao {

    boolean salvar(Usuario usuario) throws IOException, ClassNotFoundException;
    Usuario buscarPorLogin(String login) throws IOException, ClassNotFoundException;
    boolean deletarPorLogin(String login) throws IOException, ClassNotFoundException;
    boolean atualizar(Usuario usuario) throws IOException, ClassNotFoundException;
    Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException;

}
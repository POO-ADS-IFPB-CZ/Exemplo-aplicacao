package com.ifpb.aplicacao.dao;

import com.ifpb.aplicacao.model.Usuario;

import java.io.IOException;
import java.util.Set;

public interface UsuarioDao {

    boolean salvar(Usuario usuario);
    Usuario buscarPorCpf(String cpf);
    boolean deletarPorCpf(String cpf);
    boolean atualizar(Usuario usuario);
    Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException;

}
package com.ifpb.aplicacao.dao;

import com.ifpb.aplicacao.model.Usuario;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDaoArquivoImpl implements UsuarioDao {

    private File file;

    public UsuarioDaoArquivoImpl(){
        file = new File("Usuarios");
    }

    @Override
    public boolean salvar(Usuario usuario) {
        return false;
    }

    @Override
    public Usuario buscarPorCpf(String cpf) {
        return null;
    }

    @Override
    public boolean deletarPorCpf(String cpf) {
        return false;
    }

    @Override
    public boolean atualizar(Usuario usuario) {
        return false;
    }

    @Override
    public Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException {
        try(ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(file))){
            if(file.length()>0){
                return (Set<Usuario>) in.readObject();
            }else{
                return new HashSet<>();
            }
        }
    }
}

package com.ifpb.aplicacao.dao;

import com.ifpb.aplicacao.model.Usuario;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class UsuarioDaoArquivoImpl implements UsuarioDao {

    private File file;

    public UsuarioDaoArquivoImpl() throws IOException {
        file = new File("Usuarios");

        if(!file.exists()){
            file.createNewFile();
        }
    }

    @Override
    public boolean salvar(Usuario usuario) throws IOException, ClassNotFoundException {
        Set<Usuario> usuarios = getUsuarios();

        if(usuarios.add(usuario)){
            atualizarArquivo(usuarios);
            return true;
        }else{
            return false;
        }
    }

    private void atualizarArquivo(Set<Usuario> usuarios) throws IOException {
        try(ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(file))){
            out.writeObject(usuarios);
        }
    }

    @Override
    public Usuario buscarPorLogin(String login) throws IOException, ClassNotFoundException {
        Set<Usuario> usuarios = getUsuarios();

        for(Usuario usuario : usuarios){
            if(usuario.getLogin().equals(login)){
                return usuario;
            }
        }

        return null;
    }

    @Override
    public boolean deletarPorLogin(String login) throws IOException, ClassNotFoundException {
        Set<Usuario> usuarios = getUsuarios();

        Usuario usuario = new Usuario(login);

        if(usuarios.remove(usuario)){
            atualizarArquivo(usuarios);
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean atualizar(Usuario usuario) throws IOException, ClassNotFoundException {
        Set<Usuario> usuarios = getUsuarios();

        Usuario usuario1 = new Usuario(usuario.getLogin());

        if(usuarios.remove(usuario1)){
            usuarios.add(usuario);
            atualizarArquivo(usuarios);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Set<Usuario> getUsuarios() throws IOException, ClassNotFoundException {

        if(file.length()>0){
            try(ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(file))){

                return (Set<Usuario>) in.readObject();
            }
        }else{
            return new HashSet<>();
        }

    }
}

package br.ufpb.dcx.ayla.agenda;

import java.io.*;
import java.util.HashMap;
import java.io.FileInputStream;

public class GravadorDeDados {

    public static final String ARQUIVO_CONTATOS = "contatos.dat";

    public HashMap<String, Contato> recuperarContatos() throws IOException{
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO_CONTATOS))){
            return (HashMap<String, Contato>) in.readObject();
        } catch (ClassNotFoundException e) {
            throw new IOException(e);
        }
    }

    public void salvarContatos(HashMap<String,Contato> contatos) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO_CONTATOS))){
            out.writeObject(contatos);
        }
    }


}

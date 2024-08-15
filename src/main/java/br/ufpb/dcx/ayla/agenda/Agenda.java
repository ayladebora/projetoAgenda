package br.ufpb.dcx.ayla.agenda;

import java.util.Collection;
import java.io.IOException;

public interface Agenda {
    public boolean cadastraContato(String nome, int dia, int mes);
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes);
    public boolean removeContato(String nome) throws ContatoInexistenteException;
    public void salvarDados() throws IOException;
    public void recuperarDados() throws IOException;
}

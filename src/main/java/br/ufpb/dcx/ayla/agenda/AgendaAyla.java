package br.ufpb.dcx.ayla.agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.HashMap;

public class AgendaAyla implements Agenda {

    private HashMap<String,Contato> contatos;
    private GravadorDeDados gravador;

    public AgendaAyla(){
        this.contatos = new HashMap<>();
        this.gravador = new GravadorDeDados();
    }



    @Override
    public boolean cadastraContato(String nome, int dia, int mes) {
        if (this.contatos.containsKey(nome)){
            return false;
        } else {
            Contato c = new Contato(nome, dia, mes);
            this.contatos.put(nome, c);
            return true;
        }
    }

    @Override
    public Collection<Contato> pesquisaAniversariantes(int dia, int mes) {
        Collection<Contato> contatosDoDia = new ArrayList<>();
        for(Contato c: this.contatos.values()){
            if (c.getDiaAniversario()==dia && c.getMesAniversario()==mes){
                contatosDoDia.add(c);
            }
        }
        return contatosDoDia;
    }

    @Override
    public void removeContato(String nome) throws ContatoInexistenteException {
        if (this.contatos.containsKey(nome)){
            this.contatos.remove(nome);
        } else {
            throw new ContatoInexistenteException("Não existe contato com o nome "+nome);
        }
    }

    @Override
    public void salvarDados() throws IOException {
        this.gravador.salvarContatos(this.contatos);
    }

    @Override
    public void recuperarDados() throws IOException {
        this.contatos = this.gravador.recuperarContatos();
    }
}

package br.ufpb.dcx.ayla.agenda;

import java.util.Collection;
import java.io.IOException;

/**
 * Interface para as operações básicas de uma agenda de contatos.
 */
public interface Agenda {

    /**
     * Cadastra um novo contato na agenda
     * @param nome O nome do contato
     * @param dia O dia do mês em que o contato nasceu
     * @param mes O número correspondente ao mês em que o contato nasceu [1-12]
     * @return true se o contato foi cadastrado com sucesso ou false, caso contrário.
     */
    boolean cadastraContato(String nome, int dia, int mes);


    /**
     * Pesquisa todos os aniversariantes da agenda que nasceram em determinado dia
     * de determinado mês
     * @param dia o dia do mês a pesquisar
     * @param mes o número correspondente ao mês do aniversário [1-12]
     * @return uma coleção com todos os contatos que aniversariam na data indicada
     */
    Collection<Contato> pesquisaAniversariantes(int dia, int mes);

    /**
     * Remove da agenda o contato com o mesmo nome passado no parâmetro
     * @param nome O nome do contato a remover
     * @throws ContatoInexistenteException se na agenda não houver nenhum contato
     * com o nome passado.
     */
    void removeContato(String nome) throws ContatoInexistenteException;

    /**
     * Persiste os dados do sistema.
     * @throws IOException Caso haja algum problema na recuperação dos dados
     * previamente gravados.
     */
    void salvarDados() throws IOException;

    /**
     * Recupera dados previamente gravados substituindo os contatos atuais da agenda.
     * @throws IOException Caso haja algum problema na recuperação de
     * dados previamente gravados.
     */
    void recuperarDados() throws IOException;
}

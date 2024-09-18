package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

public class AgendaAylaTest {

    @Test
    public void testaCadastroPesquisaRemocao(){
        AgendaAyla agenda = new AgendaAyla();
        Collection<Contato> contatosAchados =
                agenda.pesquisaAniversariantes(
                        20,8);
        assertTrue(contatosAchados.size()==0);
        agenda.cadastraContato("Maria",20,8);
        agenda.cadastraContato("José", 20, 8);
        contatosAchados =
                agenda.pesquisaAniversariantes(
                        20,8);
        assertEquals(2, contatosAchados.size());
        Contato maria = new Contato("Maria",20,8);
        assertTrue(contatosAchados.contains(maria));
        Contato jose = new Contato("José",20,8);
        assertTrue(contatosAchados.contains(jose));
        try {
            agenda.removeContato("José");
            //Não deve lançar exceção
        } catch (ContatoInexistenteException e) {
            fail("Lançou exceção quando não deveria");
        }

    }
}

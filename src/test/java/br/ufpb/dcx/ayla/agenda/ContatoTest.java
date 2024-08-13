package br.ufpb.dcx.ayla.agenda;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContatoTest {

    @Test
    public void testaConstrutor(){
        Contato c1 = new Contato("Ayla", 5, 10);
        assertEquals("Ayla", c1.getNome());
        assertEquals(5, c1.getDiaAniversario());
        assertEquals(10, c1.getMesAniversario());
    }

}

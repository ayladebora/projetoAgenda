package br.ufpb.dcx.ayla.agenda.gui;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AgendaGUI extends JFrame {
    public AgendaGUI(){
        super.setTitle("Agenda de Aniversários da turma de POO");
        super.setSize(1000,600);
        super.setLocation(100, 200);
        //localização da janela na tela
        super.setResizable(true);
        //janela não redimensionável
        getContentPane().setBackground(Color.lightGray);
    }
    //...
    public static void main(String [] args){
        AgendaGUI janela = new AgendaGUI();
        janela.setVisible(true);
        WindowListener fechadorDeJanelaPrincipal = new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.out.println("Saindo");
                System.exit(0);
            }
        };
        janela.addWindowListener(fechadorDeJanelaPrincipal);

    }
}
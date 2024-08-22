package br.ufpb.dcx.ayla.agenda.gui;

import javax.swing.*;

public class AgendaGUIV3_Com_Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame janela = new AgendaGUIV3();
                janela.setVisible(true);
                janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
    }
}

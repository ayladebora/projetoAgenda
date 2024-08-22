package br.ufpb.dcx.ayla.agenda.gui;

import br.ufpb.dcx.ayla.agenda.Agenda;
import br.ufpb.dcx.ayla.agenda.AgendaAyla;
import br.ufpb.dcx.ayla.agenda.controller.AgendaRemoveController;
import br.ufpb.dcx.ayla.agenda.controller.AgendaSearchController;

import javax.swing.*;
import java.awt.*;

public class AgendaGUIV3ComMenu extends JFrame {
    JLabel linha1, linha2;
    ImageIcon boloImg = new ImageIcon("./imgs/bolo.jpg");
    Agenda agenda = new AgendaAyla();
    JMenuBar barraDeMenu = new JMenuBar();

    public AgendaGUIV3ComMenu() {
        setTitle("Agenda de Aniversários");
        setSize(800, 600); //tamanho da janela
        setLocation(150, 150);
        setResizable(false);
        setBackground(Color.white);
        linha1 = new JLabel("Minha Agenda de Aniversários", JLabel.CENTER);
        linha1.setForeground(Color.red);
        linha1.setFont(new Font("Serif", Font.BOLD, 24));
        linha2 = new JLabel(boloImg, JLabel.CENTER);
        setLayout(new GridLayout(3, 1));
        add(linha1);
        add(linha2);
        add(new JLabel());
        JMenu menuCadastrar = new JMenu("Cadastrar");
        JMenuItem menuCadastrarAniversariante = new JMenuItem(
                "Cadastrar aniversariante");
        menuCadastrar.add(menuCadastrarAniversariante);
        JMenu menuPesquisar = new JMenu("Pesquisar");
        JMenuItem menuPesquisarAniversariante = new JMenuItem(
                "Pesquisar aniversariante");
        menuPesquisar.add(menuPesquisarAniversariante);
        JMenu menuRemover = new JMenu("Remover");
        JMenuItem menuRemoverAniversariante = new JMenuItem(
                "Remover aniversariante");
        menuRemover.add(menuRemoverAniversariante);
        menuPesquisarAniversariante.addActionListener(
                new AgendaSearchController(agenda,this));
        menuRemoverAniversariante.addActionListener(
                new AgendaRemoveController(agenda, this));
        menuCadastrarAniversariante.addActionListener(
                (ae) -> {
                    String nome = JOptionPane.showInputDialog(this,
                            "Qual o nome do aniversariante?");
                    int dia = Integer.parseInt(JOptionPane.showInputDialog(this,
                            "Qual o dia do mês em que nasceu? [1-31]"));
                    int mes = Integer.parseInt(JOptionPane.showInputDialog(this,
                            "Qual o mês em que nasceu?[1-12]"));
                    boolean cadastrou = agenda.cadastraContato(nome, dia, mes);
                    if (cadastrou) {
                        JOptionPane.showMessageDialog(this,
                                "Aniversariante cadastrado");
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "Aniversariante não foi cadastrado. " +
                                        "Verifique se já não existia");
                    }
                });
        barraDeMenu.add(menuCadastrar);
        barraDeMenu.add(menuPesquisar);
        barraDeMenu.add(menuRemover);
        setJMenuBar(barraDeMenu);
    }

    //...
    public static void main(String[] args) {
        JFrame janela = new AgendaGUIV3ComMenu();
        janela.setVisible(true);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

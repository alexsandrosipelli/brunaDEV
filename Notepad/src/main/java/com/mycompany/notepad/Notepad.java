/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.notepad;

/**
 *
 * @author alexsandro
 */
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

import javax.swing.JMenuBar;

/**
 *
 * @author leonildo.carnevalli
 */
public class Notepad extends JFrame implements ActionListener {

    /*obj barra menu*/
    JMenuBar barraMenu = new JMenuBar();
    /*menus*/
    JMenu arquivo = new JMenu("Arquivo");
    JMenu editar = new JMenu("Editar");
    JMenu sobre = new JMenu("Sobre");

    /* itens do da opção arquivo*/
    JMenuItem novoArquivo = new JMenuItem("Novo");
    JMenuItem abrirArquivo = new JMenuItem("Abrir");
    JMenuItem salvarArquivo = new JMenuItem("Salvar");
    JMenuItem sair = new JMenuItem("Sair");

    /*itens da opção editar*/
    JMenuItem colar = new JMenuItem("Colar");
    JMenuItem cortar = new JMenuItem("Cortar");
    JMenuItem copiar = new JMenuItem("Copiar");
    JMenuItem selecionarTudo = new JMenuItem("selecionar Tudo");
    /*item sobre */
    JMenuItem sobreitem = new JMenuItem("sobre");

    /*area de texto*/
    JTextArea areaTexto = new JTextArea();

    Notepad() {
        setTitle("Aplicativo Notepad");
        setBounds(300, 200, 1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setJMenuBar(barraMenu);

        barraMenu.add(arquivo);
        barraMenu.add(editar);
        barraMenu.add(sobre);

        arquivo.add(novoArquivo);
        arquivo.add(abrirArquivo);
        arquivo.add(salvarArquivo);
        arquivo.add(sair);

        editar.add(colar);
        editar.add(cortar);
        editar.add(copiar);
        editar.add(selecionarTudo);

        sobre.add(sobreitem);

        JScrollPane telaPrincipalRolagem = new JScrollPane(areaTexto);
        add(telaPrincipalRolagem);

        areaTexto.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        areaTexto.setLineWrap(true);
        areaTexto.setWrapStyleWord(true);

        novoArquivo.addActionListener(this);
        abrirArquivo.addActionListener(this);
        salvarArquivo.addActionListener(this);
        sair.addActionListener(this);
        sobreitem.addActionListener(this);
        selecionarTudo.addActionListener(this);
        cortar.addActionListener(this);
        copiar.addActionListener(this);
        colar.addActionListener(this);

    }

    public static void main(String[] args) {
        new Notepad().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getActionCommand().equalsIgnoreCase("Novo")) {
            areaTexto.setText(null);

        } else if (e.getActionCommand().equalsIgnoreCase("ABRIR")) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                public boolean accept(File file) {
                    return file.isDirectory() || file.getName().toLowerCase().endsWith(".txt");
                }

                @Override
                public String getDescription() {
                    return "  Arquivos de Texto (*.txt)";
                }
            });

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    FileReader reader = new FileReader(selectedFile);
                    areaTexto.read(reader, null);
                    reader.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
            /*colocar o cod para procurar  no aquirvos do pc*/

        } else if (e.getActionCommand().equalsIgnoreCase("Salvar")) {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String filePath = selectedFile.getAbsolutePath();
                if (!filePath.toLowerCase().endsWith(".txt")) {
                    selectedFile = new File(filePath + ".txt");
                }
                if (selectedFile.exists()) {
                    int overwrite = JOptionPane.showConfirmDialog(this,
                            "O arquivo já existe. Deseja sobrescrever?",
                            "Confirmar Sobrescrita",
                            JOptionPane.YES_NO_OPTION);
                    if (overwrite == JOptionPane.NO_OPTION) {
                        return;
                    }
                }
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(selectedFile));
                    writer.write(areaTexto.getText());
                    writer.close();
                    JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        } else if (e.getActionCommand().equalsIgnoreCase("Sair")) {
            System.exit(0);
        } else if (e.getActionCommand().equalsIgnoreCase("sobre")) {
            JOptionPane.showMessageDialog(null, "Desenvolvido por Alexsandro Lopes Sipelli \n "
                    + "E tem serve para anotar e salvar texto ");
        } else if (e.getActionCommand().equalsIgnoreCase("selecionar tudo")) {
            areaTexto.selectAll();

        } else if (e.getActionCommand().equalsIgnoreCase("copiar")) {

            areaTexto.copy();

        } else if (e.getActionCommand().equalsIgnoreCase("colar")) {
            areaTexto.paste();

        } else if (e.getActionCommand().equalsIgnoreCase("cortar")) {
            areaTexto.cut();

        }

    }

}

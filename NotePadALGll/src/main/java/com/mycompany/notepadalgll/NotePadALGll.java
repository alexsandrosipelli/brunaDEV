/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.notepadalgll;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

/**
 *
 * @author alexsandro
 */
public class NotePadALGll extends JFrame implements ActionListener {

    /* Criando o MenuBar para acrescentar  menu e depois os itens do menu*/
    JMenuBar menuBar = new JMenuBar();
    /*criando os menus para criar ele, tem como criar com o construtor vazio e passando o paramentro de String que vai ser o nome do menu */
    JMenu arquivo = new JMenu("Arquivo");
    JMenu editar = new JMenu("Editar");
    JMenu sobre = new JMenu("Sobre");
    /* criando o itens menu as Strings que vai sendo passada no parametro vai sendo os nomes */
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
    /*criar a area de texto */
    JTextArea areaTexto = new JTextArea();

    /*agora criando o construtor da classe para inicializar e adcionar os items menu*/
    NotePadALGll() {
        setTitle("NotePad do alexsandro ");
        setBounds(300, 400, 400, 400);
        setLocationRelativeTo(null);
        /*aqui é para quando fechar  a janela e fechar completamente no parametro exit on close */
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*agora adiconando o menu */
        setJMenuBar(menuBar);
        /*aqui passando para o menu bara as opçoes de menu */
        menuBar.add(arquivo);
        menuBar.add(editar);
        menuBar.add(sobre);
        /*aqui passando para a opçao de arquivo as opçoes do item menu*/
        arquivo.add(novoArquivo);
        arquivo.add(abrirArquivo);
        arquivo.add(salvarArquivo);
        arquivo.add(sair);
        /*aqui passando para a opçao de editar as opçoes do item menu*/

        editar.add(colar);
        editar.add(cortar);
        editar.add(copiar);
        editar.add(selecionarTudo);
        /*e no sobre tambem esta sendo passado*/
        sobre.add(sobreitem);
        /*criando o obj do JScrollPane para da  scroll na area de texto*/
        JScrollPane rolagem = new JScrollPane(areaTexto);
        /*aqui adcionando o obj de scroll ao Frame*/
        add(rolagem);
        /*comfigurando o texto*/
 /*aqui a fonte,estilo e tamanho*/
        areaTexto.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
        /*aqui para quebrar linha*/
        areaTexto.setLineWrap(true);
        /*e aqui para nao quebrar as palavras como true, quando ocorrer a quebra de linha*/
        areaTexto.setWrapStyleWord(true);
        /*criando os listener dos itens menu*/
        novoArquivo.addActionListener(this);
        abrirArquivo.addActionListener(this);
        salvarArquivo.addActionListener(this);
        sair.addActionListener(this);
        sobreitem.addActionListener(this);
        selecionarTudo.addActionListener(this);
        cortar.addActionListener(this);
        copiar.addActionListener(this);
        colar.addActionListener(this);
        copiar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        colar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        cortar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        selecionarTudo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        novoArquivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        abrirArquivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        salvarArquivo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        sair.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.ALT_DOWN_MASK));
        sobreitem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_DOWN_MASK));

    }

    /* void main para chamar deixa atela visivel */
    public static void main(String[] args) {
        new NotePadALGll().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*o void actionPerfomed, vai validando qual vai ser a resposta do usuario e e ignorando se for letra maiuscular ou moinuscular
        com o ignoreCase*/
        if (e.getActionCommand().equalsIgnoreCase("Novo")) {
            JOptionPane.showMessageDialog(null, "tem certeza que deseja limpar o texto \n A area toda sera limpa !!");
            /*quando clicar em novo ira limpar todo o texto da area de texto com o parametro null*/
            areaTexto.setText(null);

        } else if (e.getActionCommand().equalsIgnoreCase("ABRIR")) {
            /*Criando o obj do JfileChoosser */
            JFileChooser escolha = new JFileChooser();
            /* aqui criando o filtro*/
            escolha.setFileFilter(new javax.swing.filechooser.FileFilter() {
                @Override
                /*aqui esta verificando se é um diretorio ou se o o nome do arquivo termina com .txt, assim vai abrir somente esses */

                public boolean accept(File arquivo) {
                    return arquivo.isDirectory() || arquivo.getName().toLowerCase().endsWith(".txt");

                }

                @Override
                /*como é implements esse GetDescription serve para a mensagem que vai aparecer na caixa que irá abrir para pesquisar os arquivos*/

                public String getDescription() {
                    return " Apenas Arquivos de Texto (*.txt)";
                }
            });
            /*aqui a escolha do usuario irá retonar um int dai, abaixo no if ira validar e for o de aprovar*/
            int respostaUsuario = escolha.showOpenDialog(this);
            if (respostaUsuario == JFileChooser.APPROVE_OPTION) {
                File selectedFile = escolha.getSelectedFile();
                try {
                    /*aqui no try vai ler o arquivo com um obj de FileReader que ler ele e apos a leitura se fecha*/
                    FileReader lerArquivo = new FileReader(selectedFile);
                    areaTexto.read(lerArquivo, null);
                    lerArquivo.close();
                } catch (IOException ex) {
                    /*aqui a mensagem  caso nao der para ler o arquivo*/
                    JOptionPane.showMessageDialog(this, "Erro ao abrir o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }

        }/*e aqui encerra a opçao de abrir o arquivo*/ else if (e.getActionCommand().equalsIgnoreCase("Salvar")) {
            JFileChooser escolha = new JFileChooser();
            int respostaUsuario = escolha.showSaveDialog(this);
            if (respostaUsuario == JFileChooser.APPROVE_OPTION) {
                /*aqui oque ocorre de diferente é criando um obj de File para salvar e depois validar se ja exite ele no local de salvar, 
                se caso houver perguntar se quer sobrescrever ele */

 /*aqui o arquivo selecionado é amarzenado na variavel do tipo File para depois ser validada*/
                File arquivoSelecionado = escolha.getSelectedFile();
                /*aqui é criado uma variavel do tipo String para amazenar o local exato onde o arquivo esta pegando com o arquivoselecionado.getAbolutPach */
                String localDoAquivo = arquivoSelecionado.getAbsolutePath();
                /*o if vai validar se o local do arquivo final termina em .txt, assim se nao terminar ele cria um arquivo para poder ser manipulado usando 
                o new File*/
                if (!localDoAquivo.toLowerCase().endsWith(".txt")) {
                    arquivoSelecionado = new File(localDoAquivo + ".txt");
                }
                /*aqui se o arquivoselecionado para salvar ja exitir no local de salvar pergunta com uma janela de confirmaçao se deseja sobreescrever*/
                if (arquivoSelecionado.exists()) {
                    int respostaDoUsuario = JOptionPane.showConfirmDialog(this,
                            "O arquivo já existe. Deseja sobrescrever?",
                            "Confirmar Sobrescrita",
                            JOptionPane.YES_NO_OPTION);
                    /*se caso a resposta for nao retorna */
                    if (respostaDoUsuario == JOptionPane.NO_OPTION) {
                        return;
                    }
                }
                try {/*se caso for sim ou se caso nao tiver um arquivo com o mesmo nome  assim cria um obj do BufferedWriter
                    para escrever o txt pegando oque estiver na area de texto, com o areaTexto.getText() e apos fecha*/
                    BufferedWriter escritor = new BufferedWriter(new FileWriter(arquivoSelecionado));
                    escritor.write(areaTexto.getText());
                    escritor.close();
                    /*apos excutar a respota de sucesso ou se caso der  algum erro o catch é acionado e mostra a mensagem de erro */
                    JOptionPane.showMessageDialog(this, "Arquivo salvo com sucesso!");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar o arquivo", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else if (e.getActionCommand().equalsIgnoreCase("Sair")) {
            int respostaDoUsuario = JOptionPane.showConfirmDialog(null, "Deseja sair ?", "SAIR", JOptionPane.YES_NO_CANCEL_OPTION);
            if (respostaDoUsuario == JOptionPane.YES_OPTION) {
                System.exit(0);
            }

        } else if (e.getActionCommand().equalsIgnoreCase("sobre")) {
            JOptionPane.showMessageDialog(null, "Desenvolvido por Alexsandro Lopes Sipelli, \n"
                    + "esta aplicação foi criada com o propósito de facilitar a anotação e o armazenamento \n"
                    + "de texto, permitindo a criação de arquivos no formato TXT. Além disso, o objetivo\n"
                    + " principal é reforçar o aprendizado da disciplina de Algoritmos 2, ministrada pelo \n"
                    + "professor Leonildo Carnevalli."
                    + "Desenvolvido dia 04, de junho de 2023 as 15:12:47 ");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author 04399704233
 */
public class Rodada {
    
    private Palavra palavra;
    private Jogador enforcador;
    private Jogador enforcado;
    private String[] cemiterio;
    private int chancesUsadas;
    
    
    public Rodada (Palavra palavra, Jogador enforcador, Jogador enforcado){
        this.enforcado = enforcado;
        this.enforcador = enforcador;
        this.palavra = palavra;
        
    }
    
    public Rodada (Palavra palavra){
        this.palavra = palavra;
    }
    //Método responsável por gerar as mensagens da forca 
    private String gerarMensagem (Rodada rodada){
        String msg = "";
        
        switch (chancesUsadas){
                case 0:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       "
                      + "\n|       "
                      + "\n|        "
                      + "\n|       ";
                case 1:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       "
                      + "\n|        "
                      + "\n|       ";
                case 2:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /"
                      + "\n|        "
                      + "\n|         ";
                case 3:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       / \\"
                      + "\n|        "
                      + "\n|       ";
                case 4:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|\\"
                      + "\n|        |"
                      + "\n|       ";
                case 5:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|\\"
                      + "\n|        |"
                      + "\n|       / ";
                case 6:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|\\"
                      + "\n|        |"
                      + "\n|       / \\";
        }
        return msg;
        
    }
    
    boolean verificarTentativa(String tentativa){
        return false;
    }
    
    //Método que recebe a rodada e gerencia o jogo dela
    public void jogarRodada (Rodada rodada){
        boolean condicaoParada = false;
        while (condicaoParada == false){
            String tentativa = JOptionPane.showInputDialog(gerarMensagem(rodada));
            if (tentativa.length() > 1){
                JOptionPane.showMessageDialog(null,"Digite apenas uma letra");                
            }
            else {
                condicaoParada = verificarTentativa(tentativa);
                
            }
        }
        
    }

    /**
     * @return the palavra
     */
    public Palavra getPalavra() {
        return palavra;
    }

    /**
     * @param palavra the palavra to set
     */
    public void setPalavra(Palavra palavra) {
        this.palavra = palavra;
    }

    /**
     * @return the enforcador
     */
    public Jogador getEnforcador() {
        return enforcador;
    }

    /**
     * @param enforcador the enforcador to set
     */
    public void setEnforcador(Jogador enforcador) {
        this.enforcador = enforcador;
    }

    /**
     * @return the enforcado
     */
    public Jogador getEnforcado() {
        return enforcado;
    }

    /**
     * @param enforcado the enforcado to set
     */
    public void setEnforcado(Jogador enforcado) {
        this.enforcado = enforcado;
    }

    /**
     * @return the cemiterio
     */
    public String[] getCemiterio() {
        return cemiterio;
    }

    /**
     * @param cemiterio the cemiterio to set
     */
    public void setCemiterio(String[] cemiterio) {
        this.cemiterio = cemiterio;
    }

    /**
     * @return the chancesUsadas
     */
    public int getChancesUsadas() {
        return chancesUsadas;
    }

    /**
     * @param chancesUsadas the chancesUsadas to set
     */
    public void setChancesUsadas() {
        this.chancesUsadas = chancesUsadas+1;
    }
    
    
}

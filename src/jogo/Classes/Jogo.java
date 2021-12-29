/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.Classes;

/**
 *
 * @author 04399704233
 */
public class Jogo {
    
    private Palavra palavra;
    private Jogador enforcador;
    private Jogador enforcado;
    private String[] cemiterio;
    private int chancesUsadas;
    
    
    public Jogo (Palavra palavra, Jogador enforcador, Jogador enforcado){
        this.enforcado = enforcado;
        this.enforcador = enforcador;
        this.palavra = palavra;
        
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

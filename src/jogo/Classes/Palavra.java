/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.Classes;

/**
 *
 * @author 04399704233
 */
public class Palavra {
    private String palavra;
    private Jogador enforcador;
    private Jogador enforcado;
    private String dica;
    private String[] cemiterio;
    // Getters e Setters
    public String getPalavra (){
        return this.palavra;
    }
    public void setPalavra (String palavra){
        this.palavra = palavra;
    }
    
    public Jogador getEnforcador (){
        return this.enforcador;
    }
    public void setEnforcador(Jogador enforcador){
        this.enforcador = enforcador;
    }
    
    public Jogador getEnforcado (){
        return this.enforcador;
    }
    public void setEnforcado(Jogador enforcado){
        this.enforcado = enforcado;
    }
    
    public String getDica (){
        return this.dica;
    }
    public void setDica (String dica){
        this.dica = dica;
    }
    
    
    
}

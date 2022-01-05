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
    private String dica;
    
    //Construtor
    public Palavra (String palavra, String dica){
        this.palavra = palavra;
        this.dica = dica;
    }
    
    
    // Getters e Setters
    public String getPalavra (){
        return this.palavra;
    }
    public void setPalavra (String palavra){
        this.palavra = palavra;
    }
    
   
    public String getDica (){
        return this.dica;
    }
    public void setDica (String dica){
        this.dica = dica;
    }
    
    
    
}

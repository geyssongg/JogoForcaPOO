/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jogo.Classes;

import java.util.Arrays;
import javax.swing.JOptionPane;

/**
 *
 * @author 04399704233
 */
public class Rodada {

    /**
     * @return the letrasAcertadas
     */
    public String[] getLetrasAcertadas() {
        return letrasAcertadas;
    }

    /**
     * @param letrasAcertadas the letrasAcertadas to set
     */
    public void setLetrasAcertadas(String[] letrasAcertadas) {
        this.letrasAcertadas = letrasAcertadas;
    }
    
    private Palavra palavra;
    private Jogador enforcador;
    private Jogador enforcado;
    private String[] cemiterio;
    private String[] letrasAcertadas;
    private int chancesUsadas;
    
    
    public Rodada (Palavra palavra){
        /*this.enforcado = enforcado;
        this.enforcador = enforcador;*/
        this.chancesUsadas = 0;
        this.palavra = palavra;
        this.letrasAcertadas = new String[palavra.getPalavra().length()];
        for (int i = 0 ; i < letrasAcertadas.length ; i++){
            letrasAcertadas[i] = "0";
        }
        
        this.cemiterio = new String[6];
        for (int i = 0 ; i < cemiterio.length ; i++){
            cemiterio[i] = "0";
        }
    }
    
    /*public Rodada (Palavra palavra){
        this.palavra = palavra;
    }*/
    //Método responsável por gerar as mensagens da forca 
    private String gerarMensagem (Rodada rodada){
        String msg = "";
        
        switch (chancesUsadas){
                case 0:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       "
                      + "\n|       "
                      + "\n|        ";
                    break;
                case 1:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       "
                      + "\n|        ";
                    break;
                case 2:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /"
                      + "\n|        ";
                    break;
                case 3:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|"
                      + "\n|        ";
                    break;
                case 4:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|\\"
                      + "\n|        ";
                    break;
                case 5:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|\\"
                      + "\n|       / ";
                    break;
                case 6:
                    msg = " ____"
                      + "\n|        |"
                      + "\n|       O"
                      + "\n|       /|\\"
                      + "\n|       / \\";
                    break;
        }
        String impressaoCemiterio = "";
        for (int i = 0 ; i < cemiterio.length ; i++){
            impressaoCemiterio += " "+cemiterio[i];
        }
        
        String[] arrayMostraEstado = new String[palavra.getPalavra().length()];
        Arrays.fill(arrayMostraEstado, "_ ");
        String aux = Arrays.toString(letrasAcertadas);
        
        
        String[] palavraToArray = new String[palavra.getPalavra().length()];
        
        for (int i = 0 ; i < this.palavra.getPalavra().length();i++){
            char auxChar = palavra.getPalavra().charAt(i);
            
            palavraToArray[i] = auxChar + "";
        }
        
        
        for (int i = 0 ; i < palavraToArray.length ; i++){
            
            if (aux.contains(palavraToArray[i])){
                arrayMostraEstado[i] = palavraToArray[i];
            }
        }   
        
        //Estado da palavra
        msg += "\n Estado da palavra " + Arrays.toString(arrayMostraEstado);
        
        msg += "\n Letras do cemiterio:" +impressaoCemiterio;
        return msg;
        
    }
    boolean verificaCemiterio (String tentativa){
        for (int i = 0 ; i < cemiterio.length ; i++){
            if (cemiterio[i].equals(tentativa)){
                return true;
            }
        }
        return false;        
    }
    
    boolean contemTentativa(String tentativa){
         
        Boolean contem = this.palavra.getPalavra().toLowerCase().contains(tentativa.toLowerCase());
        
        if(contem == false){             
            return false;
        }
        else {
            return true;
        }
    }
    
    //Método que recebe a rodada e gerencia o jogo dela
    public void jogarRodada (Rodada rodada){
        boolean condicaoParada = false;
        while (condicaoParada == false){
            // Mostrar estado da forca -- mostrar estado da palavra
            String tentativa = JOptionPane.showInputDialog(gerarMensagem(rodada));
            if (tentativa.length() > 1){
                JOptionPane.showMessageDialog(null,"Digite apenas uma letra");                
            }
            else {
                if (verificaCemiterio(tentativa)){
                    JOptionPane.showMessageDialog(null,"Você digitou uma letra que já foi inserida");
                }
                else {                    
                    boolean contemTentativa = contemTentativa(tentativa);
                    if (contemTentativa == true){
                        //código pra colocar a palavra como tentativa correta
                        boolean letraJaEscrita = false;
                        for (int i = 0 ; i < this.letrasAcertadas.length ; i++){
                            if (letrasAcertadas[i].equals(tentativa)){
                                JOptionPane.showMessageDialog(null,"Você digitou uma letra que já foi inserida");
                                letraJaEscrita = true;
                                break;
                            }
                        }
                        if (letraJaEscrita == false){
                           for (int i = 0 ; i < this.letrasAcertadas.length ; i++){
                                if (letrasAcertadas[i].equals("0")){
                                    letrasAcertadas[i] = tentativa;
                                    break;
                                }
                            } 
                        }
                        
                    }
                    else {
                        if(chancesUsadas < 6){
                            this.chancesUsadas++;
                            if(chancesUsadas == 6){
                                JOptionPane.showMessageDialog(null,"O enforcador ganhou");
                                break;
                            }
                            else{
                                for (int i = 0 ; i < this.cemiterio.length ; i++){
                                    if(cemiterio[i].equals("0") == true){
                                        cemiterio[i] = tentativa;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
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

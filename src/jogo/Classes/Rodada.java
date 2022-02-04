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
    
    
    public Rodada (Palavra palavra, Jogador enforcador, Jogador enforcado){
        this.enforcado = enforcado;
        this.enforcador = enforcador;
        this.chancesUsadas = 0;
        this.palavra = palavra;
        this.letrasAcertadas = new String[palavra.getPalavra().length()];
        for (int i = 0 ; i < letrasAcertadas.length ; i++){
            letrasAcertadas[i] = " ";
        }
        
        this.cemiterio = new String[6];
        for (int i = 0 ; i < cemiterio.length ; i++){
            cemiterio[i] = " ";
        }
    }
    
    //Esse método retorna uma string contendo o desenho atual da forca, usando um switch para os possiveis desenhos da forca
    private String gerarDesenhoForca(Rodada rodada){
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
        return msg;
    }
    
    
    //Método responsável por gerar as mensagens da forca 
    private String gerarMensagem (Rodada rodada){
        String msg = "";        
        //Criando uma array para mostrar o estado da palavra
        String[] arrayMostraEstado = new String[palavra.getPalavra().length()];
        Arrays.fill(arrayMostraEstado, "_ ");
        //Transformando as array de letras acertadas em uma string para que possa ser feito a comparação das tentativas acertadas
        //Com as letras da palavra
        String aux = Arrays.toString(letrasAcertadas);
        
        //A variavel palavraToArray é uma array com os chars separados da palavra
        String[] palavraToArray = new String[palavra.getPalavra().length()];
        
        //Preenchendo a array palavraToArray
        for (int i = 0 ; i < this.palavra.getPalavra().length();i++){
            char auxChar = palavra.getPalavra().charAt(i);
            palavraToArray[i] = auxChar + "";
        }
        
        //Percorrendo a palavra e trocando os "_" pelas letras na posição correspondente
        for (int i = 0 ; i < palavraToArray.length ; i++){      
            
            if (aux.contains(palavraToArray[i])){
                arrayMostraEstado[i] = palavraToArray[i];
            }
        }   
        
        //Verifica o estado da palavra, caso contenha "_" ainda existem letras para serem adivinhadas
        if(Arrays.toString(arrayMostraEstado).contains("_")){
            msg += gerarDesenhoForca(rodada);
            msg += "\n Estado da palavra:" + Arrays.toString(arrayMostraEstado);
            msg += "\n Letras do cemiterio:" +impressaoCemiterio();
            msg += "\n Dica: " +rodada.palavra.getDica();
            
        }
        //Caso não exista, retorna a string e que o enforcado ganhou, para que o metodo jogarRodada faça a verificação
        else {
            msg = "enforcadoGanhou";
        }
        return msg;       
    }
    
    //Esse método retorna uma string mostrando o estado atual do cemitério
    private String impressaoCemiterio (){
        String cemiterioString = "";
            for (int i = 0 ; i < cemiterio.length ; i++){
                cemiterioString += " "+cemiterio[i];
            }
        return cemiterioString;
    }
    
    /*Esse método retorna verdadeiro caso a letra digitada já esteja no cemitério, caso não, retorna falso */
    private boolean verificaCemiterio (String tentativa){
        for (int i = 0 ; i < cemiterio.length ; i++){
            if (cemiterio[i].equals(tentativa)){
                return true;
            }
        }
        return false;        
    }
    //Esse método retorna um booleano true caso a tentativa usada esteja na palavra ou false caso a tentativa não esteja contida na palavra
    
    private boolean contemTentativa(String tentativa){
        Boolean contem = this.palavra.getPalavra().toLowerCase().contains(tentativa.toLowerCase());
        if(contem == false){             
            return false;
        }
        else {
            return true;
        }
    }
    
    //Esse método é chamado quando o enforcado ganha, gerando a mensagem e a retornando em uma String
    private String gerarMensagemEnforcadoGanhou (Rodada rodada){
        String msg = "";
        msg += "O enforcado, "+rodada.getEnforcado().getNome()+", ganhou!" 
                +"\nEstado da forca:\n"+ gerarDesenhoForca(rodada)
                +"\nCemitério de letras: " +impressaoCemiterio()                
                +"Palavra:" +rodada.getPalavra().getPalavra();
        return msg;
    }
    
    //Esse método é chamado quando o enforcador ganha, gerando a mensagem e a retornando em uma String
    private String gerarMensagemEnforcadorGanhou(Rodada rodada){
        String msg = "";
        msg += "O enforcador, " + rodada.getEnforcador().getNome()+",ganhou!"
                +"\nEstado da forca: \n"+gerarDesenhoForca(rodada)
                +"\nCemitério de letras: " +impressaoCemiterio()
                +"\nPalavra: " +rodada.getPalavra().getPalavra();
        return msg;
    }
    
    //Método que recebe a rodada e gerencia o jogo dela
    public void jogarRodada (Rodada rodada){
        
        //Loop que persiste até que um dos jogadores ganhe
        while (true){
            
            // Mostrar estado da forca -- mostrar estado da palavra
            String mensagemForca = gerarMensagem(rodada);
            
            //Condição para caso a mensagem retornada seja a do enforcado ter ganhado
            if (mensagemForca.equals("enforcadoGanhou")){
                JOptionPane.showMessageDialog(null,gerarMensagemEnforcadoGanhou(rodada));
                return;
            }
            
            //Geração da mensagem que será apresentada na tentativa
            String tentativa = JOptionPane.showInputDialog(gerarMensagem(rodada));
            tentativa = tentativa.toLowerCase();
            
            //Verificação de quantas letras o usuário inseriu na tentativa, caso seja mais que uma
            if (tentativa.length() > 1){
                JOptionPane.showMessageDialog(null,"Digite apenas uma letra");                
            }
            
            //Caso a tentativa seja valida
            else {
                //Chama a função verificaCemiterio para verificar se a letra já foi inserida
                if (verificaCemiterio(tentativa)){
                    JOptionPane.showMessageDialog(null,"Você digitou uma letra que já foi inserida");
                }
                
                //Caso a tentativa não esteja no cemitério é feito a verificação de certa ou errada
                else {                    
                    //Chamada da função contemTentativa, para verificar se a tentativa está contida na palavra
                    boolean contemTentativa = contemTentativa(tentativa);
                    //Caso a tentativa esteja na palavra
                    if (contemTentativa == true){
                        //Verifica se a letra já não foi escrita na palavra, caso já tenha sido escrita muda o booleano
                        // letraJaEscrita para verdadeiro
                        boolean letraJaEscrita = false;
                        for (int i = 0 ; i < this.letrasAcertadas.length ; i++){
                            if (letrasAcertadas[i].equals(tentativa)){
                                JOptionPane.showMessageDialog(null,"Você digitou uma letra que já foi inserida");
                                letraJaEscrita = true;
                                break;
                            }
                        }
                        //Caso o booleano não seja mudado para verdadeiro, a tentativa está na palavra 
                        //Então é feito a lógica para colocar a letra na array de letras acertadas
                        if (letraJaEscrita == false){
                           for (int i = 0 ; i < this.letrasAcertadas.length ; i++){
                                if (letrasAcertadas[i].equals(" ")){
                                    letrasAcertadas[i] = tentativa;
                                    break;
                                }
                            } 
                        }
                        
                    }
                    //Caso a palavra não contenha a tentativa, é feito o acrescimo da tentativa no cemitério
                    //E somado a variavel chancesUsadas +1
                    else {
                        //Verificando se o usuário ainda tem tentativas
                        if(chancesUsadas < 6){
                            setChancesUsadas();
                            //Caso ele já tenha usado as 5 e erre mais uma, ele ira para 6 tentivas erradas
                            //O que finaliza o jogo, dando vitória ao enforcador
                            if(chancesUsadas == 6){
                                JOptionPane.showMessageDialog(null,gerarMensagemEnforcadorGanhou(rodada));
                                return;
                            }
                            //Caso ainda lhe reste tentativas é feito o acrescimo da variavel chancesUsadas
                            else{
                                for (int i = 0 ; i < this.cemiterio.length ; i++){
                                    if(cemiterio[i].equals(" ") == true){
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

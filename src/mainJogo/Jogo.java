/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainJogo;
import javax.swing.JOptionPane;
import jogo.Classes.Jogador;
import jogo.Classes.Palavra;

/**
 *
 * @author 04399704233
 */
public class Jogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        
        jogador1.setNome(javax.swing.JOptionPane.showInputDialog("Digite o nome do 1º jogador"));        
        jogador2.setNome(javax.swing.JOptionPane.showInputDialog("Digite o nome do 2º jogador"));
        
        boolean continua = true;
        int enforcadorAtual = 1;
        Palavra palavras[];
        
        while (continua){
            Palavra palavra = new Palavra();
            if (enforcadorAtual == 1){
                palavra.setEnforcador(jogador1);
                palavra.setEnforcado(jogador2);
            }
            else{                
                palavra.setEnforcado(jogador1);
                palavra.setEnforcador(jogador2);
            }
            
            palavra.setPalavra(javax.swing.JOptionPane.showInputDialog("Digite a palavra"));
            if (palavra.getPalavra() == "exit"){
                continua = false;
                break;
            }
            palavra.setDica(javax.swing.JOptionPane.showInputDialog("Digite a dica"));
        }
    }
    
}

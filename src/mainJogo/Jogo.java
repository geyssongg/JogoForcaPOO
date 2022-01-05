/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainJogo;
import javax.swing.JOptionPane;
import jogo.Classes.Jogador;
import jogo.Classes.Palavra;
import jogo.Classes.Rodada;

/**
 *
 * @author 04399704233
 */
public class Jogo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Jogador jogador1 = new Jogador();
        Jogador jogador2 = new Jogador();
        
        jogador1.setNome(javax.swing.JOptionPane.showInputDialog("Digite o nome do 1º jogador"));        
        jogador2.setNome(javax.swing.JOptionPane.showInputDialog("Digite o nome do 2º jogador"));
        
        int enforcadorAtual = 1;
        
        while (true){
            String palavra = javax.swing.JOptionPane.showInputDialog("Digite a palavra");
            if (palavra.equals("exit")){
                break;
            }
            
            String dica = javax.swing.JOptionPane.showInputDialog("Digite a dica"); 
            Palavra palavraOBJ = new Palavra (palavra,dica);
            
            if (enforcadorAtual == 1){
            Rodada rodada = new Rodada(palavraOBJ,jogador1,jogador2);
            enforcadorAtual = 2;
            rodada.jogarRodada(rodada);
            }
            else if (enforcadorAtual == 2){
            Rodada rodada = new Rodada(palavraOBJ,jogador2,jogador1);
            enforcadorAtual = 1;
            rodada.jogarRodada(rodada);
            }
            
            
        }*/
        String palavra = JOptionPane.showInputDialog("Digite a palavra");
        String dica = JOptionPane.showInputDialog("Digite a palavra");
        
        Palavra palavraOBJ  = new Palavra (palavra,dica);
        Rodada rodada = new Rodada (palavraOBJ);
        rodada.jogarRodada(rodada);
        
    }
    
}

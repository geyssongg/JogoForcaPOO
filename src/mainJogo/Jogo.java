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
        
        while (true){
            String palavra = javax.swing.JOptionPane.showInputDialog("Digite a palavra");
            if (palavra.equals("exit")){
                break;
            }
            if (enforcadorAtual == 1){
            Jogo jogo = new Jogo(jogador1,jogador2);
            }
            
        }
    }
    
}

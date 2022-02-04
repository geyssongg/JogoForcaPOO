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
        
        
        Jogador enforcador = new Jogador ();
        Jogador enforcado = new Jogador ();
        enforcador.setNome(JOptionPane.showInputDialog("Digite o nome do enforcador"));
        enforcado.setNome(JOptionPane.showInputDialog("Digite o nome do enforcado"));
        String palavra = JOptionPane.showInputDialog("Digite a palavra");
        String dica = JOptionPane.showInputDialog("Digite a dica");
        
        
        Palavra palavraOBJ  = new Palavra (palavra.toLowerCase(),dica);
        Rodada rodada = new Rodada (palavraOBJ,enforcador,enforcado);
        rodada.jogarRodada(rodada);
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import javax.swing.JFrame;

/**
 *
 * @author viniciusduarte
 */
public class JogoApp {
    
    public static void inicia(Jogo jogo){
        JFrame janela = new JFrame(jogo.getTitulo());
        janela.setSize(jogo.getLargura(), jogo.getAltura());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JogoComponent comp = new JogoComponent(jogo);
        janela.add(comp);
        janela.setVisible(true);
        comp.requestFocus();
        
        JogoLoop loop = new JogoLoop(jogo, comp);
        loop.start();
    }
    
}

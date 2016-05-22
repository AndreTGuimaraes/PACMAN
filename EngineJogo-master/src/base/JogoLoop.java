/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author viniciusduarte
 */
public class JogoLoop extends Thread {
    private final Jogo jogo;
    private final JogoComponent comp;

    public JogoLoop(Jogo jogo, JogoComponent comp) {
        this.jogo = jogo;
        this.comp = comp;
    }
    
    @Override
    public void run(){
        jogo.inicia();
        
        while(!jogo.terminou()){
            jogo.atualiza();
            comp.repaint();
            try {
                Thread.sleep(jogo.getAtraso());
            } catch (InterruptedException ex) {
                Logger.getLogger(JogoLoop.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}

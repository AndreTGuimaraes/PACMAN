/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.JComponent;

/**
 *
 * @author viniciusduarte
 */
public class JogoComponent extends JComponent implements ComponentListener {

    private final Jogo jogo;

    public JogoComponent(Jogo jogo) {
        this.jogo = jogo;
        addKeyListener(this.jogo);
        requestFocusInWindow();
        addComponentListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        jogo.desenha((Graphics2D)g);
    }

    @Override
    public void componentResized(ComponentEvent e) {
    }

    @Override
    public void componentMoved(ComponentEvent e) {
    }

    @Override
    public void componentShown(ComponentEvent e) {
    }

    @Override
    public void componentHidden(ComponentEvent e) {
    }

}

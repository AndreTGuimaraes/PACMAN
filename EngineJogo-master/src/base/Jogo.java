/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author viniciusduarte
 */
public abstract class Jogo implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    
    //Variáveis protected: visíveis às subclasses
    //Valores padrão definidos
    protected String titulo = "Jogo Genérico";
    protected int largura = 800;
    protected int altura = 600;
    protected int atraso = 100;
    protected boolean terminou = false;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getLargura() {
        return largura;
    }

    public void setLargura(int largura) {
        this.largura = largura;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getAtraso() {
        return atraso;
    }

    public void setAtraso(int atraso) {
        this.atraso = atraso;
    }
    
    public boolean terminou(){
        return terminou;
    }
    
    public void setFim(boolean b){
        this.terminou = b;
    }
    
    public abstract void inicia();
    public abstract void desenha(Graphics2D g);
    public abstract void atualiza();
}

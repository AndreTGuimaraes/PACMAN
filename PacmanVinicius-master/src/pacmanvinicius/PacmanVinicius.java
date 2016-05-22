/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacmanvinicius;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author viniciusduarte
 */
public class PacmanVinicius extends base.Jogo {

    //Objeto para armazenar o PNG do pacman.
    BufferedImage pacman;

    //Tamanho fixo de cada boneco, em pixels.
    final int TAM = 28;

    //Quadro indicador de qual boneco pegar a cada momento.
    int quadro;

    //Posição x e y, em pixels, que o pacman estará a cada momento.
    int x, y;

    //Direcao para a qual o pacman vai.
    int direcao;

    //Altura real (Precisa disso no MAC, talvez em outros OS não precise.
    int alturaReal;

    //Mapa.
    private ArrayList<String> mapa;

    //Total de linhas e total de colunas que há no arquivo do mapa.
    private int totalLinhas;
    private int totalColunas;

    //Correspondência de posição no mapa com pixels na tela: 
    //cada posição tem quantos pixels?
    final int MAPA_X_PIXEL = 2;

    public static void main(String[] args) {
        base.JogoApp.inicia(new PacmanVinicius());
    }

    public PacmanVinicius() {
        titulo = "Pacman do Vinícius";
        atraso = 80;

        /*
         ATENÇÃO ESSA DIFERENCIAÇÃO DE ALTURA E ALTURA REAL TALVEZ NÃO SEJA
         NECESSÁRIA. CASO NÃO SEJA, APAGUE O CÓDIGO E FAÇA TUDO EM TERMOS DE
         ALTURA APENAS.        
         */
        //alturaReal = altura;
        //altura += 22;
        try {
            pacman = ImageIO.read(new File("imagens/pacman.png"));
        } catch (IOException ex) {
            Logger.getLogger(PacmanVinicius.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Quadro inicial
        quadro = 0;
        //Começa indo para a direita.
        direcao = KeyEvent.VK_RIGHT;

        try {
            //Leitura do mapa
            Scanner s = new Scanner(new File("mapas/mapa.txt"));
            mapa = new ArrayList<>();
            while (s.hasNextLine()) {
                mapa.add(s.next());
            }
            s.close();

            totalLinhas = mapa.size();
            totalColunas = mapa.get(0).length();

            largura = totalColunas * MAPA_X_PIXEL + TAM;
            alturaReal = totalLinhas * MAPA_X_PIXEL + TAM;
            //Ajuste necessário, pelo menos no MAC.
            altura = alturaReal + 22;
            System.out.println(largura + " " + altura);

            //Pegar a posição inicial do pacman. Onde está o 5 no mapa.
             int linha,coluna;
            linha=coluna =0;
                    
            while( linha <mapa.size()){
                if(mapa.get(linha).contains("5")){
                    coluna=mapa.get(linha).indexOf('5');
                      break;
                    
                }
                linha++;   
            }
            x =coluna;
            y = linha;

           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PacmanVinicius.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void inicia() {

    }

    @Override
    public void desenha(Graphics2D g) {
        for (int i = 0; i < totalLinhas; i++) {
            for (int j = 0; j < totalColunas; j++) {
                if (charAt(i, j) != '0') {
                    g.fillRect(j * MAPA_X_PIXEL , i * MAPA_X_PIXEL , TAM, TAM);
                }

            }
        }
        g.drawImage(pacman.getSubimage(quadro * 30, (direcao - 37) * 30, TAM, TAM),
                x * MAPA_X_PIXEL, y * MAPA_X_PIXEL, null);
    }

    @Override
    public void atualiza() {
        //atualização do quadro
        quadro++;
        if (quadro == 3) {
            quadro = 0;
        }

        switch (direcao) {
            //Vai andar de 1 em 1 MAPA_X_PIXEL, por padrão.
            case KeyEvent.VK_RIGHT:
                if (x < totalColunas - 1 && charAt(y,x+1) !='0' ) {
                 
                  x++;
                }
                break;
            case KeyEvent.VK_LEFT:
                if (x > 0 && charAt(y,x-1) !='0' ) {
                    x--;
                }
                break;
            case KeyEvent.VK_DOWN:
                if (y < totalLinhas - 1 && charAt(y+1,x) !='0') {
                    y++;
                }
                break;
            case KeyEvent.VK_UP:
                if (y > 0 && charAt(y-1,x) !='0') {
                    y--;
                }
                break;
        }
    }
//int direcaonova;
    //Método para responder ao teclado, somente setas.
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key > 36 && key < 41) {
            direcao = key;
            
          /*switch(direcao){
               case KeyEvent.VK_RIGHT:
                if ( charAt(y,x+1) !='0' ){
                    direcaonova=0;
                    
                }else{
                direcaonova=key;
                }
          }*/
        }
    }

    //Retorna o caracter que está na posição linha x coluna
    private char charAt(int linha, int coluna) {
        return mapa.get(linha).charAt(coluna);
    }

 
   

}

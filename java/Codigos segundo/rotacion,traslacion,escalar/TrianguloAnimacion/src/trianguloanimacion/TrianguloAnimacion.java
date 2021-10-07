/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public final class TrianguloAnimacion extends JFrame implements Runnable{

    public static void main(String[] args) {
        // TODO code application logic here
        TrianguloAnimacion window = new TrianguloAnimacion();
        
    }
    Thread t;
    
    //Parpadeo
     Image imag;
     Graphics gBuffer;
    
    
    
    public TrianguloAnimacion() {
        this.t = new Thread(this);
        
        byte a = 1;
        byte b= 1;
        setTitle("Window");
        setSize(600, 600);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        startHilo();
    }

     @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrianguloAnimacion.class.getName()).log(Level.SEVERE, null, ex);
            }getGraphics().setColor(Color.yellow);
                update(this.getGraphics());
        }        
    }
    public void startHilo(){
        this.t.start();
     }

    
    @Override

    public void update(Graphics g){
        paint(g);}
     
    @Override
    public void paint(Graphics g) {
        
        if(gBuffer==null){
          imag=createImage(this.getWidth(), this.getHeight());
          gBuffer=imag.getGraphics();
     }
     gBuffer.setColor(getBackground());
     gBuffer.fillRect(0,0, this.getWidth(), this.getHeight());
    //dibuja
     gBuffer.setColor(Color.black);
     //gBuffer.drawLine(100, 100, x, y);
    //Uso
     //dibujarCirculoPolar(50, triangulo.x1+300,triangulo.y1+300, Color.red);
     this.getGraphics().drawImage(imag, 0, 0, null);
 }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trianguloanimacion;

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
import sun.java2d.loops.DrawLine;

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
    
    
    Triangulo triangulo = new Triangulo(0 ,100, 100,0, -100, 0);
    
    public TrianguloAnimacion() {
        this.t = new Thread(this);
        
        byte a = 1;
        byte b= 1;
        setTitle("Window");
        setSize(600, 600);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        triangulo.start();
        startHilo();

    }
     @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            try {
                t.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrianguloAnimacion.class.getName()).log(Level.SEVERE, null, ex);
            }getGraphics().setColor(Color.yellow);
                update(this.getGraphics());
        }        
    }
    public void startHilo(){
        this.t.start();
     }

    public void putPixel(int x, int y, Color c) {
        BufferedImage bufferPixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        bufferPixel.setRGB(0, 0, c.getRGB());
        gBuffer.drawImage(bufferPixel, x, y, this);
    }
    //Bresenham
    public void putBresenham(int x0, int y0, int x1, int y1) {
        int x, y, dx, dy, p, A, B, pasox, pasoy;
        dx = (x1 - x0);
        dy = (y1 - y0);

        if (dy < 0) {
            dy = -dy;
            pasoy = -1;
        } else {
            pasoy = 1;
        }

        if (dx < 0) {
            dx = -dx;
            pasox = -1;
        } else {
            pasox = 1;
        }

        x = x0;
        y = y0;
        putPixel(x, y, Color.BLUE);
        if (dx > dy) {
            p = 2 * dy - dx;
            A = 2 * dy;
            B = 2 * (dy - dx);
            while (x != x1) {
                x = x + pasox;
                if (p < 0) {
                    p = p + A;
                } else {
                    y = y + pasoy;
                    p = p + B;
                }
                putPixel(x, y, Color.BLUE);
            }
        } else {
            p = 2 * dx - dy;
            A = 2 * dx;
            B = 2 * (dx - dy);
            while (y != y1) {
                y = y + pasoy;
                if (p < 0) {
                    p = p + B;
                } else {
                    x = x + pasox;
                    p = p + A;
                }
                putPixel(x, y, Color.BLUE);
            }
        }

    }
    public void putTrangle(int x1, int y1, int x2, int y2, int x3, int y3, Color c) {
        putLine(x1, y1, x2, y2,Color.black);
        putLine(x1, y1, x3, y3,Color.black);
        putLine(x3, y3, x2, y2,Color.black);
    }
    public void imprimirMatriz(int [][] matriz){
        for (int x=0; x < matriz.length; x++){
        for (int y=0; y < matriz[x].length; y++)
              System.out.print(" | " + matriz[x][y]+ " | ");   
        System.out.println("\n----------------------------------------");

}
    }
    
    //Paint
    
   
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
    putTrangle(triangulo.x1+300,triangulo.y1+300, triangulo.x2+300, triangulo.y2+300,triangulo.x3+300, triangulo.y3+300, Color.red);
    //Uso
     //dibujarCirculoPolar(50, triangulo.x1+300,triangulo.y1+300, Color.red);
     this.getGraphics().drawImage(imag, 0, 0, null);
 }
    
    public void putLine (int x1, int y1, int x2, int y2, Color color) {
        int x, y;
        int dx, dy;
        int incx, incy;
        int balance;

        if (x2 >= x1) {
            dx = x2 - x1;
            incx = 1;
        } else {
            dx = x1 - x2;
            incx = -1;
        }

        if (y2 >= y1) {
            dy = y2 - y1;
            incy = 1;
        } else {
            dy = y1 - y2;
            incy = -1;
        }

        x = x1;
        y = y1;

        if (dx >= dy) {
            dy <<= 1;
            balance = dy - dx;
            dx <<= 1;

            while (x != x2) {
                putPixel(x, y, color);
                if (balance >= 0) {
                    y += incy;
                    balance -= dx;
                }
                balance += dy;
                x += incx;
            }
            putPixel(x, y, color);
        } else {
            dx <<= 1;
            balance = dx - dy;
            dy <<= 1;

            while (y != y2) {
                putPixel(x, y, color);
                if (balance >= 0) {
                    x += incx;
                    balance -= dy;
                }
                balance += dx;
                y += incy;
            }
            putPixel(x, y, color);
        }

        return;
    }
    void dibujarCirculoPolar(int r, int xc, int yc,Color c) {
        double tt = Math.toRadians(0);
        // Punto inicial
        int x = r;
        int y = 0;
        double dy=0;
        double dx=0;
        while (tt <= 2*Math.PI) {
            if(x+xc<=xc*2){
                
            
            //System.out.println("trianguloanimacion.TrianguloAnimacion.dibujarCirculoPolar()");
            putPixel(x + xc, y + yc,c);}
            tt=tt+.01;
            dx = r * Math.cos(tt);
            x = (int) Math.round(dx);
            dy = r * Math.sin(tt);
            y = (int) dy;
        }
    }
}

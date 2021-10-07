/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package curvas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;


public class Curvas extends JFrame{
    
    private BufferedImage buffer;
    
    public static void main(String[] args) {
        Curvas window = new Curvas();
    }
    
    public Curvas() {
        setSize(600,600);
        setTitle("Curvas");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

        //LLAMAR LAS FUNCIONES
        funcion9_2();
    }

   
    
    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        
        
    }
    public void dibujarCarteciano(int x0,int y0){
        putLine(0, y0, 1000, y0, Color.black);
        putLine(x0, 1000, x0, 0, Color.black);
    }
    public void funcion5_1y2(int x0, int y0, double xIni, double xFinal, int steps) {
        dibujarCarteciano(x0, y0);

        int punto1x = x0, punto1y = y0, punto2x = x0, punto2y = y0;

        while (xIni <= xFinal) {

            punto2x = punto1x;
            punto2y = punto1y;

            double y = (Math.sin(xIni));

            punto1x = ((int) (50 * xIni) + x0);
            punto1y = ((int) (y0 - (150 * y)));

            putLine(punto1x, punto1y, punto2x, punto2y, Color.red);
            putPixel(punto1x, punto1y, Color.blue);

            xIni += xFinal / steps;
        }

    }
    public void funcion6(int x0, int y0, double xIni, double xFinal, int steps){
     

        dibujarCarteciano(x0, y0);
        
        int punto1x=x0, punto1y=y0,punto2x=x0,punto2y=y0;
       
        while (xIni<=xFinal) {
            
            punto2x=punto1x;
            punto2y=punto1y;
            
            double y =xIni*(Math.cos(4*xIni));
            
            punto1x=((int)(x0-50*xIni));
            punto1y=((int)(y0+(60*y)));
            
            
            putLine(punto1y, punto1x, punto2y, punto2x, Color.red);
            putPixel(punto1y,punto1x,Color.blue);
            
            xIni+=xFinal/steps;
            
           
        }
        
    }
    public void funcion7() {
        
        //dibujarCarteciano(x0, y0);
        int punto1x = 0, punto1y = 0, punto2x = 0, punto2y = 0;

        for (double t = 0; t <= 10; t=t+.1) {
            punto2x = punto1x;
            punto2y = punto1y;
            
            punto1x= (int) (300+(10*   (t-(3*Math.sin(t)))  ));
            punto1y= (int)(300-(10*   (4-(3*Math.cos(t)))   ));
            
            if(t!=0)
            putLine(punto1x, punto1y, punto2x, punto2y, Color.red);
            System.out.println("punto1x:"+(punto1x-300)+" punto1y: "+(punto1y-300)+" punto2x: "+ punto2x+" punto2y: "+punto2y);
        }

    }
    public void funcion8(int x0, int y0, double xIni, double xFinal, int steps,int r) {
        
        //dibujarCarteciano(x0, y0);
        double punto1x = x0, punto1y = y0, punto2x = x0, punto2y = y0;

        for (double t = 0; t <= 10; t= t+.1) {
            punto2x = punto1x;
            punto2y = punto1y;
            
            punto1x= (300+((2*(r*Math.sin(t))/(1+Math.pow(Math.cos(t), 2)))));
            punto1y= (300-((2*(r*Math.sin(t)*Math.cos(t))/(1+Math.pow(Math.cos(t), 2)))));
            
            
            putLine((int)punto1x, (int)punto1y, (int)punto2x, (int)punto2y, Color.magenta);
            System.out.println("t"+t+" punto1x:"+(punto1x-300)+" punto1y: "+(punto1y-300)+" punto2x: "+ punto2x+" punto2y: "+punto2y);
        }

    }
    public void funcion9() {
        
        //dibujarCarteciano(x0, y0);
        int punto1x = 0, punto1y = 0, punto2x = 0, punto2y = 0;

        for (double t = 0; t <= 14*Math.PI; t=t+.01) {
            punto2x = punto1x;
            punto2y = punto1y;
            
            punto1x= (int) (300+(100*  (Math.cos(t)+(.5)*Math.cos(7*t)+(.33)*Math.sin(17*t))     ));
            punto1y= (int) (300-(100*  (Math.sin(t)+(.5)*Math.sin(7*t)+(.33)*Math.cos(17*t))     ));
            
            if(t!=0)
            putLine(punto1x, punto1y, punto2x, punto2y, Color.red);
            System.out.println("punto1x:"+(punto1x-300)+" punto1y: "+(punto1y-300)+" punto2x: "+ punto2x+" punto2y: "+punto2y);
        }

    }
    public void funcion9_2() {
        
       {
        
        //dibujarCarteciano(x0, y0);
        int punto1x = 0, punto1y = 0, punto2x = 0, punto2y = 0;

        for (double t = 0; t <= 14*Math.PI; t=t+.01) {
            punto2x = punto1x;
            punto2y = punto1y;
            
            punto1x= (int) (300+(10*  (17*(Math.cos(t))+7*Math.cos(2.42*t))     ));
            punto1y= (int) (300-(10*  (17*(Math.sin(t))-7*Math.sin(2.42*t))     ));
            
            if(t!=0)
            putLine(punto1x, punto1y, punto2x, punto2y, Color.red);
            System.out.println("punto1x:"+(punto1x-300)+" punto1y: "+(punto1y-300)+" punto2x: "+ punto2x+" punto2y: "+punto2y);
        }

    }

    }
    public void funcion11(int x0, int y0, double xIni, double xFinal, int steps,int r) {
        
        //dibujarCarteciano(x0, y0);
        double punto1x = x0, punto1y = y0, punto2x = x0, punto2y = y0 ,punto1z=0;

        for (double t = 0; t <= 44; t= t+.001) {
            
            
            punto1x= (300+((10*((17*Math.cos(t))+(7*Math.cos((17/7)*t))))));
            punto1y= (300-((10*(17*Math.sin(t)-(7*Math.sin(17/7*t))))));
            
            if (t!=0) {
             
            }
           
            

            System.out.println("t"+t+" punto1x:"+(punto1x)+" punto1y: "+(punto1y)+" punto2x: "+ punto2x+" punto2y: "+punto2y);
        }

    }
    public void funcion12() {
        
        //dibujarCarteciano(x0, y0);
        putRectangle(200, 200, 400, 400);
        
        for(int i=10;i<200;i= i+10){
            putLine(200, 200+i, 400, 200+i, Color.blue);
            putLine(200+i, 200, 200+i, 400, Color.blue);
        }

    }

    
    public void putPixel(int x, int y, Color c){
    buffer.setRGB(0, 0, c.getRGB());
        //System.out.println("X:"+x+" Y "+y);
    this.getGraphics().drawImage(buffer, x, y, this);
    }
    public void putLine(int x1, int y1, int x2, int y2, Color color) {
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
    
    
    public void putRectangle(int x, int y, int x2, int y2){
        
        if(x>x2){
            int temp=0;
            temp=x;
            x=x2;
            x2=temp;
            
            temp=y;
            y=y2;
            y=temp;
        }
        
        int difx=x2-x,dify=y2-y;
        
        putLine(x, y, x+difx, y,Color.black);
        putLine(x, y+dify, x+difx, y+dify,Color.black);
        putLine(x, y, x, y+dify,Color.BLACK);
        putLine(x+difx, y+dify, x+difx, y,Color.BLACK);
        
    }

}

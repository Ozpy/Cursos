/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pixel;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public class Pixel extends JFrame{
     Robot r;
     Color colorFondo = new Color(0,0,0);
    private BufferedImage buffer;
    private BufferedImage bufferGrande;
    private Graphics2D graPixel;

    public Pixel(){
     setTitle("Ventana2 (Pixel)");
     setSize(1000,1000);
     setLayout(null);
     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    bufferGrande = new BufferedImage(1000, 1000, BufferedImage.TYPE_INT_RGB);
    graPixel = (Graphics2D) buffer.createGraphics();

     setVisible(true);
    }
    
    
   
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic 
        Pixel picsel = new Pixel();
          }
    
    
    public void putPixel(int x, int y, Color c){
    buffer.setRGB(0, 0, c.getRGB());
    this.getGraphics().drawImage(buffer, x, y, this);
    }
    
    //Pintar linea mediante funcion segun la pendiente
    
    //Bresenham
    public void putBresenham(int x0, int y0, int x1, int y1)
            { int x, y, dx, dy, p, A, B, pasox, pasoy;
          dx = (x1 - x0);
          dy = (y1 - y0);
          
          if (dy < 0) { 
            dy = -dy; 
            pasoy = -1; 
          } 
          else
            pasoy = 1;
          if (dx < 0) {  
            dx = -dx; pasox = -1; 
          } 
          else 
            pasox = 1;
          x = x0;
          y = y0;
              putPixel(x, y,Color.BLUE);
         /* se cicla hasta llegar al extremo de la línea */
          if(dx>dy){
              
            
            p = 2*dy - dx;
            A = 2*dy;
            B = 2*(dy-dx);
            while (x != x1){
              x = x + pasox;
              if (p < 0){
                p = p + A;
              }
              else {
                y = y + pasoy;
                p = p + B;
              }
              putPixel(x, y,Color.BLUE);
            }
          }
          else{
            p = 2*dx - dy;
            A = 2*dx;
            B = 2*(dx-dy);
            while (y != y1){
              y = y + pasoy;
              if (p < 0){
                p = p + B;
              }
              else {
                x = x + pasox;
                p = p + A;
              }
              putPixel(x, y,Color.BLUE);
            }
          }

}
    public void putLineaPuntoMedio(int x0, int y0, int x1, int y1)
        {
            int x, y, dx, dy, fin, p, A, B;
            dx = x1 - x0;
            dy = y1 - y0;
            p = 2*dy - dx;
            A = 2*dy;
            B = 2*(dy-dx);
            /* determinar que punto usar para empezar, cual para terminar */
            if (x0 > x1) {
            x = x1;
            y = y1;
            fin = x0;
            }
            else {
            x = x0;
            y = y0;
            fin = x1;
            }
            /* se cicla hasta llegar al extremo de la línea */
            while (x <= fin)
            {
                putPixel(x, y, Color.blue);
            x = x + 1;
            if (p <= 0)
            p = p + A;
            else {
            y = y + 1;
            p = p + B;
            }
            }
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
        
        putLineaPuntoMedio(x, y, x+difx, y);
        putLineaPuntoMedio(x, y+dify, x+difx, y+dify);
        putBresenham(x, y, x, y+dify);
        putBresenham(x+difx, y+dify, x+difx, y);
        
    }
    public void putsquare(int x, int y, int side){
        putLineaPuntoMedio(x, y, x+side, y);
        putLineaPuntoMedio(x, y+side, x+side, y+side);
        putBresenham(x, y, x, y+side);
        putBresenham(x+side, y+side, x+side, y);
    }
    public void putTrangle(int x1,int y1, int x2, int y2,int x3,int y3){
           putBresenham(x1, y1, x2, y2);
           putBresenham(x1, y1, x3, y3);
           putBresenham(x3, y3, x2, y2);
       }
    public void putRhombus(int x, int y, int D,int d){
           putBresenham(x+d/2, y, x, y+D/2);
           putBresenham(x+d/2, y, x, y-D/2);
           putBresenham(x-d/2, y, x, y+D/2);
           putBresenham(x-d/2, y, x, y-D/2);
       }
    public void putCircleBasic(int xc, int yc, int r){
        int x=xc-r,y=yc;
        while (x!=xc+r) {
            y =(int)(yc + Math.sqrt(Math.pow(r, 2)-Math.pow((x-xc),2)));
            putPixel(x-r, y, Color.red);
            y =(int)(yc - Math.sqrt(Math.pow(r, 2)-Math.pow((x-xc),2)));
            putPixel(x-r, y, Color.red);
            x++;
        }
    }
    public void putCirclePolar(int xc,int yc, int r){
        int x=xc-r,
            y=yc;
        double t=3*Math.PI;
        while (t>=0) {
            System.out.println("x:"+x);
            System.out.println("t:"+t);
            
            
            
            x= (int) (xc+ r*(Math.sin(t)));
            y=(int)(yc+ r*(Math.cos(t)));
            t=t-.009;
            putPixel(x, y, Color.red);
        }
    }
    public void putOvalPolar(int xc,int yc, int rx,int ry){
        int x=xc-rx,
            y=yc;
        double t=3*Math.PI;
        while (t>0) {
            System.out.println("x:"+x);
            System.out.println("t:"+t);
            
            x= (int) (xc+ rx*(Math.sin(t)));
            y=(int)(yc+ ry*(Math.cos(t)));
            
            t=t-.005;
            putPixel(x, y, Color.red);
        }
    }
    public Color getColor(int x,int y){
        Color c=Color.BLACK;
        
     
        return c;
    }
    public void FillFlood(int x, int y, Color c){
        boolean flag=false;
        
        while(!flag){
            Color colorPixel = new Color(bufferGrande.getRGB(x, y));
            
            
             if(new Color(bufferGrande.getRGB(x+1, y)).equals(colorFondo)){
            x++;
                 System.out.println("X++");
        }else if(new Color(bufferGrande.getRGB(x, y+1)).equals(colorFondo)){
                 System.out.println("y++");
                  y++;
        }else if(new Color(bufferGrande.getRGB(x-1, y)).equals(colorFondo)){
            x--;
                            System.out.println("X--");

        
        }else if(new Color(bufferGrande.getRGB(x, y-1)).equals(colorFondo)){
            y--;
                             System.out.println("y--");

        } else{
            flag=true;
        }
             if(flag==false){
                 putPixel(x, y, c);
             }
        }
        //this.getGraphics().drawImage(bufferGrande, 0, 0, this);
    }
   public void paint (Graphics g) {
   super.paint(g);
       //putPixel(99, 100, Color. ORANGE); //Pintar un pixel <<ACT>>
       //putPixel(100, 100, Color. BLUE); //Pintar un pixel <<ACT>>

//       putBresenham( 100, 200, 200, 300);
//       putBresenham(100, 200, 200, 100); // 
//       putsquare(90, 90, 350);
     putRectangle(100, 100, 200, 300);
   //    putTrangle(100, 200, 200, 300, 250, 300);
      // putRhombus(200, 200, 100, 150);
//       putCircleBasic(300, 300, 100);
//       putOvalPolar(200, 200, 150,100);
//       //System.out.println(buffer.getGraphics().getColor());
//       
//       //Actividad Figuras          LINEAS
//       putBresenham(100, 100, 200, 200);
//       putBresenham(300, 150, 400, 150);
//       putBresenham(600, 100,500, 200);
//       putLineaPuntoMedio(700, 150, 800, 150);
//       
//       //circulos
//       putCirclePolar(200, 400, 10);
//       putCirclePolar(200, 400, 20);
//       putCirclePolar(200, 400, 30);
//       putCirclePolar(200, 400, 40);
//       
//       //Rectangulos
    //  putRectangle(300, 350, 500, 450);
      // putRectangle( 480, 430,320, 370);
//       
//       //elpises
  //  putOvalPolar(700, 400, 60, 5);
//       putOvalPolar(700, 400, 70, 15);
   //    putOvalPolar(700, 400, 80, 25);
      // putOvalPolar(700, 400, 90, 35);
       // putPixel(100, 200, Color.WHITE);
        //System.out.println(new Color (bufferGrande.getRGB(100, 100))); 
        FillFlood(110 , 110, Color.RED);
        
        
   }
   

}
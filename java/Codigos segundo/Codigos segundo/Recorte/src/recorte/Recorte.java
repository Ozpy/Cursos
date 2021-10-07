/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recorte;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Oscar
 */
public class Recorte extends JFrame implements MouseListener,
                                                MouseMotionListener{
    
    JPanel area;
    private Image temporal;
    int x,y;
    Image buffer;
    int mxtop= 100,
            mxleft=100,
            mxright=400,
            mxbot=400;
    public Recorte(){
        super("Recorte 1.0");
        
        this.setSize(600,600);
        this.setLayout(null);
        area = new JPanel();
        area.addMouseListener(this);
        area.addMouseMotionListener(this);
        area.setBounds(0,0,600,600);
       add(area);
       area.setVisible(true);
        setVisible(true);
        
        
        buffer = area.createImage(area.getWidth(),area.getHeight());
        
        
       
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Recorte();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("recorte.Recorte.mouseClicked()");
    }

    @Override
    public void mousePressed(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("recorte.Recorte.mousePressed()");
      x=me.getX();
      y=me.getY();
      temporal = area.createImage(area.getWidth(),area.getHeight());
      temporal.getGraphics().drawImage(buffer, 0, 0, this);
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Mouse Released");
        buffer.getGraphics().drawImage(temporal, 0, 0, this);
    }

    @Override
    public void mouseEntered(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("recorte.Recorte.mouseExited()");
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("recorte.Recorte.mouseDragged()");
        
       temporal.getGraphics().drawImage(buffer, 0, 0, area);
       
       
       
          putLine(x, y, me.getX(), me.getY());  
       
      
  
        
        area.getGraphics().drawImage(temporal, 0, 0, this);
        
    }

    @Override
    public void paint(Graphics grphcs) {
        super.paint(grphcs); //To change body of generated methods, choose Tools | Templates.
        area.getGraphics().drawRect(100, 100, 300, 300);
        temporal = area.createImage(area.getWidth(),area.getHeight());
        temporal.getGraphics().drawImage(buffer, 0, 0, this);
        
        boolean drawImage = temporal.getGraphics().drawImage(buffer, 0, 0, area);
        temporal.getGraphics().drawRect(100, 100, 300, 300);
        
        buffer.getGraphics().drawImage(temporal, 0, 0, this);
    }
    
    @Override
    public void mouseMoved(MouseEvent me) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println(me.getX()+"  y: "+me.getY());
    }
    public void recorteExplicito(int x1,int y1, int x2, int y2, Rectangle r){
        
    }
     public void putPixel(int x, int y) {
         
         if(x>mxleft && x<mxright && y>mxtop && y<mxbot){
             BufferedImage bufferPixel = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        bufferPixel.setRGB(0, 0, Color.black.getRGB());
        temporal.getGraphics().drawImage(bufferPixel, x, y, this);
         }
        

    }
        
    
    
         public void putLine (int x1, int y1, int x2, int y2) {
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
                putPixel(x, y);
                if (balance >= 0) {
                    y += incy;
                    balance -= dx;
                }
                balance += dy;
                x += incx;
            }
            putPixel(x, y);
        } else {
            dx <<= 1;
            balance = dx - dy;
            dy <<= 1;

            while (y != y2) {
                putPixel(x, y);
                if (balance >= 0) {
                    x += incx;
                    balance -= dy;
                }
                balance += dx;
                y += incy;
            }
            putPixel(x, y);
        }

        return;
    }

}

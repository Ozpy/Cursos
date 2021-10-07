/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanimacion3d;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public class ProyectoAnimacion3D extends JFrame implements Runnable {

    public static void main(String[] args) {
        // TODO code application logic here
        ProyectoAnimacion3D proyectoAnimacion3D = new ProyectoAnimacion3D();
    }
    private BufferedImage buffer;
    private double angulo = (30);
    Cubo3D casa1;
    Cubo3D casa2;
    Cubo3D edificio;
    Cubo3D techo1;
    Cubo3D techo2;
    
    double perspectivaCasa2= .5 ;
    boolean animacion1 = true;
    boolean animacion2 = true;
    boolean animacion3 = true;
    //Buffer
    Image imag;
    public Graphics gBuffer;
    //Hilo
    Thread th;
    //Imagen
    Dimension dimension = new Dimension(200, 300);
    int xImag = 0;
    int yImag = -10;
    
    int vientoX=100;
    ImageIcon icon = new ImageIcon(getClass().getResource("\\tenor.gif"));
    private final punto3D fuga1 = new punto3D(-100, 300, 300);
    private final punto3D fuga2 = new punto3D(-400, -500, 100);

    public ProyectoAnimacion3D() {

        this.setTitle("Transformaciones");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setBackground(new Color(237, 254, 255));
        setVisible(true);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        this.th = new Thread(this);

        casa1 = new Cubo3D(new punto3D(0, 0, 0), 100);
        casa2 = new Cubo3D(new punto3D(0, 0, 0), 100);
        edificio = new Cubo3D(new punto3D(0, -600,200), 100);
        edificio.rectangulo();

        techo1 = new Cubo3D(new punto3D(0, -20, 00), 70);
        techo2 = new Cubo3D(new punto3D(0, -20, 00), 70);
        //CubitoAnimacion cubito = new CubitoAnimacion(this, imag);
        //cubito.starthilo();
        startHiloMain();

    }

    public void startHiloMain() {
        th.start();

    }

    @Override
    public void run() {
       
        while (true) {
            
            if (animacion3) {
                try {
                    for (int i = 0; i < 30; i++) {
                        try {
                            vientoX= vientoX+i*10;
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                    }
                    
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (animacion2) {//tornado
                
               for (int i = 0; i < 40; i++) {
                   try {
                       Thread.sleep(100);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                   }
                   xImag= xImag+15;
                   
                   
                   repaint();
            } vientoX=100;
               for (int i = 0; i < 15; i++) {
                        try {
                            vientoX= vientoX+i*10;
                            Thread.sleep(300);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        repaint();
                    }
               animacion3=false;
               animacion2=false;
            }
            
            if (animacion1) {//casas
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    casa1 = casa1.TranslationAnimation(-20, -20, 20);
                    casa1 = casa1.RotateAnimationY(.5);
                    casa1 = casa1.RotateAnimationX(1);
                    techo1 = new Cubo3D(new punto3D(techo1.punto.x+i*3, techo1.punto.y+i*10, techo1.punto.z+i*5),70);
                    repaint();
                }
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                }
                for (int i = 0; i < 20; i++) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    casa2 = casa2.TranslationAnimation(-20, -20, 20);
                    casa2 = casa2.RotateAnimationY(.5);
                    casa2 = casa2.RotateAnimationX(1);
                    casa2 = casa2.ScaleAnimation(1+.3,1+.3,1+.3);
                    
                    perspectivaCasa2= perspectivaCasa2+.1;
                    techo2 = new Cubo3D(new punto3D(techo2.punto.x-i*5, techo2.punto.y+i*10, techo2.punto.z+i*10),70);

                    repaint();

                }
                animacion1 = false;
            }

            repaint();
        }
    }

    public void limpiarPantalla() {
        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
        this.getGraphics().drawImage(imag, 0, 0, null);
    }

    @Override
    public void update(Graphics g) {
        //super.update(grphcs); //To change body of generated methods, choose Tools | Templates.
        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        if (gBuffer == null) {
            imag = createImage(this.getWidth(), this.getHeight());
            gBuffer = imag.getGraphics();
        }

        gBuffer.setColor(getBackground());
        gBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());

        //dibuja en buffer
        gBuffer.setColor(Color.black);
        //Carteciano
        //dibujarCarteciano3D(300, 300);
        putLine3DPerspectiva(fuga2, new punto3D(-20, -20, -20), new Color(133, 94, 61), fuga2, 1);
        putLine3DPerspectiva(fuga2, new punto3D(0, 0, -100), new Color(133, 94, 61), fuga2, 1);
        for (int i = 0; i < 10; i++) {
            putLine3DPerspectiva(new punto3D(0, 100 + 100 + i * 10, -100), fuga1, Color.GREEN, fuga1, 1);

        }
        for (int i = 0; i < 30; i++) {
            putLine3DPerspectiva(new punto3D(0, 400 + 100 + i * 3, -100 + i * 10), new punto3D(0, 100 + 100 + i * 3, -100 + i * 10), new Color(19, 144, 13), fuga1, 1);
        }
        rellenoScan(edificio, Color.BLUE);
        rellenoScan(new Cubo3D(new punto3D(0, -580,180), 30), Color.white);
        rellenoScan(new Cubo3D(new punto3D(0, -580,130), 30), Color.white);
        rellenoScan(new Cubo3D(new punto3D(0, -580,80), 30), Color.white);
        if (animacion1) {
            
        
        
       
        
        putCubePerspectiva(casa2, perspectivaCasa2, new Color(89, 59, 35));
        
        putTranglePerspectiva(techo2,.5, new Color(236, 114, 12));
        }
        if (animacion2) {
             gBuffer.drawImage(icon.getImage(), xImag, yImag, dimension.width, dimension.height, null);
        }
        //Pasto
        

        putLine3DPerspectiva(new punto3D(0, 400, -100), new punto3D(0, 100, -100), new Color(133, 94, 61), fuga1, 1);
        // System.out.println("-----"+casa2.puntos[2].x+" "+ casa2.puntos[2].y+300+" "+ casa2.puntos[2].z);
        //System.out.println("-----"+casa2.puntos[2].x+" "+ casa2.puntos[3].y+100+" "+ casa2.puntos[3].z);

        putLine3DPerspectiva(new punto3D(0, 100 + 100, -100), fuga1, new Color(133, 94, 61), fuga1, 1);
        putLine3DPerspectiva(new punto3D(0, 100, -100), fuga1, new Color(133, 94, 61), fuga1, 1);
        
        
        //System.out.println("-----"+casa2.puntos[2].x+" "+ casa2.puntos[3].y+" "+ casa2.puntos[3].z);
        //putLine3DPerspectiva(fuga1, new punto3D(casa2.puntos[2].x, casa2.puntos[2].y+100, casa2.puntos[2].z), Color.green, fuga1, 1);
        if (animacion1) {
            //Casas
        putCubePerspectiva(new Cubo3D(new punto3D(casa1.puntos[0].x, casa1.puntos[0].y, casa1.puntos[0].z), 1), 1, new Color(248, 248, 49));
        
        
        
        putCubePerspectiva(casa1, 1, new Color(89, 59, 35));
        
        
        
        
            //Techos
        putTranglePerspectiva(techo1, 1, new Color(236, 114, 12));
        
        }
        
        
        if (animacion3) {//viento
            funcion9();
        }
        
        this.getGraphics().drawImage(imag, 0, 0, this);

    }

    public void putPixel(int x, int y, Color c) {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        buffer.setRGB(0, 0, c.getRGB());
        //System.out.println("X:"+x+" Y "+y);
        gBuffer.drawImage(buffer, x, y, this);
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
    }

    public void dibujarCarteciano3D(int x0, int y0) {
        putLine((int) (300 + 0 - 1800 * Math.cos(angulo)), (int) (300 - 0 + 1800 * Math.cos(angulo)), 300, 300, Color.red);//X
        putLine(300, 300, 300, 0, Color.blue);
        putLine(300, 300, 600, 300, Color.blue);

    }

    public void putCubePerspectiva(Cubo3D cubo, double u, Color c) {

        putLine3DPerspectiva(cubo.puntos[0], cubo.puntos[1], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[0], cubo.puntos[3], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[0], cubo.puntos[4], c, fuga1, u);

        putLine3DPerspectiva(cubo.puntos[2], cubo.puntos[1], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[2], cubo.puntos[3], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[2], cubo.puntos[6], c, fuga1, u);

        putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[4], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[6], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[1], c, fuga1, u);

        putLine3DPerspectiva(cubo.puntos[7], cubo.puntos[6], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[7], cubo.puntos[3], c, fuga1, u);
        putLine3DPerspectiva(cubo.puntos[7], cubo.puntos[4], c, fuga1, u);

    }

    public void putTranglePerspectiva(Cubo3D cubo, double u, Color c) {
        int cont = cubo.l;

        while (cont >= 0) {
            cubo = new Cubo3D(cubo.punto, cont);
            cubo.Triangulo();
            putLine3DPerspectiva(cubo.puntos[0], cubo.puntos[1], c, fuga1, u);
            putLine3DPerspectiva(cubo.puntos[0], cubo.puntos[2], c, fuga1, u);
            putLine3DPerspectiva(cubo.puntos[0], cubo.puntos[3], c, fuga1, u);

            putLine3DPerspectiva(cubo.puntos[1], cubo.puntos[2], c, fuga1, u);
            putLine3DPerspectiva(cubo.puntos[1], cubo.puntos[4], c, fuga1, u);

            putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[2], c, fuga1, u);
            putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[4], c, fuga1, u);
            putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[3], c, fuga1, u);

            putLine3DPerspectiva(cubo.puntos[5], cubo.puntos[3], c, fuga1, u);
            cont--;
        }

    }

    public void putLine3DPerspectiva(punto3D p1, punto3D p2, Color color, punto3D centro, double u) {
        int x1 = (int) ((centro.x) + (p1.x - centro.x) * u), y1 = (int) ((centro.y) + (p1.y - centro.y) * u), z1 = (int) ((centro.z) + (p1.z - centro.z) * u),
              x2 = (int) ((centro.x) + (p2.x - centro.x) * u), y2 = (int) ((centro.y) + (p2.y - centro.y) * u), z2 = (int) ((centro.z) + (p2.z - centro.z) * u);
//        System.out.println("x1:" + x1);
//        System.out.println("y1:" + y1);
//        System.out.println("z1:" + z1);
//
//        System.out.println("x2:" + x2);
//        System.out.println("y2:" + y2);
//        System.out.println("z2:" + z2);
//        System.out.println("\n\n");
        int x1temp = (int) (300 - (2 * x1 * Math.cos(angulo)) + y1);
        int y1temp = (int) (300 + (2 * x1 * Math.cos(angulo)) - z1);

        x1 = x1temp;
        y1 = y1temp;

        int x2temp = (int) (300 - (2 * x2 * Math.cos(angulo)) + y2);
        int y2temp = (int) (300 + (2 * x2 * Math.cos(angulo)) - z2);

        x2 = x2temp;
        y2 = y2temp;
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

    }
public void funcion9() {
        
        //dibujarCarteciano(x0, y0);
        int punto1x = 0, punto1y = 0, punto2x = 0, punto2y = 0;

        for (double t = -10; t <= -2; t=t+.01) {
            punto2x = punto1x;
            punto2y = punto1y;
            
            punto1x= (int) (vientoX+( 4* (2*t-(Math.PI*Math.sin(t)))     ));
            punto1y= (int) (100-( 4* (2*-(Math.PI*Math.cos(t)))     ));
            
            if(t!=0){
             putPixel(punto1x, punto1y, Color.CYAN);  
             putPixel(punto1x+20, punto1y+100, Color.CYAN);  
             putPixel(punto1x+40, punto1y+150, Color.CYAN);  
             putPixel(punto1x+60, punto1y+200, Color.CYAN);  
             putPixel(punto1x+80, punto1y+240, Color.CYAN);  
             putPixel(punto1x+100, punto1y+290, Color.CYAN);  
             putPixel(punto1x+120, punto1y+350, Color.CYAN);  
             putPixel(punto1x+140, punto1y+380, Color.CYAN);  
                
            }
            
            //System.out.println("punto1x:"+(punto1x-300)+" punto1y: "+(punto1y-300)+" punto2x: "+ punto2x+" punto2y: "+punto2y);
            
        }

    }
    public class CubitoAnimacion implements Runnable {

        Thread th;
        JFrame frame;
        Image imag;
        Graphics gBuffer;

        public CubitoAnimacion(JFrame frame, Image imag) {
            this.th = new Thread(this);
            this.frame = frame;
            this.imag = imag;

            gBuffer = imag.getGraphics();
        }

        public void starthilo() {
            th.start();
        }

        @Override
        public void run() {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

            for (int i = 0; i < 100; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(ProyectoAnimacion3D.class.getName()).log(Level.SEVERE, null, ex);
                }
                gBuffer.drawLine(100, 100, 100 + i * 10, 100 + i * 10);

                System.out.println("proyectoanimacion3d.ProyectoAnimacion3D.CubitoAnimacion.run()");
            }
        }

    }
    public void rellenoScan(Cubo3D cubo,Color c){
        
        for (int i = 0; i < cubo.puntos[0].z- cubo.puntos[2].z; i++) {
            putLine3DPerspectiva(new punto3D(cubo.puntos[0].x, cubo.puntos[0].y, cubo.puntos[0].z-i),
                    new punto3D(cubo.puntos[1].x, cubo.puntos[1].y, cubo.puntos[1].z-i), c, fuga1, .5);
        }
    }
    
    
}

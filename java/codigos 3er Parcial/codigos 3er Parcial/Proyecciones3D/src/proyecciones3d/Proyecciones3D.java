/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecciones3d;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author Oscar
 */
public class Proyecciones3D extends JFrame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Proyecciones3D pd = new Proyecciones3D();
    }
    private BufferedImage buffer;
    
    
    
    
    
    //private double angulo = (30);   //Proyeccion 2
    private double angulo = (.5*Math.PI);//Proyeccion 1
    private punto3D fuga1 = new punto3D(-100, 300,300);
    
    
    
    

    public Proyecciones3D() {
        this.setTitle("Proyecciones");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setVisible(true);
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    }

    public void dibujarCarteciano3D(int x0, int y0) {
        putLine((int) (300 + 0 - 1800 * Math.cos(angulo)), (int) (300 - 0 + 1800 * Math.cos(angulo)), 300, 300, Color.red);//X
        putLine(300, 300, 300, 0, Color.blue);
        putLine(300, 300, 600, 300, Color.blue);

    }

    @Override
    public void paint(Graphics g) {
        dibujarCarteciano3D(100, 100);
        //putCubePerspectiva(new punto3D(-100, 100, 100), 100);
        punto3D temporal = new punto3D(-100, 20, 100);
        putLine3D(temporal, temporal.derecha(200), Color.blue);
        putCubePerspectiva(new punto3D(-100, 100, 100), 100,2);
        putCubePerspectiva(new punto3D(-100, 100, 100), 100,.5);
        
    }

    public void putPixel(int x, int y, Color c) {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        buffer.setRGB(0, 0, c.getRGB());
        //System.out.println("X:"+x+" Y "+y);
        this.getGraphics().drawImage(buffer, x, y, this);
    }

    public void putPixel2D(int x, int y, Color c) {
        buffer.setRGB(0, 0, c.getRGB());
        //System.out.println("X:"+x+" Y "+y);
        this.getGraphics().drawImage(buffer, 300 + x, 300 - y, this);
    }

    public void putPixel3D(int x, int y, int z, Color c) {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        buffer.setRGB(0, 0, c.getRGB());
        //System.out.println("X:"+x+" Y "+y);
        this.getGraphics().drawImage(buffer, (int) (300 - (2 * x * Math.cos(30)) + y), (int) (300 + (2 * x * Math.cos(30)) - z), this);
    }

    public void putPixel3D(punto3D p, Color c) {
        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        buffer.setRGB(0, 0, c.getRGB());
        //System.out.println("X:"+x+" Y "+y);
        this.getGraphics().drawImage(buffer, (int) (300 - (p.x * Math.cos(angulo) + p.y)), (int) (300 + (p.x * Math.cos(angulo) - p.z)), this);
    }

    public void putCube(punto3D izquierdaArriba, int lado) {
        punto3D temp = izquierdaArriba;

        putLine3D(temp, temp.derecha(lado), Color.black);
        putLine3D(temp, temp.abajo(lado), Color.black);
        putLine3D(temp, temp.atras(lado), Color.black);

        temp.y = temp.y + lado;
        putLine3D(temp, temp.abajo(lado), Color.black);
        putLine3D(temp, temp.atras(lado), Color.black);

        temp.z = temp.z - lado;
        putLine3D(temp, temp.izquierda(lado), Color.black);
        putLine3D(temp, temp.atras(lado), Color.black);

        temp.x = temp.x + lado;
        putLine3D(temp, temp.izquierda(lado), Color.black);
        putLine3D(temp, temp.arriba(lado), Color.black);

        temp.z = temp.z + lado;
        putLine3D(temp, temp.izquierda(lado), Color.black);

        temp.y = temp.y - lado;
        putLine3D(temp, temp.abajo(lado), Color.black);

        temp.z = temp.z - lado;
        putLine3D(temp, temp.adelante(lado), Color.black);

    }

    public void putCubePerspectiva(punto3D izquierdaArriba, int lado,double u) {
        punto3D temp = izquierdaArriba;

        putLine3DPerspectiva(temp, temp.derecha(lado), Color.black,fuga1,u);
        putLine3DPerspectiva(temp, temp.abajo(lado), Color.black,fuga1,u);
        putLine3DPerspectiva(temp, temp.atras(lado), Color.black,fuga1,u);

        temp.y = temp.y + lado;
        putLine3DPerspectiva(temp, temp.abajo(lado), Color.black,fuga1,u);
        putLine3DPerspectiva(temp, temp.atras(lado), Color.black,fuga1,u);

        temp.z = temp.z - lado;
        putLine3DPerspectiva(temp, temp.izquierda(lado), Color.black,fuga1,u);
        putLine3DPerspectiva(temp, temp.atras(lado), Color.black,fuga1,u);

        temp.x = temp.x + lado;
        putLine3DPerspectiva(temp, temp.izquierda(lado), Color.black,fuga1,u);
        putLine3DPerspectiva(temp, temp.arriba(lado), Color.black,fuga1,u);

        temp.z = temp.z + lado;
        putLine3DPerspectiva(temp, temp.izquierda(lado), Color.black,fuga1,u);

        temp.y = temp.y - lado;
        putLine3DPerspectiva(temp, temp.abajo(lado), Color.black,fuga1,u);

        temp.z = temp.z - lado;
        putLine3DPerspectiva(temp, temp.adelante(lado), Color.black,fuga1,u);

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

    public void putLine3D(int x1, int y1, int z1, int x2, int y2, int z2, Color color) {

        int x1temp = (int) (300 - (2 * x1 * Math.cos(30)) + y1);
        int y1temp = (int) (300 + (2 * x1 * Math.cos(30)) - z1);

        x1 = x1temp;
        y1 = y1temp;

        int x2temp = (int) (300 - (2 * x2 * Math.cos(30)) + y2);
        int y2temp = (int) (300 + (2 * x2 * Math.cos(30)) - z2);

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
    public void putLine3D(punto3D p1, punto3D p2, Color color) {
        int x1 = p1.x, y1 = p1.y, z1 = p1.z, 
            x2 = p2.x, y2 = p2.y, z2 = p2.z;
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

    public void putLine3DPerspectiva(punto3D p1, punto3D p2, Color color, punto3D centro, double u) {
        int x1 = (int)((centro.x)+(p1.x-centro.x)*u), y1 = (int)((centro.y)+(p1.y-centro.y)*u), z1 = (int)((centro.z)+(p1.z-centro.z)*u), 
            x2 = (int)((centro.x)+(p2.x-centro.x)*u), y2 = (int)((centro.y)+(p2.y-centro.y)*u), z2 = (int)((centro.z)+(p2.z-centro.z)*u);
        System.out.println("x1:"+x1);
        System.out.println("y1:"+y1);
        System.out.println("z1:"+z1);
        
        System.out.println("x2:"+x2);
        System.out.println("y2:"+y2);
        System.out.println("z2:"+z2);
        System.out.println("\n\n");
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
}

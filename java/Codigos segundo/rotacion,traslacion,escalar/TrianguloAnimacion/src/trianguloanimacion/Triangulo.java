/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar
 */
public class Triangulo implements Runnable{
    Thread t;
    int x1, y1, x2, y2, x3, y3;
    Graphics g;
    
    int angulo=20;
    int movimientox=100
            , movimientoy=100;
    int scale=2;
    
    public Triangulo(int x1,int y1, int x2, int y2, int x3, int y3) {
    this.t= new Thread(this);
    this.x1 = x1;
    this.y1 = y1;
    this.x2 = x2;
    this.y2 = y2;
    this.x3 = x3;
    this.y3 = y3;
    }
    
    public void start(){
        this.t.start();
    }
    
    public void TrangleTraslationAnimation(){
        int dx=movimientox;
        int dy=movimientoy;
        int[][] P= {
                    {x1,x2,x3},
                    {y1,y2,y3},
                    {1,1,1}
        };
        double[][] T = {
                     {1,0,dx},
                     {0,1,dy},
                     {0,0,1}
        };
        int [][] res={{0,0,0},{0,0,0},{0,0,0}};
        //System.out.println("[0][2]"+T[0][2]); 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                 res[i][j] += ((T[i][k])*(P[k][j]));
                 
                // System.out.println("i.j.k"+i+" "+j+" "+k+" "+"Res:"+ res[i][j]+" T:"+ ((T[i][k])+" P:" +(P[k][j])));
                }
                //System.out.println("");
            }
        }
        imprimirMatriz(T);
        System.out.println( "x1:"+x1+" x2:"+x2+" x3:"+x3);
        System.out.println( "y1:"+y1+" y2:"+y2+" y3:"+y3);
        System.out.println( "");
        
        int x1Nuevo= res[0][0];
        int y1Nuevo= res[1][0];
        int x2Nuevo= res[0][1];
        int y2Nuevo= res[1][1];
        int x3Nuevo= res[0][2];
        int y3Nuevo= res[1][2];
        
        int distx1= x1-x2Nuevo;
        int distx2= x2-x2Nuevo;
        int distx3= x3-x3Nuevo;
        
        int disty1= x1-y2Nuevo;
        int disty2= x2-y2Nuevo;
        int disty3= x3-y3Nuevo;
 
        
        
        
        while(x1!=x1Nuevo || x2!=x2Nuevo || x3!=x3Nuevo  || y1!=y1Nuevo || y2!=y2Nuevo || y3!=y3Nuevo){
            if(x1<x1Nuevo)
                x1++;
            if(x1>x1Nuevo)
                x1--;
            if(x2<x2Nuevo)
                x2++;
            if(x2>x2Nuevo)
                x2--;
            if(x3<x3Nuevo)
                x3++;
            if(x3>x3Nuevo)
                x3--;
            
            if(y1<y1Nuevo)
                y1++;
            if(y1>y1Nuevo)
                y1--;
            if(y2<y2Nuevo)
                y2++;
            if(y2>y2Nuevo)
                y2--;
            if(y3<y3Nuevo)
                y3++;
            if(y3>y3Nuevo)
                y3--;
            
            try {
                System.out.println( "x1:"+x1+" x2:"+x2+" x3:"+x3);
                System.out.println( "y1:"+y1+" y2:"+y2+" y3:"+y3);
                System.out.println( "");
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrianguloAnimacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void TrangleScaleAnimation(){
        int sx=scale;
        int sy=scale;
        int[][] P= {
                    {x1,x2,x3},
                    {y1,y2,y3},
                    {1,1,1}
        };
        int[][] S = {
                     {sx,0,0},
                     {0,sy,0},
                     {0,0,1}
        };
        double [][] res={{0,0,0},{0,0,0},{0,0,0}};
        //System.out.println("[0][2]"+T[0][2]); 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                 res[i][j] += ((S[i][k])*(P[k][j]));
                 
                 System.out.println("i.j.k"+i+" "+j+" "+k+" "+"Res:"+ res[i][j]+" T:"+ ((S[i][k])+" P:" +(P[k][j])));
                }
                System.out.println("");
            }
        }
        imprimirMatriz(res);
        System.out.println( "x1:"+x1+" x2:"+x2+" x3:"+x3);
        System.out.println( "y1:"+y1+" y2:"+y2+" y3:"+y3);
        System.out.println( "");
        
        double x1Nuevo= (int)res[0][0];
        double y1Nuevo= (int)res[1][0];
        double x2Nuevo= (int)res[0][1];
        double y2Nuevo= (int)res[1][1];
        double x3Nuevo= (int)res[0][2];
        double y3Nuevo= (int)res[1][2];
        
        while(x1!=x1Nuevo || x2!=x2Nuevo || x3!=x3Nuevo  || y1!=y1Nuevo || y2!=y2Nuevo || y3!=y3Nuevo){
            if(x1<x1Nuevo)
                x1++;
            if(x1>x1Nuevo)
                x1--;
            if(x2<x2Nuevo)
                x2++;
            if(x2>x2Nuevo)
                x2--;
            if(x3<x3Nuevo)
                x3++;
            if(x3>x3Nuevo)
                x3--;
            
            if(y1<y1Nuevo)
                y1++;
            if(y1>y1Nuevo)
                y1--;
            if(y2<y2Nuevo)
                y2++;
            if(y2>y2Nuevo)
                y2--;
            if(y3<y3Nuevo)
                y3++;
            if(y3>y3Nuevo)
                y3--;
            
            try {
                System.out.println( "x1:"+x1+" x2:"+x2+" x3:"+x3);
                System.out.println( "y1:"+y1+" y2:"+y2+" y3:"+y3);
                System.out.println( "");
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrianguloAnimacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    public void TrangleRotationAnimation(){
        int[][] P= {
                    {x1,x2,x3},
                    {y1,y2,y3},
                    {1,1,1}
        };
        double [][] R = {
                     {Math.cos(angulo),-Math.sin(angulo),0},
                     {Math.sin(angulo),Math.cos(angulo),0},
                     {0,0,1}
        };
        double [][] res={{0,0,0},{0,0,0},{0,0,0}};
        //System.out.println("[0][2]"+T[0][2]); 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                 res[i][j] += ((R[i][k])*(P[k][j]));
                 
                 System.out.println("i.j.k"+i+" "+j+" "+k+" "+"Res:"+ res[i][j]+" T:"+ ((R[i][k])+" P:" +(P[k][j])));
                }
                System.out.println("");
            }
        }
        imprimirMatriz(res);
        System.out.println( "x1:"+x1+" x2:"+x2+" x3:"+x3);
        System.out.println( "y1:"+y1+" y2:"+y2+" y3:"+y3);
        System.out.println( "");
        
        double x1Nuevo= (int)res[0][0];
        double y1Nuevo= (int)res[1][0];
        double x2Nuevo= (int)res[0][1];
        double y2Nuevo= (int)res[1][1];
        double x3Nuevo= (int)res[0][2];
        double y3Nuevo= (int)res[1][2];
        
        while(x1!=x1Nuevo || x2!=x2Nuevo || x3!=x3Nuevo  || y1!=y1Nuevo || y2!=y2Nuevo || y3!=y3Nuevo){
            if(x1<x1Nuevo)
                x1++;
            if(x1>x1Nuevo)
                x1--;
            if(x2<x2Nuevo)
                x2++;
            if(x2>x2Nuevo)
                x2--;
            if(x3<x3Nuevo)
                x3++;
            if(x3>x3Nuevo)
                x3--;
            
            if(y1<y1Nuevo)
                y1++;
            if(y1>y1Nuevo)
                y1--;
            if(y2<y2Nuevo)
                y2++;
            if(y2>y2Nuevo)
                y2--;
            if(y3<y3Nuevo)
                y3++;
            if(y3>y3Nuevo)
                y3--;
            
            try {
//                System.out.print( "x1:"+x1+" x2:"+x2+" x3:"+x3);
//                System.out.println( "       x1:"+x1Nuevo+" x2:"+x2Nuevo+" x3:"+x3Nuevo);
//                System.out.print( "y1:"+y1+" y2:"+y2+" y3:"+y3);
//                System.out.println( "       y1:"+y1Nuevo+" y2:"+y2Nuevo+" y3:"+y3Nuevo);
//                System.out.println( "");
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(TrianguloAnimacion.class.getName()).log(Level.SEVERE, null, ex);
            }
            //this.repaint(); 
        }
        
    }
    @Override
    public void run() {
        try {
            t.sleep(100);
            TrangleTraslationAnimation();
           // TrangleRotationAnimation();
            //TrangleScaleAnimation();
        } catch (InterruptedException ex) {
            Logger.getLogger(Triangulo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void imprimirMatriz(double [][] matriz){
//        for (int x=0; x < matriz.length; x++){
//        for (int y=0; y < matriz[x].length; y++)
//              System.out.print(" | " + matriz[x][y]+ " | ");   
//        System.out.println("\n----------------------------------------");
//
//}
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanimacion3d;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oscar
 */
public class Cubo3D {
    punto3D[]  puntos = new punto3D[8];
    punto3D  punto = new punto3D(0, 0, 0);
    int l ;
    
    public Cubo3D(punto3D punto, int l) {
        this.l = l;
        this.punto = punto;
        this.puntos[0]= punto;
        this.puntos[1]= punto.derecha(l);
        this.puntos[2]= punto.derecha(l).abajo(l);
        this.puntos[3]= punto.abajo(l);
        
        this.puntos[4]= punto.adelante(l);
        this.puntos[5]= punto.adelante(l).derecha(l);
        this.puntos[6]= punto.adelante(l).derecha(l).abajo(l);
        this.puntos[7]= punto.adelante(l).abajo(l);
    }
    public void rectangulo(){
        this.punto = punto;
        this.puntos[0]= punto;
        this.puntos[1]= punto.derecha(l);
        this.puntos[2]= punto.derecha(l).abajo(l).abajo(l).abajo(l);
        this.puntos[3]= punto.abajo(l).abajo(l).abajo(l);
        
        this.puntos[4]= punto;
        this.puntos[5]= punto.derecha(l);
        this.puntos[6]= punto.derecha(l).abajo(l).abajo(l).abajo(l);
        this.puntos[7]= punto.abajo(l).abajo(l).abajo(l);
    }
    public Cubo3D(punto3D [] puntos) {
        this.puntos=puntos;
    }
    public Cubo3D Triangulo(){
        this.puntos[0]= punto;
        this.puntos[1]= punto.derecha(l).derecha(l);
        this.puntos[2]= punto.derecha(l).arriba(l);
        
        this.puntos[3]= punto.adelante(l);
        this.puntos[4]= punto.adelante(l).derecha(l).derecha(l);
        this.puntos[5]= punto.adelante(l).derecha(l).arriba(l);
        return this;
    }
    
    public void setL(int l){
        this.puntos[1]= punto.derecha(l);
        this.puntos[2]= punto.derecha(l).abajo(l);
        this.puntos[3]= punto.abajo(l);
        
        this.puntos[4]= punto.adelante(l);
        this.puntos[5]= punto.adelante(l).derecha(l);
        this.puntos[6]= punto.adelante(l).derecha(l).abajo(l);
        this.puntos[7]= punto.adelante(l).abajo(l);
    }
    public Cubo3D setLTriangulo(int l){
        this.puntos[1]= punto.derecha(l).derecha(l);
        this.puntos[2]= punto.derecha(l).arriba(l);
        
        this.puntos[3]= punto.adelante(l);
        this.puntos[4]= punto.adelante(l).derecha(l).derecha(l);
        this.puntos[5]= punto.adelante(l).derecha(l).arriba(l);
        return this;
    }
   public Cubo3D TranslationAnimation(int dx, int dy, int dz){
         punto3D [] puntosFinales = new punto3D[9];
        int[][] P= {
                    {puntos[0].x,puntos[1].x,puntos[2].x,puntos[3].x,puntos[4].x,puntos[5].x,puntos[6].x,puntos[7].x},
                    {puntos[0].y,puntos[1].y,puntos[2].y,puntos[3].y,puntos[4].y,puntos[5].y,puntos[6].y,puntos[7].y},
                    {puntos[0].z,puntos[1].z,puntos[2].z,puntos[3].z,puntos[4].z,puntos[5].z,puntos[6].z,puntos[7].z},
                    {1,1,1,1,1,1,1,1}
        };
        double [][] T = {
                     {1,0,0,dx},
                     {0,1,0,dy},
                     {0,0,1,dz},
                     {0,0,0,1}
        };
        
        int [][] res = xMatriz(T, P);
        imprimirMatriz(res);
        
        for (int i = 0; i < 8; i++) {
            puntosFinales[i] = new punto3D(res[0][i], res[1][i], res[2][i]);
            System.out.println("transformaciones.Cubo3D.TranslationAnimation()"+i);
       }
        System.out.println("prueba.>"+ res[2][1]);
        imprimirMatriz(P);
        return (new Cubo3D(puntosFinales));
    }
   public Cubo3D ScaleAnimation(double sx, double sy, double sz){
         punto3D [] puntosFinales = new punto3D[9];
        int[][] P= {
                    {puntos[0].x,puntos[1].x,puntos[2].x,puntos[3].x,puntos[4].x,puntos[5].x,puntos[6].x,puntos[7].x},
                    {puntos[0].y,puntos[1].y,puntos[2].y,puntos[3].y,puntos[4].y,puntos[5].y,puntos[6].y,puntos[7].y},
                    {puntos[0].z,puntos[1].z,puntos[2].z,puntos[3].z,puntos[4].z,puntos[5].z,puntos[6].z,puntos[7].z},
                    {1,1,1,1,1,1,1,1}
        };
        double [][] T = {
                     {sx,0,0,0},
                     {0,sy,0,0},
                     {0,0,sz,0},
                     {0,0,0,1}
        };
        
        int [][] res = xMatriz(T, P);
        imprimirMatriz(res);
        
        for (int i = 0; i < 8; i++) {
            puntosFinales[i] = new punto3D(res[0][i], res[1][i], res[2][i]);
            System.out.println("transformaciones.Cubo3D.TranslationAnimation()"+i);
       }
        System.out.println("prueba"+ res[2][1]);
        
        return (new Cubo3D(puntosFinales));
    }

   public Cubo3D RotateAnimationX(double ang){
         punto3D [] puntosFinales = new punto3D[9];
        int[][] P= {
                    {puntos[0].x,puntos[1].x,puntos[2].x,puntos[3].x,puntos[4].x,puntos[5].x,puntos[6].x,puntos[7].x},
                    {puntos[0].y,puntos[1].y,puntos[2].y,puntos[3].y,puntos[4].y,puntos[5].y,puntos[6].y,puntos[7].y},
                    {puntos[0].z,puntos[1].z,puntos[2].z,puntos[3].z,puntos[4].z,puntos[5].z,puntos[6].z,puntos[7].z},
                    {1,1,1,1,1,1,1,1}
        };
        double [][] T = {
                     {1,0,0,0},
                     {0,(Math.cos(ang)),(Math.sin(ang)),0},
                     {0,(-Math.sin(ang)),(Math.cos(ang)),0},
                     {0,0,0,1}
        };
        
        int [][] res = xMatriz(T, P);
        System.out.println(ang);
        imprimirMatriz(res);
        
        for (int i = 0; i < 8; i++) {
            puntosFinales[i] = new punto3D(res[0][i], res[1][i], res[2][i]);
            System.out.println("transformaciones.Cubo3D.TranslationAnimation()"+i);
       }
        System.out.println("prueba"+ res[2][1]);
        
        return (new Cubo3D(puntosFinales));
    }
   public Cubo3D RotateAnimationZ(double ang){
         punto3D [] puntosFinales = new punto3D[9];
        int[][] P= {
                    {puntos[0].x,puntos[1].x,puntos[2].x,puntos[3].x,puntos[4].x,puntos[5].x,puntos[6].x,puntos[7].x},
                    {puntos[0].y,puntos[1].y,puntos[2].y,puntos[3].y,puntos[4].y,puntos[5].y,puntos[6].y,puntos[7].y},
                    {puntos[0].z,puntos[1].z,puntos[2].z,puntos[3].z,puntos[4].z,puntos[5].z,puntos[6].z,puntos[7].z},
                    {1,1,1,1,1,1,1,1}
        };
        double [][] T = {
                     {(Math.cos(ang)),0,(Math.sin(ang)),0},
                     {(-Math.sin(ang)),(Math.cos(ang)),0,0},
                     {0,0,1,0},
                     {0,0,0,1}
        };
        
        int [][] res = xMatriz(T, P);
        imprimirMatriz(res);
        
        for (int i = 0; i < 8; i++) {
            puntosFinales[i] = new punto3D(res[0][i], res[1][i], res[2][i]);
            //System.out.println("transformaciones.Cubo3D.TranslationAnimation()"+i);
       }
        //System.out.println("prueba"+ res[2][1]);
        
        return (new Cubo3D(puntosFinales));
    }
   public Cubo3D RotateAnimationY(double ang){
         punto3D [] puntosFinales = new punto3D[9];
        int[][] P= {
                    {puntos[0].x,puntos[1].x,puntos[2].x,puntos[3].x,puntos[4].x,puntos[5].x,puntos[6].x,puntos[7].x},
                    {puntos[0].y,puntos[1].y,puntos[2].y,puntos[3].y,puntos[4].y,puntos[5].y,puntos[6].y,puntos[7].y},
                    {puntos[0].z,puntos[1].z,puntos[2].z,puntos[3].z,puntos[4].z,puntos[5].z,puntos[6].z,puntos[7].z},
                    {1,1,1,1,1,1,1,1}
        };
        double [][] T = {
                     {(Math.cos(ang)),0,(-Math.sin(ang)),0},
                     {0,1,0,0},
                     {(Math.sin(ang)),0,(Math.cos(ang)),0},
                     {0,0,0,1}
        };
        
        int [][] res = xMatriz(T, P);
        imprimirMatriz(res);
        
        for (int i = 0; i < 8; i++) {
            puntosFinales[i] = new punto3D(res[0][i], res[1][i], res[2][i]);
            System.out.println("transformaciones.Cubo3D.TranslationAnimation()"+i);
       }
        System.out.println("prueba"+ res[2][1]);
        
        return (new Cubo3D(puntosFinales));
    }
   
   public static int[][] xMatriz(double[][] a, int[][] b) {
    int[][] c = new int[a.length][b[0].length];
    // se comprueba si las matrices se pueden multiplicar
    if (a[0].length == b.length) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    // aquí se multiplica la matriz
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }
    }
    /**
     * si no se cumple la condición se retorna una matriz vacía
     */
    return c;
}
   public void imprimirMatriz(int [][] matriz){
        for (int x=0; x < matriz.length; x++){
        for (int y=0; y < matriz[x].length; y++)
              System.out.print(" | " + matriz[x][y]+ " | ");   
        System.out.println("\n----------------------------------------");

}
    }
   
  
   
}

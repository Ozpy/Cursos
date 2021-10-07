/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoanimacion3d;

/**
 *
 * @author Oscar
 */
public class punto3D {
    int x;
    int y;
    int z;

    punto3D(int x, int y, int z) {
         this.x =x;
        this.y =y;
        this.z =z;
    }
    public punto3D derecha(int n){
        return new punto3D(x, y+n, z);
    }
    public punto3D izquierda(int n){
        return new punto3D(x, y-n, z);
    }
    public punto3D arriba(int n){
        return new punto3D(x, y, z+n);
    }
    public punto3D abajo(int n){
        return new punto3D(x, y, z-n);
    }
    public punto3D adelante(int n){
        return new punto3D(x-n, y, z);
    }
    public punto3D atras(int n){
        return new punto3D(x+n, y, z);
    }
}
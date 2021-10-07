import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JFrame;
/**
/* GaciaChavezOscarAlejandro_18310105_Actividad_2
*/
public class GaciaChavezOscarAlejandro_18310105_Actividad_2 extends JFrame implements Runnable{

  private Thread th;
  int var1 = 0;
  //Parpadeo como global
  Image imag;
  Graphics gBuffer;

  public int consumidor;
  static int producto=0;
  static Object lock = new Object();



  public GaciaChavezOscarAlejandro_18310105_Actividad_2(int consumidor) {
    this.consumidor=consumidor;
  }

  public static void main(String[] args) {
    GaciaChavezOscarAlejandro_18310105_Actividad_2 main = new GaciaChavezOscarAlejandro_18310105_Actividad_2(2);
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setTitle("Actividad");
    main.setSize(1000, 1000);
    main.setLocationRelativeTo(null);
    main.setLayout(null);
    main.setVisible(true);
    main.th = new Thread(main);
    main.th.start();
    //int nHilos = 11;

    //Thread[] hilos = new Thread[nHilos];
    //for (int i=0;i<nHilos;i++) {
      //Runnable run = null;
      //if (i!=0) {
        //run =new GaciaChavezOscarAlejandro_18310105_Actividad_2(1);
      //} else {
        //run = new GaciaChavezOscarAlejandro_18310105_Actividad_2(0);
      //} 
      //hilos[i] = new Thread(run);
      //hilos[i].start();
    //}
    //for (int i=0;i<hilos.length ;i++ ) {
      //try {
        //hilos[i].join();
      //} catch(Exception e){
        //e.printStackTrace();
      //}
    //}

  }

  public void paint(Graphics g) {
    //buffer
    if(gBuffer==null){
      gBuffer=imag.getGraphics();
      imag=createImage(this.getWidth(), this.getHeight());
    }
    gBuffer.setColor(getBackground());
    gBuffer.fillRect(0,0, this.getWidth(), this.getHeight());
    gBuffer.setColor(Color.black);

    //Content
    gBuffer.drawOval(100, 100, 100+var1, 100);
    this.getGraphics().drawImage(imag, 0, 0, null);
  }

  @Override
  public void run() {
    if (consumidor!=2) {
      while (true) {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e){
          e.printStackTrace();
        }
        var1 += 10;
        paint(this.getGraphics());
      }
    //}else{
      //while (true) {
        //if (consumidor==1) {
          //consumendo();

        //}else{
          //cocinando();

        //}
      //}
    }
  }
  private void consumendo() {
      
}
private void cocinando() {
    synchronized(lock){
      if (producto==0) {
        producto=9;
        System.out.println("Cocinero: Ya hay "+producto+" productos");
        lock.notifyAll();
      }
      try {
        lock.wait();
      } catch(Exception e){
        e.printStackTrace();
      }
    }

  }
}

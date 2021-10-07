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

/**
 * /* GaciaChavezOscarAlejandro_18310105_Actividad_2
 */
public class BaseAnimacion3 extends JFrame implements Runnable {

  private Thread th;
  int var1 = 0;

  // Parpadeo
  Image imag;
  Graphics gBuffer;

  public int consumidor;
  static int producto = 0;
  static Object lock = new Object();

  public BaseAnimacion3() {
  }

  public static void main(String[] args) {
    BaseAnimacion3 main = new BaseAnimacion3();
    main.setTitle("Actividad");
    main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    main.setSize(1000, 1000);
    main.setLocationRelativeTo(null);
    main.setLayout(null);
    main.setVisible(true);

    main.th = new Thread(main);
    main.th.start();
  }

  public void update(Graphics gBuffer) {
    paint(gBuffer);
  }

  public void paint(Graphics g) {
    // buffer
    if (gBuffer == null) {
      imag = createImage(this.getWidth(), this.getHeight());
      gBuffer = imag.getGraphics();
    }
    gBuffer.setColor(getBackground());
    gBuffer.fillRect(0, 0, this.getWidth(), this.getHeight());
    gBuffer.setColor(Color.black);

    this.getGraphics().drawOval(0 + var1, 0, 100, 100);
    gBuffer.drawOval(30 + var1, 30, 100, 100);
    this.getGraphics().drawImage(imag, 0, 0, null);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      var1 += 10;
      update(this.getGraphics());
    }
  }

}

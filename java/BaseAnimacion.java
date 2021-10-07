/**
/* GaciaChavezOscarAlejandro_18310105_Actividad_2
*/
public class BaseAnimacion extends JFrame implements Runnable{

  private Thread th;
  int var1 = 0;

  //Parpadeo
  Image imag;
  Graphics gBuffer;

  public BaseAnimacion() {
    this.setTitle("Actividad");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(1000, 1000);
    setLocationRelativeTo(null);
    setLayout(null);
    setVisible(true);

    this.th = new Thread(this);
    th.start();

  }

  public static void main(String[] args) {
     BaseAnimacion main = new BaseAnimacion();
  }

  public void update(Graphics gBuffer) {
    paint(gBuffer);
  }

  public void paint(Graphics g) {
   //buffer
    if(gBuffer==null){
      imag=createImage(this.getWidth(), this.getHeight());
      gBuffer=imag.getGraphics();
    }
    gBuffer.setColor(getBackground());
    gBuffer.fillRect(0,0, this.getWidth(), this.getHeight());
    gBuffer.setColor(Color.black);

    this.getGraphics().drawOval(0+var1,0,100,100);
   gBuffer.drawOval(30+var1,30,100,100);
    this.getGraphics().drawImage(imag, 0, 0, null);
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e){
        e.printStackTrace();
      }
      var1 += 10;
      update(this.getGraphics());
    }
  }

}

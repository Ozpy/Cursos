import javax.swing.JFrame;

public class Prueba1 implements Runnable {

	public Prueba1() {

	}

	public static void main(String[] args) {
		JFrame v = new JFrame();
		v.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		v.setVisible(true);
		v.setBounds(100, 100, 600, 400);
		System.out.println("Hola");
		Prueba1 main = new Prueba1();
		main.run();

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("Corriendo");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

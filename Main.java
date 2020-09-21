package no.hvl.dat108.oppg2;

public class Main {

	public static void main(String[] args) {

		Hamburger h = new Hamburger();

		for (int i = 1; i <= 3; i++) {
			KokkTraad kokk = new KokkTraad("Kokk" + i, h);
			kokk.start();
		}

		for (int i = 1; i <= 2; i++) {
			ServitorTraad servitor = new ServitorTraad("Servitør" + i, h);
			servitor.start();
		}

	}
}

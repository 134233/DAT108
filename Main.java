package no.hvl.dat108.oppg2;

public class Main {

	public static void main(String[] args) {
		
		// delt ressurs objekt new
		Hamburger h = new Hamburger();
		
		// Oppretter og starter Kokkene
		for (int i=1; i<=3; i++) {
			KokkTraad kokk = new KokkTraad(h);
			kokk.setName("Kokk" + i);
			kokk.start();
		}
		
		// Oppretter og starter Servitørene
		for (int i=1; i<=2; i++) {
			ServitorTraad servitor = new ServitorTraad(h);
			servitor.setName("Servitør" + i);
			servitor.start();
		}
		

		}}

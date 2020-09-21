package no.hvl.dat108.oppg2;

import java.util.Random;

public class ServitorTraad extends Thread {

	private Hamburger hamburger;
	Random random = new Random();

	public ServitorTraad(String navn, Hamburger hamburger) {
		super(navn);
		this.hamburger = hamburger;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (hamburger) {
				while (hamburger.erTom()) {
					System.out.println("### " + Thread.currentThread().getName()
							+ " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
					try {
						hamburger.wait();
					} catch (InterruptedException e) {
					}
				}

				try {
					sleep((2 + random.nextInt(5)) * 1000);
				} catch (InterruptedException e) {
				}

				String fjernet = hamburger.taAv();
				hamburger.notifyAll();
				System.out.println(Thread.currentThread().getName() + " tar av hamburger " + fjernet + " => "
						+ Hamburger.getRutsjebane());
			}
		}
	}
}

package no.hvl.dat108.oppg2;

import java.util.Random;

public class KokkTraad extends Thread {

	private Hamburger hamburger;
	Random random = new Random();

	public KokkTraad(String navn, Hamburger hamburger) {
		super(navn);
		this.hamburger = hamburger;
	}

	@Override
	public void run() {

		while (true) {

			synchronized (hamburger) {
				while (hamburger.erFull()) {
					System.out.println("### " + Thread.currentThread().getName()
							+ " er klar med en hamburger, men rutsjebanener full. Venter! ###");

					try {
						hamburger.wait();
					} catch (InterruptedException e) {
					}
				}

				try {
					sleep((2 + random.nextInt(5)) * 1000);
				} catch (InterruptedException e) {
				}

				hamburger.LeggPaa(hamburger.getI() + 1);
				hamburger.notifyAll();
				System.out.println(Thread.currentThread().getName() + " legger på hamburger " + hamburger.getI()
						+ " => " + Hamburger.getRutsjebane());
			}

		}

	}

}

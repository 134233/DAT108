package no.hvl.dat108.oppg2;

import java.util.Random;

public class ServitorTraad extends Thread {

	private Hamburger hamburger1;
	Random random = new Random();
	
	public ServitorTraad(Hamburger hamburger) {
		this.hamburger1 = hamburger;
	}
	
	@Override
	public void run() {
		
		while (true) {
			synchronized(hamburger1) {
				while (!hamburger1.erTom()) {
					try {
						System.out.println("### " + Thread.currentThread().getName() + " vil ta en hamburger, men rutsjebanen er tom. Venter! ###");
						hamburger1.wait();
					} catch (InterruptedException e) {
					}
				}
				
				try {
					sleep((2 + random.nextInt(4)) * 1000);
				} catch (InterruptedException e) {
				}
				
				String fjernet = hamburger1.taAv();
				hamburger1.notifyAll();
				System.out.println(Thread.currentThread().getName() + " tar av hamburger " + fjernet + " => " + Hamburger.getRutsjebane());
			}
		}
	}
}

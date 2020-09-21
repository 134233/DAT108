package no.hvl.dat108.oppg2;

import java.util.Random;

public class KokkTraad extends Thread {
	
	private Hamburger hamburger;
	Random random = new Random();
	
	public KokkTraad(Hamburger hamburger) {
		this.hamburger = hamburger;
	}
	
	@Override
	public void run() {
		
		while (true) {
			
			synchronized(hamburger) {
				while (!hamburger.erLedig()) { 
					try {
						System.out.println("### " + Thread.currentThread().getName() + " er klar med en hamburger, men rutsjebanener full. Venter! ###");
						hamburger.wait();
					} catch (InterruptedException e) {
					}
				}
					
				try {
					sleep((2 + random.nextInt(4)) * 1000);
				} catch (InterruptedException e) {
				}
				
				
				hamburger.LeggPaa(hamburger.getI() + 1);
				hamburger.notifyAll();
				System.out.println(Thread.currentThread().getName() + " legger på hamburger " + hamburger.getI() + " => " + Hamburger.getRutsjebane());
			}
			
		}
		
	}
	
	
}

package no.hvl.dat108.oppg2;

import java.util.LinkedList;
import java.util.Queue;

public class Hamburger {
	
	// teller for hamburger nummer
	public int i = 0;

	static Queue<String> rutsjebane = new  LinkedList<>();

	public boolean erLedig() {
		if (rutsjebane.size() < 5) {
			return true;
		}
		return false;
	}

	public static Queue<String> getRutsjebane() {
		return rutsjebane;
	}

	public void LeggPaa(int i) {
		rutsjebane.add("(" +i + ")");
		this.i = i;
	}

	public int getI() {
		return i;
	}

	public String taAv() {
		String fjernet = rutsjebane.remove();
		return fjernet;
		
	}

	public boolean erTom() {
		if (rutsjebane.size() > 0) {
			return true;
		}
		return false;
	}
	
}

package no.hvl.dat108.oppg2;

import java.util.LinkedList;
import java.util.Queue;

public class Hamburger {

	public int i = 0;

	static Queue<String> rutsjebane = new LinkedList<>();

	public static Queue<String> getRutsjebane() {
		return rutsjebane;
	}

	public boolean erFull() {
		return rutsjebane.size() == 5;
	}

	public boolean erTom() {
		return rutsjebane.size() == 0;
	}

	public void LeggPaa(int i) {
		rutsjebane.add("(" + i + ")");
		this.i = i;
	}

	public String taAv() {
		String fjernet = rutsjebane.remove();
		return fjernet;
	}

	public int getI() {
		return i;
	}

}

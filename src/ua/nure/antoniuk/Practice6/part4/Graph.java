package ua.nure.antoniuk.Practice6.part4;

import java.util.HashSet;
import java.util.Set;

public class Graph {
	private int count = 0;
	private Set<Rib> set = new HashSet<>();

	public Graph(int count) {
		this.count = count;
	}

	public boolean addRebro(int from, int to) {
		if (from > count || to > count || from == 0 || to == 0) {
			throw new IllegalArgumentException();
		}
		Rib rib = new Rib(from, to);
		return set.add(rib);
	}

	public boolean removeRebro(int from, int to) {
		if (from > count || to > count || from == 0 || to == 0) {
			throw new IllegalArgumentException();
		}
		Rib rib = new Rib(from, to);
		return set.remove(rib);
	}


}



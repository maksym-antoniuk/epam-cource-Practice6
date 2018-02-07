package ua.nure.antoniuk.Practice6.part7;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Part7 {

	public static void main(String[] args) {
		Range range = new Range(3, 10, false);
		for (Integer i : range) {
			System.out.println(i);
		}
	}

}

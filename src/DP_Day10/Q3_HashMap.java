package DP_Day10;

import java.util.*;

public class Q3_HashMap {
	public static void main(String[] args) {
		
		HashMap <Integer, String> patients = new HashMap<>();
		 patients.put(103, "Pratyush");
		 patients.put(321, "Pratyush");
		 patients.put(222, "Raj");
		 patients.put(401, "Pratyush");
		 patients.put(124, "Gaurav");
		 patients.put(103, "Pratyush");
		 
		 System.out.println(patients);
		 
		 patients.put(124, "Gaurav Kumar");
		 
		 System.out.println(patients.get(401));
		 
		 System.out.println(patients.containsKey(102));
		 System.out.println(patients.containsValue("Raj"));
		 
		 patients.remove(103);
		 
		 System.out.println(patients);
		 
		 System.out.println(patients.size());
		 
		 patients.clear();
	}
}

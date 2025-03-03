package no.hvl.dat102.stabel.main;

import no.hvl.dat102.stabel.adt.LenketStabel;

import java.util.Map;

public class ParentesSjekker {
	
	public static boolean sjekkParanteser(String s) {
		
		final Map<Character, Character> par = Map.of(
				'(',')',
				'{','}',
				'[',']'
				);
		
		LenketStabel<Character> stabel = new LenketStabel<Character>();
		
		for(char c : s.toCharArray()) {
			if(par.containsKey(c)) {
				stabel.push(c);
			} else if (par.containsValue(c)) {
				if(stabel.isEmpty() || par.get(stabel.pop()) != c) {
					return false;
				}
			}
		}
		
		return stabel.isEmpty();
	}
	
	
}

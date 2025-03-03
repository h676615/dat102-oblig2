package no.hvl.dat102.stabel.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import no.hvl.dat102.stabel.main.ParentesSjekker;

public class ParantesSjekkerTest {
	@Test
	void testGyldigeStrenger() {
		assertTrue(ParentesSjekker.sjekkParanteser("{ [ ( ) ] }"));
		assertTrue(ParentesSjekker.sjekkParanteser("""
				    class HelloWorld {
				        public static void main(String[] args) {
				            System.out.println("Hello World!");
				        }
				        }
				"""));
	}

	@Test
	void testUgyldigeStrenger() {
		assertFalse(ParentesSjekker.sjekkParanteser("{ [ ( ) }"));
		assertFalse(ParentesSjekker.sjekkParanteser("[ ( ) ] }"));
		assertFalse(ParentesSjekker.sjekkParanteser("{ [ ( ] ) }"));
	}
}

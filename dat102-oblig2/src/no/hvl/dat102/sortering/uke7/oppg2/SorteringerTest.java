package no.hvl.dat102.sortering.uke7.oppg2;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SorteringerTest {

	Integer[] usortert;
	Integer[] sortert;
	String[] navnUsortert;
	String[] navnSortert;

	@BeforeEach
	void setUp() {
		usortert = new Integer[] { 3, 4, 2, 1, 5 };
		sortert = new Integer[] { 1, 2, 3, 4, 5 };
		navnUsortert = new String[] { "Gunnar", "Arne" };
		navnSortert = new String[] { "Arne", "Gunnar" };
	}

	@Test
	void insertionSortTest() {
		Sorteringer.insertionSort(usortert);
		assertArrayEquals(sortert, usortert);
		Sorteringer.insertionSort(navnUsortert);
		assertArrayEquals(navnSortert, navnUsortert);
	}

	@Test
	void selectionSortTest() {
		Sorteringer.selectionSort(usortert);
		assertArrayEquals(sortert, usortert);
	}
	
	@Test
	void quickSortTest() {
		Sorteringer.quickSort(usortert);
		assertArrayEquals(sortert, usortert);
	}
	
	@Test
	void mergeSortTest() {
		Sorteringer.mergeSort(usortert);
		assertArrayEquals(sortert, usortert);
	}

}

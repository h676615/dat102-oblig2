package no.hvl.dat102.sortering.uke7.oppg2;

import java.util.Arrays;
import java.util.Random;

public class Sorteringer {

	public static void main(String[] args) {

		int[] str = { 32000, 64000, 128000 };
		String[] typer = { "insert", "select", "quick", "merge" };
		int antall = 10;
		Random rand = new Random();

		for (String type : typer) {
			System.out.println(type);
			for (int n : str) {
				
				long totalTid = 0;
				
				for(int i = 0; i < antall; i++) {
					Integer[] a	 = new Integer[n];
					for(int j = 0; j < n; j++) {
						a[j] = rand.nextInt();
					}
					
					long start = System.currentTimeMillis();
					switch (type) {
					case "insert": insertionSort(a); break;
					case "select": selectionSort(a); break;
					case "quick" : quickSort(a); break;
					case "merge" : mergeSort(a); break;
					default: break;
					}
					long slutt = System.currentTimeMillis();
					
					long tid = slutt-start;
					totalTid += tid;
				}
				double gjennomsnitt = totalTid / antall;
				double c;
				double log2 = (Math.log(n)/Math.log(2));
				String cSvar = null;
				switch (type) {
				case "insert": 
					c = (gjennomsnitt/Math.pow(n,2))*1000000; 
					cSvar = "Teoretisk tid; "+ c +" (x10^(-6)) ms per n^2";
					break;
				case "select": 
					c = (gjennomsnitt/Math.pow(n,2))*1000000; 
					cSvar = "Teoretisk tid; "+ c +" (x10^(-6)) ms per n^2"; 
				break;
				case "quick" : 
					c = (gjennomsnitt/(n*log2))*1000000; 
					cSvar = "Teoretisk tid; "+ c +" (x10^(-6)) ms per nlog(n)"; 
					break;
				case "merge" : 
					c = (gjennomsnitt/(n*log2))*1000000;
					cSvar = "Teoretisk tid; "+ c +" (x10^(-6)) ms per nlog(n)"; 
					break;
				default: break;
				}

				System.out.println("N = "+n + ", \tSnitttid: "+ gjennomsnitt + "ms, \t"
						+ cSvar);
			}

		}

	}

	public static <T extends Comparable<? super T>> void insertionSort(T[] a) {
		for (int i = 1; i < a.length; i++) {
			T temp = a[i];
			int j = i;
			while (j > 0 && temp.compareTo(a[j - 1]) < 0) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void selectionSort(T[] a) {
		for (int i = 0; i < a.length; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j].compareTo(a[min]) < 0) {
					min = j;
				}
			}
			T temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
	}

	public static <T extends Comparable<? super T>> void quickSort(T[] array) {
		quickSortHelper(array, 0, array.length - 1);
	}

	private static <T extends Comparable<? super T>> void quickSortHelper(T[] array, int low, int high) {
		if (low < high) {
			int pivotIndex = partition(array, low, high);
			quickSortHelper(array, low, pivotIndex - 1);
			quickSortHelper(array, pivotIndex + 1, high);
		}
	}

	private static <T extends Comparable<? super T>> int partition(T[] array, int low, int high) {
		T pivot = array[high];
		int i = low - 1;
		for (int j = low; j < high; j++) {
			if (array[j].compareTo(pivot) < 0) {
				i++;
				T temp = array[i];
				array[i] = array[j];
				array[j] = temp;
			}
		}
		T temp = array[i + 1];
		array[i + 1] = array[high];
		array[high] = temp;
		return i + 1;
	}

	public static <T extends Comparable<? super T>> void mergeSort(T[] array) {
		if (array.length < 2)
			return;
		int mid = array.length / 2;
		T[] left = Arrays.copyOfRange(array, 0, mid);
		T[] right = Arrays.copyOfRange(array, mid, array.length);

		mergeSort(left);
		mergeSort(right);
		merge(array, left, right);
	}

	private static <T extends Comparable<? super T>> void merge(T[] array, T[] left, T[] right) {
		int i = 0, j = 0, k = 0;
		while (i < left.length && j < right.length) {
			if (left[i].compareTo(right[j]) <= 0) {
				array[k++] = left[i++];
			} else {
				array[k++] = right[j++];
			}
		}
		while (i < left.length) {
			array[k++] = left[i++];
		}
		while (j < right.length) {
			array[k++] = right[j++];
		}
	}

}

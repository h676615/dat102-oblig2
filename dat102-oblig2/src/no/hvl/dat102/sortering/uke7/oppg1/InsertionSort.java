
package no.hvl.dat102.sortering.uke7.oppg1;

import java.util.Random;
public class InsertionSort {

    public static void main(String[] args) {

        int str = 80000; 
        Integer[] a = new Integer[str];
        Random rand = new Random();
        for (int i = 0; i < str; i++) {
            a[i] = rand.nextInt();
        }
        
        long start = System.currentTimeMillis();
        insertionSort(a, str);
        long slutt = System.currentTimeMillis();
        
        double total = (slutt - start)/1000.0;
        System.out.println(total);
    }

    
    public static <T extends Comparable<? super T>> void insertionSort(T[] a, int n) {
        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        
        byttOm(a, minIndex, 0);

        for (int i = 1; i < n - 1; i += 2) {
            T minste = a[i];
            T største = a[i + 1];

            if (minste.compareTo(største) > 0) {
                T temp = minste;
                minste = største;
                største = temp;
            }

            int j = i - 1;
            while (j >= 0 && a[j].compareTo(største) > 0) {
                a[j + 2] = a[j];
                j--;
            }
            a[j + 2] = største;

            j++;
            while (j >= 0 && a[j].compareTo(minste) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = minste;
        }

        if (n % 2 != 0) {
            T siste = a[n - 1];
            int j = n - 2;
            while (j >= 0 && a[j].compareTo(siste) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = siste;
        }
    }

    private static <T> void byttOm(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

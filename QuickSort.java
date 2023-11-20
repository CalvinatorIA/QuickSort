package manageQuickSort;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/******************************
 * @author Calvin Andersen
 * I did NOT work with anyone else for this Project
 * 
 * Start date: 04/27/2022
 * Finish date: 04/28/2022
 * 
 * This Project implements the Quicksort algorithm.
 ******************************/

public class QuickSort {
	public static void main(String[] args) {
		List<Integer> integerList = new ArrayList<>();
		List<String> stringList = new ArrayList<>();
		List<Float> floatList = new ArrayList<>();
		List<Double> doubleList = new ArrayList<>();
		
		// Add 20 elements to integerList
		for (int i = 0; i < 20; i++)
			integerList.add((int) (Math.random() * 100) + 1);
		
		// Add 20 elements to stringList
		for (int i = 0; i < 20; i++) {
			switch((int) (Math.random() * 8)) {
			case 0: stringList.add("Bob"); break;
			case 1: stringList.add("Bill"); break;
			case 2: stringList.add("Joe"); break;
			case 3: stringList.add("Jim"); break;
			case 4: stringList.add("Jill"); break;
			case 5: stringList.add("Ann"); break;
			case 6: stringList.add("Jane"); break;
			case 7: stringList.add("Sally"); break;
			}
		}
		
		// Add 20 elements to floatList
		for (int i = 0; i < 20; i++)
			floatList.add((float) (Math.random() * 100) + 1);
		
		// Add 10 elements to doubleList
		for (int i = 0; i < 10; i++)
			doubleList.add(Math.random() * 100 + 1);
		
		// Display integerList
		System.out.println("Before quick sort: " + integerList.toString());
		quickSort(integerList);
		System.out.println("After quick sort: " + integerList.toString() + "\n");
		
		// Display stringList
		System.out.println("Before quick sort: " + stringList.toString());
		quickSort(stringList);
		System.out.println("After quick sort: " + stringList.toString() + "\n");
		
		// Display floatList
		System.out.println("Before quick sort: " + floatList.toString());
		quickSort(floatList);
		System.out.println("After quick sort: " + floatList.toString() + "\n");
		
		// Display doubleList
		System.out.println("Before quick sort: " + doubleList.toString());
		quickSort(doubleList);
		System.out.println("After quick sort: " + doubleList.toString() + "\n");
	}
	
	private static String addCommas(long number) {
		DecimalFormat formatter = new DecimalFormat("#,###");
		
		return formatter.format(number);
  }
  
	private static <E extends Comparable<E>> void quickSort(List<E> arr) {
		int low = 0;
		int high = arr.size() - 1;
		
		if (low < high) {
			
	        int pi = partition(arr, low, high);
	        
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}
	private static <E extends Comparable<E>> void quickSort(List<E> arr, int low, int high) {
		if (low < high) {
			
	        int pi = partition(arr, low, high);
	        
	        quickSort(arr, low, pi - 1);
	        quickSort(arr, pi + 1, high);
	    }
	}
	private static <E extends Comparable<E>> int partition(List<E> arr, int low, int high) {
	    E pivot = arr.get(high);
	    int i = (low - 1);
	    
	    for (int j = low; j <= high - 1; j++) {
	        //arr.get(j) < pivot
	        if (arr.get(j).compareTo(pivot) < 0) {
	            i++;
	            swap(arr, i, j);
	        }
	    }
	    
	    swap(arr, i + 1, high);
	    return (i + 1);
	}
	private static <E extends Comparable<E>> void swap(List<E> arr, int i, int j) {
		E temp = arr.get(i);
		arr.set(i, arr.get(j));
		arr.set(j, temp);
	}
}

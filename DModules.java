package modules;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class DModules {
	
	public static <T extends Comparable<T>>int binarySearch(List<T> list, T target) {
		int min = 0;
		int max = list.size() - 1;
		int mid;
		while (min <= max) {
			mid = (min + max)/2;
			if(list.get(mid).compareTo(target) == 0) {
				return mid;
			}else if(list.get(mid).compareTo(target) < 0) {
				min = mid + 1;
			}else {
				max = mid - 1;
			}
		}
		return -1;		 
	}
	
	public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
		
		for (int i = 0; i < list.size(); i++) {
			for(int j = 1; j < list.size() - i; j++) {
				if(list.get(j).compareTo(list.get(j-1))< 0) {
					swap(list, j, j-1);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>>void insertionSort(List<T> list) {
		int j;
		for(int i = 1; i < list.size(); i++) {
			j = i;
			while (j > 0 && list.get(j).compareTo(list.get(j - 1)) < 0) {
				swap(list, j, j - 1);
				j--;
			}
		}
	}
	public static <T extends Comparable<T>>void maxInsertSort(List<T> list) {
		int j;
		for(int i = 1; i < list.size(); i++) {
			j = i;
			while (j > 0 && list.get(j).compareTo(list.get(j - 1)) > 0) {
				swap(list, j, j - 1);
				j--;
			}
		}
	}
	
	public static <T> void maxSelectionSort(List<T> list, Comparator<T> comp) {
		int minIndex;
		for(int i = 0; i < list.size() - 1; i++) {
			minIndex = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(comp.compare(list.get(j), list.get(minIndex)) > 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(list,minIndex, i);
			}
		}
	}
	// Merges the left/right elements into a sorted result.
	// Precondition: left/right are sorted
	private static <T extends Comparable<T>> void merge(List<T> list, List<T> left, List<T> right) {
		int index 		= 0;		// index of data array
		int leftIndex 	= 0;		// index in left array
		int rightIndex 	= 0;		// index in right array
		
		while(leftIndex < left.size() && rightIndex < right.size()) {
			if(left.get(leftIndex).compareTo(right.get(rightIndex)) < 0) 
				list.set(index++, left.get(leftIndex)); 
			else {
				list.set(index++, right.get(rightIndex));
			}
		}
		while(leftIndex < left.size()) {
			list.set(index++, left.get(leftIndex));
		}
		while(rightIndex < right.size()) {
			list.set(index++, right.get(rightIndex));
		}
	}
	
	public static <T extends Comparable<T>> void mergeSort(List<T> list) {
		if(list.size()> 1) {
			List<T> left = splitFirstHalf(list);
			List<T> right = splitSecondHalf(list);
		
			// sort the two halves
			mergeSort(left);
			mergeSort(right);
		
			// merge the sorted halves into a sorted whole
			merge(list, left, right);
		}
	}
	
	private static <T extends Comparable<T>> int partition(List<T> list, int low, int high) {
		int mid;
		T pivot;
		boolean comp;
		mid = low + (high - low) / 2;
		pivot = list.get(mid);
		comp = false;

		while (!comp) {
			while (list.get(low).compareTo(pivot) < 0) { ++low; }
			while (pivot.compareTo(list.get(high)) < 0) { --high; }
			if (low >= high) {
				comp = true;
			} else {
				swap(list, low, high);
				++low;
				--high;
			}
		}
		return high;
	}
	
	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		quickSort(list, 0, list.size() - 1);	
	}
	
	private static <T extends Comparable<T>> void quickSort(List<T> list, int left, int right) {
		if(left < right) {
			int mid = partition(list, left, right);
			
				quickSort(list, left ,mid);
				quickSort(list, mid + 1 ,right);
		}
	}
	
	public static <T> void selectionSort(List<T> list, Comparator<T> comp) {
		int minIndex;
		for(int i = 0; i < list.size() - 1; i++) {
			minIndex = i;
			for(int j = i + 1; j < list.size(); j++) {
				if(comp.compare(list.get(j), list.get(minIndex)) < 0) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(list,minIndex, i);
			}
		}
	}
	
	private static <T> List<T> splitFirstHalf(List<T> list) {
		int listing = list.size()/ 2;
		List<T> firstHalf = new ArrayList<T>(listing);
		for (int i = 0; i < listing; i++) {
			firstHalf.set(i, list.get(i));
		}
		return firstHalf;
	}
	
	private static <T> List<T> splitSecondHalf(List<T> list) {
		int listing = list.size()/ 2;
		List<T> secondHalf = new ArrayList<T>(listing);
		for (int i = 0; i < listing; i++) {
			secondHalf.set(i, list.get(i));
		}
		return secondHalf;
	}
	
	public static <T> void swap(List<T> list, int a, int b) {
		T temp = list.get(a);
		list.set(a,  list.get(b));
		list.set(b,  temp);
	}
	
	public static <T> void swap(List<T> list, T a, T b) {
		list.set(list.indexOf(a), b);
		list.set(list.indexOf(b), a);
		
	}
}

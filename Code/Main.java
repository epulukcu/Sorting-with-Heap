import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/**
 * 
 * @author Elif Pulukçu Student ID: 041701017
 * December 16th, 2019
 * Program Explanation: The program aims to compare speeds of a Heapsort algorithm, Java's sorting algorithm and
 * selection sort algorithm.
 * Hence, I create an integer array of size 40000 as user input. 
 * Fill the array with random integers with values in the range [0,10000000] by the help of Random class.
 * Then, I perform sort operations and record elapsed time for the sorting algorithm with System.nanoTime() method.
 * Repeat these steps ten times and report timing to get an average elapsed time in milliseconds. 
 */
public class Elif_Pulukcu {
	/**
	 * Method Explanation: This method creates a Heap and adds elements to the Heap. Then, remove elements from the heap
	 * because when removing elements from a Heap it will sorted.
	 * @param list Method takes an array of Integers that named list as a parameter
	 */
	public static void heapSort(Integer[] list) {

		// Create a heap
		Heap<Integer> heap = new Heap<Integer>();

		// Add elements to the heap
		for (int i = 0; i < list.length; i++) {
			heap.add(list[i]);
		}

		// Remove elements from the heap to sort it
		for (int i = 0; i < list.length; i++) {
			heap.remove();
		}
	}
	/**
	 *
	 * Method Explanation: Selection Sort is a sorting method in Java which finds firstly minimum element of the array.
	 * Then, swap the minimum element with the element that located in the first index of the array. Consequently, repeating this
	 * operation n-1 times, whereas n is the number of elements in the array, array will sort.
	 * @param list Method takes an array of Integers that named list
	 */
	public static void selectionSort(Integer[] list) {

		// code for selection sort algorithm
		int k = 0; int min = 0; int j = 0; int n = list.length; int i = 0; int h = 0;
		for (i = 0; i < n - 1; i++) {
			k = i;
			for (j = i + 1; j < n; j++) {
				if (list[j] < list[k]) 
					min = j;
			}
			h = list[min];
			list[min] = list[i];
			list[i] = h;
		}
		// to print to content of the array
		/*
		 * for (i = 1; i <= n; i++) System.out.println(list[i]);
		 */
	}
	/**
	 * Method Explanation: In the main method, I created ten arrays based on random values and time values to measure 
	 * every sorting algorithm's sorting time. And then, with the conversation of nanoseconds to milliseconds and dividing 
	 * the sum of all the sort timing of algorithms by 10 gives the average sort time.
	 * @param args String[] args in Java is an array of strings which stores arguments passed by command line while starting a program. 
	 * All the command line arguments are stored in that array.
	 */
	public static void main(String[] args) {

		// Getting Parameters such as array size from user
		System.out.println("Please Enter Array Size:");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		System.out.println("Array Size :" + number);
		Integer[] intArrayForHeapSort = new Integer[number]; // Generating the Array for Heap Sort
		Integer[] intArrayForJavaArraySort = new Integer[number]; // Generating the Array for Java Array Sort
		Integer[] intArrayForSelectionSort = new Integer[number]; // Generating the Array for Selection Sort

		// Running Heap Sort Algorithm
		double hstime = 0;
		for (int hs = 1; hs < 11; hs++) {
			// 1- Generate the random numbers and assign to array
			Random random = new Random();
			for (int i = 0; i < intArrayForHeapSort.length; i++) {
				intArrayForHeapSort[i] = random.nextInt(10000000);
				// System.out.println(myIntArray[i]);
				// System.out.println(i);
			}
			
			// 2- Start the time
			long start = System.nanoTime();
			
			// 3- Sort the Array via Heap Sort
			heapSort(intArrayForHeapSort);

			// 4- End the time
			long finish = System.nanoTime();
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; // convert nanoseconds to milliseconds
			System.out.println(hs + ": " + elapsedTimeMilliSeconds + " msec");
			hstime += elapsedTimeMilliSeconds;
		}
		System.out.println("Average Sort Time for Heap Sort  : " + hstime / 10 + " msec");
		System.out.println("");


		// Running Java Array Sort Algorithm
		double jstime = 0;
		for (int js = 1; js < 11; js++) {
			// 1-Generate the random numbers and assign to array
			Random random = new Random();
			for (int i = 0; i < intArrayForJavaArraySort.length; i++) {
				intArrayForJavaArraySort[i] = random.nextInt(10000000);
				// System.out.println(myIntArray[i]);
				// System.out.println(i);
			}
			
			// 2- Start the time
			long start = System.nanoTime(); // After the creation of the arrays with random integers, start the time before sorting method run
			
			// 3- Sort the Array via Java Sort
			Arrays.sort(intArrayForJavaArraySort);

			// 4- End the time
			long finish = System.nanoTime();
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; // convert nanoseconds to milliseconds
			System.out.println(js + ": " + elapsedTimeMilliSeconds + " msec");
			jstime += elapsedTimeMilliSeconds;
		}
		System.out.println("Average Sort Time for Java Array Sort : " + jstime / 10 + " msec");
		System.out.println("");


		// Running Selection Sort Algorithm
		double sstime = 0;
		for (int ss = 1; ss < 11; ss++) {
			// 1-Generate the random numbers and assign to array
			Random random = new Random();
			for (int i = 0; i < intArrayForSelectionSort.length; i++) 
				intArrayForSelectionSort[i] = random.nextInt(10000000);
				// System.out.println(myIntArray[i]);
				// System.out.println(i);
	
			// 2- Start the time
			long start = System.nanoTime();
			
			// 3- Sort the Array via Java Sort
			selectionSort(intArrayForSelectionSort);

			// 4- End the time
			long finish = System.nanoTime();
			double elapsedTimeMilliSeconds = (finish - start) / 1000000.0; // convert nanoseconds to milliseconds
			System.out.println(ss + ": " + elapsedTimeMilliSeconds + " msec");
			sstime += elapsedTimeMilliSeconds;
		}
		System.out.println("Average Sort Time for Selection Sort : " + sstime / 10 + " msec");
		System.out.println("");
	}
}

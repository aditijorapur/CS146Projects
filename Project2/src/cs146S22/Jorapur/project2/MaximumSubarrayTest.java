package cs146S22.Jorapur.project2;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * This class is used to test the MaximumSubarray class.
 * @author Aditi Jorapur
 * @date 10/23/22
 */

public class MaximumSubarrayTest {
	
	public static String inputFile = "C:\\Users\\aditi\\Desktop\\CS146Projects\\Project2\\src\\cs146S22\\Jorapur\\project2\\maxSumtest.txt";

	@Test
	public void testBruteForce() throws NumberFormatException, IOException {
		ArrayList<String> lines = MaxSumFileReader.processInput(inputFile); //Creates a new arrayList of Strings called lines that contains the lines from the input file 
		//loops through all the test cases and puts 100 elements in the elements array while also converting to integers
		for(int i = 0; i < lines.size(); i++) {
//			System.out.println("processing line: " + i);
			String line = lines.get(i);
			String[] elements = line.split("  ");
			int[] array = new int[100];
			for(int j = 0; j < 100; j++) {
				if(elements[j].trim().length() > 0) {
					array[j] = Integer.parseInt(elements[j].trim());
				}
			}
		
			//creates a new array with the last 3 elements of the array which contains the actual Answers
			int[] actualAnswerArray = new int[3];
			actualAnswerArray[0] = Integer.parseInt(elements[101].trim());
			actualAnswerArray[1] = Integer.parseInt(elements[102].trim());
			actualAnswerArray[2] = Integer.parseInt(elements[100].trim());
			
			//creates a new array with the brute force maximum subarray algorithm 
			int[] calculatedAnswerArray = MaximumSubarray.bruteForceMaxSubarray(array);
			
			//tests to see if the actual answer is equal to the answer calculated by the brute force method
			for(int k = 0; k < 3; k++) {
				assertEquals(actualAnswerArray[k], calculatedAnswerArray[k]);
			}
		}
	}
	
	@Test
	public void testDivideAndConquer() throws NumberFormatException, IOException {
//		System.out.println("Test Divide and Conquer");
		ArrayList<String> lines = MaxSumFileReader.processInput(inputFile); //Creates a new arrayList of Strings called lines that contains the lines from the input file 
		//loops through all the test cases and puts 100 elements in the elements array while also converting to integers
		for(int i = 0; i < lines.size(); i++) {
//			System.out.println("processing line: " + i);
			String line = lines.get(i);
			String[] elements = line.split("  ");
			int[] array = new int[100];
			for(int j = 0; j < 100; j++) {
				if(elements[j].trim().length() > 0) {
					array[j] = Integer.parseInt(elements[j].trim());
				}
			}
			//creates a new array with the last 3 elements of the array which contains the actual Answers
			int[] actualAnswerArray = new int[3];
			actualAnswerArray[0] = Integer.parseInt(elements[101].trim());
			actualAnswerArray[1] = Integer.parseInt(elements[102].trim());
			actualAnswerArray[2] = Integer.parseInt(elements[100].trim());
			
			//creates a new array with the brute force maximum subarray algorithm 
			int[] calculatedAnswerArray = MaximumSubarray.divdeAndConquerMaxSubarray(array,0,array.length-1);
			
			//tests to see if the actual answer is equal to the answer calculated by the brute force method
			for(int k = 0; k < 3; k++) {
				assertEquals(actualAnswerArray[k], calculatedAnswerArray[k]);
			}

		}
	}
	
	
	@Test
	public void testKadanesAlgorithm() throws NumberFormatException, IOException {
//		System.out.println("Test Kadane's Algorithm");
		ArrayList<String> lines = MaxSumFileReader.processInput(inputFile); //Creates a new arrayList of Strings called lines that contains the lines from the input file 
		//loops through all the test cases and puts 100 elements in the elements array while also converting to integers
		for(int i = 0; i < lines.size(); i++) {
//			System.out.println("processing line: " + i);
			String line = lines.get(i);
			String[] elements = line.split("  ");
			int[] array = new int[100];
			for(int j = 0; j < 100; j++) {
				if(elements[j].trim().length() > 0) {
					array[j] = Integer.parseInt(elements[j].trim());
				}
			}
			//creates a new array with the last 3 elements of the array which contains the actual Answers
			int[] actualAnswerArray = new int[3];
			actualAnswerArray[0] = Integer.parseInt(elements[101].trim());
			actualAnswerArray[1] = Integer.parseInt(elements[102].trim());
			actualAnswerArray[2] = Integer.parseInt(elements[100].trim());
	
			//creates a new array with the brute force maximum subarray algorithm 
			int[] calculatedAnswerArray = MaximumSubarray.kadaneMaxSubarray(array);

			//tests to see if the actual answer is equal to the answer calculated by the brute force method
			for(int k = 0; k < 3; k++) {
				assertEquals(actualAnswerArray[k], calculatedAnswerArray[k]);
			}
		}
	}
	
	@Test
	public void test2BruteForce() {
		//creates an array and tests to see if brute force returns the correct values
		int[] testArray = {-2,-3,4,-1,-2,1,5,-3};
		//arrive, depart, sum
		int[] actualAnswerArray = {2,6,7};
		int[] calculatedAnswerArray = MaximumSubarray.bruteForceMaxSubarray(testArray);
		
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void test2DivideAndConquer() {
		//creates an array and tests to see if divide and conquer returns the correct values
		int[] testArray = {-2,-3,4,-1,-2,1,5,-3};
		//arrive, depart, sum
		int[] actualAnswerArray = {2,6,7};
		int[] calculatedAnswerArray = MaximumSubarray.divdeAndConquerMaxSubarray(testArray,0,testArray.length-1);
		
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void test2KadanesAlgorithm() {
		//creates an array and tests to see if Kadane's Algorithm returns the correct values
		int[] testArray = {-2,-3,4,-1,-2,1,5,-3};
		//arrive, depart, sum
		int[] actualAnswerArray = {2,6,7};
		int[] calculatedAnswerArray = MaximumSubarray.kadaneMaxSubarray(testArray);
		
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void test3BruteForce() {
		//creates a negative array and tests to see if brute force returns the correct values
		int[] testArray = {-3,-4,-5,-6,-7,-8,-9};
		//arrive, depart, sum
		int[] actualAnswerArray = {0,-1,0};
		int[] calculatedAnswerArray = MaximumSubarray.bruteForceMaxSubarray(testArray);
//		System.out.println("brute force " + calculatedAnswerArray[0] + " " + calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}

	@Test
	public void test3DivideAndConquer() {
		//creates a negative array and tests to see if divide and conquer returns the correct values
		int[] testArray = {-3,-4,-5,-6,-7,-8,-9,-10};
		//arrive, depart, sum
		//sum = 0, arrive = 0, depart = -1
		int[] actualAnswerArray = {0,-1,0};
		int[] calculatedAnswerArray = MaximumSubarray.divdeAndConquerMaxSubarray(testArray,0,testArray.length-1);
//		System.out.println("divide and conquer " + calculatedAnswerArray[0] + " " + calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void test3KadanesAlgorithm() {
		//creates a negative array and tests to see if kadane's algorithm returns the correct values
		int[] testArray = {-3,-4,-5,-6,-7,-8,-9,-10};
		//arrive, depart, sum
		//sum = 0, arrive = 0, depart = -1
		int[] actualAnswerArray = {0,-1,0};
		int[] calculatedAnswerArray = MaximumSubarray.kadaneMaxSubarray(testArray);
//		System.out.println("kadane's algorthm " + calculatedAnswerArray[0] + " " + calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testOneElementBruteForce() {
		//creates an one element array and tests to see if brute force returns the correct values
		int[] testArray = {3};
		int[] actualAnswerArray = {0,0,3};
		int[] calculatedAnswerArray = MaximumSubarray.bruteForceMaxSubarray(testArray);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testOneElementDivideAndConquer() {
		//creates an one element array and tests to see if divide and conquer returns the correct values
		int[] testArray = {3};
		int[] actualAnswerArray = {0,0,3};
		int[] calculatedAnswerArray = MaximumSubarray.divdeAndConquerMaxSubarray(testArray,0,testArray.length-1);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testOneElementKadanesAlgorithm() {
		//creates an one element array and tests to see if kadane's algorithm returns the correct values
		int[] testArray = {3};
		int[] actualAnswerArray = {0,0,3};
		int[] calculatedAnswerArray = MaximumSubarray.kadaneMaxSubarray(testArray);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testOneElementNegKadanesAlgorithm() {
		//creates a negative one element array and tests to see if kadane's algorithm returns the correct values
		int[] testArray = {-3};
		int[] actualAnswerArray = {0,-1,0};
		int[] calculatedAnswerArray = MaximumSubarray.kadaneMaxSubarray(testArray);
//		System.out.println(calculatedAnswerArray[0] + " "+ calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testOneElementNegBruteForce() {
		//creates a negative one element array and tests to see if brute force algorithm returns the correct values
		int[] testArray = {-3};
		int[] actualAnswerArray = {0,-1,0};
		int[] calculatedAnswerArray = MaximumSubarray.bruteForceMaxSubarray(testArray);
//		System.out.println(calculatedAnswerArray[0] + " "+ calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testTwoElementsBruteForce() {
		//creates a two element array and tests to see if brute force algorithm returns the correct values
		int[] testArray = {1,5};
		int[] actualAnswerArray = {0,1,6};
		int[] calculatedAnswerArray = MaximumSubarray.bruteForceMaxSubarray(testArray);
//		System.out.println(calculatedAnswerArray[0] + " "+ calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testTwoElementsDivideAndConquer() {
		//creates a two element array and tests to see if divide and conquer algorithm returns the correct values
		int[] testArray = {1,5};
		int[] actualAnswerArray = {0,1,6};
		int[] calculatedAnswerArray = MaximumSubarray.divdeAndConquerMaxSubarray(testArray,0,testArray.length-1);
//		System.out.println(calculatedAnswerArray[0] + " "+ calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	@Test
	public void testTwoElementsKadanesAlgorithm() {
		//creates a two element array and tests to see if kadane's algorithm returns the correct values
		int[] testArray = {1,5};
		int[] actualAnswerArray = {0,1,6};
		int[] calculatedAnswerArray = MaximumSubarray.kadaneMaxSubarray(testArray);
//		System.out.println(calculatedAnswerArray[0] + " "+ calculatedAnswerArray[1] + " " + calculatedAnswerArray[2]);
		for(int i = 0; i < 3; i++) {
			assertEquals(actualAnswerArray[i], calculatedAnswerArray[i]);
		}
	}
	
	

}

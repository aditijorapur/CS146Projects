package cs146S22.Jorapur.project2;

import java.util.Arrays;
import java.util.Random;

/**
 * The MaximumSubarray class contains three different algorithms that compute the maximum sub array. 
 * It has the bruteforce method, divide and conquer method with a crossSubarray helper method, and Kadanes Algorithm.
 * Each of these three methods have a different runtime with Kadane's Algorithm being the most efficient.
 * @author Aditi Jorapur
 * @date 10/23/22
 */
public class MaximumSubarray {

	// brute force algorithm O(n^2)
	/**
	 * Brute Force Algorithm for finding the Maximum Subarray with an O(n^2)
	 * runtime. First it creates a variable called maxSum that is equal to the
	 * smallest value. It also creates arrive and depart variables which indicate
	 * the start and end of the max subarray respectfully. It creates a new array
	 * called ans which will retunn the maxsum, arrive, and depart variables. Then
	 * it traverses through the array and initializes the current sum of the array
	 * to 0. It will traverse through the array again with another pointer that
	 * starts at the index of i. It checks to see if the currentSum is greater than
	 * the max sum and if it is, the currentSum is the new maxSum and it sets the
	 * values for arrive and departure. Checks to see if the sum is not negative and
	 * if it is, depart and maxsum are set to -1 and 0 respectfully. This method
	 * then returns the array od the maxsum, arrive, and depart of the max sub array
	 * of the array.
	 * 
	 * @param array the array we are going to traverse through
	 * @return returns the maxSum
	 */
	public static int[] bruteForceMaxSubarray(int[] array) {
		int maxSum = Integer.MIN_VALUE;
		int arrive = 0;
		int depart = 0;
		int[] ans = new int[3];
		
		/*
		 * traverses through the array and the inner loop traverses again starting from index i to the 
		 * end of the array. Calculates the possible sum and compares it with the overall maximum Sum.
		 */
//		System.out.println("inside brute force");
		for (int i = 0; i < array.length; i++) {
			int currentSum = 0;
			for (int j = i; j < array.length; j++) {
				currentSum += array[j];
				if (currentSum > maxSum) {
					maxSum = currentSum;
					arrive = i;
					depart = j;
				}
			}
		}
		//if the maxSum is less than 0, that is not allowed so depart and maxSum are reset
		if (0 >= maxSum) {
			arrive = 0;
			depart = -1;
			maxSum = 0;
		}
		//fills in the ans array with the maxSum, starting, and ending indices
		
		ans[0] = arrive;
		ans[1] = depart;
		ans[2] = maxSum;

		return ans;
	}

	/**
	 * the maxCrossSubarray is a helper method for the divide and conquer algorithm
	 * when calculating the maximum subarray. This method calculates the max of the
	 * left and right ends of an array by using the temporary sum and updating the
	 * final sum or the two sides. It returns the answer as an array that contains
	 * the maxLeft value, maxRight value, and the sum of the left and right;
	 * 
	 * @param array array we are calculating the cross sum for
	 * @param low   the leftmost value of the array
	 * @param mid   the middle value of the array
	 * @param high  the rightmost value of the array
	 * @return returns ans which is a array containing the maxleft variable,
	 *         maxright variable, and the sum
	 */
	public static int[] maxCrossSubarray(int[] array, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int rightSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = 0;
		int maxRight = 0;
		int[] ans = new int[3];
	
		//calculates the sum of the left side of the array
		for (int i = mid; i >= low; i--) {
			sum = sum + array[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}
		
		sum = 0;
		//calculates the sum of the right side of the array
		for (int j = mid + 1; j <= high; j++) {
			sum = sum + array[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		//puts the sum, and left and right indices in an array and returns it
		ans[0] = maxLeft;
		ans[1] = maxRight;
		ans[2] = leftSum + rightSum;
		return ans;
	}

	/**
	 * Divide and conquer algorithm O(nlgn)
	 * the divide and conquer algorithm is a recursive algorithm that calculates the maximum subarray and takes in three parameters.
	 * It first checks if the max is in the left side of the array, the right side, or the middle (cross).
	 * When only one element is being compared, the array is returned with the starting and ending values and the maxSum.
	 * It then calculates the leftArray, crossArray, and rightArray and compares all three.
	 * Finally, it returns the maxSum, the highest and lowest in the array. 
	 * @param array the array we are finding the max sum of
	 * @param low the leftmost value of the array
	 * @param high the rightmost value of the array
	 * @return one of the three arrays that contain the maxsum, starting and ending values
	 */
	public static int[] divdeAndConquerMaxSubarray(int[] array, int low, int high) {
		int[] leftArray;
		int[] crossArray;
		int[] rightArray;
		int[] ans = new int[3];
		
		
		//one element base case
		if(array.length == 1) {
			int[] ansArr = {0,0,array[0]};
			return ansArr;
		}
		
		//checks to see if the array is one negative element
		if(array.length == 1 && array[0] < 0) {
			int[] ansArr = {0,-1,0};
			return ansArr;
		}
		
		//base case that checks if we are comparing only one element
		if (low == high) {
			ans[0] = low;
			ans[1] = high;
			ans[2] = array[low];
			return ans;
		}
		//calculates the midpoint and recursively finds the high, low, and sum for the right and left side of the array and the middle.
		else {
			int middle = (low + high) / 2;
			leftArray = divdeAndConquerMaxSubarray(array, low, middle);
			ans[0] = leftArray[0];
			
			crossArray = maxCrossSubarray(array, low, middle, high);
			rightArray = divdeAndConquerMaxSubarray(array, (middle + 1), high);
		}
		//check if sum of rightArray is greatest
		if (leftArray[2] <= rightArray[2] && crossArray[2] <= rightArray[2]) {

			if (0 > rightArray[2]) {
				rightArray[0] = 0;
				rightArray[1] = -1;
				rightArray[2] = 0;

			}
			return rightArray;
		}
		//check if sum of leftArray is greatest
		if (rightArray[2] <= leftArray[2] && crossArray[2] <= leftArray[2]) {

			if (0 > leftArray[2]) {
				leftArray[0] = 0;
				leftArray[1] = -1;
				leftArray[2] = 0;
			}
			return leftArray;
		}
		//if crossArray contains the largest sum
		else {
			if(0 > crossArray[2]) {
				crossArray[0] = 0;
				crossArray[1] = -1;
				crossArray[2] = 0;
			}
			
			return crossArray;
		}
		
		
		
		
	}
	
	/**
	 * Kadane's algorithm O(n)
	 * It traverses through the array and calculates the maximum temporary sum. 
	 * If the temp sum is less than 0 then the starting value is moved to the next index because it cannot be less than 0.
	 * If the max Sum is less than the temp sum at any point then the new max sum is the temp sum and the other values are updated.
	 * At the end, the arrive value is finalized and an array is created with the three values: maxSum, arrive and depart indices and is returned.
	 * @param array the array that we are finding the maxSum of
	 * @return the array with the maxSum, arrive, and depart values
	 */
	public static int[] kadaneMaxSubarray(int array[]) {
		
		int maxSum = 0;
		int maxTemp = 0;
		int arrive = 0;
		int depart = -1;
		int tempArrive = 0;
		
		//traverses through the array looking for the maxSum, arrive, and depart values
		for(int i = 0; i < array.length; i++) {
			maxTemp = maxTemp + array[i];
			
			//checks to see if the temporary sum is less than zero and if it is, it is reset and the arrive value is incremented
			if(maxTemp < 0) {
				maxTemp = 0;
				arrive = i + 1;
			}
			
			//checks if the maxSum is less than the temp sum and if it is, the temp sum is the new max sum
			if(maxSum < maxTemp) {
				maxSum = maxTemp;
				depart = i;
				tempArrive = arrive;
			}
		}
		
		//finalize the arrive value and returns an array with the three values
		arrive = tempArrive;
		int[] ans = {arrive, depart, maxSum};
		return ans;
		
	}
	
	//creates a new instance of the MaximumSubarray class
//	MaximumSubarray maximumSubarray = new MaximumSubarray();
	
	/**
	 * This method calculates the average runtime for the brute force maximum subarray algorithm. 
	 * it creates an integer array with random values and uses those values to calculate the runtime of brute force.
	 * @param num num is the input size that we want the array to be set to.
	 */
	public void runtimeBruteForce(int num) {
		// creates a random variable
		Random r = new Random();
		//seed value is set to 20 so it is the same sequence of numbers everytime
		r.setSeed(20);
		//initalizes variables
		long start = 0;
		long end = 0;
		long totalTime = 0;
		
		//we are testing 10 cases
		for(int i = 0; i < 10; i++) {
			//creates a new array of the input size length
			int[] array = new int[num];
			//random values
			for(int j = 0; j < num; j++) {
				array[j] = r.nextInt();
			}
			
			//calculates the amount of time brute force takes
			start = System.currentTimeMillis();
			bruteForceMaxSubarray(array);
			end = System.currentTimeMillis();
			totalTime += (end - start);
		}
		
		//prints out the average time bruteforce algorithm takes
		System.out.println("BruteForce runtime: " + " input size: " + num + " Runtime: " + totalTime/10);
		
	}
	
	/**
	 * This method calculates the average runtime for the divide and conquer maximum subarray algorithm. 
	 * it creates an integer array with random values and uses those values to calculate the runtime of divide and conquer.
	 * @param num num is the input size that we want the array to be set to.
	 */
	public void runtimeDivideAndConquer(int num) {
		// creates a random variable
		Random r = new Random();
		//seed value is set to 20 so it is the same sequence of numbers everytime
		r.setSeed(20);
		//initalizes variables
		long start = 0;
		long end = 0;
		long totalTime = 0;
		
		//we are testing 10 cases
		for(int i = 0; i < 10; i++) {
			//creates a new array of the input size length
			int[] array = new int[num];
			//random values
			for(int j = 0; j < num; j++) {
				array[j] = r.nextInt();
			}
			
			//calculates the amount of time brute force takes
			start = System.currentTimeMillis();
			divdeAndConquerMaxSubarray(array, 0, array.length - 1);
			end = System.currentTimeMillis();
			totalTime += (end - start);
		}
		
		//prints out the average time divide and conquer algorithm takes
		System.out.println("Divide and Conquer runtime: " + " input size: " + num + " Runtime: " + totalTime/10);
		
	}
	
	/**
	 * This method calculates the average runtime for the Kadanes algorithm maximum subarray algorithm. 
	 * it creates an integer array with random values and uses those values to calculate the runtime of kadanes algorithm.
	 * @param num num is the input size that we want the array to be set to.
	 */
	public void runtimeKadane(int num) {
		// creates a random variable
		Random r = new Random();
		//seed value is set to 20 so it is the same sequence of numbers everytime
		r.setSeed(20);
		//initalizes variables
		long start = 0;
		long end = 0;
		long totalTime = 0;
		
		//we are testing 10 cases
		for(int i = 0; i < 10; i++) {
			//creates a new array of the input size length
			int[] array = new int[num];
			//random values
			for(int j = 0; j < num; j++) {
				array[j] = r.nextInt();
			}
			
//			//calculates the amount of time Kadanes takes
			start = System.currentTimeMillis();
			
			kadaneMaxSubarray(array);
			end = System.currentTimeMillis();
//			System.out.print("end" + end);
//			System.out.println("total" + totalTime);
			totalTime = totalTime + (end - start);
//			System.out.println("total" + totalTime);
		
			
			
		}
		
		//prints out the average time divide and conquer algorithm takes
		
		System.out.println("Kadane's runtime: " + " input size: " + num + " Runtime: " + totalTime/10);
		
	}
	

	
	
//	public static void main(String[] args) {
//		int[] arr = {22, -27  ,38  ,-34,  49  ,40  ,13  ,-44  ,-13  ,28  ,46  ,7  ,-26,  42,  29,  0,  -6,  35};
//		//2,17,204
//		MaximumSubarray ms = new MaximumSubarray();
//		int[] test1 = ms.bruteForceMaxSubarray(arr);
//		System.out.println("brute force" + Arrays.toString(test1));
//		int[] test2 = ms.divdeAndConquerMaxSubarray(arr,0,arr.length - 1);
//		System.out.println("divide and conquer" + Arrays.toString(test2));
//		int[] test3 = ms.kadaneMaxSubarray(arr);
//		System.out.println("kanade's" + Arrays.toString(test3));
//		//ms.runtimeBruteForce(0100);
////		ms.runtimeDivideAndConquer(5000000);
////		ms.runtimeKadane(100000000);
		
		
		

//	}
}

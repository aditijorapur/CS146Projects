package cs146S22.Jorapur.project2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
/**
 * This class is used to read the maxSumtest.txt file that contains the test cases for the MaximumSubarray class.
 * @author Aditi Jorapur
 * @date 10/23/22
 */
public class MaxSumFileReader {
	/**
	 * 
	 * @param lines
	 * @return
	 * @throws IOException
	 * @throws NumberFormatException
	 */
	public static ArrayList<String> processInput(String fileName) throws IOException, NumberFormatException{
		
		File file = new File(fileName); //creates a new file with the given file
		FileReader fr = new FileReader(file); //creates a new file reader
		BufferedReader br = new BufferedReader(fr); //creates a new buffered reader
		ArrayList<String> linesArray = new ArrayList<String>(); //creates an array list that will store the lines
		String currentLine = br.readLine(); //reads the line and stores it as a string
		//while the current line is not equal to null, we add the contents of the line to linesArray
		while(currentLine != null) { 
			if(currentLine.trim().length() > 0) {
				linesArray.add(currentLine);
			}
			currentLine = br.readLine(); //current line is equal to the next line
		}
		
//		for(int i = 0; i < linesArray.size(); i++) {
//			System.out.println(linesArray.get(i));
//		}
//		
//		int[] array = new int[103];
//		
//		String line = br.readLine();
//		
//		String[] strArr = line.split(" ");
//		
//		System.out.println(strArr.length);
//		
//		for(int i = 0; i < strArr.length; i++) {
//			array[i] = Integer.parseInt(strArr[i]);
//		}
		
		
		br.close(); //close the buffered reader
		fr.close(); //close the file reader
		
		return linesArray; //return the string array with the lines
		
		
	}
		
		

}

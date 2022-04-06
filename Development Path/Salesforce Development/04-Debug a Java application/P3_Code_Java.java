package com.hemebiotech.analytics;
import java.io.*;
import java.util.*;

public class AnalyticsCounter {
	public static void main(String args[]) throws Exception {

//1st: Getting input from the original text file using BufferedReader class
		BufferedReader reader = new BufferedReader (new FileReader("/home/thabit/Documents/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/symptoms.txt"));  
    String eachLine = new String();   //Reads each line of the text file
		ArrayList<String> symptomsDotText = new ArrayList<String>();  //Creating new ArrayList for containing lines from the file as elements
		while ((eachLine = reader.readLine()) != null) {  //While loop to add each line of text file to the new ArrayList
			symptomsDotText.add(eachLine);
		Collections.sort(symptomsDotText); 
		} reader.close();

//2nd: Convert the ArrayList into an Array
    String[] symptomsDotTxtToArray = new String [symptomsDotText.size()];
		symptomsDotText.toArray(symptomsDotTxtToArray);
		System.out.println(Arrays.toString(symptomsDotTxtToArray));
	 
//3rd: Introduce BufferedWriter class for later file output using the append option
    BufferedWriter writer = new BufferedWriter (new FileWriter("/home/thabit/Documents/Project_DA_Java_EN_Come_to_the_Rescue_of_a_Java_Application/Project02Eclipse/results.out", true));    
    
    
//4th: Introduce nested while loop to reiterate through the elements of the Array and count occurences of each
   int lengthOfEachElement = 0;
   while (lengthOfEachElement < symptomsDotTxtToArray.length) { 			int indexElement = lengthOfEachElement;
	 while (lengthOfEachElement < symptomsDotTxtToArray.length && symptomsDotTxtToArray[lengthOfEachElement].equals(symptomsDotTxtToArray[indexElement])) {lengthOfEachElement++;}
		
   //count = length position - index position
     			int count = lengthOfEachElement - indexElement; 
      		 
//5th: Writing output of the program and to the results.out
          System.out.println(symptomsDotTxtToArray[indexElement] + " : " + count);
          String symptomFrequency = symptomsDotTxtToArray[indexElement].toString() + " : " + Integer.toString(count);
			    symptomFrequency = symptomFrequency.substring(0,1).toUpperCase() + symptomFrequency.substring(1).toLowerCase();
			    writer.write(symptomFrequency + "\n");
		} 
   writer.write("\n" + "+++End of Output+++" + "\n\n");
   writer.close();
  }
}
